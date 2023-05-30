package com.axpal.converter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


import java.util.Map;
import java.util.TimeZone;

/**
 * Nesneler arasında donusum saglayan siniftir.
 * Donusum islemi yapilirken {@link ObjectMapper} sinifi kullanilmaktadir.
 * Bu yuzden donusum sirasinda 'JSON' formati kullanilmaktadir. Donusturulecek olan nesnelerde iliskiler tanimlanirken
 * {@link com.fasterxml.jackson.annotation.JsonIdentityInfo}
 * {@link com.fasterxml.jackson.annotation.JsonManagedReference}
 * {@link com.fasterxml.jackson.annotation.JsonBackReference}
 * gibi özelliklerden yararlanmasi gerekmektedir.
 *
 * @author Baksipal
 * @see ObjectMapper
 * @see com.fasterxml.jackson.annotation.JsonBackReference
 * @see com.fasterxml.jackson.annotation.JsonManagedReference
 * @see com.fasterxml.jackson.annotation.JsonIdentityInfo
 */


public class AxpalCommonConverter {

    private static final boolean DESERIALIZATION_FEATURE_STATE = false;

    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper().registerModule(new JavaTimeModule());
        OBJECT_MAPPER.setTimeZone(TimeZone.getDefault());
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,DESERIALIZATION_FEATURE_STATE);
        OBJECT_MAPPER.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    }

    private AxpalCommonConverter(){
    }

    /**
     * Nesnenin verilen sinif turune gore donusumunu yapan yontemdir.
     *
     * @param from Kaynak nesne
     * @param clazz Hedef sinif
     * @param <TO> Generik tur
     * @return TO Hedef sinif turunden nesne
     */

    public static <TO> TO convert (Object from,Class<TO> clazz){return OBJECT_MAPPER.convertValue(from,clazz);}
    /**
     * Nesnenin verilen {@link java.util.Collection} sinifi turune donusumunu yapan yontemdir.
     *
     * @param from Kaynak nesne
     * @param typeReference Hedef {@link java.util.Collection} turunden sinif
     * @param <TO> Generik tur
     * @return TO Hedef turunden nesne
     */

    public static <TO> TO convert (Object from, TypeReference<TO> typeReference){
        return OBJECT_MAPPER.convertValue(from, typeReference);
    }
    /**
     * Nesnenin verilen sinif turune donusumunu yapan yontemdir. Bu yontemin {@link #convert(Object, Class)}
     * yonteminden farki gelistirici kendi {@link ObjectMapper} nesnesini verebilmesidir.
     *
     * @param mapper {@link ObjectMapper} nesnesi
     * @param from Kaynak nesne
     * @param clazz Hedef sinif
     * @param <TO> Generik tur
     * @return TO Hedef sinif turunden nesne
     */
    public static <TO> TO convert (ObjectMapper mapper, Object from, Class<TO> clazz){
        return mapper.convertValue(from,clazz);
    }

    /**
     * Nesnenin verilen sinif donusumunu uapan yontemdir.
     * @param from Kaynak nesne
     * @param clazz Hedef sinif
     * @param <TO> Generik tur
     * @return TO hedef sinif turunden nesne
     */
    public static <TO> TO convert (Map<String,Object> from, Class<TO> clazz){
        return OBJECT_MAPPER.convertValue(from,clazz);
    }
    /**
     * Nesnelerin verilen sinif turune gore donusumunu yapan yontemdir.
     *
     * @param from Kaynak nesne
     * @param typeReference Hedef {@link java.util.Collection} turunden sinif
     * @param <TO> Generik Tur
     * return TO Hedef turunden nesne
     */
    public static <TO> TO convert (Map<String,Object> from, TypeReference<TO> typeReference){
        return OBJECT_MAPPER.convertValue(from,typeReference);
    }

    /**
     * Nesnenin verilen sinif turune donusumunu yapan yontemdir.Bu yontemin {@link  #convert(Map,Class)}
     * yonteminden farki gelistirici kendi {@link ObjectMapper} nesnesini verebilmektedir.
     *
     * @param mapper {@link ObjectMapper} nesnesi
     * @param from Kaynak nesne
     * @param clazz Hedef sinif
     * @param <TO> Generik tur
     * @return TO Hedef sinif turunden nesne
     */
    public static <TO> TO convert (ObjectMapper mapper, Map<String,Object>from,Class<TO>clazz){
        return mapper.convertValue(from,clazz);
    }

    /**
     *
     *'JSON' verisinin verilen sinif turune donusumunu yapan yontemdir.
     *
     * @param from Kaynak nesne
     * @param clazz Hedef sinif
     * @param <TO> Generik tur
     * @return TO Hedef sinif turunden nesne
     */
    public static <TO> TO convert (String from,Class<TO>clazz){
        return OBJECT_MAPPER.convertValue(from,clazz);}

    /**
     *
     *'JSON' verisinin verilen {@link java.util.Collection)} sinifi turune donusumu yapan yontemdir.
     *
     * @param from Kaynak nesne
     * @param typeReference Hedef {@link java.util.Collection}turunden sinif
     * @param <TO> Generik tur
     * @return TO Hedef sinif turunden nesne
     */
    public static <TO> TO convert (String from,TypeReference<TO>typeReference){
        return OBJECT_MAPPER.convertValue(from,typeReference);}

    /**
     *
     *'JSON' verisinin verilen sinif turune donusumunu yapan yontemdir.Bu yontemin {@link #convert(String, Class)}
     * yonteminden farki gelistirici kendi {@link ObjectMapper}nesnesini verebilmektedir.
     *
     * @param mapper {@link ObjectMapper} nesnesi
     * @param from Kaynak nesne
     * @param clazz Hedef sinif
     * @param <TO> Generik tur
     * @return TO Hedef sinif turunden nesne
     */
    public static <TO> TO convert (ObjectMapper mapper,String from,Class<TO>clazz){
        return mapper.convertValue(from,clazz);}
}
