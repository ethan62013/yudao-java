package cn.iocoder.yudao.module.equipment.service.device;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.mybatis.core.util.MyBatisUtils;
import cn.iocoder.yudao.module.equipment.controller.admin.device.vo.EquipmentPageReqVO;
import cn.iocoder.yudao.module.equipment.controller.admin.device.vo.EquipmentSaveReqVO;
import cn.iocoder.yudao.module.equipment.dal.dataobject.device.EquipmentDO;
import cn.iocoder.yudao.module.equipment.dal.mysql.device.EquipmentMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.equipment.enums.ErrorCodeConstants.EQUIPMENT_NOT_EXISTS;

/**
 * 设备 Service 实现类
 */
@Service
@Validated
public class EquipmentServiceImpl implements EquipmentService {

    @Resource
    private EquipmentMapper equipmentMapper;

    @Override
    public Long createEquipment(EquipmentSaveReqVO createReqVO) {
        EquipmentDO equipment = BeanUtils.toBean(createReqVO, EquipmentDO.class);
        equipmentMapper.insert(equipment);
        return equipment.getId();
    }

    @Override
    public void deleteEquipment(Long id) {
        validateEquipmentExists(id);
        equipmentMapper.deleteById(id);
    }

    private void validateEquipmentExists(Long id) {
        if (equipmentMapper.selectById(id) == null) {
            throw exception(EQUIPMENT_NOT_EXISTS);
        }
    }

    @Override
    public PageResult<EquipmentDO> getEquipmentPage(EquipmentPageReqVO pageReqVO) {
        IPage<EquipmentDO> page = equipmentMapper.selectEquipmentPage(MyBatisUtils.buildPage(pageReqVO), pageReqVO);
        return new PageResult<>(page.getRecords(), page.getTotal());
    }

}
