package cn.iocoder.yudao.module.equipment.service.device;

import cn.iocoder.yudao.module.equipment.controller.admin.device.vo.EquipmentDevicesUserSaveReqVO;

import javax.validation.Valid;

public interface EquipmentDevicesUserService {
    /**
     * 新增设备人员
     *
     * @param createReqVO 设备编号、用户编号
     * @return 设备人员编号
     */
    Long createEquipment(@Valid EquipmentDevicesUserSaveReqVO createReqVO);
}
