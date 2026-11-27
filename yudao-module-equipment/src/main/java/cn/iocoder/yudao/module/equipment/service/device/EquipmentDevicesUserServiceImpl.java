package cn.iocoder.yudao.module.equipment.service.device;


import cn.iocoder.yudao.module.equipment.controller.admin.device.vo.EquipmentDevicesUserSaveReqVO;
import cn.iocoder.yudao.module.equipment.dal.dataobject.device.EquipmentDevicesUserDO;
import cn.iocoder.yudao.module.equipment.dal.mysql.device.EquipmentDevicesUserMapper;
import cn.iocoder.yudao.module.equipment.dal.mysql.device.EquipmentMapper;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.equipment.enums.ErrorCodeConstants.EQUIPMENT_NOT_EXISTS;
import static cn.iocoder.yudao.module.equipment.enums.ErrorCodeConstants.EQUIPMENT_USER_EXISTS;
import javax.annotation.Resource;

/**
 * 设备人员 Service 实现类
 *
 * 负责把「某台设备」和「某个用户」绑定成一条关联记录。
 */
@Service
@Validated
public class EquipmentDevicesUserServiceImpl implements EquipmentDevicesUserService {

    /** 设备人员表。插入关联、按设备和用户查重都走这里 */
    @Resource
    private EquipmentDevicesUserMapper equipmentDevicesUserMapper;

    /** 设备表。用来确认传入的设备编号是否存在 */
    @Resource
    private EquipmentMapper equipmentMapper;

    /** 系统用户接口。用来确认传入的用户编号是否存在、是否被禁用 */
    @Resource
    private AdminUserApi adminUserApi;

    /**
     * 新增设备人员
     *
     * 先校验设备和用户都有效，并且这一对还没有绑定过，再写入 equipment_device_user。
     *
     * @param createReqVO 前端传入的设备编号、用户编号
     * @return 新关联记录的编号
     */
    @Override
    public Long createEquipment(EquipmentDevicesUserSaveReqVO createReqVO) {
        // 设备不存在时直接失败，避免往关联表写入一条无效的设备编号
        if (equipmentMapper.selectById(createReqVO.getEquipmentId()) == null) {
            throw exception(EQUIPMENT_NOT_EXISTS);
        }
        // 用户不存在或已被禁用时，系统模块会抛出对应异常
        adminUserApi.validateUser(createReqVO.getUserId());
        // 同一台设备不能重复绑定同一个用户
        if (equipmentDevicesUserMapper.selectByEquipmentId(createReqVO.getEquipmentId(), createReqVO.getUserId()) != null) {
            throw exception(EQUIPMENT_USER_EXISTS);
        }

        // 请求对象只有两个编号，转成表对象后再插入。id、创建时间等由数据库和框架填充
        EquipmentDevicesUserDO row = BeanUtils.toBean(createReqVO, EquipmentDevicesUserDO.class);
        equipmentDevicesUserMapper.insert(row);
        // 插入成功后，自增主键会回填到 row.id
        return row.getId();
    }

}
