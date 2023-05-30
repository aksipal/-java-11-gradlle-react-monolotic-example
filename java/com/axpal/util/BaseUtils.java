package com.axpal.util;

import com.axpal.core.AxpalEnumeration;
import com.axpal.data.AxpalPkInterface;
import com.axpal.entity.AxpalEntity;
import com.axpal.model.AxpalModel;
import com.axpal.model.query.BaseQueryModel;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.util.StringUtils;


import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BaseUtils {

    public static final Locale LOCALE_TR = new Locale("tr","TR");
    public static final BigDecimal TOPLAM_SAYI_MAX = new BigDecimal(100);

    private BaseUtils(){
    }

    /**
     * Verilen String degeri null veya bos ise <code>true<code/>, degilse <code>false<code/> dondurur.
     */
    public static boolean isEmpty(String x){return (x == null || x.trim().equals(""));}

    public static boolean isEmpty(Object x){return (x == null || x.equals(""));}

    /**
     * Verilen String degeri null ise <code>true<code/>, degilse <code>false<code/> dondurur.
     */
    public static boolean isEmpty(Boolean x){return (x == null);}


    /**
     * Verilen String degeri null veya bos ise <code>true<code/>, degilse <code>false<code/> dondurur.
     */
    public static boolean isEmpty(Integer x){return (x == null || x == 0);}


    /**
     * Verilen Long degeri null veya bos ise <code>true<code/>, degilse <code>false<code/> dondurur.
     */
    public static boolean isEmpty(Long x){return (x == null || x == 0);}

    public static boolean isNotEmpty(Long x){return ! isEmpty(x);}


    /**
     * Verilen Number degeri null veya bos ise <code>true<code/>, degilse <code>false<code/> dondurur.
     */
    public static boolean isEmpty(Number x)
    {return (x == null ||x.intValue() == 0 || x.longValue() == 0 || x.doubleValue() == 0 || x.floatValue() == 0 ||
            x.shortValue() == 0 || x.byteValue() == 0);}

    /**
     * Verilen Collection degeri null veya bos ise <code>true<code/>, degilse <code>false<code/> dondurur.
     */
    public static boolean isEmpty(Collection<?> x){return (x == null || x.isEmpty());}

    public static boolean isNotEmpty(Collection<?> x){return (x != null && !x.isEmpty());}


    /**
     * Verilen Collection degeri null ise <code>true<code/>, degilse <code>false<code/> dondurur.
     */
    public static boolean isNull(Collection<?> x){return (x == null);}

    /**
     * Verilen Iterable degeri null veya bos ise <code>true<code/>, degilse <code>false<code/> dondurur.
     */
    public static boolean isEmpty(Iterable<?> x){return (x == null || !x.iterator().hasNext());}

    /**
     * Verilen Map degeri null veya bos ise <code>true<code/>, degilse <code>false<code/> dondurur.
     */
    public static boolean isEmpty(Map<?, ?> x){return (x == null || x.size() == 0);}

    /**
     * Verilen array degeri null veya bos ise <code>true<code/>, degilse <code>false<code/> dondurur.
     */
    public static boolean isEmpty(Object[] x){return (x == null || x.length == 0);}

    /**
     * Verilen array degeri null veya bos ise <code>true<code/>, degilse <code>false<code/> dondurur.
     */
    public static boolean isEmpty(BigDecimal x){return (x == null || x.compareTo(BigDecimal.ZERO) == 0);}

    /**
     * Verilen Date degeri null ise <code>true<code/>, degilse <code>false<code/> dondurur.
     */
    public static boolean isEmpty(Date x){return (x == null);}

    /**
     * Verilen Enum degeri bilinmeyen kullanim durumuna gore kontrol eder.
     * Bilinmeyen yoksa ve null ise <code>true<code/>, degilse <code>false<code/> dondurur.
     * Bilinmeyen varsa ve null ise veya code = 0 ise <code>true<code/>, degilse <code>false<code/> dondurur.
     */
    public static <T extends AxpalEnumeration> boolean isEmpty(T x, Boolean bilinmeyenYok){
        if (isFalse(bilinmeyenYok)){
            return x == null;
        }else {
            return x == null || x.code() == 0;
        }
    }

    public static <T extends AxpalEnumeration> boolean isEmpty(T x){return isEmpty(x,true);}


    /**
     * Verilen Collection degeri null degil ve verilen size a esit ise <code>true<code/>, degilse <code>false<code/> dondurur.
     */
    public static boolean checkSize(Collection<?> x, int size){return (x != null && x.size() == size);}

    /**
     * Verilen Map degeri null degil ve verilen size a esit ise <code>true<code/>, degilse <code>false<code/> dondurur.
     */
    public static boolean checkSize(Map<?,?> x, int size){return (x != null && x.size() == size);}


    /**
     * Verilen Array degeri null degil ve verilen size a esit ise <code>true<code/>, degilse <code>false<code/> dondurur.
     */
    public static boolean checkSize(Object[] x, int size){return (x != null && x.length == size);}

    /**
     * Verilen Collection parametresi null degil ve verilen size'lardan birine esit ise <code>true<code/>,
     * degilse <code>false<code/> dondurur.
     */
    public static boolean checkSize(Collection<?> x, Integer... size){
        return (x != null && asSet(size).contains(x.size()));}


    /**
     * Verilen Map parametresi null degil ve verilen size'lardan birine esit ise <code>true<code/>,
     * degilse <code>false<code/> dondurur.
     */
    public static boolean checkSize(Map<?,?> x, Integer... size){
        return (x != null && asSet(size).contains(x.size()));}

    /**
     * Verilen Array parametresi null degil ve verilen size'lardan birine esit ise <code>true<code/>,
     * degilse <code>false<code/> dondurur.
     */
    public static boolean checkSize(Object[] x, Integer... size){
        return (x != null && asSet(size).contains(x.length));
    }

    public static <T>Set<T> asSet(T... a){
        Set<T> retVal = new HashSet<>(a.length);
        Collections.addAll(retVal, a);
        return retVal;
    }

    /**
     * Herhangi bir List<> icerisinde stream api ile distinct olarak filtreleme yapmak icin
     * Ör: birimList.stream().filter(BaseUtils.distinctByKey(IlacTanimModel::getIlacNo)).collect(Collectors.toList());
     * @param keyExtractor
     * @param <T>
     * @return
     */
    public static <T>Predicate<T> distinctByKey(Function<? super  T,?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t),Boolean.TRUE) == null;
    }

    /**
     * Verilen enumArrayinde search enum var mı ?
     */
    public static <T extends AxpalEnumeration> boolean contains(T searchEnum, T... enumValues){
        if (BaseUtils.isEmpty(enumValues))
            return false;
        for (T val : enumValues)
            if (searchEnum == val)
                return true;
        return false;
    }

    /**
     * Verilen boolean parametresi null degil ve true ise <code>true</code> doner
     */
    public static boolean isTrue(Boolean b){return b != null && b;}


    /**
     * Verilen boolean parametresi null degil ve false ise <code>false</code> doner
     */
    public static boolean isFalse(Boolean b){return b != null && b;}

    /**
     * Verilen string degeri bos degilse butun bosluklari siler islemi gerceklestirir.
     */
    public static String trimAllWhiteSpaces(String stringValue){
        return isEmpty(stringValue)? null : StringUtils.trimAllWhitespace(stringValue);
    }

    /**
     * Verilen string degeri bos degilse stringin basindaki ve sonundaki bosluklari siler islemi gerceklestirir.
     */
    public static String trim(String stringValue){
        return isEmpty(stringValue)? null : StringUtils.trimWhitespace(stringValue);
    }

    /**
     * Verilen string degeri verilen maxLen degerine kadar alinir sonuna "..." eklenir.
     *
     * Ornek: subString("123154512",5) -> "12...."
     */
    public static String subString(String string, int maxLen){
        if (string ==null)
            return null;
        return string.length() <= maxLen ? string : (string.substring(0,maxLen -3) + "...");
    }

    /**
     * Verilen string degeri verilen maxLen degerine kadar alinir.
     *
     * Ornek: subString("123154512",5) -> "12315"
     */
    public static String subString2(String string, int maxLen){
        if (string ==null)
            return null;
        return string.length() <= maxLen ? string : string.substring(0,maxLen);
    }

    /**
     * Icindeki I, ı ve İ karekterini i yaptiktan sonra toLowerCase metodunu cagirir.
     */
    public static String trLowerCase(String x){
        return x == null ? null : x.replace('I','i').replace('İ','i').
                replace('ı','i').toLowerCase();
    }

    /**
     * <b>Buyuk</b> turkce karekterlerini <b>kucuk</b> turkce karekterlere cevirir.
     */
    public static String replaceTurkishChars(String s){
        if (s == null)
            return s;
        return s.replace('Ç','ç').replace('Ğ','ğ').replace('İ','i').replace('I','ı')
                .replace('Ö','ö').replace('Ş','ş').replace('Ü','ü');
    }

    /**
     * Verilen nesneyi string degerine cevirir.
     */
    public static synchronized String obj2Str(Object o, String nullVal, Obj2StrEnum type) {
        if (o == null) {
            return nullVal;
        } else if (type != null) {
            Date date = (Date) o;
            Instant instant = date.toInstant();
            LocalDateTime ldt = instant.atOffset(ZoneOffset.UTC).toLocalDateTime();
            if (type == Obj2StrEnum.DATE_MINUTE) {
                return ldt.format(DateUtils.TR_DATETIME_FORMAT);
            } else if (type == Obj2StrEnum.DATE_SECOND) {
                return ldt.format(DateUtils.TR_DATETIME_SECOND_FORMAT);
            } else if (type == Obj2StrEnum.HOUR_MIN) {
                return ldt.format(DateUtils.HOUR_MIN_FORMAT);
            } else if (type == Obj2StrEnum.HOUR_MIN_SEC) {
                return ldt.format(DateUtils.HOUR_MIN_SEC_FORMAT);
            }

        } else if (o instanceof AxpalEnumeration) {
            return ((AxpalEnumeration) o).label();
        } else if (o instanceof Date) {
            return DateUtils.date2Str((Date) o);
        } else if (o instanceof Boolean) {
            if (isTrue((Boolean) o)) {
                return "Evet";
            } else {
                return "Hayir";
            }
        }
        return o.toString();
    }

    /**
     * Verilen obje null olmasi kosulunda <code>nullVall</code> degerini doner.
     * Degilse enum,date,boolean veya bigDecimal icin default deger doner.
     */
    public static String obj2Str(Object o, String nullVal){return obj2Str(o,nullVal,null);}

    /**
     * Null ise "-" doner.
     */
    public static String obj2Str(Object o){return obj2Str(o,"-");}

    public static String obj2Str(Object o, Obj2StrEnum type){return obj2Str(o,"-",type);}

    public static String generateString(int length){
        if (length > 0){
            int numBits = (int) (Math.floor(length * Math.log(36) / Math.log(2)));
            return new BigInteger(numBits,new SecureRandom()).toString(36);
        }
        return null;
    }

    public static boolean equals(Object a, Object b){
        if (a == null && b == null)
            return true;
        if (a == null)
            return false;
        return a.equals(b);
    }

    public static <T> int compareTo(Comparable<T> a, Comparable<T> b){
        if (a == null && b == null)
            return 0;
        if (a == null)
            return -1;
        return a.compareTo((T)b);
    }

    public static String boslukKontrol(String sCumle, String sAraCumle){
        StringBuilder builder = new StringBuilder(sCumle);
        if (!BaseUtils.isEmpty(sCumle))
            builder.append(sAraCumle).append(" ");
        return builder.toString();
    }

    public static boolean boslukVarMi(String s){return StringUtils.containsWhitespace(s);}

    public static boolean sayiVarMi(String s) throws Exception{
        if (BaseUtils.isEmpty(s)){
            throw new Exception(s);
        }
        return s.matches("[0-9]+");
    }

    public static boolean toplamSayiKontrol(List<BigDecimal> list, BigDecimal max){
        BigDecimal toplam = BigDecimal.ZERO;
        if (isEmpty(list)){
            return true;
        }
        if (isEmpty(max)){
            max = TOPLAM_SAYI_MAX;
        }
        for (BigDecimal sayi : list){
            if (!isEmpty(sayi)){
                toplam = toplam.add(sayi);
            }
            if (toplam.compareTo(max)> 0){
                return false;
            }
        }
        return true;
    }

    /**
     * .asd || asd. || . || .asd. ---> null
     * asd.fgh ---> fgh
     */

    public static String getFileExtensionName(String fileName){
        if (BaseUtils.isEmpty(fileName))
            return null;
        int idx = fileName.lastIndexOf('.');
        if (idx < 0 || BaseUtils.compareTo(idx, fileName.length() -1) == 0)
            return null;
        return fileName.substring(idx + 1);
    }

    public static boolean isObjectHasField(Object object, String filedName){
        return Arrays.stream(object.getClass().getDeclaredFields()).anyMatch(f -> f.getName().equals(filedName));
    }

    public static Object getObjectFieldValue(Object object, String filedName){
        Field field = null;
        Object result = null;

        if (!isObjectHasField(object, filedName))
            return result;
        try {
            field = object.getClass().getDeclaredField(filedName);
            field.setAccessible(true);
            result = field.get(object);
        }catch (NoSuchFieldException | IllegalAccessException e){

        }
        return result;
    }

    /**
     * Virgulle ayrilmis paremetreleri obje arrayi olarak doner
     */
    public static Object[] createObjectArray(Object... o){return o.clone();}

    public static List<Object> arrayToList(Object... o)throws Exception{
        if (!isEmpty(o)){
            ArrayList<Object> list = new ArrayList<>(o.length);
            Collections.addAll(list,o);
            return list;
        }else {
            throw new Exception();
        }
    }

    public static <T extends AxpalModel> boolean isModelNull(T model){return (model == null);}

    public static <T extends AxpalPkInterface<?>> boolean isModelNull(T model){
        return (model == null);
    }

    /**
     * Verilen modelin ve ID'sinin null kontrolu yapilir.
     */

    public static <T extends AxpalModel> boolean isModelIdNotNull(T model){
        return (model == null && model.getId() != null);
    }

    public static <T extends AxpalEntity> boolean isEntityIdNotNull(T entity){
        return (entity == null && entity.getId() != null);
    }

    public static <T extends AxpalPkInterface<?>> boolean isModelIdNotNull(T model){
        return (model == null && model.getUniqueValue() != null);
    }

    public static <T extends BaseQueryModel> boolean isModelIdNotNull(T model){
        return (model == null && model.getId() != null);
    }

    /**
     * Verilen modelin ve UUID'sinin null kontrolu yapilir.
     */
    public static <T extends AxpalModel> boolean isModelUuidIdNotNull(T model){
        return (model == null && model.getUuid() != null);
    }

    public static <T extends AxpalModel> boolean isModelIdEquals(T a, T b){
        return (isModelIdNotNull(a) && isModelIdNotNull(b) && a.getId().equals(b.getId()));
    }

    /**
     * Verilen Modelin ve istenilen propertysinin null olama durumunu kontrol eder
     * @param model
     * @param propertyName kontrol edilecek ozellik
     * @param <T>
     * @return
     */
    public static <T extends AxpalModel> boolean isPropertyNull(T model, String propertyName){
        Object property = ReflectionUtils.getProperty(model,propertyName);
        return (model != null && property != null);
    }

    /**
     * Bir modelin sadece kendi alanlarini clonlamak icin kullanilir. EczaModelden gelen (ID haric) alanlari clonlar.
     * @param from clon obje
     * @param clazz clon obje sinifi
     * @param <TO> clonlamamis model
     * @return
     */
    public static <TO> TO cloneModelWithId(TO from , Class<TO> clazz){
        ObjectMapper mapper = new ObjectMapper();
        mapper.setAnnotationIntrospector(new IgnoreEczaModelJacksonIntrospector());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        String[] excludeFields = {"version","dateCreated","dateUpdated","createdBy","updatedBy","deleted","deletedDate"};
        FilterProvider filters = new SimpleFilterProvider().addFilter("FilterOnlyIdAndUuid", SimpleBeanPropertyFilter.serializeAllExcept(excludeFields));
        mapper.setFilterProvider(filters);
        mapper.addMixIn(AxpalModel.class,EczaModelMixIn.class);
        return mapper.convertValue(from,clazz);
    }

    /**
     * Modelin constraintlerini rest e gitmeden kontrol etmek icin kullanilir. Eger bir constraints uygun degilse false yoksa true doner.
     * @param obj validate edilmek istenen model
     * @param <T>
     * @return
     */
    public static <T>boolean isValid(T obj){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(obj).isEmpty();
    }

    public static String kelimelerinIlkHarfleriniGetir(String value){
        if (isEmpty(value)){
            return "";
        }else{
            value = trim(value);
            if (isEmpty(value)){
                return "";
            }else{
                String[] kelimeler = value.split(" ");
                if (isEmpty(kelimeler)){
                    return "";
                }else {
                    return Arrays.stream(kelimeler).map(e -> e.substring(0,1).toUpperCase()).collect(Collectors.joining());
                }
            }
        }
    }

    public enum Obj2StrEnum{
        /**
         * Tarihi dakika hassasiyetinde gösterir
         */
        DATE_MINUTE,
        /**
         * Tarihi saniye hassasiyetinde gösterir
         */
        DATE_SECOND,
        /**
         * Tarihi saat ,dakika hassasiyetinde gösterir
         */
        HOUR_MIN,
        /**
         * Tarihi saat,dakikai saniye hassasiyetinde gösterir
         */
        HOUR_MIN_SEC,
        /**
         * Bigdecimal icin #,###.# formati
         */
        SCALE_4_1,
        /**
         * Bigdecimal icin #,###.## formati
         */
        SCALE_4_2,
        /**
         * Bigdecimal icin ##,#### formati
         */
        SCALE_2_4,

        SCALE_4_3_TR
    }

    private static class IgnoreEczaModelJacksonIntrospector extends JacksonAnnotationIntrospector{
        @Override
        public boolean hasIgnoreMarker(AnnotatedMember m){
            return m.getDeclaringClass() == AxpalModel.class || super.hasIgnoreMarker(m);
        }
    }

    public static String formatNumber(BigDecimal decimal, int maxFractionDigit, int minFranctionDigit){
        if (isEmpty(decimal)){
            return "";
        }else {
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(maxFractionDigit);
            df.setMinimumFractionDigits(minFranctionDigit);
            df.setDecimalSeparatorAlwaysShown(true);
            return df.format(decimal);
        }
    }
    /**
     * A,B,C,Ç ....Z,AA,AB...
     */
    public static class AlphabeticSequence{
        private AlphabeticSequence(){
        }

        private static final String ALPHABET = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ";
        private static final char FIRST = ALPHABET.charAt(0);
        private static final char LAST = ALPHABET.charAt(ALPHABET.length()- 1);

        public static String getNext(String str){
            if (isEmpty(str))
                return String.valueOf(FIRST);

            StringBuilder sb = new StringBuilder(str.toUpperCase());
            for (int i = str.length() -1 ;i >= 0 ; i--){
                if (sb.charAt(i) != LAST){
                    sb.setCharAt(i,ALPHABET.charAt(ALPHABET.indexOf(sb.charAt(i))+ 1));
                    return sb.toString();
                }
                sb.setCharAt(i,FIRST);
            }
            sb.append(FIRST);
            return sb.toString();
        }
    }

    @JsonFilter("FilterOnlyIdAndUuid")
    private class EczaModelMixIn{
    }
    public static <T> T getRandomElementFromList(List<T> list){
        return isEmpty(list) ? null : list.get(RandomUtils.nextInt(0, list.size()));
    }
}
