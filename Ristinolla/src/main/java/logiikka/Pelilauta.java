/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import java.util.*;

public class Pelilauta {

    private char[][] pelilauta;
    private int pelatut;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;

    public Pelilauta() {
        this.pelilauta = new char[6][6];
        this.pelatut = 0;
        this.pelaaja1 = new Pelaaja(1);
        this.pelaaja2 = new Pelaaja(2);
        for (int y = 0; y < pelilauta[1].length; y++) {
            for (int x = 0; x < pelilauta.length; x++) {
                pelilauta[x][y] = '#';
            }
        }
    }

    public void pelaaMerkki(PeliMerkki merkki) {
        if (merkki.getX() >= 0 && merkki.getX() < 6 && merkki.getY() >= 0 && merkki.getY() < 6) {
            if (pelilauta[merkki.getX()][merkki.getY()] != 'x' && pelilauta[merkki.getX()][merkki.getY()] != 'o') {
                if (merkki.getMerkki() == 'x') {
                    pelaaja1.lisaaPelattuMerkki(merkki);
                    pelatut++;
                    pelilauta[merkki.getX()][merkki.getY()] = merkki.getMerkki();
                } else if (merkki.getMerkki() == 'o') {
                    pelaaja2.lisaaPelattuMerkki(merkki);
                    pelatut++;
                    pelilauta[merkki.getX()][merkki.getY()] = merkki.getMerkki();
                } else {
                    System.out.println("Merkki ei kuulu peliin xD");
                }
            } else {
                System.out.println("Merkkiä ei voitu lisätä. Koordinaattissa on jo pelaajan merkki.");
            }
        } else {
            System.out.println("Merkkiä ei voitu lisätä. Koordinaatit ylittivät pelialueen");
        }
    }

    public boolean onkoViidenSuoraa(char m) {
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                if (pelilauta[x][y] == m) {
                    if (onkoViisiVaakaan(x, y)) {
                        return true;
                    }
                    if (onkoViisiKaakkoon(x, y)) {
                        return true;
                    }
                    if (onkoViisiPystyyn(x, y)) {
                        return true;
                    }
                    if (onkoViisiLounaaseen(x, y)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean onkoViisiVaakaan(int x, int y) {
        char m = pelilauta[x][y];
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
        char m = pelilauta[x][y];
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
        char m = pelilauta[x][y];
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
        char m = pelilauta[x][y];
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

    public Pelaaja getPelaaja1() {
        return pelaaja1;
    }

    public Pelaaja getPelaaja2() {
        return pelaaja2;
    }

    public char[][] getPelilauta() {
        return pelilauta;
    }

    public int getPelattujenMaara() {
        return pelatut;
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
