package com.axpal.app;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;


@Configuration
@EnableAutoConfiguration
@ComponentScans(
        value = {
                @ComponentScan(basePackages = AxpalAppMainConfigurationConstant.PROJECT_BASE_PACKAGE,
                        includeFilters = @ComponentScan.Filter(type = FilterType.REGEX
                                , pattern = AxpalAppMainConfigurationConstant.PROJECT_BASE_PACKAGE_REGEX)
                ),
                @ComponentScan(basePackages = AxpalAppMainConfigurationConstant.FRAMEWORK_EVENT_LOG_PACKAGE)
        }
)
@Import(value = {AxpalConfiguration.class, AxpalEventLogConfiguration.class})
@EntityScan(basePackages = AxpalMainConfigurationConstant.BASE_PACKAGE)
public class AxpalApplicationConfiguration {

    @Value(value = ("${application.runAsJob:false}"))
    private boolean runAsJob;

    public boolean getRunAsJob() {
        return runAsJob;
    }
}
