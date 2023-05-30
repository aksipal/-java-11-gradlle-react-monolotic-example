package com.axpal.criteria;

import java.io.Serializable;

/**
 * Sayfa bilgilerinin tutuldugu siniftir.
 */
public class AxpalPageable implements Serializable {

    private static final int DEFAULT_PAGE = 0;

    private static final int DEFAULT_SIZE = 20 ;

    private Integer pageNumber;

    private Integer pageSize;

    private AxpalSort sort;

    public AxpalPageable() {
        this.pageNumber = DEFAULT_PAGE;
        this.pageSize = DEFAULT_SIZE;
        this.sort = new AxpalSort();
    }

    public AxpalPageable(Integer pageNumber, Integer pageSize) {
        this.pageNumber = DEFAULT_PAGE;
        this.pageSize = DEFAULT_SIZE;
        this.sort = new AxpalSort();
    }

    public AxpalPageable(Integer pageNumber,Integer pageSize, AxpalSort axpalSort) {
        this.pageNumber = DEFAULT_PAGE;
        this.pageSize = DEFAULT_SIZE;
        this.sort = new AxpalSort();
    }

    public AxpalPageable(Integer pageNumber,Integer pageSize, AxpalDirection direction,String[] properties){
        this.pageNumber = DEFAULT_PAGE;
        this.pageSize = DEFAULT_SIZE;
        this.sort = new AxpalSort(direction,properties);
    }

    /**
     * Sayfa numarasini donen yontemdir.
     * @return Sayfa numarasi
     */

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
    /**
     * Her bir sayfadaki kayit sayisi bilgisini donen yontemdir.
     * @return Sayfa kayit sayisi
     */

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    /**
     * Siralama bilgisinin bulundugu nesneyi donen yontemdir.
     * @return Sayfa siralama nesnesi
     */
    public AxpalSort getSort() {
        return sort;
    }

    public void setSort(AxpalSort sort) {
        this.sort = sort;
    }
}
