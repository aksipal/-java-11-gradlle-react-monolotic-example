package com.axpal.exception;
import com.axpal.annotations.AxpalFeignClientError;
import com.axpal.constans.AxpalExceptionCodeConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Kayit, guncelleme veya sil islemlerinde belirli bir is kurali disinda kalan durumlarin kontrolunde atilacak hatadir.
 *
 *Ornek:Firma ortaklarinin hisse oraninin toplami %100'u gecemez.
 *
 */

@AxpalFeignClientError
public class KontrolException extends AxpalCheckedException {

    private static final Logger LOGGER = LoggerFactory.getLogger(KontrolException.class);
    private static final String EXCEPTION_LOG = "\n Time: {} \n Exception Code: {} \n Exception UUID: {} ," +
            "Exception Service: {} \n Exception Message {} \n  Error Detail: {} \n Root: {}";

    private EnumExceptionTur enumExceptionTur;

    public KontrolException(){
        this.setErrorDetail(new AxpalErrorDetail(AxpalExceptionCodeConstants.KONTROL_EXCEPTION_CODE,null,
                "default.codedException"));
        this.enumExceptionTur = EnumExceptionTur.ERROR_GROWL;

        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(),AxpalExceptionCodeConstants.KAYDET_EXCEPTION_CODE,
                this.getErrorDetail().getUuid(),this.getErrorDetail().getService(),
                this.getErrorDetail().getErrorMessage(),this.getErrorDetail(),this.getErrorDetail(),
                this.getStackTrace()[0]);
    }


    public KontrolException(String message,Object[] arguments, Class<?> service){
        super(new AxpalErrorDetail(AxpalExceptionCodeConstants.KONTROL_EXCEPTION_CODE,null,
                message,arguments,service.getSimpleName(),new Date()));

        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(),AxpalExceptionCodeConstants.KAYDET_EXCEPTION_CODE,
                this.getErrorDetail().getUuid(),this.getErrorDetail().getService(),
                this.getErrorDetail().getErrorMessage(),this.getErrorDetail(),this.getErrorDetail(),
                this.getStackTrace()[0]);
    }

    public KontrolException(String message,Class<?>service){
        super(new AxpalErrorDetail(AxpalExceptionCodeConstants.KONTROL_EXCEPTION_CODE,null,message,
                service.getSimpleName(),new Date()));

        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(),AxpalExceptionCodeConstants.KAYDET_EXCEPTION_CODE,
                this.getErrorDetail().getUuid(),this.getErrorDetail().getService(),
                this.getErrorDetail().getErrorMessage(),this.getErrorDetail(),this.getErrorDetail(),
                this.getStackTrace()[0]);
    }

    public EnumExceptionTur getEnumExceptionTur() {
        return enumExceptionTur;
    }

    public void setEnumExceptionTur(EnumExceptionTur enumExceptionTur) {
        this.enumExceptionTur = enumExceptionTur;
    }
}


