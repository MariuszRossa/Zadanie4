/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadanie4;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable; 
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.*;
import javafx.geometry.VPos;
import javax.swing.*;
import javax.swing.JButton;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;
/**
 *
 * @author Test101
 */
public class Wielowatkowosc implements Runnable { 
   private Thread t;
//   private String threadName;
   private int nazwaWatku;
   String aaa= "aaa";
   private boolean pauza = false;

    public boolean isPauza() {
        return pauza;
    }
   
private final Object pauseLock = new Object();



    public void setPauza(boolean pauza) {
        this.pauza = pauza;
    }
   private DefaultTableModel samoltM, lotniskoM;
   Ruch ruch = new Ruch();
   Losowosc los = new Losowosc();
  
    Wielowatkowosc(DefaultTableModel model1, DefaultTableModel model2, int name) {
        nazwaWatku = name;
        this.samoltM = model1;
        this.lotniskoM = model2;
        System.out.println("Creating " +  nazwaWatku );
        los.odswiezLos();
        ruch.setLotnLos(los.getLosLot());
//        samoltM.setValueAt(los.getLosLot(), nazwaWatku-1, 3);
        
   }
   // przyjac lot nastepnie przeslac go do tabeli i ponownie wywolac rysowanie 
    @Override
   public void run() {
        System.out.println("Running " +  nazwaWatku );

        try {
            while(pauza != true) {
                synchronized (pauseLock){
                ruch.Odswiez(samoltM, lotniskoM, nazwaWatku);
                ruch.Lec();
                System.out.println("Thread: " + nazwaWatku + ", ");
                // Let the thread sleep for a while.          
                Thread.sleep(50);
                
                if(ruch.getX3()== ruch.getX2() && ruch.getY3()== ruch.getY2()) {
                    lotniskoM.setValueAt("tak",los.getLosLot() , 2);
//                    ruch.Odswiez(samoltM, lotniskoM, nazwaWatku);
                    Thread.sleep(3000);                       
                    lotniskoM.setValueAt("nie", los.getLosLot(), 2);
                    samoltM.setValueAt((int) 150, nazwaWatku-1, 2);
                    los.odswiezLos();
                    ruch.setLotnLos(los.getLosLot());

//                 pauseLock.notifyAll();
                }
                if (pauza == true){
                     pauseLock.wait();
//                     while (pauza != true)
                 }
                
            }
            }
            
      } catch (InterruptedException e) {
         System.out.println("Thread " +  nazwaWatku + " interrupted.");
      }
      System.out.println("Thread " +  nazwaWatku + " exiting.");
   }
   public void resume() {
        synchronized (pauseLock) {
        pauseLock.notifyAll(); // Unblocks thread
        pauza = false;
        }
   }
   public void start () {
      System.out.println("Starting " +  nazwaWatku );
      if (t == null) {
         t = new Thread(this);
         t.start();
      }
   }

}
