package cn.iocoder.yudao.module.equipment.controller.admin.device;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.equipment.controller.admin.device.vo.EquipmentPageReqVO;
import cn.iocoder.yudao.module.equipment.controller.admin.device.vo.EquipmentRespVO;
import cn.iocoder.yudao.module.equipment.controller.admin.device.vo.EquipmentSaveReqVO;
import cn.iocoder.yudao.module.equipment.dal.dataobject.device.EquipmentDO;
import cn.iocoder.yudao.module.equipment.service.device.EquipmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 设备")
@RestController
@RequestMapping("/equipment/device")
@Validated
public class EquipmentController {

    @Resource
    private EquipmentService equipmentService;

    @PostMapping("/create")
    @Operation(summary = "创建设备")
    @PreAuthorize("@ss.hasPermission('equipment:device:create')")
    public CommonResult<Long> createEquipment(@Valid @RequestBody EquipmentSaveReqVO createReqVO) {
        return success(equipmentService.createEquipment(createReqVO));
    }

    @GetMapping("/page")
    @Operation(summary = "获得设备分页")
    @PreAuthorize("@ss.hasPermission('equipment:device:query')")
    public CommonResult<PageResult<EquipmentRespVO>> getEquipmentPage(@Valid EquipmentPageReqVO pageReqVO) {
        PageResult<EquipmentDO> pageResult = equipmentService.getEquipmentPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, EquipmentRespVO.class));
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除设备")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('equipment:device:delete')")
    public CommonResult<Boolean> deleteEquipment(@RequestParam("id") Long id) {
        equipmentService.deleteEquipment(id);
        return success(true);
    }



}
