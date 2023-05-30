package com.axpal.model.query;
import com.axpal.criteria.AxpalPageable;

import java.io.Serializable;
import java.util.Map;

/**
 * Sorgulama icin kullanilacak olan parametrelerin tasinmasini saglayan temel transfer nesnesidir.
 */
public class AxpalQueryModel implements Serializable {

    private AxpalPageable pageable;

    private Map<String,Object> filters;

    public AxpalQueryModel() {
        this.pageable = new AxpalPageable();
    }

    public AxpalQueryModel(AxpalPageable pageable) {
        this.pageable = pageable;
    }

    public AxpalQueryModel(Map<String,Object> filters) {
        this.filters = filters;
    }
    public AxpalQueryModel(AxpalPageable pageable,Map<String,Object> filters) {
        this.pageable = pageable;
        this.filters = filters;
    }

    /**
     * Sayfalama bilgisini donen yontemdir
     *
     * @return EczaPagable Sayfalama nesnesi
     */
    public AxpalPageable getPageable() {
        return pageable;
    }

    public void setPageable(AxpalPageable pageable) {
        this.pageable = pageable;
    }

    /**
     * Sorguda kullanilan filtreyi donen yontemdir.
     *
     * @return Filtreler
     */
    public Map<String, Object> getFilters() {
        return filters;
    }

    public void setFilters(Map<String, Object> filters) {
        this.filters = filters;
    }
}
