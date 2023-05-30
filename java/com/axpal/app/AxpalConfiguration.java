package com.axpal.app;

import com.axpal.entity.configuration.AxpalBaseConfiguration;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(basePackages = {AxpalMainConfigurationConstant.BASE_PACKAGE
        , AxpalMainConfigurationConstant.CORE_BASE_PACKAGE},
        useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = AxpalProfileConfiguration.class),
        }
)
public class AxpalConfiguration extends AxpalBaseConfiguration implements InitializingBean {

    @Autowired
    private ObjectMapper jacksonObjectMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        jacksonObjectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    }
}
