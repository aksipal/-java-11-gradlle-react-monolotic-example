package com.axpal.util;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * ReflectionUtils'deki degisiklikVarMi methodu icin yazilmistir. Annotasyon kullanimi fieldler farkli mi degil mi bakar.
 */
@Target(FIELD)
@Retention(RUNTIME)
public @interface CheckFieldToChange {

    String displayName() default "";
}
