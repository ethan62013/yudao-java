package cn.iocoder.yudao.module.equipment.dal.dataobject.device;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 * 设备人员 DO
 */
@TableName("equipment_device_user")
@KeySequence("equipment_device_user_seq")
@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class EquipmentDevicesUserDO extends BaseDO {
    /**
     * 编号
     */
    @TableId
    private Long id;

    /**
     * 设备编号
     */
    private Long equipmentId;

    /**
     * 用户编号
     */
    private Long userId;


}
