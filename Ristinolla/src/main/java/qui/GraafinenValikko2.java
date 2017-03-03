/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author veerakoskinen
 */
public class GraafinenValikko2 extends JPanel{
    
    public GraafinenValikko2() {
        setOpaque(true);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);    // täyttää taustan
        setBackground(Color.black);
        g.setColor(Color.red);
        
        g.drawString("Aloita uusi peli!", 50, 100);
        int[] xTaulu1 = {40,155,155,40};
        int[] yTaulu1 = {80,80,115,115};
        g.drawPolygon(xTaulu1,yTaulu1 , 4);
        
        g.drawString("Mitä haluat tehdä seuraavaksi? ", 20, 155);
        
        g.drawString("Lopeta peli!", 150, 200);
        int[] xTaulu2 = {135,245,245,135};
        int[] yTaulu2 = {180,180,215,215};
        g.drawPolygon(xTaulu2,yTaulu2 , 4);
    }
}
