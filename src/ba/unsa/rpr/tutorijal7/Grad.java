package ba.unsa.rpr.tutorijal7;

import java.io.Serializable;

public class Grad implements Serializable {

    private String naziv;
    private int brojStanovnika;
    private Double[] temperature;

    public Grad() {
        naziv = "";
        brojStanovnika = 0;
        temperature = new Double[1000];
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }

    public Double[] getTemperature() {
        return temperature;
    }

    public void setTemperature(Double[] temperature) {
        this.temperature = temperature;
    }
}
