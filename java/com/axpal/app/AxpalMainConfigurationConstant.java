package com.axpal.app;

public class AxpalMainConfigurationConstant {

    private AxpalMainConfigurationConstant() {
    }

    public static final String BASE_PACKAGE = "com.via";

    public static final String CORE_BASE_PACKAGE = "com.via.infra";

    public static final String ALWAYS_SHOW_OUTPUT = "spring.ouput.ansi.enabled=always";

    public static final String ALWAYS_SHOW_JPA_OUTPUT = "spring.jpa.showSql=true";

    public static final String OVERRIDE_BEAN_DEFINITIONS = "spring.main.allow-bean-definition-overriding=true";

}