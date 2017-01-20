/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import logiikka.PeliMerkki;
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
public class PeliMerkkiTest {
    
    public PeliMerkkiTest() {
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
    
    // konstruktorin testit

    @Test
    public void konstruktoriAsettaaPelaajanOikein() {
        PeliMerkki m = new PeliMerkki(2,'x'); 
        assertEquals(2,m.getPelaajaId());
    }
    
//    @Test
//    public void konstruktoriAsettaaJarjestysluvunOikein() {
//        PeliMerkki m = new PeliMerkki(2,1); 
//        assertEquals(1,m.getpaikkaJonossa());
//    }
    
    @Test 
    public void konstruktoriAsettaaMerkinOikein() {
        PeliMerkki m = new PeliMerkki(2,'x');
        assertEquals('x',m.getMerkki());
    }
    
    @Test
    public void konstruktoriAsettaaXkoordinaatinOikein() {
        PeliMerkki m = new PeliMerkki(2,'x'); 
        assertEquals(20,m.getX());
    }
    
    @Test
    public void konstruktoriAsettaaYkoordinaatinOikein() {
        PeliMerkki m = new PeliMerkki(2,'x'); 
        assertEquals(20,m.getY());
    }
    
    // metodin setXJaY testaus
    
    @Test
    public void setXJaYAsettaaArvonXOikein() {
        PeliMerkki m = new PeliMerkki(2,'x'); 
        m.setXJaY(2,3);
        assertEquals(2,m.getX());
    }
    
    @Test
    public void setXJaYJattaaArvonXAsettamattaJosArvoOnPelialueenUlkopuolella() {
        PeliMerkki m = new PeliMerkki(2,'x'); 
        m.setXJaY(8,3);
        assertEquals(20,m.getX());
    } 
    
    @Test
    public void setXJaYAsettaaArvonYOikein() {
        PeliMerkki m = new PeliMerkki(2,'x'); 
        m.setXJaY(2,3);
        assertEquals(3,m.getY());
    }
    
    @Test
    public void setXJaYJattaaArvonYAsettamattaJosArvoOnPelialueenUlkopuolella() {
        PeliMerkki m = new PeliMerkki(2,'x'); 
        m.setXJaY(4,9);
        assertEquals(20,m.getY());
    } 
    
    // compareTo testit
//    
//    @Test
//    public void compareToPalauttaaArvotHalutussaJarjestyksessa1() {
//        PeliMerkki m = new PeliMerkki(1,1);
//        PeliMerkki s = new PeliMerkki(2,1);
//        assertEquals(1,m.compareTo(s));
//        
//    }
//    
//    @Test
//    public void compareToPalauttaaArvotHalutussaJarjestyksessa2() {
//        PeliMerkki m = new PeliMerkki(2,1);
//        PeliMerkki s = new PeliMerkki(1,1);
//        assertEquals(-1,m.compareTo(s));
//    }
//    
//    @Test
//    public void compareToPalauttaaArvotHalutussaJarjestyksessa3() {
//        PeliMerkki m = new PeliMerkki(1,5);
//        PeliMerkki s = new PeliMerkki(2,4);
//        assertEquals(-1,m.compareTo(s));
//    }
//    
//    @Test
//    public void compareToPalauttaaArvotHalutussaJarjestyksessa4() {
//        PeliMerkki m = new PeliMerkki(1,8);
//        PeliMerkki s = new PeliMerkki(2,9);
//        assertEquals(1,m.compareTo(s));
//    }
//    
//    @Test
//    public void compareToPalauttaaArvotHalutussaJarjestyksessa5() {
//        PeliMerkki m = new PeliMerkki(2,8);
//        PeliMerkki s = new PeliMerkki(2,8);
//        assertEquals(0,m.compareTo(s));
//    }
    
}
