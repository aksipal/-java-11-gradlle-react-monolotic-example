package com.axpal.exception;

/**
 * Ele alinmasi zorunlu tutmak istedigimiz hatalarin turemesi gereken temel hata sinifidir.
 *
 * @author Baksipal
 */
public class AxpalCheckedException extends Exception implements AxpalException {

    private AxpalErrorDetail errorDetail;

    public AxpalCheckedException() {
    }

    public AxpalCheckedException(AxpalErrorDetail errorDetail) {
        super(errorDetail.getErrorMessage());
        this.errorDetail = errorDetail;
    }

    public AxpalCheckedException(String message, AxpalErrorDetail errorDetail) {
        super(message);
        this.errorDetail = errorDetail;
    }

    public AxpalCheckedException(String message, Throwable cause, AxpalErrorDetail errorDetail) {
        super(message, cause);
        this.errorDetail = errorDetail;
    }


    public AxpalCheckedException(Throwable cause, AxpalErrorDetail errorDetail) {
        super(errorDetail.getErrorMessage(), cause);
        this.errorDetail = errorDetail;
    }

    public AxpalCheckedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, AxpalErrorDetail errorDetail) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorDetail = errorDetail;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AxpalErrorDetail getErrorDetail() {
        return errorDetail;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setErrorDetail(AxpalErrorDetail errorDetail) {
        this.errorDetail = errorDetail;
    }
}
