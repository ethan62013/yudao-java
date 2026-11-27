package cn.iocoder.yudao.module.equipment.controller.admin.device.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Schema(description = "管理后台 - 设备人员新增 Request VO")
@Data
public class EquipmentDevicesUserSaveReqVO {

    @Schema(description = "设备编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "设备编号不能为空")
    private Long equipmentId;

    @Schema(description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "用户编号不能为空")
    private Long userId;

}
