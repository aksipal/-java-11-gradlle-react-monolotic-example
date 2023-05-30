package com.axpal.converter;
/**
 * Veritabani(Entity) siniflarinda kullanilan {@link java.util.Enumeration} alanlarinin veritabani islemlerinde donusumunu saglayan siniftir.
 * {@link javax.persistence.Convert} annotation ile tanimlanmaktadir.
 *
 * @param <DV> Generik sinif
 */
public interface AxpalEnumerationConverter<DV> {
    /**
     * Donusum sonucunu donen yontemdir.
     *
     * @return DV Veritabani generik nesnesi
     */
    DV toDbValue();
}
