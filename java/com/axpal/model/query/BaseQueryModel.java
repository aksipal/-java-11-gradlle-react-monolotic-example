package com.axpal.model.query;

import com.axpal.data.AxpalPkInterface;
import com.axpal.model.AxpalBaseDtoModel;
import com.axpal.model.AxpalBaseModel;
import com.axpal.model.AxpalModel;
import com.axpal.model.BaseQueryDtoInterface;
import com.axpal.util.BaseUtils;

public class BaseQueryModel extends AxpalBaseModel implements BaseQueryDtoInterface {

    private Long id;
    private String ad;
    private String kod;

    private  Object info;

    public BaseQueryModel() {
    }

    public BaseQueryModel(Long id) {
        this.id = id;
    }

    public BaseQueryModel(AxpalPkInterface<Long> model) {
        if (model == null)
            return;
        this.id = model.getUniqueValue();
        this.ad = model.toString();
        this.kod = (String) BaseUtils.getObjectFieldValue(model,"kod");
    }
    public BaseQueryModel (AxpalBaseDtoModel model){
        if (model == null)
            return;
        this.id =model.getId();
        this.ad = model.getAd();
        this.kod = model.getKod();
        this.info = model.getInfo();
    }

    public BaseQueryModel (AxpalModel model){
        if (model == null)
            return;
        this.id =model.getId();
        this.ad = model.toString();
        this.kod =(String) BaseUtils.getObjectFieldValue(model,"kod");
    }

    public BaseQueryModel (AxpalBaseModel model){
        if (model == null)
            return;
        this.id =model.getId();
        this.ad = model.toString();
        this.kod =(String) BaseUtils.getObjectFieldValue(model,"kod");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    @Override
    public String getAd() {
        return ad;
    }

    @Override
    public void setAd(String ad) {
        this.ad = ad;
    }

    @Override
    public Object getInfo() {
        return info;
    }

    @Override
    public void setInfo(Object info) {
        this.info = info;
    }
}
