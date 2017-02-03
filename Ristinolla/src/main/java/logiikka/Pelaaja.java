/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import java.util.*;

public class Pelaaja {

    private boolean vuoro;
    private int pelattujenMaara;
    private Merkki merkki;

    public Pelaaja(Merkki m) {
        this.pelattujenMaara = 0;
        this.merkki = m;
        if (m == Merkki.RISTI) {
            this.vuoro = true;
        } else {
            this.vuoro = false;
        }

    }

    public boolean onkoVuoro() {
        return vuoro;
    }

    public void lopetaVuoro() {
        vuoro = false;
    }

    public void aloitaVuoro() {
        vuoro = true;
    }

    public void lisaaPelattuMerkki(PeliMerkki merkki) {
        pelattujenMaara++;
    }

    public int getPelatutMerkit() {
        return pelattujenMaara;
    }

    public String toString() {
        return "Pelaaja " + merkki;
    }

    public Merkki getMerkki() {
        return merkki;
    }
}
