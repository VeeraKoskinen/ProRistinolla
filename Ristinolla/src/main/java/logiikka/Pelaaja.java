/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;
import java.util.*;

public class Pelaaja {

    private int id;
    private boolean vuoro;
    private List<PeliMerkki> pelatut; 
    private int pelattujenMaara;
    private char merkki;

    public Pelaaja(int id) {
        this.pelattujenMaara = 0;
        this.id = id;
        this.pelatut = new ArrayList();
        if (this.id == 1) {
            this.vuoro = true;
            this.merkki = 'x';
        } else {
            this.vuoro = false;
            this.merkki = 'o';
        }
    }

    public int getId() {
        return id;
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
        pelatut.add(merkki);
        pelattujenMaara++;
    }

    public int getPelatutMerkit() {
        return pelattujenMaara;
    }
    
    public List getPelatut() {
        return pelatut;
    }

    public String toString() {
        return "Pelaaja " + id;
    }

    public char getMerkki() {
        return merkki;
    }
}
