package ba.unsa.rpr.tutorijal7;

import java.io.Serializable;

public class Drzava implements Serializable {

    private String naziv;
    private int brojStanovnika;
    private Double povrsina;
    private String jedinicaZaPovrsinu;
    private Grad glavniGrad;

    Drzava() {
        naziv = "";
        brojStanovnika = 0;
        povrsina = (double) 0;
        jedinicaZaPovrsinu = "";
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

    Double getPovrsina() {
        return povrsina;
    }

    void setPovrsina(Double povrsina) {
        this.povrsina = povrsina;
    }

    String getJedinicaZaPovrsinu() {
        return jedinicaZaPovrsinu;
    }

    void setJedinicaZaPovrsinu(String jedinicaZaPovrsinu) {
        this.jedinicaZaPovrsinu = jedinicaZaPovrsinu;
    }

    Grad getGlavniGrad() {
        return glavniGrad;
    }

    void setGlavniGrad(Grad glavniGrad) {
        this.glavniGrad = glavniGrad;
    }
}
