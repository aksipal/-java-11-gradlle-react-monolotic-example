package com.axpal.exception;

/**
 * Ele alinmasini zorunlu tutmak istedigimiz hatalarin turemesi gerek temel hata sinifidir.
 */
public class AxpalUncheckedException extends RuntimeException implements AxpalException{

    private AxpalErrorDetail errorDetail;

    public AxpalUncheckedException() {
    }

    public AxpalUncheckedException(AxpalErrorDetail errorDetail) {
        super(errorDetail.getErrorMessage());
        this.errorDetail = errorDetail;
    }

    public AxpalUncheckedException(String message, AxpalErrorDetail errorDetail) {
        super(message);
        this.errorDetail = errorDetail;
    }

    public AxpalUncheckedException(String message, Throwable cause, AxpalErrorDetail errorDetail) {
        super(message, cause);
        this.errorDetail = errorDetail;
    }

    public AxpalUncheckedException(Throwable cause, AxpalErrorDetail errorDetail) {
        super(errorDetail.getErrorMessage(),cause);
        this.errorDetail = errorDetail;
    }

    public AxpalUncheckedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, AxpalErrorDetail errorDetail) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorDetail = errorDetail;
    }

    @Override
    public AxpalErrorDetail getErrorDetail() {
        return errorDetail;
    }

    @Override
    public void setErrorDetail(AxpalErrorDetail errorDetail) {
        this.errorDetail = errorDetail;
    }
}
