package com.axpal.exception.model;
import com.axpal.constans.AxpalExceptionCodeConstants;
import com.axpal.exception.AxpalErrorDetail;
import com.axpal.exception.AxpalUncheckedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

//@FeignClientError
public class AxpalUtilException extends AxpalUncheckedException {

    private static final Logger LOGGER = LoggerFactory.getLogger(AxpalUtilException.class);

    private static final String EXCEPTION_LOG =
            "\n Time: {} \n Exception Code: {} \n Exception UUID: {} \n Exception Service: {} \n " +
                    "Exception Message: {} \n Error Detail: {} \n Root: {}";

    public AxpalUtilException() {
        this.setErrorDetail(new AxpalErrorDetail(
                AxpalExceptionCodeConstants.UTIL_EXCEPTION,
                null,
                "default.codedException"));

        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(), AxpalExceptionCodeConstants.UTIL_EXCEPTION,
                this.getErrorDetail().getUuid(), this.getErrorDetail().getService(),
                this.getErrorDetail().getErrorMessage(), this.getErrorDetail(),
                this.getStackTrace()[0]);
    }

    public AxpalUtilException(Throwable e, Class<?> service) {
        super(e,
                new AxpalErrorDetail(AxpalExceptionCodeConstants.UTIL_EXCEPTION, null, e.getMessage(), service.getSimpleName(),
                        new Date()));

        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(), AxpalExceptionCodeConstants.UTIL_EXCEPTION,
                this.getErrorDetail().getUuid(), this.getErrorDetail().getService(),
                this.getErrorDetail().getErrorMessage(), this.getErrorDetail(),
                this.getStackTrace()[0]);
    }

    public AxpalUtilException(Throwable e, String message, Class<?> service) {
        super(e,
                new AxpalErrorDetail(AxpalExceptionCodeConstants.UTIL_EXCEPTION, null, message, service.getSimpleName(),
                        new Date()));

        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(), AxpalExceptionCodeConstants.UTIL_EXCEPTION,
                this.getErrorDetail().getUuid(), this.getErrorDetail().getService(),
                this.getErrorDetail().getErrorMessage(), this.getErrorDetail(),
                this.getStackTrace()[0]);
    }

    public AxpalUtilException(Throwable e, String message,Object[] arguments, Class<?> service) {
        super(e,
                new AxpalErrorDetail(AxpalExceptionCodeConstants.UTIL_EXCEPTION, null, message,arguments, service.getSimpleName(),
                        new Date()));

        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(), AxpalExceptionCodeConstants.UTIL_EXCEPTION,
                this.getErrorDetail().getUuid(), this.getErrorDetail().getService(),
                this.getErrorDetail().getErrorMessage(), this.getErrorDetail(),
                this.getStackTrace()[0]);
    }

    public AxpalUtilException(String message,Object[] arguments, Class<?> service) {
        super(new AxpalErrorDetail(AxpalExceptionCodeConstants.UTIL_EXCEPTION, null, message,arguments, service.getSimpleName(),
                new Date()));

        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(), AxpalExceptionCodeConstants.UTIL_EXCEPTION,
                this.getErrorDetail().getUuid(), this.getErrorDetail().getService(),
                this.getErrorDetail().getErrorMessage(), this.getErrorDetail(),
                this.getStackTrace()[0]);
    }

    public AxpalUtilException(String message, Class<?> service) {
        super(new AxpalErrorDetail(AxpalExceptionCodeConstants.UTIL_EXCEPTION, null, message, service.getSimpleName(),
                new Date()));

        LOGGER.error(EXCEPTION_LOG, this.getErrorDetail().getTime(), AxpalExceptionCodeConstants.UTIL_EXCEPTION,
                this.getErrorDetail().getUuid(), this.getErrorDetail().getService(),
                this.getErrorDetail().getErrorMessage(), this.getErrorDetail(),
                this.getStackTrace()[0]);
    }


}
