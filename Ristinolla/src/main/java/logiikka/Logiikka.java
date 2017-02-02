/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import java.util.Scanner;

/**
 *
 * @author veerakoskinen
 */
public class Logiikka {

    private Pelilauta lauta;
    private Scanner lukija;

    public Logiikka() {
        this.lauta = new Pelilauta();
        this.lukija = new Scanner(System.in);
    }

    public void pelaaPeli() {
        System.out.println("Ohje:");
        System.out.println("Koordinaatteja voi antaa väliltä 0-5. Ensimmäisenä viisi vaakaan/pystyyn/vinottain saanut voittaa.");
        boolean tasapeli = false;
        boolean voitto = false;
        while (voitto == false) {
            if (lauta.getPelaaja1().onkoVuoro()) {
                lauta.tulostaLauta();
                System.out.println("");
                // kyselyt
                System.out.println("Anna x-koordinaatti:");
                int x = Integer.parseInt(lukija.nextLine());
                System.out.println("Anna y-koordinaatti:");
                int y = Integer.parseInt(lukija.nextLine());
                voitto = pelaaVuoro(lauta.getPelaaja1(), x, y);
            } else {
                lauta.tulostaLauta();
                System.out.println("");
                // kyselyt
                System.out.println("Anna x-koordinaatti:");
                int x = Integer.parseInt(lukija.nextLine());
                System.out.println("Anna y-koordinaatti:");
                int y = Integer.parseInt(lukija.nextLine());
                voitto = pelaaVuoro(lauta.getPelaaja2(), x, y);
            }
            if (lauta.getPelattujenMaara() == 36) {
                tasapeli = true;
                break;
            }
        }
        System.out.println("Lopputulos:");
        lauta.tulostaLauta();
        if (tasapeli && voitto == false) {
            System.out.println("Pelasitte tasapelin.");
        } else if (lauta.getPelaaja1().onkoVuoro()) {
            System.out.println("Pelaaja2 voitti (o)");
        } else {
            System.out.println("Pelaaja1 voitti (x)");
        }
    }

    public boolean pelaaVuoro(Pelaaja p, int x, int y) {
        return pelaaMerkki(new PeliMerkki(p.getMerkki(), x, y));
    }
    
    public boolean onkoViidenSuoraa(char m) {
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                if (lauta.getPelilauta()[x][y] == m) {
                    if (lauta.onkoViisiVaakaan(x, y)) {
                        return true;
                    }
                    if (lauta.onkoViisiKaakkoon(x, y)) {
                        return true;
                    }
                    if (lauta.onkoViisiPystyyn(x, y)) {
                        return true;
                    }
                    if (lauta.onkoViisiLounaaseen(x, y)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void vaihdaVuoroa() {
        if (lauta.getPelaaja1().onkoVuoro()) {
            lauta.getPelaaja1().lopetaVuoro();
            lauta.getPelaaja2().aloitaVuoro();
        } else if (lauta.getPelaaja2().onkoVuoro()) {
            lauta.getPelaaja2().lopetaVuoro();
            lauta.getPelaaja1().aloitaVuoro();
        }
    }
    
    public boolean pelaaMerkki(PeliMerkki merkki) {
        if (merkki.getX() >= 0 && merkki.getX() < 6 && merkki.getY() >= 0 && merkki.getY() < 6) {
            if (lauta.getPelilauta()[merkki.getX()][merkki.getY()] != 'x' && lauta.getPelilauta()[merkki.getX()][merkki.getY()] != 'o') {
                if (merkki.getMerkki() == 'x') {
                    lauta.getPelaaja1().lisaaPelattuMerkki(merkki);
                    lauta.kasvataPelattujaMerkkejaYhdella();
                    lauta.getPelilauta()[merkki.getX()][merkki.getY()] = merkki.getMerkki();
                } else if (merkki.getMerkki() == 'o') {
                    lauta.getPelaaja2().lisaaPelattuMerkki(merkki);
                    lauta.kasvataPelattujaMerkkejaYhdella();
                    lauta.getPelilauta()[merkki.getX()][merkki.getY()] = merkki.getMerkki();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
    
    public Pelilauta getLauta() {
        return lauta;
    }
}
