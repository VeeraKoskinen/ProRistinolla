/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qui;

import java.awt.*;
import javax.swing.*;
import logiikka.Merkki;
import logiikka.*;

/**
 *
 * @author veerakoskinen
 */
public class GraafinenPelilauta extends JPanel {

    private static final int sarakkeet = 6;
    private static final int rivit = 6;

    public static final int solunKoko = 50;
    public static final int leveys = solunKoko * sarakkeet;
    public static final int korkeus = solunKoko * rivit;
    public static final int ristikonLeveys = 8;    //ristikon viivojen leveys        

    public static final int solunappulanKoko = solunKoko / 6;  // onko tarpeeton
    public static final int symbolinKoko = solunKoko - solunappulanKoko * 2; // 
    public static final int symbolinViivanLeveys = 8; // piirtoviiva

    private Logiikka logiikka;
    private PelinTila pelinTila = PelinTila.KAYNNISSA;

    private JLabel tilannepalkki;  // statusbar

    public GraafinenPelilauta(JLabel tilasarake) {
        this.tilannepalkki = tilasarake;
        this.logiikka = new Logiikka();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);    // täyttää taustan
        setBackground(Color.CYAN); // asettaa taustavärin

        g.setColor(Color.LIGHT_GRAY);
        for (int viiva = 0; viiva < 6; ++viiva) {
            g.fillRoundRect(0, solunKoko * viiva - ristikonLeveys / 2, leveys - 1, ristikonLeveys, ristikonLeveys, ristikonLeveys);
        }
        for (int i = 1; i < sarakkeet; ++i) {
            g.fillRoundRect(solunKoko * i - ristikonLeveys / 2, 0, ristikonLeveys, korkeus - 1, ristikonLeveys, ristikonLeveys);
        }
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(symbolinViivanLeveys, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        for (int y = 0; y < rivit; ++y) {
            for (int x = 0; x < sarakkeet; ++x) {
                int x1 = x * solunKoko + solunappulanKoko;
                int y1 = y * solunKoko + solunappulanKoko;
                if (logiikka.getLauta().getPelilauta()[y][x] == Merkki.RISTI) {
                    g2D.setColor(Color.WHITE);
                    int x2 = (x + 1) * solunKoko - solunappulanKoko;
                    int y2 = (y + 1) * solunKoko - solunappulanKoko;
                    g2D.drawLine(x1, y1, x2, y2);
                    g2D.drawLine(x2, y1, x1, y2);
                } else if (logiikka.getLauta().getPelilauta()[y][x] == Merkki.NOLLA) {
                    g2D.setColor(Color.magenta);
                    g2D.drawOval(x1, y1, symbolinKoko, symbolinKoko);
                }
            }
        }
        if (pelinTila == PelinTila.KAYNNISSA) {
            tilannepalkki.setForeground(Color.BLACK);
            if (logiikka.kummanVuoro().getMerkki() == Merkki.RISTI) {
                tilannepalkki.setText("X:n VUORO");
            } else if (logiikka.kummanVuoro().getMerkki() == Merkki.NOLLA) {
                tilannepalkki.setText("O:n VUORO");
            }
        } else if (pelinTila == PelinTila.TASAPELI) {
            tilannepalkki.setForeground(Color.green);
            tilannepalkki.setText("Tasapeli!");
        } else if (pelinTila == PelinTila.RISTI_VOITTAA) {
            tilannepalkki.setForeground(Color.green);
            tilannepalkki.setText("'X' VOITTI!");
        } else if (pelinTila == PelinTila.NOLLA_VOITTAA) {
            tilannepalkki.setForeground(Color.green);
            tilannepalkki.setText("'O' VOITTI!");
        }
    }

    public JLabel getTilannepalkki() {
        return tilannepalkki;
    }

    public PelinTila getPelinTila() {
        return pelinTila;
    }

    public void setPelinTila(PelinTila uusi) {
        pelinTila = uusi;
    }

    public Logiikka getLogiikka() {
        return logiikka;
    }

    public int getSarakkeet() {
        return sarakkeet;
    }

    public int getRivit() {
        return rivit;
    }

    public int getSolunKoko() {
        return solunKoko;
    }

    public int getLeveys() {
        return leveys;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getRistikonLeveys() {
        return ristikonLeveys;
    }

    public int getSolunappulanKoko() {
        return solunappulanKoko;
    }

    public int getSymbolinKoko() {
        return symbolinKoko;
    }

    public int getSymbolinViivanLeveys() {
        return symbolinViivanLeveys;
    }
}
