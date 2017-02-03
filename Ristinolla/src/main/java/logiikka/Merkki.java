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
public enum Merkki{
    RISTI ('x'),
    NOLLA ('o'),
    TYHJA ('t');
    
    private char merkki;
    
    Merkki(char merkki) {
        this.merkki = merkki;
    }
    
    public char getMerkki() {
        return merkki;
    }
    
    public String toString() {
        return "" + merkki + "";
    }


}  
