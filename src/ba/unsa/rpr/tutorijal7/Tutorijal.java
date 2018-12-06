package ba.unsa.rpr.tutorijal7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Tutorijal {

    public static void main(String[] args) {

    }

    static void ucitajGradove() {

        ArrayList<Grad> gradovi = new ArrayList<>();
        Scanner ulaz;
        try {
            ulaz = new Scanner(new FileReader("mjerenja.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Datoteka mjerenja.txt ne postoji ili se ne može otvoriti");
            System.out.println("Greška: " + e);
            return;
        }

        try {
            String linija;
            while (ulaz.hasNextLine()) {
                linija = ulaz.nextLine();
                String[] parts = linija.split(",");
                if (parts.length > 1001) {
                    throw new ArrayIndexOutOfBoundsException("Vise od 1000 temperatura");
                }
                String nazivGrada = parts[0];
                Double[] temperature = new Double[parts.length - 1];
                for (int i = 1; i < parts.length; i++) {
                    temperature[i - 1] = Double.parseDouble(parts[i]);
                }
                Grad grad = new Grad();
                grad.setNaziv(nazivGrada);
                grad.setTemperature(temperature);
                gradovi.add(grad);
            }
        } catch (Exception e) {
            System.out.println("Problem pri čitanju/pisanju podataka.");
            System.out.println("Greška: " + e);
        } finally {
            ulaz.close();
        }


}

    private static int countChar(String str, char c)
    {
        int count = 0;
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
}
