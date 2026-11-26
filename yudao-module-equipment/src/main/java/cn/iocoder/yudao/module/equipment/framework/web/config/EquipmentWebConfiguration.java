package cn.iocoder.yudao.module.equipment.framework.web.config;

import cn.iocoder.yudao.framework.swagger.config.YudaoSwaggerAutoConfiguration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * equipment 模块的 web 组件的 Configuration
 */
@Configuration(proxyBeanMethods = false)
public class EquipmentWebConfiguration {

    /**
     * equipment 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi equipmentGroupedOpenApi() {
        return YudaoSwaggerAutoConfiguration.buildGroupedOpenApi("equipment");
    }

}
