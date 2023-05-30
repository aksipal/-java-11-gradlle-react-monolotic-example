package com.axpal.exception;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Hata icerigini detayli olarak tutalmasini saglayan siniftir.
 *
 */
public class AxpalErrorDetail implements Serializable {

    private String uuid;

    private String errorClassName;

    private String errorCode;

    private String errorDetail;

    private String errorMessage;

    private Object[] errorArguments;

    private String service;

    private Date time;

    public AxpalErrorDetail() {
        this.uuid = String.valueOf(UUID.randomUUID());
    }

    public AxpalErrorDetail(String errorCode){
        this();
        this.errorCode = errorCode;
    }

    public AxpalErrorDetail(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public AxpalErrorDetail(String errorCode, String errorMessage, Object[] errorArguments) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorArguments = errorArguments;
    }

    public AxpalErrorDetail(String errorCode, String errorDetail, String errorMessage) {
        this.errorCode = errorCode;
        this.errorDetail = errorDetail;
        this.errorMessage = errorMessage;
    }

    public AxpalErrorDetail(String errorCode, String errorDetail, String errorMessage, Object[] errorArguments) {
        this.errorCode = errorCode;
        this.errorDetail = errorDetail;
        this.errorMessage = errorMessage;
        this.errorArguments = errorArguments;
    }

    public AxpalErrorDetail(String errorCode, String errorDetail, String errorMessage, String service, Date time) {
        this.errorCode = errorCode;
        this.errorDetail = errorDetail;
        this.errorMessage = errorMessage;
        this.service = service;
        this.time = time;
    }

    public AxpalErrorDetail(String errorCode, String errorDetail, String errorMessage, Object[] errorArguments, String service, Date time) {
        this.errorCode = errorCode;
        this.errorDetail = errorDetail;
        this.errorMessage = errorMessage;
        this.errorArguments = errorArguments;
        this.service = service;
        this.time = time;
    }
    /**
     * Hatanin essiz belitecini donen yontemdir.
     *
     * @return Hata belirteci
     */
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Hatanin sinif ismini donen yontemdir.
     *
     * @return Hata sinif ismi
     */
    public String getErrorClassName() {
        return errorClassName;
    }

    public void setErrorClassName(String errorClassName) {
        this.errorClassName = errorClassName;
    }
    /**
     * Hatanin essiz kod bilgisini donen yontemdir.
     *
     * @return Hata kodu
     */
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    /**
     * Hatanin icerigini donen yontemdir.
     *
     * @return Hata icerigi
     */
    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }
    /**
     * Hatanin mesajini donen yontemdir.
     *
     * @return Hata mesaji
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    /**
     * Hatanin ile kullanilacak olan argumanlari donen yontemdir.
     *
     * @return Hata argumanlari
     */
    public Object[] getErrorArguments() {
        return errorArguments;
    }

    public void setErrorArguments(Object[] errorArguments) {
        this.errorArguments = errorArguments;
    }
    /**
     * Hatanin icin kullanilacak servis bilgisini donen yontemdir.
     *
     * @return Servis ismi
     */
    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
    /**
     * Hatanin meydana geldigi zamani donen yontemdir.
     *
     * @return Tarih bilgisi
     */
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
