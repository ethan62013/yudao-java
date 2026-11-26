package cn.iocoder.yudao.module.equipment.service.device;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.util.MyBatisUtils;
import cn.iocoder.yudao.module.equipment.controller.admin.device.vo.EquipmentPageReqVO;
import cn.iocoder.yudao.module.equipment.dal.dataobject.device.EquipmentDO;
import cn.iocoder.yudao.module.equipment.dal.mysql.device.EquipmentMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * 设备 Service 实现类
 */
@Service
@Validated
public class EquipmentServiceImpl implements EquipmentService {

    @Resource
    private EquipmentMapper equipmentMapper;

    @Override
    public PageResult<EquipmentDO> getEquipmentPage(EquipmentPageReqVO pageReqVO) {
        IPage<EquipmentDO> page = equipmentMapper.selectEquipmentPage(MyBatisUtils.buildPage(pageReqVO), pageReqVO);
        return new PageResult<>(page.getRecords(), page.getTotal());
    }

}
