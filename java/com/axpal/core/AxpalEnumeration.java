package com.axpal.core;

/**
 * {@link java.util.Enumeration} siniflari icin {@link #code()} ve {@link #label()} destegi saglamaktadir.
 *
 * @author OCalbay
 */
public interface AxpalEnumeration {

    /**
     * Kod bilgisini donen yontemdir.
     *
     * @return int Kod bilgisi
     */
    int code();

    /**
     * Icerik bilgisi donen yontemdir.
     *
     * @return String Icerik bilgisi
     */
    String label();
}
