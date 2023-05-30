package com.axpal.criteria;

import java.io.Serializable;
import java.util.List;

public class AxpalPage<D> implements Serializable {

    private List<D> data;

    private Long totalElements;

    private Integer totalPage;

    private AxpalPageable pageable;

    public AxpalPage() {
    }

    public AxpalPage(List<D> data, Long totalElements, Integer totalPage) {
        this.data = data;
        this.totalElements = totalElements;
        this.totalPage = totalPage;
    }

    public AxpalPage(List<D> data, Long totalElements, Integer totalPage, AxpalPageable pageable) {
        this.data = data;
        this.totalElements = totalElements;
        this.totalPage = totalPage;
        this.pageable = pageable;
    }

    /**
     * Sorgulama sonucunda sayfada bulunan veriyi donen yontemdir.
     *
     * @return Veri Listesi
     */
    public List<D> getData() {
        return data;
    }

    public void setData(List<D> data) {
        this.data = data;
    }
    /**
     * Sorgulama sonucunda toplam kayit sayisini donen yontemdir.
     *
     * @return Toplam kayit sayisi
     */
    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    /**
     * Sorgulama sonucunda toplam sayfa sayisini donen yontemdir.
     *
     * @return Toplam sayfa sayisi
     */

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
    /**
     * Sayfa bilgisinin bulundugu nesneyi donen yontemdir.
     *
     * @return EczaPageable Sayfa nesnesi
     */
    public AxpalPageable getPageable() {
        return pageable;
    }

    public void setPageable(AxpalPageable pageable) {
        this.pageable = pageable;
    }
}
