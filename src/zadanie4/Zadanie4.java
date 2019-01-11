
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
import java.lang.Thread;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author Mariusz Rossa
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

Zaimplementować program „Samoloty i lotniska” który będzie symulował ruch samolotów
pomiędzy lotniskami. Interfejs użytkownika powinien umożliwiać start i zatrzymanie 
symulacji oraz bieżące śledzenie w Tabeli położenia poszczególnych samolotów. 
Wykorzystać programowanie w tym celu programowanie wielowątkowe. 
Samoloty tankują na każdym lotnisku do pełna. W trakcie lotu zużywają paliwo. 
Startując oraz lądując rezerwują pas lotniska na określony czas (np. 10 sec) 
w trakcie którego inne samoloty nie mogą go zając.

Program zamieścić w repozytorium Github.

Jako rezultat zadania na platformie Moodle nalezy zamiesić link do repozytorium projektu Github
 */
public class Zadanie4 extends JFrame implements ActionListener{
    JFrame jf = new JFrame();
    JPanel panel = new JPanel();
    JPanel panelW = new JPanel();
    JPanel panelS = new JPanel();
    JPanel panelC = new JPanel();
    JButton btn1 = new JButton("Wznow");
    JButton greenButton = new JButton("Start");
    JButton blueButton = new JButton("Pauza");
    
    JLabel lbl1 = new JLabel("Samoloty");
    JLabel lbl2 = new JLabel("Lotniska");
//    JLabel lbl3 = new JLabel("Dodaj parametr X, Y");
//    JTextField text1 = new JTextField();
//    JTextField text2 = new JTextField();
//    JTextField text3 = new JTextField(5);
//    JTextField text4 = new JTextField(5);
    String [][] samo  = {{"10", "10","150"},
                {"60", "100","150"},
                {"180", "250","150"},
                {"1410", "535","150"}};

    /**
     *
     * @param model
     */
    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    /**
     *
     * @return
     */
    public DefaultTableModel getModel() {
        return model;
    }
    
    /**
     *
     * @return
     */
    public DefaultTableModel getModel2() {
        return model2;
    }

    /**
     *
     * @param model2
     */
    public void setModel2(DefaultTableModel model2) {
        this.model2 = model2;
    }
    
    String [][]  lotni  = {{"23", "432","nie" },
                {"605", "65","nie" },
                {"100", "450","nie" },
                {"290", "450","nie" }};
    String[] samoX_Y = {"X", "Y", "Paliwo"};
    String[] lotniX_Y = {"X", "Y","Zajete_Lotnisko"};
    DefaultTableModel model = new DefaultTableModel(samo ,samoX_Y);


    DefaultTableModel model2 = new DefaultTableModel(lotni ,lotniX_Y);
    JTable tabela1 = new JTable(model);
    JTable tabela2 = new JTable(model2);
    Losowosc los = new Losowosc();
    int losowaX, losowaY;
            Wielowatkowosc R1 = new Wielowatkowosc(model, model2, 1);
            Wielowatkowosc R2 = new Wielowatkowosc(model, model2, 2);
            Wielowatkowosc R3 = new Wielowatkowosc(model, model2, 3);
            Wielowatkowosc R4 = new Wielowatkowosc(model, model2, 4);

    /**
     *
     */
    public Zadanie4() {
        super("Samoloty");
        greenButton.addActionListener(this);
        blueButton.addActionListener(this);
        btn1.addActionListener(this);
        setSize(1500, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int count = 0; count <tabela1.getRowCount(); count++) {
            los.odswiezLos();
            losowaX = los.getLosowaX();
            losowaY = los.getLosowaY();
            tabela1.setValueAt(losowaX, count, 0);
            tabela1.setValueAt(losowaY, count, 1);
        }
        for (int count = 0; count <tabela2.getRowCount(); count++) {
            los.odswiezLos();
            losowaX = los.getLosowaX();
            losowaY = los.getLosowaY();
            tabela2.setValueAt(losowaX, count, 0);
            tabela2.setValueAt(losowaY, count, 1);
        }
        panel.setLayout(new BorderLayout());
        add(panel);     
        panel.add(panelW, BorderLayout.WEST);
        panel.setBackground(Color.BLACK);
        panelW.setLayout(new GridLayout(6, 2));
        panelW.add(btn1);
        panelW.add(blueButton);
        panelW.add(greenButton);
        panelW.setBackground(Color.GRAY);
        panel.add(panelS,  BorderLayout.SOUTH);
        panelS.add(lbl1);
        panelS.setBackground(Color.GRAY);
        panelS.add(new JScrollPane(tabela1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED)).setPreferredSize(new Dimension(200, getWidth()/7));       
        panelS.add(lbl2);
        panelS.add(new JScrollPane(tabela2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED)).setPreferredSize(new Dimension(200, getWidth()/7));
        Graf rys = new Graf(model, model2, Color.BLUE, Color.RED);
        panel.add(rys);
        //pack();
//        panel2.add(text1);
//        panel2.add(lbl2);
//        panel2.add(text2);
//        panel3.add(lbl3);
//        panel3.add(text3);
//        panel3.add(text4);

      

      
      Timer timer = new Timer();
                       
        TimerTask task = new TimerTask() {
        @Override
        public void run() {
            //System.out.println("Inside Timer Task" + System.currentTimeMillis());
            //timer.schedule(this, 100);
            repaint();
            setVisible(true);
            }
            };
        timer.schedule(task, 100,100);
        //System.out.println("Current time" + System.currentTimeMillis());
    }
    /**
     * @param e
     */
    	@Override
	public void actionPerformed(ActionEvent e) {
                
		Object source = e.getSource();

		if(source == greenButton){
                    R1.start();
                    R2.start();
                    R3.start();
                    R4.start();
                }
		if(source == blueButton){
                    //if (R1.isPauza() == false){
		    R1.setPauza(true);                   
                   // }             
                  //  if (R2.isPauza() == true){
                    R2.setPauza(true);                  
                  //  }
                 //   if (R3.isPauza() == true){
                    R3.setPauza(true);                   
                 //   }
                 //   if (R4.isPauza() == true){
                    R4.setPauza(true);                   
                  //  }
                }
                if (source == btn1){
                    R1.resume();
                    R2.resume();
                    R3.resume();
                    R4.resume();
                }
	}
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {


            new Zadanie4();
}
}
