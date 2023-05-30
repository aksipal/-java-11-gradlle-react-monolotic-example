package com.axpal.exception;
import com.axpal.annotations.AxpalFeignClientError;
import com.axpal.constans.AxpalExceptionCodeConstants;
import com.axpal.util.BaseUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@AxpalFeignClientError
public class SingleRecordError extends AxpalCheckedException {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingleRecordError.class);
    private static final String EXCEPTION_LOG = "\n Time: {} \n Exception Code: {} \n Exception UUID: {} ," +
            "Exception Service: {} \n Exception Message {} \n  Error Detail: {} \n Root: {}";

    private EnumExceptionTur enumExceptionTur;

    public SingleRecordError(){
        this.setErrorDetail(new AxpalErrorDetail(AxpalExceptionCodeConstants.TEKIL_KAYIT_EXCEPTION_CODE));
    }

    public <T extends UniqueConstraintsBundleEnumeration> SingleRecordError(Throwable constraintExcepiton,
                                                                              Class<T>enumClass,
                                                                              Class<?>service){
        super(constraintExcepiton,new AxpalErrorDetail(AxpalExceptionCodeConstants.TEKIL_KAYIT_EXCEPTION_CODE,
                null,
                null,
                service.getSimpleName(),
                new Date()));
        Throwable cause = constraintExcepiton.getCause();
        ConstraintViolationException cve = (ConstraintViolationException) cause;
        String key = cve.getConstraintName();

        String errorLabel = null;
        for(T enumConstant : enumClass.getEnumConstants()){
            if (StringUtils.equalsIgnoreCase(enumConstant.toString(),key)){
                errorLabel = enumConstant.label();
            }
        }
        if (BaseUtils.isEmpty(errorLabel)){
            Optional<T> any = Arrays.stream(enumClass.getEnumConstants()).filter(e -> e.toString().toUpperCase().contains(key.toUpperCase())).findAny();
            if (any.isPresent()){
                errorLabel = any.get().label();
            }
            else if (key.toUpperCase().endsWith("KOD_IDX")){
                errorLabel = "ecza_uidx_kod_hata";
            }
            else if (key.toUpperCase().endsWith("AD_IDX")){
                errorLabel =  "ecza_uidx_ad_hata";
            }
            else {
                errorLabel = "ecza_uidx_hata";
            }
        }

        this.getErrorDetail().setErrorMessage(errorLabel);
        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(),AxpalExceptionCodeConstants.TEKIL_KAYIT_EXCEPTION_CODE,
                this.getErrorDetail().getUuid(),this.getErrorDetail().getService(),
                this.getErrorDetail().getErrorMessage(),this.getErrorDetail(),this.getErrorDetail(),
                this.getStackTrace()[0]);
    }

    public SingleRecordError(String message,Class<?>service){
        super(new AxpalErrorDetail(AxpalExceptionCodeConstants.TEKIL_KAYIT_EXCEPTION_CODE,null,message,
                service.getSimpleName(),new Date()));

        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(),AxpalExceptionCodeConstants.TEKIL_KAYIT_EXCEPTION_CODE,
                this.getErrorDetail().getUuid(),this.getErrorDetail().getService(),
                this.getErrorDetail().getErrorMessage(),this.getErrorDetail(),this.getErrorDetail(),
                this.getStackTrace()[0]);
    }

    public SingleRecordError(Throwable e,String message,Class<?>service){
        super(e, new AxpalErrorDetail(AxpalExceptionCodeConstants.TEKIL_KAYIT_EXCEPTION_CODE,e.getMessage(),message,
                service.getSimpleName(),new Date()));

        if (e instanceof AxpalCheckedException){
            this.setErrorDetail(((AxpalCheckedException)e).getErrorDetail());
        }
        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(),AxpalExceptionCodeConstants.TEKIL_KAYIT_EXCEPTION_CODE,
                this.getErrorDetail().getUuid(),this.getErrorDetail().getService(),
                this.getErrorDetail().getErrorMessage(),this.getErrorDetail(),this.getErrorDetail(),
                this.getStackTrace()[0]);
    }

    public SingleRecordError(Throwable e,String message,Object[] arguments,Class<?>service){
        super(e, new AxpalErrorDetail(AxpalExceptionCodeConstants.TEKIL_KAYIT_EXCEPTION_CODE,e.getMessage(),message,arguments,
                service.getSimpleName(),new Date()));

        if (e instanceof AxpalCheckedException){
            this.setErrorDetail(((AxpalCheckedException)e).getErrorDetail());
        }
        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(),AxpalExceptionCodeConstants.TEKIL_KAYIT_EXCEPTION_CODE,
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


