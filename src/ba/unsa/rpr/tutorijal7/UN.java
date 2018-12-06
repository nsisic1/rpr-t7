package ba.unsa.rpr.tutorijal7;

import java.io.Serializable;
import java.util.ArrayList;

public class UN implements Serializable {

    private ArrayList<Drzava> drzave;

    UN() {
        drzave = new ArrayList<>();
    }

    ArrayList<Drzava> getDrzave() {
        return drzave;
    }

    void setDrzave(ArrayList<Drzava> drzave) {
        this.drzave = drzave;
    }
}
