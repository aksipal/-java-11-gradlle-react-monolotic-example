package com.axpal.entity;

import com.axpal.entity.configuration.AxpalEntityAutoConfiguration;
import com.axpal.strategy.uuid.AxpalEntityUUIDGeneratorStrategy;

import javax.persistence.PrePersist;
import java.util.Objects;

/**
 * AxpalEntity nesnesinden türüuem veritabani nesneleri icin desigisiklik yapildiginda devreye giren siniftir.
 *
 * @author Baksipal
 */
public class AxpalEntityListener {

    /**
     * Veritabani kayit islemdinden önce calisir.
     *
     * @param entity Veritabani nesnesi
     */

    @PrePersist
    public void prePersist(Object entity){
        if(entity instanceof AxpalSoftDeleteEntity){
            ((AxpalSoftDeleteEntity)entity).setDeleted(false);
        }
        if(entity instanceof AxpalSimpleEntity){
            AxpalEntityUUIDGeneratorStrategy uuidGeneratorStrategy = AxpalEntityAutoConfiguration.getUuidGeneratorStrategy();
            if(Objects.nonNull(uuidGeneratorStrategy)){
                ((AxpalSimpleEntity)entity).setUuid(uuidGeneratorStrategy.genarate());
            }
        }
    }
}
