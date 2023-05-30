package com.axpal.entity.configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 'ecza-framework' sistemini kullanacak olan uygulamalarda konfigurasyon siniflari bundan turemelidir.
 * Konfigurasyon acisindan altyapi destegini almak isteniyorsa
 * bu siniftan tureyen konfigurasyon siniflari yazilmalidir.
 *
 * @author baksipal
 */
public class AxpalBaseConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(AxpalBaseConfiguration.class);

    protected AxpalBaseConfiguration(){ info(); }

    /**
     * Konfigurasyon sinifi hakkinda bilgi vermeye yarayan yontemdir
     */
    protected void info(){
        if(LOGGER.isInfoEnabled()){
            LOGGER.info(String.format("%s class was added as configuration class.",this.getClass().getSimpleName()));
        }
    }
}
