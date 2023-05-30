package com.axpal.model;

import com.axpal.data.AxpalPkInterface;
import com.axpal.util.BaseUtils;

public class AxpalBaseDtoModel extends AxpalModel implements BaseQueryDtoInterface{

    private Long id;
    private String ad;
    private String kod;

    private Object info;

    private Object extra;

    public AxpalBaseDtoModel() {
    }

    public AxpalBaseDtoModel(AxpalPkInterface<Long> model) {
        this.id = model.getUniqueValue();
        this.ad = model.toString();
        this.kod = (String) BaseUtils.getObjectFieldValue(model,"kod");
    }

    public AxpalBaseDtoModel(AxpalModel model) {
        this.id = model.getId();
        this.ad = model.toString();
        this.kod = (String) BaseUtils.getObjectFieldValue(model,"kod");
    }

    public AxpalBaseDtoModel(AxpalBaseModel model) {
        this.id = model.getId();
        this.ad = model.toString();
        this.kod = (String) BaseUtils.getObjectFieldValue(model,"kod");
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getAd() {
        return ad;
    }

    @Override
    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    @Override
    public Object getInfo() {
        return info;
    }

    @Override
    public void setInfo(Object info) {
        this.info = info;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }
}
