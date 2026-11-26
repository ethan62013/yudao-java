package cn.iocoder.yudao.module.equipment.service.device;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.equipment.controller.admin.device.vo.EquipmentPageReqVO;
import cn.iocoder.yudao.module.equipment.dal.dataobject.device.EquipmentDO;

/**
 * 设备 Service
 */
public interface EquipmentService {

    /**
     * 获得设备分页
     *
     * @param pageReqVO 分页查询
     * @return 设备分页
     */
    PageResult<EquipmentDO> getEquipmentPage(EquipmentPageReqVO pageReqVO);

}
