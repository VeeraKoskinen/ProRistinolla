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
    public void konstruktoriAsettaaIdnOikein() {
        Pelaaja p1 = new Pelaaja(1);
        assertEquals(1, p1.getId());
        Pelaaja p2 = new Pelaaja(2);
        assertEquals(2, p2.getId());
    }
    
    @Test
    public void konstruktoriAsettaaPelattujenMaaranOikein() {
        Pelaaja p1 = new Pelaaja(1);
        Pelaaja p2 = new Pelaaja(2);
        assertEquals(0, p1.getPelatutMerkit());
        assertEquals(0, p2.getPelatutMerkit());
        
    } 
    
    @Test
    public void konstruktoriAsettaaPelattujenListanAlkuunTyhjaksi() {
        Pelaaja p = new Pelaaja(1);
        Pelaaja p2 = new Pelaaja(2);
        assertEquals(0, p.getPelatut().size());
        assertEquals(0, p2.getPelatut().size());
    } 
    
    @Test
    public void konstruktoriAsettaaPelaajanMerkinOikeaksiKunIdOn1() {
        Pelaaja p = new Pelaaja(1);
        assertEquals('x', p.getMerkki());
    }
    
    @Test
    public void konstruktoriAsettaaPelaajanMerkinOikeaksiKunIdOn2() {
        Pelaaja p = new Pelaaja(2);
        assertEquals('o', p.getMerkki());
    }
    
    @Test
    public void konstruktoriAsettaaPelaajanMerkinOikeaksiKunIdOn6() {
        Pelaaja p = new Pelaaja(6);
        assertEquals('o', p.getMerkki());
    }
 
    @Test
    public void konstruktoriAsettaaPelaajan1VuoronAlkuunTrue() {
        Pelaaja p = new Pelaaja(1);
        assertTrue(p.onkoVuoro());
    }
    
    @Test
    public void konstruktoriAsettaaPelaajan2VuoronAlkuunFalse() {
        Pelaaja p = new Pelaaja(2);
        assertFalse(p.onkoVuoro());
    }
    
    // aloita vuoro -metodin testit
    
    @Test
    public void aloitaVuoroMetodiAsettaaPelaajanKaksiVuoronTrue() {
        Pelaaja p = new Pelaaja(2);
        p.aloitaVuoro();
        assertTrue(p.onkoVuoro());
    } 
    
    @Test
    public void aloitaVuoroMetodiAsettaaPelaajanYksiVuoronTrue() {
        Pelaaja p = new Pelaaja(1);
        p.aloitaVuoro();
        assertTrue(p.onkoVuoro());
    } 
    
    // lopeta vuoro -metodin testit
    
    @Test
    public void lopetaVuoroMetodiAsettaaPelaajanYksiVuoronFalse() {
        Pelaaja p = new Pelaaja(1);
        p.lopetaVuoro();
        assertFalse(p.onkoVuoro());
    } 
    
    @Test
    public void lopetaVuoroMetodiAsettaaPelaajanKaksiVuoronFalse1() {
        Pelaaja p = new Pelaaja(2);
        p.lopetaVuoro();
        assertFalse(p.onkoVuoro());
    } 
    
    @Test
    public void lopetaVuoroMetodiAsettaaPelaajanKaksiVuoronFalse2() {
        Pelaaja p = new Pelaaja(2);
        p.aloitaVuoro();
        p.lopetaVuoro();
        assertFalse(p.onkoVuoro());
    } 
    
    // toString tulostaa pelaajan halutullatavalla
    
    @Test
    public void toStringPalauttaaPelaajan1TiedotOikein() {
        Pelaaja p = new Pelaaja(2);
        assertEquals("Pelaaja 2", p.toString());
    }
    

    
    
    
    
    
    
}
