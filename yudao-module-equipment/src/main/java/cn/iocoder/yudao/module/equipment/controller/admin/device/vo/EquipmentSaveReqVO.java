package cn.iocoder.yudao.module.equipment.controller.admin.device.vo;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Schema(description = "管理后台 - 设备新增 Request VO")
@Data
public class EquipmentSaveReqVO {

    @Schema(description = "设备名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "数控车床")
    @NotEmpty(message = "设备名称不能为空")
    @Size(max = 100, message = "设备名称长度不能超过 100 个字符")
    private String name;

    @Schema(description = "设备编码", example = "EQ-004")
    @Size(max = 64, message = "设备编码长度不能超过 64 个字符")
    private String code;

    @Schema(description = "状态，参见 CommonStatusEnum 枚举类", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    @InEnum(value = CommonStatusEnum.class, message = "状态必须是 {value}")
    private Integer status;

    @Schema(description = "备注", example = "一号车间")
    @Size(max = 500, message = "备注长度不能超过 500 个字符")
    private String remark;

}
