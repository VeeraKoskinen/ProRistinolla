/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import java.util.*;

/**
 * Luokka sisältää pelilaudan taulukkona sekä taulukon sisältöä koskevat metodit. Luokka pitää myös yllä pelattujen merkkien kokonaismäärää. 
 * Luokassa oliomuuttujina myös pelin kaksi pelaajaa.
 */
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
        alustaLaudanKoordinaatitTyhjiksi();
        
    }
    /**
     * Metodi kertoo onko laudalle syntynyt vaakasuunnassa viiden saman merkin riviä.
     * @return palautetaan true jos rivi löytyy ja false jos riviä ei synny.
     */
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
    /**
     * Metodi kertoo onko laudalle syntynyt laskevassa poikittaissuunnassa viiden saman merkin riviä.
     * @return palautetaan true jos rivi löytyy ja false jos riviä ei synny.
     */
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
    /**
     * Metodi kertoo onko laudalle syntynyt pystysuunnassa viiden saman merkin riviä.
     * @return palautetaan true jos rivi löytyy ja false jos riviä ei löydy.
     */
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
    /**
     * Metodi kertoo onko laudalle syntynyt nousevassa poikittaissuunnassa viiden saman merkin riviä.
     * @return palautetaan true jos rivi löytyy ja false jos riviä ei löydy.
     */
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
    /**
     * Metodi palauttaa tiedon siitä voiko kyseiseen koordinaattiin uuden merkin laittaa.
     * @return true jos merkki voidaan sijoittaa koordinaatteihin ja false jos ei.
     */
    public boolean voikoMerkinLisataKoordinaattiin(int x, int y) {
        if (x >= 0 && x < 6 && y >= 0 && y < 6) {
            if (pelilauta[x][y] == Merkki.TYHJA) {
                return true;
            }
        }
        return false;
    }
    /**
     * Metodi palauttaa pelaajan 1.
     * @return pelaaja risti
     */
    public Pelaaja getPelaaja1() {
        return pelaaja1;
    }
    /**
     * Metodi palauttaa pelaajan 2.
     * @return pelaaja nolla
     */
    public Pelaaja getPelaaja2() {
        return pelaaja2;
    }
    /**
     * Metodi palauttaa pelilaudansolujen sisällön.
     * @return Palauttaa taulukkomuotoisena pelilaudan.
     */
    public Merkki[][] getPelilauta() {
        return pelilauta;
    }
    /**
     * Metodi palauttaa jo pelattujen merkkien kokonaismäärän.
     * @return Jo pelattujen merkkien määrä.
     */
    public int getPelattujenMaara() {
        return pelatut;
    }
    /**
     * Metodissa voit asettaa pelattujen merkkien määrän haltuksi. Käytössä lähinnä nollauksessa.
     * @param uusi on asetettavissa oleva merkkien määrä
     */
    public void setpelattujenMaara(int uusi) {
        pelatut =  uusi;
    }
    /**
     * Metodi kasvattaa pelattujen merkkien määrää yhdellä.
     */
    public void kasvataPelattujaMerkkejaYhdella() {
        pelatut++;
    }
    /**
     * Metodi tulostaa laudan tekstikäyttöliittymän tilannetietona.
     */
    public void tulostaLauta() {
        for (int y = 0; y < pelilauta[1].length; y++) {
            for (int x = 0; x < pelilauta.length; x++) {
                System.out.print(pelilauta[x][y]);
            }
            System.out.println("");
        }
    }
    /**
     * Metodi palauttaa pelilaudan taulukon alkutilaan.
     */
   public void alustaLaudanKoordinaatitTyhjiksi() {
       for (int y = 0; y < pelilauta[1].length; y++) {
            for (int x = 0; x < pelilauta.length; x++) {
                pelilauta[x][y] = Merkki.TYHJA;
            }
        }
   }
}
