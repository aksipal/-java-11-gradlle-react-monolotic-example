package com.axpal.exception;

import java.io.Serializable;

/**
 * Hata siniflari icin temel arayuzdur
 */
public interface AxpalException extends Serializable {

    /**
     * Hata detayini donen yontemdir.
     *
     * @return Hata detay nesnesi
     */
    AxpalErrorDetail getErrorDetail();

    /**
     * Hataya detay alanini vermektedir.
     *
     * @param errorDetail Hata detay nesnesi
     */
    void setErrorDetail(AxpalErrorDetail errorDetail);

}
