package com.axpal.criteria;

import java.io.Serializable;

/**
 * Sİralama bilgilerinin tutuldugu siniftir.
 */
public class AxpalSort implements Serializable {

    private static final AxpalDirection DEFAULT_DIRECTION = AxpalDirection.UNSORTED;

    private static final String ID_FIELD = "id";

    private static final String[] DEFAULT_PROPERTIES = new String[]{ID_FIELD};

    private AxpalDirection direction;

    private String[] properties;

    public AxpalSort() {
        this.direction = DEFAULT_DIRECTION;
        this.properties = DEFAULT_PROPERTIES;
    }

    public AxpalSort(AxpalDirection direction, String[] properties) {
        this.direction = DEFAULT_DIRECTION;
        this.properties = DEFAULT_PROPERTIES;
    }

    /**
     * Siralama yonu bilgisini donen yontemdir.
     *
     * @return Siralama yon nesnesi
     */

    public AxpalDirection getDirection(){return direction;}

    public void setDirection(AxpalDirection direction){this.direction=direction;}

    /**
     * Siralama sirasinda kullanilan ozellikleri donen yontemdir.
     *
     * @return Siralama sirasinda kullanilan ozellikler
     */

    public String[] getProperties() {return properties;}

    public void setProperties(String[] properties) {
        this.properties = properties;
    }
}
