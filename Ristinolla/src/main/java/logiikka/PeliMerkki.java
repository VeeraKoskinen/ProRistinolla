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

    /**
     * Palauttaa PeliMerkin merkin.
     * @return merkin enum -arvon
     */
    public Merkki getMerkki() {
        return merkki;
    }
    /**
     * Palauttaa PeliMerkin x-koordinaatin.
     * @return x-koordinaatti
     */
    public int getX() {
        return x;
    }
    /**
     * Palauttaa PeliMerkin y-koordinaatin.
     * @return y-koordinaatti
     */
    public int getY() {
        return y;
    }
}
