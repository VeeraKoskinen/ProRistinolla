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
public class PeliMerkki {
    // implements Comparable<PeliMerkki> 

    private int pelaajaId;
    //private int paikkaJonossa;
    private char merkki;
    private int x;
    private int y;

    public PeliMerkki(int pelaaja, char merkki) {  //, int paikkaJonossa
        this.pelaajaId = pelaaja;
        //this.paikkaJonossa = paikkaJonossa;
        this.x = 20;
        this.y = 20;
        this.merkki = merkki;
    }

    public int getPelaajaId() {
        return pelaajaId;
    }
    
    public char getMerkki() {
        return merkki;
    }

//    public int getpaikkaJonossa() {
//        return paikkaJonossa;
//    }

    public void setXJaY(int koordinaattiX, int koordinaattiY) {
        if (koordinaattiX < 6 && koordinaattiY < 6) {
            this.x = koordinaattiX;
            this.y = koordinaattiY;
        } 
        else {
            System.out.println("Nyt valitsemasi koordinaattipiste ei ole pelialueella. Yritä uudelleen.");
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

//    @Override
//    public int compareTo(PeliMerkki o) {
//        if (paikkaJonossa - o.paikkaJonossa < 0) {
//            return 1;
//        } else if (paikkaJonossa - o.paikkaJonossa > 0) {
//            return -1;
//        } else {
//            if (pelaajaId - o.pelaajaId < 0) {
//                return 1;
//            } else if (pelaajaId - o.pelaajaId > 0) {
//                return -1;
//            }
//            return 0;
//        }
//    }

  

}
