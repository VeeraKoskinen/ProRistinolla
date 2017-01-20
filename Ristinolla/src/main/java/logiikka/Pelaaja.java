/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;
import java.util.*;
/**
 *
 * @author veerakoskinen
 */
public class Pelaaja {
    
    private int id;
    private boolean vuoro;
    
    public Pelaaja(int id) {
        this.id = id;
        if (this.id == 1) {
            this.vuoro = true;
        } else {
            this.vuoro = false;
        }   
    }
    
    public int getId() {
        return id;
    }
    
    public boolean onkoVuoro() {
        return vuoro;
    }
    
    public void lopetaVuoro() {
        vuoro = false;
    }
    
    public void aloitaVuoro() {
        vuoro = true;
    }
        
}
