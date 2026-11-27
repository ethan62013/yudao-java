package cn.iocoder.yudao.module.equipment.dal.mysql.device;


import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.equipment.dal.dataobject.device.EquipmentDevicesUserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EquipmentDevicesUserMapper extends BaseMapperX<EquipmentDevicesUserDO> {
    default EquipmentDevicesUserDO selectByEquipmentId(Long equipmentId , Long userId ) {
        return selectOne(EquipmentDevicesUserDO::getEquipmentId,equipmentId , EquipmentDevicesUserDO::getUserId,userId);
    }
}
