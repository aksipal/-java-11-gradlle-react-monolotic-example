package com.axpal.util;

import javax.validation.constraints.NotNull;
import java.util.List;

public class DegisiklikKontrolSonucModel {

    @NotNull
    private Boolean degisiklikVarmi;

    private List<String> degisikliginOlduguPropertyListe;

    private List<String> degisiklikAlanAdListe;

    public DegisiklikKontrolSonucModel() {
    }

    public DegisiklikKontrolSonucModel(Boolean degisiklikVarmi, List<String> degisikliginOlduguPropertyListe, List<String> degisiklikAlanAdListe) {
        this.degisiklikVarmi = degisiklikVarmi;
        this.degisikliginOlduguPropertyListe = degisikliginOlduguPropertyListe;
        this.degisiklikAlanAdListe = degisiklikAlanAdListe;
    }

    public Boolean getDegisiklikVarmi() {
        return degisiklikVarmi;
    }

    public void setDegisiklikVarmi(Boolean degisiklikVarmi) {
        this.degisiklikVarmi = degisiklikVarmi;
    }

    public List<String> getDegisikliginOlduguPropertyListe() {
        return degisikliginOlduguPropertyListe;
    }

    public void setDegisikliginOlduguPropertyListe(List<String> degisikliginOlduguPropertyListe) {
        this.degisikliginOlduguPropertyListe = degisikliginOlduguPropertyListe;
    }

    public List<String> getDegisiklikAlanAdListe() {
        return degisiklikAlanAdListe;
    }

    public void setDegisiklikAlanAdListe(List<String> degisiklikAlanAdListe) {
        this.degisiklikAlanAdListe = degisiklikAlanAdListe;
    }
}
