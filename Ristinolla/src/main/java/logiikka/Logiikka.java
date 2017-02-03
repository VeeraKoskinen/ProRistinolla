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

    public Logiikka() {
        this.lauta = new Pelilauta();

    }

    public boolean pelaaVuoro(Pelaaja p, int x, int y) {
        if (pelaaMerkki(new PeliMerkki(p.getMerkki(), x, y))) {
            vaihdaVuoroa();
            return true;
        }
        return false;
    }

    public boolean onkoViidenSuoraa(Merkki m) {
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
        if (lauta.voikoMerkinLisataKoordinaattiin(merkki.getX(), merkki.getY())) {
            if (merkki.getMerkki() == Merkki.RISTI) {
                lauta.getPelaaja1().lisaaPelattuMerkki(merkki);
                lauta.kasvataPelattujaMerkkejaYhdella();
                lauta.getPelilauta()[merkki.getX()][merkki.getY()] = merkki.getMerkki();
            } else if (merkki.getMerkki() == Merkki.NOLLA) {
                lauta.getPelaaja2().lisaaPelattuMerkki(merkki);
                lauta.kasvataPelattujaMerkkejaYhdella();
                lauta.getPelilauta()[merkki.getX()][merkki.getY()] = merkki.getMerkki();
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
