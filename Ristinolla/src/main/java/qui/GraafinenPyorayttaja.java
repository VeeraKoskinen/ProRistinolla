/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import logiikka.*;
import static qui.GraafinenPelilauta.solunKoko;
import static qui.GraafinenPelilauta.solunappulanKoko;
import static qui.GraafinenPelilauta.symbolinKoko;

/**
 *
 * @author veerakoskinen
 */
public class GraafinenPyorayttaja extends JPanel { 

    public GraafinenPyorayttaja(Logiikka logiikka) {
        setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        int[] VYNuoliOikealleX = {50,70,70,100,70,70,50};
        int[] VYNuoliOikealleY = {15,15,0,25,50,35,35};
        
        int[] VYNuoliAlasX = {0,15,15,35,35,50,25};
        int[] VYNuoliAlasY = {70,70,50,50,70,70,100};
        
        int[] OYNuoliVasemmalleX = {250,230,230,200,230,230,250};
        int[] OYNuoliVasemmalleY = {15,15,0,25,50,35,35};
        
        int[] OYNuoliAlasX = {250,265,265,285,285,300,275};
        int[] OYNuoliAlasY = {70,70,50,50,70,70,100};
        
        int[] OANuoliYlosX = {250,275,300,285,285,265,265};  
        int[] OANuoliYlosY = {230,200,230,230,250,250,230};
        
        int[] OANuoliVasemmalleX = {250,230,230,200,230,230,250};
        int[] OANuoliVasemmalleY = {265,265,250,275,300,285,285};
        
        int[] VANuoliYlosX = {0,15,15,35,35,50,25};
        int[] VANuoliYlosY = {225,225,250,250,225,225,200}; 
        
        int[] VANuoliOikealleX = {50,70,70,100,70,70,50};
        int[] VANuoliOikealleY = {265,265,250,275,300,285,285};
        super.paintComponent(g);    // täyttää taustan

        g.setColor(Color.CYAN);
        
        g.fillPolygon(VYNuoliOikealleX,VYNuoliOikealleY,7);
        g.fillPolygon(VYNuoliAlasX, VYNuoliAlasY, 7);
        
        g.fillPolygon(OYNuoliVasemmalleX, OYNuoliVasemmalleY, 7);
        g.fillPolygon(OYNuoliAlasX, OYNuoliAlasY, 7);
        
        g.fillPolygon(OANuoliYlosX, OANuoliYlosY, 7);
        g.fillPolygon(OANuoliVasemmalleX, OANuoliVasemmalleY, 7);
//        
        g.fillPolygon(VANuoliYlosX, VANuoliYlosY, 7);
        g.fillPolygon(VANuoliOikealleX, VANuoliOikealleY, 7);
        
        
        
    }
    
    
}
