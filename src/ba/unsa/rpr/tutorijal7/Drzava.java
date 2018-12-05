package ba.unsa.rpr.tutorijal7;

public class Drzava {

    private String naziv = "";
    private int brojStanovnika = 0;
    private Double povrsina = (double) 0;
    private String jedinicaZaPovrsinu = "";
    private Grad glavniGrad;

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
