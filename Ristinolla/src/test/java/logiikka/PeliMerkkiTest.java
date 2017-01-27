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
    public void konstruktoriAsettaaMerkinXKoordinaatinOikein() {
        PeliMerkki m = new PeliMerkki('x', 2, 3); 
        assertEquals(2,m.getX());
    }
    
    @Test 
    public void konstruktoriAsettaaMerkinOikein() {
        PeliMerkki m = new PeliMerkki('x', 2, 3);
        assertEquals('x',m.getMerkki());
    }
    
    @Test
    public void konstruktoriAsettaaYkoordinaatinOikein() {
        PeliMerkki m = new PeliMerkki('x', 2, 3);; 
        assertEquals(3,m.getY());
    }

}
