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
    
    // alustaLaudanKoordinaatitTyhjiksi testit
    
    @Test
    public void alustaLautaAsettaaTaulukonPaikan0_0Tyhjaksi() {
        lauta.getPelilauta()[0][0] = Merkki.NOLLA;
        lauta.getPelilauta()[3][2] = Merkki.NOLLA;
        lauta.getPelilauta()[5][1] = Merkki.RISTI;
        lauta.getPelilauta()[3][1] = Merkki.NOLLA;
        lauta.alustaLaudanKoordinaatitTyhjiksi();
        assertEquals(Merkki.TYHJA, lauta.getPelilauta()[0][0]);
        assertEquals(Merkki.TYHJA, lauta.getPelilauta()[3][2]);
        assertEquals(Merkki.TYHJA, lauta.getPelilauta()[5][1]);
        assertEquals(Merkki.TYHJA, lauta.getPelilauta()[3][1]);
    }
    
    // kierraVasenYlaMyotapaivaan testit
    
    @Test
    public void kierraVasenYlaMyotapaivaanTesti1() {
        lauta.getPelilauta()[0][0] = Merkki.RISTI;
        lauta.getPelilauta()[1][2] = Merkki.NOLLA;
        lauta.getPelilauta()[2][1] = Merkki.RISTI;
        lauta.getPelilauta()[2][0] = Merkki.NOLLA;
        lauta.kierraVasenYlaMyotapaivaan();
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[0][1]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[1][2]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[2][0]);
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[2][2]);
    }
    
    @Test
    public void kierraVasenYlaMyotapaivaanTesti2() {
        lauta.getPelilauta()[1][0] = Merkki.NOLLA;
        lauta.getPelilauta()[0][1] = Merkki.NOLLA;
        lauta.getPelilauta()[1][1] = Merkki.RISTI;
        lauta.getPelilauta()[0][2] = Merkki.RISTI;
        lauta.getPelilauta()[2][2] = Merkki.RISTI;
        lauta.kierraVasenYlaMyotapaivaan();
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[1][0]);
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[2][1]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[0][0]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[1][1]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[0][2]);
    }
       
    // kierraVasenYlaVastapaivaan testit
    
    @Test
    public void kierraVasenYlaVastapaivaanTesti1() {
        lauta.getPelilauta()[0][0] = Merkki.RISTI;
        lauta.getPelilauta()[1][2] = Merkki.NOLLA;
        lauta.getPelilauta()[2][1] = Merkki.RISTI;
        lauta.getPelilauta()[2][0] = Merkki.NOLLA;
        lauta.kierraVasenYlaVastapaivaan();
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[0][0]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[1][0]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[0][2]);
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[2][1]);
    }
    
    @Test
    public void kierraVasenYlaVastapaivaanTesti2() {
        lauta.getPelilauta()[1][0] = Merkki.NOLLA;
        lauta.getPelilauta()[0][1] = Merkki.NOLLA;
        lauta.getPelilauta()[1][1] = Merkki.RISTI;
        lauta.getPelilauta()[0][2] = Merkki.RISTI;
        lauta.getPelilauta()[2][2] = Merkki.RISTI;
        lauta.kierraVasenYlaVastapaivaan();
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[0][1]);
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[1][2]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[2][0]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[1][1]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[2][2]);
    }
       
    // kierraVasenAlaMyotapaivaan testit
    
    @Test
    public void kierraVasenAlaMyotapaivaanTesti1() {
        lauta.getPelilauta()[0][3] = Merkki.RISTI;
        lauta.getPelilauta()[1][5] = Merkki.NOLLA;
        lauta.getPelilauta()[2][4] = Merkki.RISTI;
        lauta.getPelilauta()[2][3] = Merkki.NOLLA;
        lauta.kierraVasenAlaMyotapaivaan();
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[0][4]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[1][5]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[2][3]);
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[2][5]);
    }
    
    @Test
    public void kierraVasenAlaMyotapaivaanTesti2() {
        lauta.getPelilauta()[1][3] = Merkki.NOLLA;
        lauta.getPelilauta()[0][4] = Merkki.NOLLA;
        lauta.getPelilauta()[1][4] = Merkki.RISTI;
        lauta.getPelilauta()[0][5] = Merkki.RISTI;
        lauta.getPelilauta()[2][5] = Merkki.RISTI;
        lauta.kierraVasenAlaMyotapaivaan();
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[1][3]);
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[2][4]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[0][3]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[1][4]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[0][5]);
    }
    
    // kierraVasenAlaVastapaivaan testit
    
    @Test
    public void kierraVasenAlaVastapaivaanTesti1() {
        lauta.getPelilauta()[0][3] = Merkki.RISTI;
        lauta.getPelilauta()[1][5] = Merkki.NOLLA;
        lauta.getPelilauta()[2][4] = Merkki.RISTI;
        lauta.getPelilauta()[2][3] = Merkki.NOLLA;
        lauta.kierraVasenAlaVastapaivaan();
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[0][3]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[1][3]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[0][5]);
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[2][4]);
    }
    
    @Test
    public void kierraVasenAlaVastapaivaanTesti2() {
        lauta.getPelilauta()[1][3] = Merkki.NOLLA;
        lauta.getPelilauta()[0][4] = Merkki.NOLLA;
        lauta.getPelilauta()[1][4] = Merkki.RISTI;
        lauta.getPelilauta()[0][5] = Merkki.RISTI;
        lauta.getPelilauta()[2][5] = Merkki.RISTI;
        lauta.kierraVasenAlaVastapaivaan();
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[0][4]);
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[1][5]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[2][3]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[1][4]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[2][5]);
    }
    
    // kierraOikeaYlaMyotapaivaan testit
    
    @Test
    public void kierraOikeaYlamyotapaivaanTesti1() {
        lauta.getPelilauta()[3][0] = Merkki.RISTI;
        lauta.getPelilauta()[4][2] = Merkki.NOLLA;
        lauta.getPelilauta()[5][1] = Merkki.RISTI;
        lauta.getPelilauta()[5][0] = Merkki.NOLLA;
        lauta.kierraOikeaYlaMyotapaivaan();
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[3][1]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[4][2]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[5][0]);
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[5][2]);
    }
    
    @Test
    public void kierraOikeaYlaMyotapaivaanTesti2() {
        lauta.getPelilauta()[4][0] = Merkki.NOLLA;
        lauta.getPelilauta()[3][1] = Merkki.NOLLA;
        lauta.getPelilauta()[4][1] = Merkki.RISTI;
        lauta.getPelilauta()[3][2] = Merkki.RISTI;
        lauta.getPelilauta()[5][2] = Merkki.RISTI;
        lauta.kierraOikeaYlaMyotapaivaan();
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[4][0]);
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[5][1]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[3][0]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[4][1]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[3][2]);
    }
    
    // kierraOikeaYlaVastapaivaan testit
    
    @Test
    public void kierraOikeaYlaVastapaivaanTesti1() {
        lauta.getPelilauta()[3][0] = Merkki.RISTI;
        lauta.getPelilauta()[4][2] = Merkki.NOLLA;
        lauta.getPelilauta()[5][1] = Merkki.RISTI;
        lauta.getPelilauta()[5][0] = Merkki.NOLLA;
        lauta.kierraOikeaYlaVastapaivaan();
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[3][0]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[4][0]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[3][2]);
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[5][1]);
    }
    
    @Test
    public void kierraOikeaYlaVastapaivaanTesti2() {
        lauta.getPelilauta()[4][0] = Merkki.NOLLA;
        lauta.getPelilauta()[3][1] = Merkki.NOLLA;
        lauta.getPelilauta()[4][1] = Merkki.RISTI;
        lauta.getPelilauta()[3][2] = Merkki.RISTI;
        lauta.getPelilauta()[5][2] = Merkki.RISTI;
        lauta.kierraOikeaYlaVastapaivaan();
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[3][1]);
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[4][2]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[5][0]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[4][1]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[5][2]);
    }
    
    // kierraOikeaAlaMyotapaivaan testit
    
    @Test
    public void kierraOikeaAlaMyotapaivaanTesti1() {
        lauta.getPelilauta()[3][3] = Merkki.RISTI;
        lauta.getPelilauta()[4][5] = Merkki.NOLLA;
        lauta.getPelilauta()[5][4] = Merkki.RISTI;
        lauta.getPelilauta()[5][3] = Merkki.NOLLA;
        lauta.kierraOikeaAlaMyotapaivaan();
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[3][4]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[5][3]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[4][5]);
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[5][5]);
    }
    
    @Test
    public void kierraOikeaAlaMyotapaivaanTesti2() {
        lauta.getPelilauta()[4][3] = Merkki.NOLLA;
        lauta.getPelilauta()[3][4] = Merkki.NOLLA;
        lauta.getPelilauta()[4][4] = Merkki.RISTI;
        lauta.getPelilauta()[3][5] = Merkki.RISTI;
        lauta.getPelilauta()[5][5] = Merkki.RISTI;
        lauta.kierraOikeaAlaMyotapaivaan();
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[4][3]);
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[5][4]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[3][3]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[4][4]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[3][5]);
    }
    
    // kierra OikeaAlaVastapaivaan testit
    
    @Test
    public void kierraOikeaAlaVastapaivaanTesti1() {
        lauta.getPelilauta()[3][3] = Merkki.RISTI;
        lauta.getPelilauta()[4][5] = Merkki.NOLLA;
        lauta.getPelilauta()[5][4] = Merkki.RISTI;
        lauta.getPelilauta()[5][3] = Merkki.NOLLA;
        lauta.kierraOikeaAlaVastapaivaan();
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[3][3]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[4][3]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[3][5]);
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[5][4]);
    }
    
    @Test
    public void kierraOikeaAlaVastapaivaanTesti2() {
        lauta.getPelilauta()[4][3] = Merkki.NOLLA;
        lauta.getPelilauta()[3][4] = Merkki.NOLLA;
        lauta.getPelilauta()[4][4] = Merkki.RISTI;
        lauta.getPelilauta()[3][5] = Merkki.RISTI;
        lauta.getPelilauta()[5][5] = Merkki.RISTI;
        lauta.kierraOikeaAlaVastapaivaan();
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[3][4]);
        assertEquals(Merkki.NOLLA, lauta.getPelilauta()[4][5]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[5][3]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[4][4]);
        assertEquals(Merkki.RISTI, lauta.getPelilauta()[5][5]);
    }
}
