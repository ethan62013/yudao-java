package cn.iocoder.yudao.module.equipment.dal.mysql.device;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.equipment.controller.admin.device.vo.EquipmentPageReqVO;
import cn.iocoder.yudao.module.equipment.dal.dataobject.device.EquipmentDO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 设备 Mapper
 */
@Mapper
public interface EquipmentMapper extends BaseMapperX<EquipmentDO> {

    IPage<EquipmentDO> selectEquipmentPage(IPage<EquipmentDO> page, @Param("reqVO") EquipmentPageReqVO reqVO);

}
