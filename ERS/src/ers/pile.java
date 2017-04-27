/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers;
import java.util.*;

/**
 *
 * @author shadows97_7
 */
public class pile {
    static ArrayList<card> pil;//static
    public int NUM_RANKS = 13;
    pile(){
        pil = new ArrayList<card>();
    }
    
    public card BottomCard() {
        return pil.get(0);
    }
    
    public card DrawBottom() {
        return pil.remove(0);
    }
    
    public card TopCard() {
        return pil.get(pil.size()-1);
    }
    
    public card DrawTop() {
        return pil.remove(pil.size()-1);
    }
    
    public card LastCard() {
        return TopCard();
    }
    
    public card SecondLastCard() {
        return pil.get(pil.size()-2);
    }
    
    public card ThirdLastCard() {
        return pil.get(pil.size()-3);
    }
    
    public card FourthLastCard() {
        return pil.get(pil.size()-4);
    }
    
    public void AddToBottom(card cCard) {
        pil.add(0, cCard);
    }
    
    public void AddToTop(card cCard) {
        pil.add(cCard);
    }
    public boolean Check_slap(){
        //series of checks; return true if check is true
        /*otherwise*/return false;
    }
    
    public class SlapRules {
        public boolean Double() {
            return (LastCard().rank == SecondLastCard().rank);
        }
        
        public boolean Sandwich() {
            return (LastCard().rank == ThirdLastCard().rank);
        }
        
        public boolean TopBottom() {
            return (TopCard().rank == BottomCard().rank);
        }
        
        public boolean Tens() {
            if(LastCard().rank + SecondLastCard().rank == 10) {
                return true;
            } else if(LastCard().rank + ThirdLastCard().rank == 10) {
                return true;
            } else {
                return false;
            }
        }
        
        public boolean Run() {
            if((FourthLastCard().rank + 1) % NUM_RANKS == ThirdLastCard().rank) {
                if((ThirdLastCard().rank + 1) % NUM_RANKS == SecondLastCard().rank) {
                    if((SecondLastCard().rank + 1) % NUM_RANKS LastCard().rank) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
