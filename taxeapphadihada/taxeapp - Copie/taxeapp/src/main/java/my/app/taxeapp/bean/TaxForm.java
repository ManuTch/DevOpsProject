package my.app.taxeapp.bean;

import jakarta.persistence.Entity;

public class TaxForm {
    private String cin;
    private Integer year;
    private String terrainType;


    public String getCin() {
        return cin;
    }
    public TaxForm() {
    }
    public void setCin(String cin) {
        this.cin = cin;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getTerrainType() {
        return terrainType;
    }

    public void setTerrainType(String terrainType) {
        this.terrainType = terrainType;
    }
}


