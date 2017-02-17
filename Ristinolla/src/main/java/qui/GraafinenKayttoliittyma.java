/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import logiikka.*;
import qui.*;

/**
 *
 * @author veerakoskinen
 */
public class GraafinenKayttoliittyma extends JFrame {

    private GraafinenPelilauta lauta;

    public GraafinenKayttoliittyma() {
        int leveys = 300;
        int korkeus = 300;

        this.lauta = new GraafinenPelilauta(new JLabel("  "));
        lauta.setPreferredSize(new Dimension(leveys, korkeus));

        lauta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                int hiiriX = event.getX();
                int hiiriY = event.getY();

                int valittuRivi = hiiriX / lauta.getSolunKoko();
                int valittuSarake = hiiriY / lauta.getSolunKoko();

                Pelaaja vuorossa = lauta.getLogiikka().kummanVuoro();
                if (lauta.getLogiikka().pelaaVuoro(vuorossa, valittuSarake, valittuRivi)) {
                    lauta.getLogiikka().vaihdaVuoroa();
                    paivitaPeli(vuorossa.getMerkki());
                } else {
                    lauta.getLogiikka().alustaPeliUudelleen();  // jos henkilö asettaa merkkiä väärin alkaa peli toistaiseksi alusta
                    // käyttöliittymän alustus alkutilaan
                    lauta.setPelinTila(PelinTila.KAYNNISSA);
                }
                repaint();
            }
        });

        lauta.getTilannepalkki().setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
        lauta.getTilannepalkki().setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(lauta, BorderLayout.CENTER);
        cp.add(lauta.getTilannepalkki(), BorderLayout.PAGE_END); // sama kuin "SOUTH"

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();  // paketoidaan kaikki JFrame:ssa
        setTitle("ProRistinolla");
        setVisible(true);  // näyttää JFrame:n
        setResizable(false);

    }

    public void paivitaPeli(Merkki m) {
        if (lauta.getLogiikka().onkoViidenSuoraa(m)) {  // check for win
            if (lauta.getLogiikka().kummanVuoro().getMerkki() == Merkki.NOLLA) {
                lauta.setPelinTila(PelinTila.RISTI_VOITTAA);
            } else {
                lauta.setPelinTila(PelinTila.NOLLA_VOITTAA);
            }
        } else if (lauta.getLogiikka().onkoTasapeli()) {  // check for draw
            lauta.setPelinTila(PelinTila.TASAPELI);
        }
    }

}
