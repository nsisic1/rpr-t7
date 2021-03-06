package ba.unsa.rpr.tutorijal7;

import java.io.Serializable;

public class Drzava implements Serializable {

    private String naziv;
    private int brojStanovnika;
    private Double povrsina;
    private String jedinicaZaPovrsinu;
    private Grad glavniGrad;

    public Drzava() {
        naziv = "";
        brojStanovnika = 0;
        povrsina = (double) 0;
        jedinicaZaPovrsinu = "";
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

    public Double getPovrsina() {
        return povrsina;
    }

    public void setPovrsina(Double povrsina) {
        this.povrsina = povrsina;
    }

    public String getJedinicaZaPovrsinu() {
        return jedinicaZaPovrsinu;
    }

    public void setJedinicaZaPovrsinu(String jedinicaZaPovrsinu) {
        this.jedinicaZaPovrsinu = jedinicaZaPovrsinu;
    }

    public Grad getGlavniGrad() {
        return glavniGrad;
    }

    public void setGlavniGrad(Grad glavniGrad) {
        this.glavniGrad = glavniGrad;
    }
}
