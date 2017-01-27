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
    public void KonstruktoriAsettaaPelaajan1Oikein() {
        assertEquals(1, lauta.getPelaaja1().getId());
    }

    @Test
    public void KonstruktoriAsettaaPelaajan2Oikein() {
        assertEquals(2, lauta.getPelaaja2().getId());
    }

    @Test
    public void KonstruktoriAsettaaPelattujenMerkkienMaaranOikein() {
        assertEquals(0, lauta.getPelattujenMaara());
    }

    @Test
    public void KonstruktoriLuoPelilaudanOikean() {
        assertEquals(6, lauta.getPelilauta().length);  // sarake
        assertEquals(6, lauta.getPelilauta()[1].length);  // rivi 
    }
    
    
    // pelaaMerkki testit
    @Test
    public void pelaaMerkkiEiLisaaMerkkiaKunKoordinaattiOnLaudanUlkopuolella1() {
        this.lauta = new Pelilauta();
        lauta.pelaaMerkki(new PeliMerkki('x', 5,6));
        assertEquals(0,lauta.getPelattujenMaara());
    }
    
     @Test
    public void pelaaMerkkiEiLisaaMerkkiaKunKoordinaattiOnLaudanUlkopuolella2() {
        this.lauta = new Pelilauta();
        lauta.pelaaMerkki(new PeliMerkki('x', 6,4));
        assertEquals(0,lauta.getPelattujenMaara());
    }
    
    @Test
    public void pelaaMerkkiEiLisaaMerkkiaKunKoordinaattiOnLaudanUlkopuolella3() {
        this.lauta = new Pelilauta();
        lauta.pelaaMerkki(new PeliMerkki('x', -1,4));
        assertEquals(0,lauta.getPelattujenMaara());
    }
    
    @Test
    public void pelaaMerkkiEiLisaaMerkkiaKunKoordinaattiOnLaudanUlkopuolella4() {
        this.lauta = new Pelilauta();
        lauta.pelaaMerkki(new PeliMerkki('x', 3,-1));
        assertEquals(0,lauta.getPelattujenMaara());
    }
    
    @Test
    public void pelaaMerkkiEiLisaaMerkkiaKunKoordinaattiOnLaudanUlkopuolella5() {
        this.lauta = new Pelilauta();
        lauta.pelaaMerkki(new PeliMerkki('s', 3,4));
        assertEquals(0,lauta.getPelattujenMaara());
    }
    
    // onkoViisiVaakaan testit
    
    @Test
    public void onkoViisiVaakaan1() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[1][1] = 'x';
        assertFalse(lauta.onkoViisiVaakaan(1, 1));
    }
    
    @Test
    public void onkoViisiVaakaan2() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[0][2] = 'o';
        lauta.getPelilauta()[1][2] = 'o';
        lauta.getPelilauta()[2][2] = 'o';
        lauta.getPelilauta()[3][2] = 'o';
        lauta.getPelilauta()[4][2] = 'x';
        assertFalse(lauta.onkoViisiVaakaan(0, 2));
    }
    
    @Test
    public void onkoViisiVaakaan3() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[0][2] = 'o';
        lauta.getPelilauta()[1][2] = 'o';
        lauta.getPelilauta()[2][2] = 'o';
        lauta.getPelilauta()[3][2] = 'o';
        lauta.getPelilauta()[4][2] = 'o';
        assertTrue(lauta.onkoViisiVaakaan(0, 2));
    }
    
     @Test
    public void onkoViisiVaakaan4() {
        this.lauta = new Pelilauta();      
        lauta.getPelilauta()[1][2] = 'o';
        lauta.getPelilauta()[2][2] = 'o';
        lauta.getPelilauta()[3][2] = 'o';
        lauta.getPelilauta()[4][2] = 'o';
        assertFalse(lauta.onkoViisiVaakaan(1, 2));
    }
    
    
    // onkoViisiKaakkoon testit
    
    @Test
    public void onkoViisiKaakkoon1() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[1][1] = 'x';
        assertFalse(lauta.onkoViisiKaakkoon(1, 1));
    }
    
    @Test
    public void onkoViisiKaakkoon2() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[0][0] = 'o';
        lauta.getPelilauta()[1][1] = 'o';
        lauta.getPelilauta()[2][2] = 'o';
        lauta.getPelilauta()[3][3] = 'o';
        lauta.getPelilauta()[4][4] = 'x';
        assertFalse(lauta.onkoViisiKaakkoon(0, 0));
    }
    
    @Test
    public void onkoViisiKaakkoon3() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[0][0] = 'o';
        lauta.getPelilauta()[1][1] = 'o';
        lauta.getPelilauta()[2][2] = 'o';
        lauta.getPelilauta()[3][3] = 'o';
        lauta.getPelilauta()[4][4] = 'o';
        assertTrue(lauta.onkoViisiKaakkoon(0, 0));
    }
    
    @Test
    public void onkoViisiKaakkoon4() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[2][2] = 'o';
        lauta.getPelilauta()[3][3] = 'o';
        lauta.getPelilauta()[4][4] = 'o';
        lauta.getPelilauta()[5][5] = 'o';
        assertFalse(lauta.onkoViisiKaakkoon(0, 0));
    }
    
    
    // onkoViisiPystyyn testit
    
  @Test
    public void onkoViisiPystyyn1() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[5][5] = 'x';
        assertFalse(lauta.onkoViisiPystyyn(5, 5));
    }
    
    @Test
    public void onkoViisiPystyyn2() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[0][0] = 'o';
        lauta.getPelilauta()[0][1] = 'o';
        lauta.getPelilauta()[0][2] = 'o';
        lauta.getPelilauta()[0][3] = 'o';
        lauta.getPelilauta()[0][4] = 'x';
        assertFalse(lauta.onkoViisiPystyyn(0, 0));
    }
    
    @Test
    public void onkoViisiPystyyn3() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[0][0] = 'o';
        lauta.getPelilauta()[0][1] = 'o';
        lauta.getPelilauta()[0][2] = 'o';
        lauta.getPelilauta()[0][3] = 'o';
        lauta.getPelilauta()[0][4] = 'o';
        assertTrue(lauta.onkoViisiPystyyn(0, 0));
    }
    
    @Test
    public void onkoViisiPystyyn4() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[0][2] = 'o';
        lauta.getPelilauta()[0][3] = 'o';
        lauta.getPelilauta()[0][4] = 'o';
        lauta.getPelilauta()[0][5] = 'o';
        assertFalse(lauta.onkoViisiPystyyn(0, 2));
    }
      
    // onkoViisiLounaaseen testit

    @Test
    public void onkoViisiLounaaseen1() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[1][1] = 'x';
        assertFalse(lauta.onkoViisiLounaaseen(1, 1));
    }
    
    @Test
    public void onkoViisiLounaaseen2() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[5][0] = 'o';
        lauta.getPelilauta()[4][1] = 'o';
        lauta.getPelilauta()[3][2] = 'o';
        lauta.getPelilauta()[2][3] = 'o';
        lauta.getPelilauta()[1][4] = 'x';
        assertFalse(lauta.onkoViisiLounaaseen(5, 0));
    }
    
    @Test
    public void onkoViisiLounaaseen3() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[5][0] = 'o';
        lauta.getPelilauta()[4][1] = 'o';
        lauta.getPelilauta()[3][2] = 'o';
        lauta.getPelilauta()[2][3] = 'o';
        lauta.getPelilauta()[1][4] = 'o';
        assertTrue(lauta.onkoViisiLounaaseen(5, 0));
    }
    
    @Test
    public void onkoViisiLounaaseen4() {
        this.lauta = new Pelilauta();
        lauta.getPelilauta()[3][2] = 'o';
        lauta.getPelilauta()[2][3] = 'o';
        lauta.getPelilauta()[1][4] = 'o';
        lauta.getPelilauta()[0][5] = 'o';
        assertFalse(lauta.onkoViisiLounaaseen(3, 2));
    }
    
    
}
