/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import java.awt.event.*;
import java.util.*;

/**
 *
 * @author veerakoskinen
 */
/**
 * Luokka kerää yhteen metodit joilla saadaan ohjailtua koko peliä.
 */
public class Logiikka {
    // action performed tekemättä ja timer asettamatta ??

    private Pelilauta lauta;

    public Logiikka() {
        this.lauta = new Pelilauta();
    }

    /**
     * Metodi suorittaa yhden vuoron olennaiset toiminnot: Merkin pelaamisen ja
     * vuoron vaihtamisen.
     *
     * @param p vuorossa oleva pelaaja
     * @param x tarjottu x-koordinaatti
     * @param y tarjottu y-koordinaatti
     * @return true jos merkki saatiin pelattua ja false jos ei.
     */
    public boolean pelaaVuoro(Pelaaja p, int x, int y) {
        if (pelaaMerkki(new PeliMerkki(p.getMerkki(), x, y))) {
            return true;
        }
        return false;
    }

    /**
     * Metodi kertoo onko koko laudalle syntynyt johonkin suuntaan viiden saman
     * merkin riviä.
     *
     * @param m merkki jonka riviä etsitään
     * @return true jos rivi löytyy ja false jos riviä ei synny.
     */
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

    /**
     * Metodi vaihtaa pelaajien vuorot eli vuoro-muuttujan arvot keskenään.
     */
    public void vaihdaVuoroa() {
        if (lauta.getPelaaja1().onkoVuoro()) {
            lauta.getPelaaja1().lopetaVuoro();
            lauta.getPelaaja2().aloitaVuoro();
        } else if (lauta.getPelaaja2().onkoVuoro()) {
            lauta.getPelaaja2().lopetaVuoro();
            lauta.getPelaaja1().aloitaVuoro();
        }
    }

    /**
     * Metodi kertoo voidaanko merkki lisata kyseessä olevaan koordinaattiin.
     * Jos voidaan, niin merkki lisätään.
     *
     * @return true jos merkki voitiin lisätä laudalle. Jos ei, niin palautetaan
     * false.
     */
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

    /**
     * Metodi palauttaa pelaajan jonka vuoro-arvo on true, eli pelaajan joka on
     * juuri vuorossa.
     *
     * @return vuorossa oleva pelaaja
     */
    public Pelaaja kummanVuoro() {
        if (lauta.getPelaaja1().onkoVuoro()) {
            return lauta.getPelaaja1();
        } else {
            return lauta.getPelaaja2();
        }
    }

    public Pelilauta getLauta() {
        return lauta;
    }
    /**
     * Metodi kertoo jos tilanne on tasan.
     *
     * @return true jos kyseessä on tasapeli ja false jos peli ei ole tasan
     */
    public boolean onkoTasapeli() {
        if (lauta.getPelattujenMaara() >= 36) {
            return true;
        }
        return false;
    }
    /**
     * Metodi alustaa pelin alkutilaan.
     * 
     * @return true jos rivi löytyy ja false jos riviä ei synny.
     */
    public void alustaPeliUudelleen() {
        this.lauta = new Pelilauta();    
    }


}
