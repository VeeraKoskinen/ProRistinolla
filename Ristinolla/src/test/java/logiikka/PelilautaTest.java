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
public class PelilautaTest {

    private Pelilauta lauta;

    public PelilautaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.lauta = new Pelilauta();
    }

    @After
    public void tearDown() {

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void KonstruktoriAsettaaPelattujenMerkkienMaaranOikein() {
        assertEquals(0, lauta.getPelattujenMaara());
    }

    @Test
    public void KonstruktoriLuoPelilaudanOikean() {
        assertEquals(6, lauta.getPelilauta().length);  // sarake
        assertEquals(6, lauta.getPelilauta()[1].length);  // rivi 
    }

    // onkoViisiVaakaan testit
    @Test
    public void onkoViisiVaakaan1() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[1][1] = Merkki.RISTI;
        assertFalse(lauta.onkoViisiVaakaan(1, 1));
    }

    @Test
    public void onkoViisiVaakaan2() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[0][2] = Merkki.NOLLA;
        lauta.getPelilauta()[1][2] = Merkki.NOLLA;
        lauta.getPelilauta()[2][2] = Merkki.NOLLA;
        lauta.getPelilauta()[3][2] = Merkki.NOLLA;
        lauta.getPelilauta()[4][2] = Merkki.NOLLA;
        assertTrue(lauta.onkoViisiVaakaan(0, 2));
    }

    @Test
    public void onkoViisiVaakaan3() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[0][2] = Merkki.NOLLA;
        lauta.getPelilauta()[1][2] = Merkki.NOLLA;
        lauta.getPelilauta()[2][2] = Merkki.NOLLA;
        lauta.getPelilauta()[3][2] = Merkki.NOLLA;
        lauta.getPelilauta()[4][2] = Merkki.NOLLA;
        assertTrue(lauta.onkoViisiVaakaan(0, 2));
    }

    @Test
    public void onkoViisiVaakaan4() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[1][2] = Merkki.NOLLA;
        lauta.getPelilauta()[2][2] = Merkki.NOLLA;
        lauta.getPelilauta()[3][2] = Merkki.NOLLA;
        lauta.getPelilauta()[4][2] = Merkki.NOLLA;
        assertFalse(lauta.onkoViisiVaakaan(1, 2));
    }
    
    @Test
    public void onkoViisiVaakaan5() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[2][2] = Merkki.NOLLA;
        lauta.getPelilauta()[3][2] = Merkki.NOLLA;
        lauta.getPelilauta()[4][2] = Merkki.NOLLA;
        lauta.getPelilauta()[5][2] = Merkki.NOLLA;
        assertFalse(lauta.onkoViisiVaakaan(2, 2));
    }
    
    @Test
    public void onkoViisiVaakaan6() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[2][5] = Merkki.NOLLA;
        lauta.getPelilauta()[3][5] = Merkki.NOLLA;
        lauta.getPelilauta()[4][5] = Merkki.NOLLA;
        lauta.getPelilauta()[5][5] = Merkki.NOLLA;
        assertFalse(lauta.onkoViisiVaakaan(2, 5));
    }
    
    

    // onkoViisiKaakkoon testit
    @Test
    public void onkoViisiKaakkoon1() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[1][1] = Merkki.RISTI;
        assertFalse(lauta.onkoViisiKaakkoon(1, 1));
    }

    @Test
    public void onkoViisiKaakkoon2() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[0][0] = Merkki.NOLLA;
        lauta.getPelilauta()[1][1] = Merkki.NOLLA;
        lauta.getPelilauta()[2][2] = Merkki.NOLLA;
        lauta.getPelilauta()[3][3] = Merkki.NOLLA;
        lauta.getPelilauta()[4][4] = Merkki.RISTI;
        assertFalse(lauta.onkoViisiKaakkoon(0, 0));
    }

    @Test
    public void onkoViisiKaakkoon3() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[0][0] = Merkki.NOLLA;
        lauta.getPelilauta()[1][1] = Merkki.NOLLA;
        lauta.getPelilauta()[2][2] = Merkki.NOLLA;
        lauta.getPelilauta()[3][3] = Merkki.NOLLA;
        lauta.getPelilauta()[4][4] = Merkki.NOLLA;
        assertTrue(lauta.onkoViisiKaakkoon(0, 0));
    }

    @Test
    public void onkoViisiKaakkoon4() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[2][2] = Merkki.NOLLA;
        lauta.getPelilauta()[3][3] = Merkki.NOLLA;
        lauta.getPelilauta()[4][4] = Merkki.NOLLA;
        lauta.getPelilauta()[5][5] = Merkki.NOLLA;
        assertFalse(lauta.onkoViisiKaakkoon(2, 2));
    }
    
    @Test
    public void onkoViisiKaakkoon5() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[2][3] = Merkki.NOLLA;
        lauta.getPelilauta()[3][4] = Merkki.NOLLA;
        lauta.getPelilauta()[4][5] = Merkki.NOLLA;
        assertFalse(lauta.onkoViisiKaakkoon(2, 3));
    }

    // onkoViisiPystyyn testit
    @Test
    public void onkoViisiPystyyn1() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[5][5] = Merkki.RISTI;
        assertFalse(lauta.onkoViisiPystyyn(5, 5));
    }

    @Test
    public void onkoViisiPystyyn2() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[0][0] = Merkki.NOLLA;
        lauta.getPelilauta()[0][1] = Merkki.NOLLA;
        lauta.getPelilauta()[0][2] = Merkki.NOLLA;
        lauta.getPelilauta()[0][3] = Merkki.NOLLA;
        lauta.getPelilauta()[0][4] = Merkki.RISTI;
        assertFalse(lauta.onkoViisiPystyyn(0, 0));
    }

    @Test
    public void onkoViisiPystyyn3() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[0][0] = Merkki.NOLLA;
        lauta.getPelilauta()[0][1] = Merkki.NOLLA;
        lauta.getPelilauta()[0][2] = Merkki.NOLLA;
        lauta.getPelilauta()[0][3] = Merkki.NOLLA;
        lauta.getPelilauta()[0][4] = Merkki.NOLLA;
        assertTrue(lauta.onkoViisiPystyyn(0, 0));
    }

    @Test
    public void onkoViisiPystyyn4() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[0][2] = Merkki.NOLLA;
        lauta.getPelilauta()[0][3] = Merkki.NOLLA;
        lauta.getPelilauta()[0][4] = Merkki.NOLLA;
        lauta.getPelilauta()[0][5] = Merkki.NOLLA;
        assertFalse(lauta.onkoViisiPystyyn(0, 2));
    }

    // onkoViisiLounaaseen testit
    @Test
    public void onkoViisiLounaaseen1() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[1][1] = Merkki.RISTI;
        assertFalse(lauta.onkoViisiLounaaseen(1, 1));
    }

    @Test
    public void onkoViisiLounaaseen2() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[5][0] = Merkki.NOLLA;
        lauta.getPelilauta()[4][1] = Merkki.NOLLA;
        lauta.getPelilauta()[3][2] = Merkki.NOLLA;
        lauta.getPelilauta()[2][3] = Merkki.NOLLA;
        lauta.getPelilauta()[1][4] = Merkki.RISTI;
        assertFalse(lauta.onkoViisiLounaaseen(5, 0));
    }

    @Test
    public void onkoViisiLounaaseen3() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[5][0] = Merkki.NOLLA;
        lauta.getPelilauta()[4][1] = Merkki.NOLLA;
        lauta.getPelilauta()[3][2] = Merkki.NOLLA;
        lauta.getPelilauta()[2][3] = Merkki.NOLLA;
        lauta.getPelilauta()[1][4] = Merkki.NOLLA;
        assertTrue(lauta.onkoViisiLounaaseen(5, 0));
    }

    @Test
    public void onkoViisiLounaaseen4() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[3][2] = Merkki.NOLLA;
        lauta.getPelilauta()[2][3] = Merkki.NOLLA;
        lauta.getPelilauta()[1][4] = Merkki.NOLLA;
        lauta.getPelilauta()[0][5] = Merkki.NOLLA;
        assertFalse(lauta.onkoViisiLounaaseen(3, 2));
    }

    // voiko merkin lisata laudalle
    @Test
    public void voikoMerkinLisataLaudallePalauttaaTrueKunMerkinKoordinaatitOvatValilla0Ja5() {
        assertTrue(lauta.voikoMerkinLisataKoordinaattiin(0, 0));
        assertTrue(lauta.voikoMerkinLisataKoordinaattiin(5, 0));
        assertTrue(lauta.voikoMerkinLisataKoordinaattiin(0, 5));
        assertTrue(lauta.voikoMerkinLisataKoordinaattiin(5, 5));
        assertTrue(lauta.voikoMerkinLisataKoordinaattiin(3, 4));
    }

    @Test
    public void voikoMerkinLisataLaudallePalauttaaFalseKunMerkinKoordinaatitEivatOleValilla0Ja5() {
        assertFalse(lauta.voikoMerkinLisataKoordinaattiin(-1, 0));
        assertFalse(lauta.voikoMerkinLisataKoordinaattiin(5, -1));
        assertFalse(lauta.voikoMerkinLisataKoordinaattiin(6, 0));
        assertFalse(lauta.voikoMerkinLisataKoordinaattiin(-1, 7));
        assertFalse(lauta.voikoMerkinLisataKoordinaattiin(8, 6));        
    }
    
    // tulosta lauta testit (ei testejä, koska väliaikaisessa käytössä)
    
    
}
