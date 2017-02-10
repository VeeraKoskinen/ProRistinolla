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
public class PelaajaTest {
    
    public PelaajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    // konstruktorin testit
    
    
    @Test
    public void konstruktoriAsettaaPelattujenMaaranOikein() {
        Pelaaja p1 = new Pelaaja(Merkki.RISTI);
        Pelaaja p2 = new Pelaaja(Merkki.NOLLA);
        assertEquals(0, p1.getPelatutMerkit());
        assertEquals(0, p2.getPelatutMerkit());
        
    } 
    
    @Test
    public void konstruktoriAsettaaPelaajanMerkinOikeaksiKunMerkkiOnRisti() {
        Pelaaja p = new Pelaaja(Merkki.RISTI);
        assertEquals('x', p.getMerkki().getMerkki());
    }
    
    @Test
    public void konstruktoriAsettaaPelaajanMerkinOikeaksiKunMerkkiOnNolla() {
        Pelaaja p = new Pelaaja(Merkki.NOLLA);
        assertEquals('o', p.getMerkki().getMerkki());
    }
    
    @Test
    public void konstruktoriAsettaaPelaajanMerkinOikeaksiKunMerkkiOnTyhja() {
        Pelaaja p = new Pelaaja(Merkki.TYHJA);
        assertEquals('t', p.getMerkki().getMerkki());
    }
 
    @Test
    public void konstruktoriAsettaaPelaajan1VuoronAlkuunTrue() {
        Pelaaja p = new Pelaaja(Merkki.RISTI);
        assertTrue(p.onkoVuoro());
    }
    
    @Test
    public void konstruktoriAsettaaPelaajan2VuoronAlkuunFalse() {
        Pelaaja p = new Pelaaja(Merkki.NOLLA);
        assertFalse(p.onkoVuoro());
    }
    
    // aloita vuoro -metodin testit
    
    @Test
    public void aloitaVuoroMetodiAsettaaPelaajanKaksiVuoronTrue() {
        Pelaaja p = new Pelaaja(Merkki.NOLLA);
        p.aloitaVuoro();
        assertTrue(p.onkoVuoro());
    } 
    
    @Test
    public void aloitaVuoroMetodiAsettaaPelaajanYksiVuoronTrue() {
        Pelaaja p = new Pelaaja(Merkki.RISTI);
        p.aloitaVuoro();
        assertTrue(p.onkoVuoro());
    } 
    
    // lopeta vuoro -metodin testit
    
    @Test
    public void lopetaVuoroMetodiAsettaaPelaajanYksiVuoronFalse() {
        Pelaaja p = new Pelaaja(Merkki.RISTI);
        p.lopetaVuoro();
        assertFalse(p.onkoVuoro());
    } 
    
    @Test
    public void lopetaVuoroMetodiAsettaaPelaajanKaksiVuoronFalse1() {
        Pelaaja p = new Pelaaja(Merkki.NOLLA);
        p.lopetaVuoro();
        assertFalse(p.onkoVuoro());
    } 
    
    @Test
    public void lopetaVuoroMetodiAsettaaPelaajanKaksiVuoronFalse2() {
        Pelaaja p = new Pelaaja(Merkki.NOLLA);
        p.aloitaVuoro();
        p.lopetaVuoro();
        assertFalse(p.onkoVuoro());
    } 
    
    // toString tulostaa pelaajan halutullatavalla
    
    @Test
    public void toStringPalauttaaPelaajan1TiedotOikein() {
        Pelaaja p = new Pelaaja(Merkki.NOLLA);
        assertEquals("Pelaaja o", p.toString());
    }
    
    
    // pelattujenMerkkienMaara testit
    
    
    @Test
    public void MaaraOnOikeaKunmerkkejaonPelattu0() {
        Pelaaja p = new Pelaaja(Merkki.NOLLA);
        assertEquals(0, p.getPelatutMerkit());
    }
    
    @Test
    public void MaaraOnOikeaKunMerkkejaOnPelattu1() {
        Pelaaja p = new Pelaaja(Merkki.NOLLA);
        p.lisaaPelattuMerkki(new PeliMerkki(Merkki.NOLLA, 2, 3));
        assertEquals(1, p.getPelatutMerkit());
    }
    
    @Test
    public void MaaraOnOikeaKunMerkkejaOnPelattu4() {
        Pelaaja p = new Pelaaja(Merkki.NOLLA);
        p.lisaaPelattuMerkki(new PeliMerkki(Merkki.NOLLA, 2, 3));
        p.lisaaPelattuMerkki(new PeliMerkki(Merkki.NOLLA, 5, 3));
        p.lisaaPelattuMerkki(new PeliMerkki(Merkki.NOLLA, 1, 3));
        p.lisaaPelattuMerkki(new PeliMerkki(Merkki.NOLLA, 0, 3));
        assertEquals(4, p.getPelatutMerkit());
    }
    
    // pelattujen maaran nollaus
    
    @Test
    public void nollaaPelatutMerkitMuuttaaMerkkienMaaraaOikein1() {
        Pelaaja p = new Pelaaja(Merkki.NOLLA);
        p.lisaaPelattuMerkki(new PeliMerkki(Merkki.NOLLA, 2, 3));
        p.lisaaPelattuMerkki(new PeliMerkki(Merkki.NOLLA, 2, 4));
        p.nollaaPelatutMerkit();
        assertEquals(0, p.getPelatutMerkit());
    }
    
    @Test
    public void nollaaPelatutMerkitMuuttaaMerkkienMaaraaOikein2() {
        Pelaaja p = new Pelaaja(Merkki.NOLLA);
        p.nollaaPelatutMerkit();
        assertEquals(0, p.getPelatutMerkit());
    }
    
     @Test
    public void nollaaPelatutMerkitMuuttaaMerkkienMaaraaOikein3() {
        Pelaaja p = new Pelaaja(Merkki.NOLLA);
        p.lisaaPelattuMerkki(new PeliMerkki(Merkki.NOLLA, 2, 3));
        p.lisaaPelattuMerkki(new PeliMerkki(Merkki.NOLLA, 1, 4));
        p.lisaaPelattuMerkki(new PeliMerkki(Merkki.NOLLA, 2, 5));
        p.lisaaPelattuMerkki(new PeliMerkki(Merkki.NOLLA, 3, 4));
        p.nollaaPelatutMerkit();
        assertEquals(0, p.getPelatutMerkit());
    }
    
    
}
