package com.axpal.model;

import com.axpal.converter.AxpalEnumerationConverter;
import com.axpal.core.AxpalEnumeration;

import java.util.Objects;

public enum EnumVeriKaynak implements AxpalEnumeration, AxpalEnumerationConverter<Integer> {

    KULLANICI(0,"veriKaynagi_kullanici"),
    DIS_ENTEGRASYON(1,"veriKaynagi_disEntegrasyom"),
    VERI_TRANSFERI(2,"veriKaynagi_veriTransferi"),
    AKTARIM(3,"veriKaynagi_aktarim");

    private final int code;
    private final String label;

    EnumVeriKaynak(int code, String label) {
        this.code = code;
        this.label = label;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String label() {
        return label;
    }

    @Override
    public Integer toDbValue() {
        return code;
    }

    public static EnumVeriKaynak fromDbValue(int code){
        for (EnumVeriKaynak tip : values()){
            if (Objects.equals(tip.code(),code)){
                return tip;
            }
        }
        throw new IllegalArgumentException(code + "type is invalid type " + EnumVeriKaynak.class.getName());
    }
}
