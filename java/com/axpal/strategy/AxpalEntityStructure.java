package com.axpal.strategy;

import java.io.Serializable;

/**
 * Veritabani nesneleri için temel arayuzudur.
 *
 * @author Baksipal
 */

public interface AxpalEntityStructure <ID extends Number> extends Serializable {

    /**
     * Nesnenin 'id' alaninin degerini donmektedir.
     *
     * @return Nesnenin anahtar alani
     */

    ID getId();

    /**
     * Nesnenin 'id' alanina deger vermektedir.
     *
     * @param id Nesnenin anahtar alani
     */

    void setId(ID id);

    /**
     * Nesnenin 'uuid' alaninin degerini donmektedir.
     *
     * @return nesnenin belirtec alani
     */

    String getUuid();

    /**
     * Nesnenin 'uuid' alanina deger vermektedir.
     *
     * @param uuid Nesnenin belirtec alani
     */
    void setUuid(String uuid);
}
