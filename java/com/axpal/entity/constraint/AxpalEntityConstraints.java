package com.axpal.entity.constraint;

public class AxpalEntityConstraints {

    private AxpalEntityConstraints(){
        //initlenememesi icin private yapilmistir.
    }

    public static final int CREATED_BY_SIZE=50;

    public static final int UPDATED_BY_SIZE=50;

    public static final String VERSION_DEFINATION="INT DEFAULT 0";

    public static final String TIMESTAP_WITH_UTC_DEFINATION="TIMESTAP WITH TIME ZONE";

    public static final String TIMESTAP_WITHOUT_UTC_DEFINATION="TIMESTAP WITHOUT TIME ZONE";

    public static final String SEQUENCE_GENERATOR="entitySequenceGenerator";

    public static final String SEQUENCE_GENERATOR_STRATEGY= "com/axpal/infras/data/EczaEntityUUIDGeneratorStrategy.java";

    public static final String SEQUENCE_GENERATOR_STRATEGY_POOL_PARAM= "pooled-lo";

    public static final String SEQUENCE_GENERATOR_STRATEGY_INITIAL_PARAM= "1";

    public static final String SEQUENCE_GENERATOR_STRATEGY_INCREMENT_PARAM= "10";

}
