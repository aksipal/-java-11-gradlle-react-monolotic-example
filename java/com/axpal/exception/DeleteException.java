package com.axpal.exception;
import com.axpal.annotations.AxpalFeignClientError;
import com.axpal.constans.AxpalExceptionCodeConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;

@AxpalFeignClientError
public class DeleteException extends AxpalCheckedException {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteException.class);
    private static final String EXCEPTION_LOG = "\n Time: {} \n Exception Code: {} \n Exception UUID: {} ," +
            "Exception Service: {} \n Exception Message {} \n  Error Detail: {} \n Root: {}";

    private EnumExceptionTur enumExceptionTur;

    public DeleteException(){
        this.setErrorDetail(new AxpalErrorDetail(AxpalExceptionCodeConstants.SIL_EXCEPTION_CODE,null,
                AxpalExceptionCodeConstants.SILME_BASARISIZ));
        this.enumExceptionTur = EnumExceptionTur.ERROR_GROWL;

        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(),AxpalExceptionCodeConstants.SIL_EXCEPTION_CODE,
                this.getErrorDetail().getUuid(),this.getErrorDetail().getService(),
                this.getErrorDetail().getErrorMessage(),this.getErrorDetail(),this.getErrorDetail(),
                this.getStackTrace()[0]);
    }

    public DeleteException(Throwable e,Class<?>service){
        super(e, new AxpalErrorDetail(AxpalExceptionCodeConstants.SIL_EXCEPTION_CODE,null,AxpalExceptionCodeConstants.SILME_BASARISIZ,
                service.getSimpleName(),new Date()));

        if (e instanceof AxpalCheckedException){
            this.setErrorDetail(((AxpalCheckedException)e).getErrorDetail());
        }
        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(),AxpalExceptionCodeConstants.SIL_EXCEPTION_CODE,
                this.getErrorDetail().getUuid(),this.getErrorDetail().getService(),
                this.getErrorDetail().getErrorMessage(),this.getErrorDetail(),this.getErrorDetail(),
                this.getStackTrace()[0]);
    }

    public DeleteException(String message, Class<?> service){
        super(new AxpalErrorDetail(AxpalExceptionCodeConstants.SIL_EXCEPTION_CODE,null,
                message,service.getSimpleName(),new Date()));

        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(),AxpalExceptionCodeConstants.SIL_EXCEPTION_CODE,
                this.getErrorDetail().getUuid(),this.getErrorDetail().getService(),
                this.getErrorDetail().getErrorMessage(),this.getErrorDetail(),this.getErrorDetail(),
                this.getStackTrace()[0]);
    }

    public DeleteException(Throwable e,String message,Class<?>service){
        super(e, new AxpalErrorDetail(AxpalExceptionCodeConstants.SIL_EXCEPTION_CODE,null,message,
                service.getSimpleName(),new Date()));

        if (e instanceof AxpalCheckedException){
            this.setErrorDetail(((AxpalCheckedException)e).getErrorDetail());
        }
        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(),AxpalExceptionCodeConstants.SIL_EXCEPTION_CODE,
                this.getErrorDetail().getUuid(),this.getErrorDetail().getService(),
                this.getErrorDetail().getErrorMessage(),this.getErrorDetail(),this.getErrorDetail(),
                this.getStackTrace()[0]);
    }

    public DeleteException(Throwable e,String message,Object[] arguments,Class<?>service){
        super(e, new AxpalErrorDetail(AxpalExceptionCodeConstants.SIL_EXCEPTION_CODE,null,
                message,arguments,
                service.getSimpleName(),new Date()));

        if (e instanceof AxpalCheckedException){
            this.setErrorDetail(((AxpalCheckedException)e).getErrorDetail());
        }
        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(),AxpalExceptionCodeConstants.SIL_EXCEPTION_CODE,
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

