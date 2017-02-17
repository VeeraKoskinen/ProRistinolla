/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import java.util.*;

/**
 * Luokka sisältää pelilaudan taulukkona sekä taulukon sisältöä koskevat
 * metodit. Luokka pitää myös yllä pelattujen merkkien kokonaismäärää. Luokassa
 * oliomuuttujina myös pelin kaksi pelaajaa.
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
     * Metodi kertoo onko laudalle syntynyt vaakasuunnassa viiden saman merkin
     * riviä.
     *
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
     * Metodi kertoo onko laudalle syntynyt laskevassa poikittaissuunnassa
     * viiden saman merkin riviä.
     *
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
     * Metodi kertoo onko laudalle syntynyt pystysuunnassa viiden saman merkin
     * riviä.
     *
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
     * Metodi kertoo onko laudalle syntynyt nousevassa poikittaissuunnassa
     * viiden saman merkin riviä.
     *
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
     * Metodi palauttaa tiedon siitä voiko kyseiseen koordinaattiin uuden merkin
     * laittaa.
     *
     * @return true jos merkki voidaan sijoittaa koordinaatteihin ja false jos
     * ei.
     */
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

    /**
     * Metodissa voit asettaa pelattujen merkkien määrän haltuksi. Käytössä
     * lähinnä nollauksessa.
     *
     * @param uusi on asetettavissa oleva merkkien määrä
     */
    public void setpelattujenMaara(int uusi) {
        pelatut = uusi;
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

    public void kierraOikeaYlaMyotapaivaan() {
        Merkki[][] apu = new Merkki[3][3];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                apu[x][y] = pelilauta[x][y];
            }
        }
        //1. rivi
        pelilauta[0][0] = apu[0][2];
        pelilauta[1][0] = apu[0][1];
        pelilauta[2][0] = apu[0][0];
        //2. rivi
        pelilauta[0][1] = apu[1][2];
        pelilauta[2][1] = apu[1][0];
        //3. rivi
        pelilauta[0][2] = apu[2][2];
        pelilauta[1][2] = apu[2][1];
        pelilauta[2][2] = apu[2][0];

    }

    public void kierraOikeaYlaVastapaivaan() {
        Merkki[][] apu = new Merkki[3][3];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                apu[x][y] = pelilauta[x][y];
            }
        }
        //1. rivi
        pelilauta[0][0] = apu[2][0];
        pelilauta[1][0] = apu[2][1];
        pelilauta[2][0] = apu[2][2];
        //2. rivi
        pelilauta[0][1] = apu[1][0];
        pelilauta[2][1] = apu[1][2];
        //3. rivi
        pelilauta[0][2] = apu[0][0];
        pelilauta[1][2] = apu[0][1];
        pelilauta[2][2] = apu[0][2];
    }

    public void kierraOikeaAlaMyotapaivaan() {
        Merkki[][] apu = new Merkki[3][3];
        for (int y = 3; y < 6; y++) {
            for (int x = 0; x < 3; x++) {
                apu[x][y - 3] = pelilauta[x][y];
            }
        }
        //1. rivi
        pelilauta[0][3] = apu[0][2];
        pelilauta[1][3] = apu[0][1];
        pelilauta[2][3] = apu[0][0];
        //2. rivi
        pelilauta[0][4] = apu[1][2];
        pelilauta[2][4] = apu[1][0];
        //3. rivi
        pelilauta[0][5] = apu[2][2];
        pelilauta[1][5] = apu[2][1];
        pelilauta[2][5] = apu[2][0];
    }

    public void kierraOikeaAlaVastapaivaan() {
        Merkki[][] apu = new Merkki[3][3];
        for (int y = 3; y < 6; y++) {
            for (int x = 0; x < 3; x++) {
                apu[x][y - 3] = pelilauta[x][y];
            }
        }
        //1. rivi
        pelilauta[0][3] = apu[2][0];
        pelilauta[1][3] = apu[2][1];
        pelilauta[2][3] = apu[2][2];
        //2. rivi
        pelilauta[0][4] = apu[1][0];
        pelilauta[2][4] = apu[1][2];
        //3. rivi
        pelilauta[0][5] = apu[0][0];
        pelilauta[1][5] = apu[0][1];
        pelilauta[2][5] = apu[0][2];
    }

    public void kierraVasenYlaMyotapaivaan() {
        Merkki[][] apu = new Merkki[3][3];
        for (int y = 0; y < 3; y++) {
            for (int x = 3; x < 6; x++) {
                apu[x-3][y] = pelilauta[x][y];
            }
        }
        //1. rivi
        pelilauta[3][0] = apu[0][2];
        pelilauta[4][0] = apu[0][1];
        pelilauta[5][0] = apu[0][0];
        //2. rivi
        pelilauta[3][1] = apu[1][2];
        pelilauta[5][1] = apu[1][0];
        //3. rivi
        pelilauta[3][2] = apu[2][2];
        pelilauta[4][2] = apu[2][1];
        pelilauta[5][2] = apu[2][0];
    }

    public void kierraVasenYlaVastapaivaan() {
        Merkki[][] apu = new Merkki[3][3];
        for (int y = 0; y < 3; y++) {
            for (int x = 3; x < 6; x++) {
                apu[x-3][y] = pelilauta[x][y];
            }
        }
        //1. rivi
        pelilauta[3][0] = apu[2][0];
        pelilauta[4][0] = apu[2][1];
        pelilauta[5][0] = apu[2][2];
        //2. rivi
        pelilauta[3][1] = apu[1][0];
        pelilauta[5][1] = apu[1][2];
        //3. rivi
        pelilauta[3][2] = apu[0][0];
        pelilauta[4][2] = apu[0][1];
        pelilauta[5][2] = apu[0][2];
    }

    public void kierraVasenAlaMyotapaivaan() {
        Merkki[][] apu = new Merkki[3][3];
        for (int y = 3; y < 6; y++) {
            for (int x = 3; x < 6; x++) {
                apu[x-3][y-3] = pelilauta[x][y];
            }
        }
        //1. rivi
        pelilauta[3][3] = apu[0][2];
        pelilauta[4][3] = apu[0][1];
        pelilauta[5][3] = apu[0][0];
        //2. rivi
        pelilauta[3][4] = apu[1][2];
        pelilauta[5][4] = apu[1][0];
        //3. rivi
        pelilauta[3][5] = apu[2][2];
        pelilauta[4][5] = apu[2][1];
        pelilauta[5][5] = apu[2][0];
    }

    public void kierraVasenAlaVastaPaivaan() {
        Merkki[][] apu = new Merkki[3][3];
        for (int y = 3; y < 6; y++) {
            for (int x = 3; x < 6; x++) {
                apu[x-3][y-3] = pelilauta[x][y];
            }
        }
          //1. rivi
        pelilauta[3][3] = apu[2][0];
        pelilauta[4][3] = apu[2][1];
        pelilauta[5][3] = apu[2][2];
        //2. rivi
        pelilauta[3][4] = apu[1][0];
        pelilauta[5][4] = apu[1][2];
        //3. rivi
        pelilauta[3][5] = apu[0][0];
        pelilauta[4][5] = apu[0][1];
        pelilauta[5][5] = apu[0][2];
    }
}
