package cn.iocoder.yudao.module.equipment.service.device;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.equipment.controller.admin.device.vo.EquipmentPageReqVO;
import cn.iocoder.yudao.module.equipment.controller.admin.device.vo.EquipmentSaveReqVO;
import cn.iocoder.yudao.module.equipment.dal.dataobject.device.EquipmentDO;

import javax.validation.Valid;

/**
 * 设备 Service
 */
public interface EquipmentService {

    /**
     * 创建设备
     *
     * @param createReqVO 创建信息
     * @return 设备编号
     */
    Long createEquipment(@Valid EquipmentSaveReqVO createReqVO);

    /**
     * 删除设备
     *
     * @param id 设备编号
     */
    void deleteEquipment(Long id);

    /**
     * 获得设备分页
     *
     * @param pageReqVO 分页查询
     * @return 设备分页
     */
    PageResult<EquipmentDO> getEquipmentPage(EquipmentPageReqVO pageReqVO);

}
