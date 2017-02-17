/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

/**
 *
 * @author veerakoskinen
 */
/**
 * Pelilaudalla ilmentyvät merkit.
 */
public enum Merkki {

    RISTI('x'),
    NOLLA('o'),
    TYHJA('t');

    private final char merkki;
    
    /**
    * Konstruktorissa asetetaan merkeille omat char arvot, jotka helpottavat testien tulkintaa.
    * 
    * @param merkki 
    */    
    Merkki(char merkki) {
        this.merkki = merkki;
    }

    public char getMerkki() {
        return merkki;
    }

    @Override
    public String toString() {
        return "" + merkki + "";
    }

}
