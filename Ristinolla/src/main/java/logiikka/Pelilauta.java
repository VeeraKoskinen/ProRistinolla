/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import java.util.*;

public class Pelilauta {

    private Merkki[][] pelilauta;
    private int pelatut;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;

    public Pelilauta() {
        this.pelilauta = new Merkki[6][6];
        this.pelatut = 0;
        this.pelaaja1 = new Pelaaja(Merkki.RISTI);
        this.pelaaja2 = new Pelaaja(Merkki.NOLLA);
        for (int y = 0; y < pelilauta[1].length; y++) {
            for (int x = 0; x < pelilauta.length; x++) {
                pelilauta[x][y] = Merkki.TYHJA;
            }
        }
    }

    public boolean onkoViisiVaakaan(int x, int y) {
        Merkki m = pelilauta[x][y];
        for (int i = 1; i < 5; i++) {
            if (x + i > 5) {
                return false;
            }
            if (pelilauta[x + i][y] != m) {
                return false;
            }
        }
        return true;
    }

    public boolean onkoViisiKaakkoon(int x, int y) {
        Merkki m = pelilauta[x][y];
        for (int i = 1; i < 5; i++) {
            if (x + i > 5 || y + i > 5) {
                return false;
            }
            if (pelilauta[x + i][y + i] != m) {
                return false;
            }
        }
        return true;
    }

    public boolean onkoViisiPystyyn(int x, int y) {
        Merkki m = pelilauta[x][y];
        for (int i = 1; i < 5; i++) {
            if (y + i > 5) {
                return false;
            }
            if (pelilauta[x][y + i] != m) {
                return false;
            }
        }
        return true;
    }

    public boolean onkoViisiLounaaseen(int x, int y) {
        Merkki m = pelilauta[x][y];
        for (int i = 1; i < 5; i++) {
            if (x - i < 0 || y + i > 5) {
                return false;
            }
            if (pelilauta[x - i][y + i] != m) {
                return false;
            }
        }
        return true;
    }

    public boolean voikoMerkinLisataKoordinaattiin(int x, int y) {
        if (x >= 0 && x < 6 && y >= 0 && y < 6) {
            if (pelilauta[x][y] == Merkki.TYHJA) {
                return true;
            }
        }
        return false;
    }

    public Pelaaja getPelaaja1() {
        return pelaaja1;
    }

    public Pelaaja getPelaaja2() {
        return pelaaja2;
    }

    public Merkki[][] getPelilauta() {
        return pelilauta;
    }

    public int getPelattujenMaara() {
        return pelatut;
    }

    public void kasvataPelattujaMerkkejaYhdella() {
        pelatut++;
    }

    public void tulostaLauta() {
        for (int y = 0; y < pelilauta[1].length; y++) {
            for (int x = 0; x < pelilauta.length; x++) {
                System.out.print(pelilauta[x][y]);
            }
            System.out.println("");
        }
    }
}
