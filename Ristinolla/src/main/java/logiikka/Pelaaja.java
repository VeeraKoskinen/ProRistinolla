/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import java.util.*;

/**
 * Luokka tarjoaa pelaajien vuorojen hallintaan tarvittavat apumetodit sekä
 * pitää muistissa pelaajan omaaman merkin sekä pelattujen merkkien määrän.
 */
public class Pelaaja {

    private boolean vuoro;
    private int pelattujenMaara;
    private Merkki merkki;

    /**
     * Konstruktorissa Pelaajalle määrätään hänen merkkinsä sekä määrätään onko
     * hän aloitusvuorossa.
     *
     * @param m ,merkki jonka pelaaja saa.
     */
    public Pelaaja(Merkki m) {
        this.pelattujenMaara = 0;
        this.merkki = m;
        if (m == Merkki.RISTI) {
            this.vuoro = true;
        } else {
            this.vuoro = false;
        }

    }

    /**
     * Kertoo onko kyseisen pelaajan vuoro meneillään.
     *
     * @return true jos on pelaajan vuoro ja false jos on toisen pelaajan vuoro
     */
    public boolean onkoVuoro() {
        return vuoro;
    }

    /**
     * Metodi asettaa vuoron arvon false:ksi.
     */
    public void lopetaVuoro() {
        vuoro = false;
    }

    /**
     * Metodi asettaa vuoron arvon true:ksi.
     */
    public void aloitaVuoro() {
        vuoro = true;
    }

    /**
     * Metodi kasvattaa pelattujen merkkien maaraa yhdellä. Metodin parametri on
     * toistaiseksi turha.
     *
     * @param merkki Juuri pelattu merkki, joka lisätään pelattujen määrään.
     */
    public void lisaaPelattuMerkki(PeliMerkki merkki) {
        pelattujenMaara++;
    }

    /**
     * Metodi palauttaa jo pelattujen merkkien määrän pelaajan osalta.
     *
     * @return Jo pelattujen merkkien määrä
     */
    public int getPelatutMerkit() {
        return pelattujenMaara;
    }

    @Override
    public String toString() {
        return "Pelaaja " + merkki;
    }

    public Merkki getMerkki() {
        return merkki;
    }

    /**
     * Metodi nollaa pelaajan merkkien määrän.
     */
    public void nollaaPelatutMerkit() {
        pelattujenMaara = 0;
    }
}
