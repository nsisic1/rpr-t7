package ba.unsa.rpr.tutorijal7;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Tutorijal {

    public static void main(String[] args) {
        try {
            zapisiXml(ucitajXml(ucitajGradove()));
            System.out.println("Uspjeh!");
        } catch (Exception e) {
            System.out.println("Greska1: " + e.getMessage());
        }
    }

    static ArrayList<Grad> ucitajGradove() throws Exception {

        ArrayList<Grad> gradovi = new ArrayList<>();
        Scanner ulaz;
        try {
            ulaz = new Scanner(new FileReader("mjerenja.txt"));
        } catch (FileNotFoundException e) {
            throw new Exception("Datoteka mjerenja.txt ne postoji ili se ne može otvoriti.\n" + "Greska2: " + e);
        }

        try {
            String linija;
            while (ulaz.hasNextLine()) {
                linija = ulaz.nextLine();
                String[] parts = linija.split(",");
                if (parts.length > 1001) {
                    throw new Exception("Vise od 1000 temperatura");
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
            throw new Exception("Problem pri čitanju/pisanju podataka.\n" + "Greska3: " + e);
        } finally {
            ulaz.close();
        }

        return gradovi;
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

    static UN ucitajXml(ArrayList<Grad> gradovi) throws Exception{

        Document xmldoc = null;
        try {
            DocumentBuilder docReader = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmldoc = docReader.parse(new File("drzave.xml"));
        } catch (Exception e) {
            throw e;
        }


        UN un = new UN();
        ArrayList<Drzava> drzave = new ArrayList<Drzava>();
        NodeList nodes = xmldoc.getDocumentElement().getChildNodes();

        for(int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node instanceof Element) {
                Element elem = (Element) node;
                Drzava drzava = new Drzava();
                drzava.setBrojStanovnika(Integer.parseInt(elem.getAttribute("stanovnika")));
                drzava.setNaziv(elem.getElementsByTagName("naziv").item(0).getTextContent());
                drzava.setJedinicaZaPovrsinu(
                    elem.getElementsByTagName("povrsina").item(0).getAttributes().getNamedItem("jedinica").getTextContent());
                drzava.setPovrsina(Double.parseDouble(elem.getElementsByTagName("povrsina").item(0).getTextContent()));

                System.out.println("Naziv drzave: " + elem.getElementsByTagName("naziv").item(0).getTextContent());
                System.out.println("Stanovnistvo: " + elem.getAttribute("stanovnika"));
                System.out.println("Povrsina: " + elem.getElementsByTagName("povrsina").item(0).getTextContent());
                System.out.println("Jedinica za povrsninu: " +
                        elem.getElementsByTagName("povrsina").item(0).getAttributes().getNamedItem("jedinica").getTextContent());
                System.out.println("Moneta: " +
                        elem.getElementsByTagName("moneta").item(0).getAttributes().getNamedItem("naziv").getTextContent());


                Node nodeGrad = elem.getElementsByTagName("glavnigrad").item(0);
                if (nodeGrad.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementGrad = (Element) nodeGrad;
                    Grad grad = new Grad();
                    grad.setNaziv(elementGrad.getElementsByTagName("naziv").item(0).getTextContent());
                    grad.setBrojStanovnika(Integer.parseInt(elementGrad.getAttribute("stanovnika")));
                    drzava.setGlavniGrad(grad);

                    System.out.println("Glavni grad: " + grad.getNaziv());
                    System.out.println("Stanovnistvo: " + grad.getBrojStanovnika());

                    for (Grad g : gradovi) {
                        if (g.getNaziv().equals(grad.getNaziv())) {
                            grad.setTemperature(g.getTemperature());
                            System.out.print("Temperature: ");
                            Double[] nizTemperatura = g.getTemperature();
                            for (Double d : nizTemperatura) {
                                System.out.print(d + " ");
                            }
                        }
                    }

                }
                System.out.println();
                drzave.add(drzava);
            }
        }

        un.setDrzave(drzave);
        return un;
    }

    public static void zapisiXml(UN un) {
        try {
            XMLEncoder izlaz = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("un.xml")));
            izlaz.writeObject(un);
            izlaz.close();
        } catch(Exception e) {
            System.out.println("Greska4: " + e);
        }
    }
}
