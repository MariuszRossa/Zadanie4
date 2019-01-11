/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadanie4;
import java.lang.Math;
import java.util.Objects;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Test101
 */
public class Ruch {
    private double d, x3, y3, r;
    private Boolean celLotu;

    /**
     *
     * @return
     */
    public Boolean getCelLotu() {
        return celLotu;
    }

    /**
     *
     * @param celLotu
     */
    public void setCelLotu(Boolean celLotu) {
        this.celLotu = celLotu;
    }
    private String celLotuKon, sprawdzenie= "tak";

    /**
     *
     * @return
     */
    public double getX3() {
        return x3;
    }

    /**
     *
     * @return
     */
    public double getY3() {
        return y3;
    }
    private DefaultTableModel samolot, lotnisko ;
    private int x1, x2, y1, y2, n =10,watek, paliwo, lotnLos;
//    private String zajete;

    /**
     *
     * @param paliwo
     */
    public void setPaliwo(int paliwo) {
        this.paliwo = paliwo;
    }
    
//        public DefaultTableModel getLotnisko() {
//        return lotnisko;
//    }
//
//    public void setLotnisko(DefaultTableModel lotnisko) {
//        this.lotnisko = lotnisko;
//    }

    /**
     *
     * @return
     */
    public int getX2() {
        return x2;
    }

    /**
     *
     * @return
     */
    public int getY2() {
        return y2;
    }

    /**
     *
     */
    public Ruch(){
    }

    /**
     *
     * @param model1
     * @param model2
     * @param watekN
     */
    public void Odswiez(DefaultTableModel model1, DefaultTableModel model2, int watekN){
        this.samolot = model1;
        this.lotnisko = model2;
        this.watek = watekN;

//        int [] xRuchu = new int [ruch.getRowCount()];
//        int [] yRuchu = new int [ruch.getRowCount()];
        x1 = Integer.parseInt(samolot.getValueAt(watek-1, 0).toString());
        y1 = Integer.parseInt(samolot.getValueAt(watek-1, 1).toString());
        paliwo = Integer.parseInt(samolot.getValueAt(watek-1, 2).toString());
        x2 = Integer.parseInt(lotnisko.getValueAt(lotnLos, 0).toString());
        y2 = Integer.parseInt(lotnisko.getValueAt(lotnLos, 1).toString());
        celLotuKon = lotnisko.getValueAt(lotnLos, 2).toString();
//        celLotuKon = lotnisko.getValueAt(lotnLos, 2).toString();
//        System.out.println(""+ celLotuKon);
//        if (sprawdzenie.equals(celLotuKon)){
//             //Objects.equals(celLotuKon, "tak"
//            celLotu = true;
////            System.out.println("test 1   "+ celLotu);
//        }
//        else {
//            celLotu = false;
//            System.out.println("test2   "+ celLotu);
//        }
        
       // celLotu = celLotuKon;
    }
//    private Ruch(int x1, int y1, int x2, int y2){
//        this.x1 = x1;
//        this.y1 = y1;
//        this.x2 = x2;
//        this.y2 = y2;
//    }     DefaultTableModel defm

    /**
     *
     * @param lotnLos
     */
    public void setLotnLos(int lotnLos) {
        this.lotnLos = lotnLos;
    }

    /**
     *
     */
    public void Lec () {

        if (Math.abs(x3 - x2)<11 && Math.abs(y3 - y2)<11){
            x3 = x2;
            y3 = y2;
            samolot.setValueAt((int) x3, watek-1, 0);
            samolot.setValueAt((int) y3, watek-1, 1) ;
            samolot.setValueAt((int) paliwo -1, watek-1, 2);
//            lotnisko.setValueAt("tak", watek-1, 2);
            //set true zajete 
        } else if (Objects.equals(celLotuKon, "tak") && Math.abs(x3 - x2)<20 && Math.abs(y3 - y2)<20){
            System.out.println("sadsadssdas55555"+ celLotu);
//            if () {
                    samolot.setValueAt((int) paliwo -1, watek-1, 2);
//                }
            } else {        
            d = Math.sqrt(Math.pow((double)(x2-x1), 2) + Math.pow((double)(y2 - y1),2));// #distance
            r = n/d;  //  d #segment ratio;
            x3 = r * x2 + (1 - r) * x1; // #find point that divides the segment
            y3 = r * y2 + (1 - r) * y1; // #into the ratio (1-r): r  
            samolot.setValueAt((int) x3, watek-1, 0);
            samolot.setValueAt((int) y3, watek-1, 1) ;
            samolot.setValueAt((int) paliwo -1, watek-1, 2);
        }
    }

}

