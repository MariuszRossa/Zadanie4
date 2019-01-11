/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadanie4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Mariusz Rossa
 */
public class Graf extends JPanel{

//    private int xPoly[];
//    private int yPoly[];
    private DefaultTableModel defmS, defmL;
    private Color kolWybor, kolWybor2;
    //int xPoly[] = {150, 250, 325, 375};
  //  int yPoly[] = {150, 100, 125, 225};
    
    
//    public Rysowanie(){
//       int x[], int y[]
//    }

    /**
     *
     */
    public Graf(){
    }
    
    /**
     *
     * @param mojmodel
     * @param mojmodel2
     * @param niebieski
     * @param czerwony
     */
    public Graf(DefaultTableModel mojmodel, DefaultTableModel mojmodel2, Color niebieski, Color czerwony){
         defmS = mojmodel;
         defmL = mojmodel2;
         kolWybor = niebieski;        
         kolWybor2 = czerwony;
    }

    /**
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        int [] xKolo = new int [defmS.getRowCount()];
        int [] yKolo = new int [defmS.getRowCount()];
        int [] xKolo2 = new int [defmL.getRowCount()];
        int [] yKolo2 = new int [defmL.getRowCount()];

        for (int count = 0; count <defmS.getRowCount(); count++) {
            int x = Integer.parseInt(defmL.getValueAt(count, 0).toString());
            int y = Integer.parseInt(defmL.getValueAt(count, 1).toString());
            int xS = Integer.parseInt(defmS.getValueAt(count, 0).toString());
            int yS = Integer.parseInt(defmS.getValueAt(count, 1).toString());
            //super.paintComponent(g);
            g.setColor(kolWybor);
            g.drawOval(x, y, 10, 10);
            g.fillOval(x, y, 10, 10); 
            g.setColor(kolWybor2);
            g.drawOval(xS, yS, 10, 10);
            g.fillOval(xS, yS, 10, 10);
            
        }
    }
  
    
}
