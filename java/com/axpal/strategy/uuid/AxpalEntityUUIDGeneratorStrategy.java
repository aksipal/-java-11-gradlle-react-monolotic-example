package com.axpal.strategy.uuid;

import com.axpal.entity.AxpalSimpleEntity;

/**
 * {@link AxpalSimpleEntity} turunden siniflarda UUID uretme stratejilerinin arayuz sinifidir.
 */
public interface AxpalEntityUUIDGeneratorStrategy {

    /**
     * UUID ureten ve{@link String} olarak donmesini saglayan yontemdir
     *
     * @return UUID
     */

    String genarate();
}
