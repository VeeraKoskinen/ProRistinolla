/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;
import java.util.*;
/**
 *
 * @author veerakoskinen
 */
public class Pelaaja {
    
    private int id;
    private boolean vuoro;
    private int pelatut;
    private char merkki;
    
    public Pelaaja(int id) {
        this.pelatut = 0;
        this.id = id;
        
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
        pelatut++;
    }
    
    public int getPelatutMerkit() {
        return pelatut;
    }
    
    public String toString() {
        return "Pelaaja " + id;
    }
    
    public char getMerkki() {
        return merkki;
    }
        
}
