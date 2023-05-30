package com.axpal.util;
import com.axpal.converter.AxpalCommonConverter;
import com.axpal.exception.model.AxpalUtilException;
import com.axpal.model.AxpalModel;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.SqlTimestampConverter;
import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.Hibernate;
import org.apache.commons.beanutils.PropertyUtils;
import org.reflections.Reflections;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;

public class ReflectionUtils {

    private ReflectionUtils() {
    }

    public static Long getId(Object o) {
        try {
            return (Long) getProperty(o, "id");
        } catch (Exception e) {
            throw new AxpalUtilException(e, "Property getirilemiyor.", Exception.class);
        }
    }

    /**
     * Verilen beanden istenilen propertyi doner
     *
     * @param bean
     * @param property
     * @return
     */
    public static Object getProperty(Object bean, String property) {
        try {
            return PropertyUtils.getProperty(bean, property);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new AxpalUtilException(e, "Property getirilemedi.", ReflectionUtils.class);
        }
    }

    /**
     * Verilen beandeki istenilen propertyleri doner.
     *
     * @param bean
     * @param properties
     * @return
     */
    public static String getProperties(Object bean, String properties) {
        try {
            StringBuilder result = new StringBuilder();
            String[] prp = properties.split(" ,");
            for (String property : prp) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(PropertyUtils.getProperty(bean, property).toString());
            }
            return result.toString();
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new AxpalUtilException(e, "Property getirilemedi", ReflectionUtils.class);
        }
    }

    public static Class<?> getPropertyType(Object bean, String property) {
        try {
            return PropertyUtils.getPropertyType(bean, property);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new AxpalUtilException(e, "Property tipi getirilemedi", ReflectionUtils.class);
        }
    }

    /**
     * Verilen nesnenin propertysini <code>value<code/> degerine setler.
     *
     * @param bean
     * @param property
     * @param value
     */
    public static void setProperty(Object bean, String property, Object value) {
        try {
            if (value == null) {
                PropertyUtils.setProperty(bean, property, value);
            } else {
                BeanUtilsBean beanUtilsBean = BeanUtilsBean.getInstance();
                beanUtilsBean.getConvertUtils().register(new BigDecimalConverter(null), BigDecimal.class);
                beanUtilsBean.getConvertUtils().register(new DateConverter(), Date.class);
                beanUtilsBean.getConvertUtils().register(new SqlTimestampConverter(null), Timestamp.class);
                BeanUtilsBean.getInstance().setProperty(bean, property, value);
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new AxpalUtilException(e, "Property setlenmedi", ReflectionUtils.class);

        }
    }

    public static Object callMethod(Object bean, String methodName, Object... params) {
        try {
            return MethodUtils.invokeMethod(bean, methodName, params);
        } catch (Exception e) {
            throw new AxpalUtilException(e, "Method Cagirilamiyor", ReflectionUtils.class);
        }
    }

    /**
     * Bir sinifin static bir metodunu cagirmak icin kullanilir. //Java reflection api ile
     *
     * @param methodName
     * @param className
     * @return
     */
    public static Object callStaticMethod(String className, String methodName) {
        try {
            Class<?> c = Class.forName(className);
            Method m = c.getMethod(methodName);
            return m.invoke(null);
        } catch (Exception e) {
            throw new AxpalUtilException(e, "Method Cagirilamiyor", ReflectionUtils.class);
        }
    }

    /**
     * Bir sinifin static bir metodunu cagirmak icin kullanilir. //apache-common api ile
     *
     * @param methodName
     * @param className
     * @return
     */
    public static Object callStaticMethod(String className, String methodName, Object... args) {
        try {
            Class<?> c = Class.forName(className);
            return MethodUtils.invokeStaticMethod(c, methodName, args);
        } catch (Exception e) {
            throw new AxpalUtilException(e, "Method Cagirilamiyor", ReflectionUtils.class);
        }
    }

    public static void copyPropertiesExact(Object destination, Object origin) {
        try {
            PropertyUtils.copyProperties(destination, origin);
        } catch (Exception e) {
            throw new AxpalUtilException(e, "Property Kopyalanamadi", ReflectionUtils.class);
        }
    }


    /**
     * Verilen package yolundaki classlari dondurur.
     */
    public static Class<?>[] getClasses(String packageName, String packageNameFilter) {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            assert classLoader != null;

            String path = packageName.replace('.', '/');
            Enumeration<URL> resources = classLoader.getResources(path);
            List<File> dirs = new ArrayList<>();
            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                dirs.add(new File(resource.getFile()));
            }
            ArrayList<Class<?>> classes = new ArrayList<>();
            for (File directory : dirs) {
                classes.addAll(findClasses(directory, packageName
                        , packageNameFilter));
            }
            return classes.toArray(new Class[classes.size()]);
        } catch (IOException e) {
            throw new AxpalUtilException(e, "Classlar getirilemedi", ReflectionUtils.class);
        }
    }

    /**
     * Verilen directory ve subdirectorydeki tum classlari dondurur.
     */
    public static List<Class<?>> findClasses(File directory, String packageName, String packageNameFilter) {
        try {
            List<Class<?>> classes = new ArrayList<>();
            if (!directory.exists()) {
                return classes;
            }
            File[] files = directory.listFiles();
            for (File file : Objects.requireNonNull(files)) {
                if (file.isDirectory()) {
                    assert !file.getName().contains(".");
                    classes.addAll(findClasses(file, packageName + "." + file.getName(), packageNameFilter));
                } else if (file.getName().endsWith(".class") && (packageNameFilter == null || packageName.contains(packageNameFilter))) {
                    classes.add(Class.forName(packageName
                            + '.'
                            + file.getName().substring(0,
                            file.getName().length() - 6)));
                }
            }
            return classes;
        } catch (ClassNotFoundException e) {
            throw new AxpalUtilException(e, "Class bulunamadi", ReflectionUtils.class);
        }
    }

    /**
     * Verilen paketteki ulasilabilir tum classlari doner.
     *
     * @param packageName
     * @param clazz
     * @return
     */
    public static Set<Class> getClasses(String packageName, Class clazz) {
        Reflections reflections = new Reflections(packageName);
        return reflections.getSubTypesOf(clazz);
    }

    /**
     * Verilen directory ve alt directorydeki tum siniflari doner.
     */
    public static List<Class<?>> findClasses(File directory, String packageName) {
        try {
            List<Class<?>> classes = new ArrayList<>();
            if (!directory.exists()) {
                return classes;
            }
            File[] files = directory.listFiles();
            for (File file : Objects.requireNonNull(files)) {
                if (file.isDirectory()) {
                    assert !file.getName().contains(".");
                    classes.addAll(findClasses(file, packageName + "." + file.getName()));
                } else if (file.getName().endsWith(".class")) {
                    classes.add(Class.forName(packageName
                            + '.'
                            + file.getName().substring(0,
                            file.getName().length() - 6)));
                }
            }
            return classes;
        } catch (ClassNotFoundException e) {
            throw new AxpalUtilException(e, "Class bilgileri bulunamadi", ReflectionUtils.class);
        }
    }

    public static <T extends AxpalModel> T cloneAsNewObject(T cloneAlinacakModel) {
        try {
            Map convert = AxpalCommonConverter.convert(cloneAlinacakModel, Map.class);
            T clone = (T) AxpalCommonConverter.convert(convert, cloneAlinacakModel.getClass());
            Field[] declareFields = AxpalModel.class.getDeclaredFields();
            for (Field field : declareFields) {
                if (!BaseUtils.equals(field.getName(), "serialVersionUID")) {
                    ReflectionUtils.setProperty(clone, field.getName(), null);
                }
            }
            return clone;
        } catch (Exception e) {
            throw new AxpalUtilException(e, ReflectionUtils.class);
        }
    }

     /**
     * Iki objede {@link CheckFieldToChange} annotasyonu ile isaretlenmis alanlarda degisiklik olup olmadigini kontrol eder.
     */
    public static DegisiklikKontrolSonucModel degisiklikVarMi(Object obj1, Object obj2) {
        return check(obj1, obj2, true);
    }

    /**
     * Iki objede alanlarda degisiklik olup olmadigini kontrol eder
     *
     * @param obj1
     * @param obj2
     * @return
     */
    public static DegisiklikKontrolSonucModel farkliDegereSahipAlanlariBul(Object obj1, Object obj2) {
        return check(obj1, obj2, false);
    }


    private static DegisiklikKontrolSonucModel check(Object obj1, Object obj2, Boolean sadeceCheckFieldToChangeOlanAlanlaraBak) {
        List<String> degisikliginOlduguAlanlar = new ArrayList<>();
        List<String> degisiklAlanAdListe = new ArrayList<>();
        if (Hibernate.getClass(obj1) == Hibernate.getClass(obj2)) {

            Class<?> current = obj1.getClass();
            while (current.getSuperclass() != null) {
                Field[] declareFields = current.getDeclaredFields();
                degisikliKontrol(obj1, obj2, degisikliginOlduguAlanlar, declareFields, sadeceCheckFieldToChangeOlanAlanlaraBak, degisiklAlanAdListe);
                current = current.getSuperclass();
            }
        } else {
            throw new AxpalUtilException("Iki sinif ayni degil", ReflectionUtils.class);
        }
        return new DegisiklikKontrolSonucModel(!BaseUtils.isEmpty(degisikliginOlduguAlanlar), degisikliginOlduguAlanlar, degisiklAlanAdListe);
    }

    private static void degisikliKontrol(Object obj1, Object obj2, List<String> degisikliginOlduguAlanlar, Field[] declaredFileds, Boolean sadeceCheckFieldToChangeOlanAlanlaraBak, List<String> degisiklikAlanAdListe) {

        for (Field field : declaredFileds) {
            if (!sadeceCheckFieldToChangeOlanAlanlaraBak || (field.getAnnotation(CheckFieldToChange.class) != null)) {
                try {
                    field.setAccessible(true);
                    Object o1 = field.get(obj1);
                    Object o2 = field.get(obj2);
                    if (!ObjectUtils.equals(o1, o2)) {
                        degisikliginOlduguAlanlar.add(field.getName());
                        if ((field.get(CheckFieldToChange.class) != null) && !BaseUtils.isEmpty(field.getAnnotation(CheckFieldToChange.class).displayName())) {
                            degisiklikAlanAdListe.add(field.getAnnotation(CheckFieldToChange.class).displayName());
                        } else {
                            degisiklikAlanAdListe.add(field.getName());
                        }
                    }
                } catch (IllegalAccessException e) {
                    throw new AxpalUtilException(e, "Field valuleri getirilemedi", ReflectionUtils.class);
                }
            }
        }
    }
}
