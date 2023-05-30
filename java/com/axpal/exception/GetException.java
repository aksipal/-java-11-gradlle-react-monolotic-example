package com.axpal.exception;
import com.axpal.annotations.AxpalFeignClientError;
import com.axpal.constans.AxpalExceptionCodeConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;

@AxpalFeignClientError
public class GetException extends AxpalCheckedException {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetException.class);
    private static final String EXCEPTION_LOG = "\n Time: {} \n Exception Code: {} \n Exception UUID: {} ," +
            "Exception Service: {} \n Exception Message {} \n  Error Detail: {} \n Root: {}";

    private EnumExceptionTur enumExceptionTur;

    public GetException(){
        this.setErrorDetail(new AxpalErrorDetail(AxpalExceptionCodeConstants.GETIR_EXCEPTION_CODE,null,
                AxpalExceptionCodeConstants.GETIRME_BASARISIZ,null,new Date()));
        this.enumExceptionTur = EnumExceptionTur.ERROR_GROWL;

        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(),AxpalExceptionCodeConstants.GETIR_EXCEPTION_CODE,
                this.getErrorDetail().getUuid(),this.getErrorDetail().getService(),
                this.getErrorDetail().getErrorMessage(),this.getErrorDetail(),this.getErrorDetail(),
                this.getStackTrace()[0]);
    }
    public GetException(AxpalCheckedException e,Class<?>service){
        super(e.getErrorDetail());
        getErrorDetail().setService(service.getSimpleName());

        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(),AxpalExceptionCodeConstants.GETIR_EXCEPTION_CODE,
                this.getErrorDetail().getUuid(),this.getErrorDetail().getService(),
                this.getErrorDetail().getErrorMessage(),this.getErrorDetail(),this.getErrorDetail(),
                this.getStackTrace()[0]);
    }

    public GetException(Throwable e,Class<?>service){
        super(e, new AxpalErrorDetail(AxpalExceptionCodeConstants.GETIR_EXCEPTION_CODE,e.getMessage(),AxpalExceptionCodeConstants.GETIRME_BASARISIZ,
                service.getSimpleName(),new Date()));

        if (e instanceof AxpalCheckedException){
            this.setErrorDetail(((AxpalCheckedException)e).getErrorDetail());
        }
        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(),AxpalExceptionCodeConstants.GETIR_EXCEPTION_CODE,
                this.getErrorDetail().getUuid(),this.getErrorDetail().getService(),
                this.getErrorDetail().getErrorMessage(),this.getErrorDetail(),this.getErrorDetail(),
                this.getStackTrace()[0]);
    }

    public GetException(String message, Class<?> service){
        super(new AxpalErrorDetail(AxpalExceptionCodeConstants.GETIR_EXCEPTION_CODE,null,
                message,service.getSimpleName(),new Date()));

        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(),AxpalExceptionCodeConstants.GETIR_EXCEPTION_CODE,
                this.getErrorDetail().getUuid(),this.getErrorDetail().getService(),
                this.getErrorDetail().getErrorMessage(),this.getErrorDetail(),this.getErrorDetail(),
                this.getStackTrace()[0]);
    }

    public GetException(Throwable e,String message,Class<?>service){
        super(e, new AxpalErrorDetail(AxpalExceptionCodeConstants.GETIR_EXCEPTION_CODE,e.getMessage(),message,
                service.getSimpleName(),new Date()));

        if (e instanceof AxpalCheckedException){
            this.setErrorDetail(((AxpalCheckedException)e).getErrorDetail());
        }
        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(),AxpalExceptionCodeConstants.GETIR_EXCEPTION_CODE,
                this.getErrorDetail().getUuid(),this.getErrorDetail().getService(),
                this.getErrorDetail().getErrorMessage(),this.getErrorDetail(),this.getErrorDetail(),
                this.getStackTrace()[0]);
    }

    public GetException(Throwable e,String message,Object[] arguments,Class<?>service){
        super(e, new AxpalErrorDetail(AxpalExceptionCodeConstants.GETIR_EXCEPTION_CODE,e.getMessage(),message,arguments,
                service.getSimpleName(),new Date()));

        if (e instanceof AxpalCheckedException){
            this.setErrorDetail(((AxpalCheckedException)e).getErrorDetail());
        }
        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(),AxpalExceptionCodeConstants.GETIR_EXCEPTION_CODE,
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


