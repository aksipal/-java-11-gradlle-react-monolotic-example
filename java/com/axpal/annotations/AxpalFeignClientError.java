package com.axpal.annotations;

import java.lang.annotation.*;

/**
 * {@link org.springframework.cloud.openfeign.FeignClient} hatalarinin anlamlandirilmasi icin hata siniflarina verilen
 * annotationdur.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AxpalFeignClientError {
}
