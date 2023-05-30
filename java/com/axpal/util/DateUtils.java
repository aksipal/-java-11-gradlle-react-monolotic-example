package com.axpal.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {

    public static final int YILDAKI_AY = 12;
    public static final int YILDAKI_GUN = 365;
    public static final int AYDAKI_GUN = 30;
    public static final int GUNDEKI_SAAT = 24;
    public static final int SAATTEKI_DAKIKA = 60;
    public static final int DAKIKADAKI_SANIYE = 60;
    public static final int SAATTEKI_SANIYE = SAATTEKI_DAKIKA * DAKIKADAKI_SANIYE;
    public static final int SANIYEDEKI_MILISANIYE = 1000;
    public static final int GUNDEKI_SANIYE = GUNDEKI_SAAT *
            SAATTEKI_DAKIKA *
            DAKIKADAKI_SANIYE;
    public static final int GUNDEKI_MILISANIYE = GUNDEKI_SAAT *
            SAATTEKI_DAKIKA *
            DAKIKADAKI_SANIYE *
            SANIYEDEKI_MILISANIYE;
    public static final int DAKIKADAKI_MILISANIYE = DAKIKADAKI_SANIYE * SANIYEDEKI_MILISANIYE;
    public static final int SAATTEKI_MILISANIYE = 3600000;

    public static final String HOUR_MIN_FORMAT_STR = "HH:mm";

    public static final DateTimeFormatter HOUR_MIN_FORMAT = DateTimeFormatter.ofPattern(HOUR_MIN_FORMAT_STR);

    public static final String HOUR_MIN_SEC_FORMAT_STR = "HH:mm:ss";

    public static final DateTimeFormatter HOUR_MIN_SEC_FORMAT = DateTimeFormatter.ofPattern(HOUR_MIN_SEC_FORMAT_STR);

    public static final String MONTH_YEAR_FORMAT_STR = "dd/MM";

    public static final DateTimeFormatter MONTH_YEAR_FORMAT = DateTimeFormatter.ofPattern(MONTH_YEAR_FORMAT_STR);

    public static final String TR_DATE_FORMAT_STR = "dd/MM/yyyy";
    public static final String ENT_SOAP_DATE_FORMAT_STR = "yyyy-MM-dd'T'HH:mm:ss";

    public static final String TR_DATE_FORMAT_PLACEHOLDER = "__/__/____";

    public static final String TR_HOUR_FORMAT_PLACEHOLDER = "__:__";

    public static final DateTimeFormatter TR_DATE_FORMAT = DateTimeFormatter.ofPattern(TR_DATE_FORMAT_STR);

    public static final String TR_DATETIME_FORMAT_STR = "dd/MM/yyyy HH:mm";

    public static final DateTimeFormatter TR_DATETIME_FORMAT = DateTimeFormatter.ofPattern(TR_DATETIME_FORMAT_STR);

    public static final String TR_DATETIME_SECOND_FORMAT_STR = "dd/MM/yyyy HH:mm:ss";

    public static final DateTimeFormatter TR_DATETIME_SECOND_FORMAT = DateTimeFormatter.ofPattern(TR_DATETIME_SECOND_FORMAT_STR);

    public static final  String TR_DATETIME_DMHM_FORMAT_STR = "dd/MM HH:mm";


    public static String date2Str(Date date){
        if (date != null){
            Instant instant = date.toInstant();
            LocalDateTime ldt = instant.atOffset(zoneOffsetGetir()).toLocalDateTime();
            return ldt.format(TR_DATE_FORMAT);
        }
        return null;
    }

    public static ZoneOffset zoneOffsetGetir(){
        LocalDateTime now = LocalDateTime.now();
        ZoneId zoneId = zoneIdGetir();
        return zoneId.getRules().getOffset(now);
    }

    public static ZoneId zoneIdGetir(){
        return ZoneId.of("Europe/Istanbul");
    }
}
