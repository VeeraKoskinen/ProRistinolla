/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

/**
 * Luokka sisältää pelimerkin korrdinaatteineen ja näiden get -metodit.
 */
public class PeliMerkki {

    private Merkki merkki;
    private int x;
    private int y;

    public PeliMerkki(Merkki merkki, int koordinaattiX, int koordinaattiY) {
        this.merkki = merkki;
        this.x = koordinaattiX;
        this.y = koordinaattiY;
    }

    public Merkki getMerkki() {
        return merkki;
    }
 
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
