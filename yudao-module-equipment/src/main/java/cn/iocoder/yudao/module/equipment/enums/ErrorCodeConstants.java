package cn.iocoder.yudao.module.equipment.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * Equipment 错误码枚举类
 * <p>
 * equipment 系统，使用 1-061-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== 设备 1-061-001-000 ==========
    ErrorCode EQUIPMENT_NOT_EXISTS = new ErrorCode(1_061_001_000, "设备不存在");

}
