/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla;

import java.util.Scanner;
import logiikka.*;

/**
 *
 * @author veerakoskinen
 */
public class Tekstikayttoliittyma {

    private final Logiikka l;
    private final Scanner lukija;

    public Tekstikayttoliittyma() {
        l = new Logiikka();
        this.lukija = new Scanner(System.in);
    }

    public void pelaaPeli() {
        System.out.println("Ohje:");
        System.out.println("Koordinaatteja voi antaa väliltä 0-5. Ensimmäisenä viisi vaakaan/pystyyn/vinottain saanut voittaa.");
        boolean tasapeli = false;
        boolean voitto = false;
        while (voitto == false) {
            if (l.getLauta().getPelaaja1().onkoVuoro()) {
//                l.getLauta().tulostaLauta();
                System.out.println(""); // kyselyt
                System.out.println("Anna x-koordinaatti:");
                int x = Integer.parseInt(lukija.nextLine());
                System.out.println("Anna y-koordinaatti:");
                int y = Integer.parseInt(lukija.nextLine());
                if (l.pelaaVuoro(l.getLauta().getPelaaja1(), x, y)) {
                    voitto = l.onkoViidenSuoraa(l.getLauta().getPelaaja1().getMerkki());
                }
            } else {
//                l.getLauta().tulostaLauta();
                System.out.println("");
                // kyselyt
                System.out.println("Anna x-koordinaatti:");
                int x = Integer.parseInt(lukija.nextLine());
                System.out.println("Anna y-koordinaatti:");
                int y = Integer.parseInt(lukija.nextLine());

                if (l.pelaaVuoro(l.getLauta().getPelaaja2(), x, y)) {
                    voitto = l.onkoViidenSuoraa(l.getLauta().getPelaaja2().getMerkki());
                }
            }
            if (l.getLauta().getPelattujenMaara() == 36) {
                tasapeli = true;
                break;
            }
        }
        System.out.println("Lopputulos:");
//        l.getLauta().tulostaLauta();
        if (tasapeli && voitto == false) {
            System.out.println("Pelasitte tasapelin.");
        } else if (l.getLauta().getPelaaja1().onkoVuoro()) {
            System.out.println("Pelaaja2 voitti (o)");
        } else {
            System.out.println("Pelaaja1 voitti (x)");
        }
    }
}
