package com.axpal.model;

import com.axpal.util.BaseUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class AxpalBaseModel extends AxpalModel implements AxpalNesneInterface{

    @NotNull
    private EnumVeriKaynak veriKaynak = EnumVeriKaynak.KULLANICI;

    private String nesneAd;

    private String nesneTanim;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AxpalBaseModel that = (AxpalBaseModel) o;
        if (that.getId() == null && that.getUuid() != null){
            return Objects.equals(that.getUuid(),this.getUuid());
        }else {
            return Objects.equals(that.getId(), this.getId());
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),this.getId());
    }

    public String getNesneAd(){
        if (BaseUtils.isEmpty(nesneAd)){
            nesneAd = this.getClass().getSimpleName();
        }
        return nesneAd;
    }

    @Override
    public Long getNesneId() {
        return getId();
    }
    public void setNesneAd(String nesneAd) {
        this.nesneAd = nesneAd;
    }
    public String getNesneTanim() {
        return nesneTanim;
    }
    public void setNesneTanim(String nesneTanim) {
        this.nesneTanim = nesneTanim;
    }
    @JsonIgnore
    public String getEtiketAd(){return toString();}

    public EnumVeriKaynak getVeriKaynak() {
        return veriKaynak;
    }

    public void setVeriKaynak(EnumVeriKaynak veriKaynak) {
        this.veriKaynak = veriKaynak;
    }

}
