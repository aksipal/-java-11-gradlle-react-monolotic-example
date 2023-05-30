package com.axpal.entity.configuration;
import com.axpal.entity.configuration.constan.AxpalEntityConfigurationConstant;
import com.axpal.strategy.uuid.AxpalEntityUUIDGeneratorStrategy;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.apache.commons.lang3.StringUtils;

/**
 * Modul ile ilgili gerekli konfigurasyonlarin yapildigi siniftir.
 */
@Configuration
public class AxpalEntityAutoConfiguration implements InitializingBean {

    private static final int DEFAULT_DCE_SECURITY_IDENTIFIER=2323;

    private static AxpalEntityUUIDGeneratorStrategy uuidGeneratorStrategy;

    private static int dceSecurityBaseGenaratorIdentifier;

    private final Environment environment;


    public AxpalEntityAutoConfiguration(Environment environment) {
        this.environment = environment;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        String uuidStrategy = environment.getProperty(AxpalEntityConfigurationConstant.UUID_STRATEGY_PROPERTY);
        if(StringUtils.isNotEmpty(uuidStrategy)){
            Class<?> uuidStrategyClass = Class.forName(uuidStrategy);
            if(AxpalEntityUUIDGeneratorStrategy.class.isAssignableFrom(uuidStrategyClass)){
                uuidGeneratorStrategy = (AxpalEntityUUIDGeneratorStrategy) uuidStrategyClass.getDeclaredConstructor().newInstance();
            }else {
                throw new IllegalArgumentException("The uuid strategy class must be extend from EczaEntityUUIDGeneratorStrategy class.");
            }
        }
        String dceSecurityIdentifier = environment.getProperty(AxpalEntityConfigurationConstant.DCE_SECURITY_IDENTIFIER);
        if(StringUtils.isEmpty(dceSecurityIdentifier)){
            dceSecurityBaseGenaratorIdentifier = DEFAULT_DCE_SECURITY_IDENTIFIER;
        }
    }

    public static AxpalEntityUUIDGeneratorStrategy getUuidGeneratorStrategy() {
        return uuidGeneratorStrategy;
    }

    public static int getDceSecurityBaseGenaratorIdentifier() {
        return dceSecurityBaseGenaratorIdentifier;
    }
}
