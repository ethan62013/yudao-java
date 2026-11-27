package cn.iocoder.yudao.module.equipment.controller.admin.device;


import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.equipment.controller.admin.device.vo.EquipmentDevicesUserSaveReqVO;
import cn.iocoder.yudao.module.equipment.service.device.EquipmentDevicesUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name ="管理后台 - 设备人员")
@RestController
@RequestMapping("/equipment/device-user")
@Validated
public class EquipmentDevicesUserController {
    @Resource
    private EquipmentDevicesUserService equipmentDevicesUserService;

    @PostMapping("/create")
    @Operation(summary="新增设备人员")
    @PreAuthorize("@ss.hasPermission('equipment:device-user:create')")
    public CommonResult<Long> createEquipment(@Valid @RequestBody EquipmentDevicesUserSaveReqVO createReqVO) {
        return success(equipmentDevicesUserService.createEquipment(createReqVO));
    }

}
