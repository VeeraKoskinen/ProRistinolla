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

    private JLayeredPane nakyma;
    private GraafinenPelilauta lauta;
    private GraafinenPyorayttaja pyorayttaja;
    private Logiikka logiikka;
    private JLabel palkki;
    

    public GraafinenKayttoliittyma() {
        this.logiikka = new Logiikka();
        this.palkki = new JLabel();
        this.nakyma = new JLayeredPane();
        int leveys = 300;
        int korkeus = 300;
        Dimension ikkuna = new Dimension(leveys, korkeus);
        nakyma.setPreferredSize(ikkuna);
        this.lauta = new GraafinenPelilauta(logiikka);
        lauta.setBounds(0, 0, leveys, korkeus);

        lauta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                int hiiriX = event.getX();
                int hiiriY = event.getY();

                int valittuRivi = hiiriX / lauta.getSolunKoko();
                int valittuSarake = hiiriY / lauta.getSolunKoko();

                Pelaaja vuorossa = lauta.getLogiikka().kummanVuoro();
                if (lauta.getLogiikka().pelaaVuoro(vuorossa, valittuSarake, valittuRivi)) {
                    nakyma.moveToFront(pyorayttaja);
                } else {
                    lauta.getLogiikka().alustaPeliUudelleen();  // jos henkilö asettaa merkkiä väärin alkaa peli toistaiseksi alusta
                    // käyttöliittymän alustus alkutilaan
                    lauta.setPelinTila(PelinTila.KAYNNISSA);
                }
                repaint();
            }
        });
        
        nakyma.add(lauta);
        this.pyorayttaja = new GraafinenPyorayttaja(logiikka);
        pyorayttaja.setBounds(0, 0, leveys, korkeus);
        pyorayttaja.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                int hiiriY = event.getX();
                int hiiriX = event.getY();
               
                if (hiiriX > 50 && hiiriX < 100 && hiiriY > 0 && hiiriY < 50) {  // vasemman yläkulman pyöraytys myötäpäivään
                    lauta.getLogiikka().getLauta().kierraVasenYlaMyotapaivaan();
                    paivitaPeli();
                    nakyma.moveToFront(lauta);
                } else if (hiiriX > 0 && hiiriX < 50 && hiiriY > 50 && hiiriY < 100) {  // vasemman yläkulman pyöräytys vastapäivään
                    lauta.getLogiikka().getLauta().kierraVasenYlaVastapaivaan();
                    paivitaPeli();
                    nakyma.moveToFront(lauta);
                } else if (hiiriX > 200 && hiiriX < 250 && hiiriY > 0 && hiiriY < 50) {  // oikean yläkulman pyöräytys vastapäivään
                    lauta.getLogiikka().getLauta().kierraOikeaYlaVastapaivaan();
                    paivitaPeli();
                    nakyma.moveToFront(lauta);
                } else if (hiiriX > 250 && hiiriX < 300 && hiiriY > 50 && hiiriY < 100) { // oikean yläkulman pyöräytys myötäpäivään
                    lauta.getLogiikka().getLauta().kierraOikeaYlaMyotapaivaan();
                    paivitaPeli();
                    nakyma.moveToFront(lauta);
                } else if (hiiriX > 0 && hiiriX < 50 && hiiriY > 200 && hiiriY < 250) { // vasemman alakulman pyöräytys myotapaivaan
                    lauta.getLogiikka().getLauta().kierraVasenAlaMyotapaivaan();
                    paivitaPeli();
                    nakyma.moveToFront(lauta);
                } else if (hiiriX > 50 && hiiriX < 100 && hiiriY > 250 && hiiriY < 300) {  // vasemman alakulman pyöraytys vastapäivään
                    lauta.getLogiikka().getLauta().kierraVasenAlaVastapaivaan();
                    paivitaPeli();
                    nakyma.moveToFront(lauta);
                } else if (hiiriX > 250 && hiiriX < 300 && hiiriY > 200 && hiiriY < 250) { // oikean alakulman pyöräytys vastapäivään
                    lauta.getLogiikka().getLauta().kierraOikeaAlaVastapaivaan();
                    paivitaPeli();
                    nakyma.moveToFront(lauta);
                } else if (hiiriX > 200 && hiiriX < 250 && hiiriY > 250 && hiiriY < 300) { // oikean alakulman pyöräytys myotapaivaan
                    lauta.getLogiikka().getLauta().kierraOikeaAlaMyotapaivaan();
                    paivitaPeli();
                    nakyma.moveToFront(lauta);
                }
            }
        });
        nakyma.add(pyorayttaja);
        lauta.getTilannepalkki().setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
        lauta.getTilannepalkki().setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));

        nakyma.moveToFront(lauta);
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(nakyma, BorderLayout.CENTER);
        cp.add(lauta.getTilannepalkki(), BorderLayout.PAGE_END); // sama kuin "SOUTH"

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();  // paketoidaan kaikki JFrame:ssa
        setTitle("ProRistinolla");
        setVisible(true);  // näyttää JFrame:n

    }

    public void paivitaPeli() {
        if (lauta.getLogiikka().onkoViidenSuoraa(Merkki.RISTI) && lauta.getLogiikka().onkoViidenSuoraa(Merkki.NOLLA)) {  // check for win
            lauta.setPelinTila(PelinTila.TASAPELI);
        } else if (lauta.getLogiikka().onkoViidenSuoraa(Merkki.RISTI)) {
            lauta.setPelinTila(PelinTila.RISTI_VOITTAA);
        }  else if (lauta.getLogiikka().onkoViidenSuoraa(Merkki.NOLLA)) {
            lauta.setPelinTila(PelinTila.NOLLA_VOITTAA);
        }  else if (lauta.getLogiikka().onkoTasapeli()) {
            lauta.setPelinTila(PelinTila.TASAPELI);
        }
        lauta.getLogiikka().vaihdaVuoroa();
    }

}
