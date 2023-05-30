package com.axpal.app;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@ConfigurationProperties(prefix = AxpalEventLogConfigurationConstant.ECZA_UI_EVENT_LOG_PROPERTIES_PREFIX)
public class AxpalEventLogConfiguration implements Serializable, InitializingBean {

    public static final Logger LOGGER = LoggerFactory.getLogger(AxpalEventLogConfiguration.class);

    private boolean enabled;

    private String indexName;

    private String documentType;

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("Event log is" + ((this.enabled) ? "enabled.": "disabled."));
        if (this.enabled){
            LOGGER.info("Event log index name is " + this.indexName);
            LOGGER.info("Evenet log document type is " + this.documentType);
        }
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }
}
