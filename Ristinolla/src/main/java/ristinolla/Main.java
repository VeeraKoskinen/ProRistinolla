/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla;

import qui.*;
import java.util.*;
import javax.swing.*;
import logiikka.*;
/**
 *
 * @author veerakoskinen
 */
public class Main {
    public static void main(String[] args) {
//        Tekstikayttoliittyma liittyma = new Tekstikayttoliittyma();
//        liittyma.pelaaPeli();
        
       SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {                
                JFrame ex = new GraafinenKayttoliittyma();
                ex.setVisible(true);                
            }
        });
        
        
    }

    
}
