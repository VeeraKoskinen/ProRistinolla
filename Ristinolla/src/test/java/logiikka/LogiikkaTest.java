/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author veerakoskinen
 */
public class LogiikkaTest {

    private Logiikka logiikka;

    public LogiikkaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Logiikka logiikka = new Logiikka();
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    // konsturktorin testit
    @Test
    public void konstruktoriLuoPelilaudanOikein() {
        this.logiikka = new Logiikka();
        assertEquals(0, logiikka.getLauta().getPelattujenMaara());
    }

    // pelaaMerkki testit
    @Test
    public void pelaaMerkkiEiLisaaMerkkiaKunKoordinaattiOnLaudanUlkopuolella1() {
        this.logiikka = new Logiikka();
        assertFalse(logiikka.pelaaMerkki(new PeliMerkki(Merkki.RISTI, 5, 6)));
    }

    @Test
    public void pelaaMerkkiEiLisaaMerkkiaKunKoordinaattiOnLaudanUlkopuolella2() {
        this.logiikka = new Logiikka();
        assertFalse(logiikka.pelaaMerkki(new PeliMerkki(Merkki.RISTI, 6, 4)));
    }

    @Test
    public void pelaaMerkkiEiLisaaMerkkiaKunKoordinaattiOnLaudanUlkopuolella3() {
        this.logiikka = new Logiikka();
        assertFalse(logiikka.pelaaMerkki(new PeliMerkki(Merkki.RISTI, -1, 4)));
    }

    @Test
    public void pelaaMerkkiEiLisaaMerkkiaKunKoordinaattiOnLaudanUlkopuolella4() {
        this.logiikka = new Logiikka();
        assertFalse(logiikka.pelaaMerkki(new PeliMerkki(Merkki.NOLLA, 3, -1)));
    }

    @Test
    public void pelaaMerkkiEiLisaaMerkkiaKunKoordinaattiOnLaudanUlkopuolella5() {
        this.logiikka = new Logiikka();
        assertFalse(logiikka.pelaaMerkki(new PeliMerkki(Merkki.TYHJA, 3, 4)));
    }

    @Test
    public void LisaaMerkinKunMerkkiKuuluuPeliaulueelle() {
        this.logiikka = new Logiikka();
        assertTrue(logiikka.pelaaMerkki(new PeliMerkki(Merkki.RISTI, 3, 4)));
        assertTrue(logiikka.pelaaMerkki(new PeliMerkki(Merkki.NOLLA, 2, 4)));
    }

    // pelaa vuoro testit
    @Test
    public void pelaaVuoroEiAsetaLaudanUlkopuolistaKoordinaattia1() {
        this.logiikka = new Logiikka();
        assertFalse(logiikka.pelaaVuoro(logiikka.getLauta().getPelaaja1(), 4, 6));
    }

    @Test
    public void pelaaVuoroEiAsetaLaudanUlkopuolistaKoordinaattia2() {
        this.logiikka = new Logiikka();
        assertFalse(logiikka.pelaaVuoro(logiikka.getLauta().getPelaaja1(), 6, 3));
    }

    @Test
    public void pelaaVuoroEiAsetaKoordinaattiinMerkkiaJosRuutuOnJoVarattu() {
        this.logiikka = new Logiikka();
        logiikka.pelaaVuoro(logiikka.getLauta().getPelaaja2(), 2, 3);
        assertFalse(logiikka.pelaaVuoro(logiikka.getLauta().getPelaaja1(), 2, 3));
    }

    @Test
    public void pelaaVuoroAsettaaMerkinLaudanTyhjaanRuutuun_4_3() {
        this.logiikka = new Logiikka();
        assertTrue(logiikka.pelaaVuoro(logiikka.getLauta().getPelaaja1(), 4, 3));
    }

    // vaihda vuoroa testit
    @Test
    public void vaihdaVuoroaVaihtaaPelaajanYksiFalseJaPelaajanKaksiTrueKutsuttaessaEnsimmaisenKerran() {
        this.logiikka = new Logiikka();
        logiikka.vaihdaVuoroa();
        assertTrue(logiikka.getLauta().getPelaaja2().onkoVuoro());
        assertFalse(logiikka.getLauta().getPelaaja1().onkoVuoro());
    }

    @Test
    public void vaihdaVuoroaVaihtaaPelaajanYksiTrueJaPelaajanKaksiFalseKahdellaVuoronVaihdolla() {
        this.logiikka = new Logiikka();
        logiikka.vaihdaVuoroa();
        logiikka.vaihdaVuoroa();
        assertFalse(logiikka.getLauta().getPelaaja2().onkoVuoro());
        assertTrue(logiikka.getLauta().getPelaaja1().onkoVuoro());
    }

    @Test
    public void vaihdaVuoroaVaihtaaPelaajanYksiFalseJaPelaajanKaksiTrueViidellaVaihdolla() {
        this.logiikka = new Logiikka();
        logiikka.vaihdaVuoroa();
        logiikka.vaihdaVuoroa();
        logiikka.vaihdaVuoroa();
        logiikka.vaihdaVuoroa();
        logiikka.vaihdaVuoroa();
        assertFalse(logiikka.getLauta().getPelaaja1().onkoVuoro());
        assertTrue(logiikka.getLauta().getPelaaja2().onkoVuoro());
    }

    // pelaa merkki testit
    @Test
    public void pelaaMerkkiPalauttaaTrueKunMerkkiVoidaanAsettaaLaudalle() {
        this.logiikka = new Logiikka();
        assertTrue(logiikka.pelaaMerkki(new PeliMerkki(Merkki.RISTI, 3, 2)));
    }

    @Test
    public void pelaaMerkkiPalauttaaFalseKunMerkinX_9_koordinaattiOnUlkonaLaudalta() {
        this.logiikka = new Logiikka();
        assertFalse(logiikka.pelaaMerkki(new PeliMerkki(Merkki.RISTI, 9, 2)));
    }

    @Test
    public void pelaaMerkkiPalauttaaFalseKunMerkinY_6_koordinaattiOnUlkonaLaudalta() {
        this.logiikka = new Logiikka();
        assertFalse(logiikka.pelaaMerkki(new PeliMerkki(Merkki.RISTI, 2, 6)));
    }

    @Test
    public void pelaaMerkkiPalauttaaFalseKunRuudussaOnJoMerkki() {
        this.logiikka = new Logiikka();
        logiikka.pelaaMerkki(new PeliMerkki(Merkki.NOLLA, 2, 2));
        assertFalse(logiikka.pelaaMerkki(new PeliMerkki(Merkki.RISTI, 2, 2)));
    }

    // onko viiden suoraa
    @Test
    public void onkoViidenSuoraaPalauttaaTrueKunEnsimmaisellaVaakarivillaOnSuora() {
        this.logiikka = new Logiikka();
        for (int i = 0; i < 5; i++) {
            logiikka.pelaaMerkki(new PeliMerkki(Merkki.RISTI, i, 0));
        }
        assertTrue(logiikka.onkoViidenSuoraa(Merkki.RISTI));
    }

    @Test
    public void onkoViidenSuoraaPalauttaaTrueKunKolmannellaVaakarivillaOnSuora() {
        this.logiikka = new Logiikka();
        for (int i = 0; i < 5; i++) {
            logiikka.pelaaMerkki(new PeliMerkki(Merkki.NOLLA, i, 2));
        }
        assertTrue(logiikka.onkoViidenSuoraa(Merkki.NOLLA));
    }

    @Test
    public void onkoViidenSuoraaPalauttaaTrueKunEnsimmaisellaPystyrivillaOnSuora() {
        this.logiikka = new Logiikka();
        for (int i = 0; i < 5; i++) {
            logiikka.pelaaMerkki(new PeliMerkki(Merkki.RISTI, 0, i));
        }
        assertTrue(logiikka.onkoViidenSuoraa(Merkki.RISTI));
    }

    @Test
    public void onkoViidenSuoraaPalauttaaTrueKunLaskevallaVinorivillaOnSuora() {
        this.logiikka = new Logiikka();
        for (int i = 1; i < 6; i++) {
            logiikka.pelaaMerkki(new PeliMerkki(Merkki.RISTI, i, i));
        }
        assertTrue(logiikka.onkoViidenSuoraa(Merkki.RISTI));
    }

    @Test
    public void onkoViidenSuoraaPalauttaaTrueKunNousevallaVinorivillaOnSuora() {
        this.logiikka = new Logiikka();
        int s = 0;
        for (int i = 5; i > 0; i--) {
            logiikka.pelaaMerkki(new PeliMerkki(Merkki.RISTI, i, s));
            s++;
        }
        assertTrue(logiikka.onkoViidenSuoraa(Merkki.RISTI));
    }

    // onko tasapeli testit
    @Test
    public void onkoTasapeliPalauttaaFalseKunMerkkejaOnPelattu2() {
        this.logiikka = new Logiikka();
        logiikka.pelaaMerkki(new PeliMerkki(Merkki.RISTI, 2, 3));
        logiikka.pelaaMerkki(new PeliMerkki(Merkki.NOLLA, 1, 3));
        assertFalse(logiikka.onkoTasapeli());
    }

    @Test
    public void onkoTasapeliPalauttaaFalseKunMerkkejaOnPelattu35() {
        this.logiikka = new Logiikka();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 5 && j == 5) {
                    continue;
                } else {
                    logiikka.pelaaMerkki(new PeliMerkki(Merkki.RISTI, j, i));
                }
            }
        }
        assertFalse(logiikka.onkoTasapeli());
    }

    @Test
    public void onkoTasapeliPalauttaaTrueKunMerkkejaOnPelattu36() {
        this.logiikka = new Logiikka();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                logiikka.pelaaMerkki(new PeliMerkki(Merkki.RISTI, j, i));
            }
        }
        assertTrue(logiikka.onkoTasapeli());
    }
    
    // kummanVuoro testit
    
    @Test
    public void kummanVuoroPalauttaaPelaajan1KunPeliAlkaa() {
        this.logiikka = new Logiikka();
        assertEquals(Merkki.RISTI,logiikka.kummanVuoro().getMerkki());
    }
    
    @Test
    public void kummanVuoroPalauttaaPelaajan2KunOnPelattuYksiVuoro() {
        this.logiikka = new Logiikka();
        logiikka.vaihdaVuoroa();
        assertEquals(Merkki.NOLLA,logiikka.kummanVuoro().getMerkki());
    }
    
    @Test
    public void kummanVuoroPalauttaaPelaajan2KunOnPelattu10Vuoroa() {
        this.logiikka = new Logiikka();
        for (int i = 0; i < 9; i++) {
            logiikka.vaihdaVuoroa();
        }
        assertEquals(Merkki.NOLLA,logiikka.kummanVuoro().getMerkki());
    }
    
    // pelin uudelleen alustuksen testi
    @Test
    public void alustaUudelleenAustaaPelilaudanAlkutilaan() {
        this.logiikka = new Logiikka();
        assertEquals(0, logiikka.getLauta().getPelattujenMaara());
        assertTrue(logiikka.getLauta().getPelaaja1().onkoVuoro());
        assertFalse(logiikka.getLauta().getPelaaja2().onkoVuoro());
    }

    //
}
