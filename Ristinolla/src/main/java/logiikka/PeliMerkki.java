/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

public class PeliMerkki {

    private char merkki;
    private int x;
    private int y;

    public PeliMerkki(char merkki, int koordinaattiX, int koordinaattiY) {
        this.merkki = merkki;
        this.x = koordinaattiX;
        this.y = koordinaattiY;
    }

    public char getMerkki() {
        return merkki;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
