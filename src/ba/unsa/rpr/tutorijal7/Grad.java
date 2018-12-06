package ba.unsa.rpr.tutorijal7;

public class Grad {

    private String naziv;
    private int brojStanovnika;
    private Double[] temperature;

    Grad() {
        naziv = "";
        brojStanovnika = 0;
        temperature = new Double[1000];
    }

    String getNaziv() {
        return naziv;
    }

    void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    int getBrojStanovnika() {
        return brojStanovnika;
    }

    void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }

    Double[] getTemperature() {
        return temperature;
    }

    void setTemperature(Double[] temperature) {
        this.temperature = temperature;
    }
}
