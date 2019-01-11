/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadanie4;
import java.util.Random;
/**
 *
 * @author Test101
 */
public class Losowosc {
    private int losowaX, losowaY, losLot;
    private Random rand = new Random();
    
    public Losowosc() {  
    }
    
    public void odswiezLos(){
        ///maksymalny zakres x "1410", y "535"       
        losowaX = rand.nextInt(1410) + 1;
        losowaY = rand.nextInt(535) + 1;
        losLot = rand.nextInt(4);
    }

    public int getLosLot() {
        return losLot;
    }

    public int getLosowaX() {
        return losowaX;
    }

    public int getLosowaY() {
        return losowaY;
    }
    


}

