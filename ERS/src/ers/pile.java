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
    static ArrayList<card> pileCards;//static
    public int NUM_RANKS = 13;
    pile(){
        pileCards = new ArrayList<card>();
    }
    
    public card BottomCard() {
        return pileCards.get(0);
    }
    
    public card DrawBottom() {
        return pileCards.remove(0);
    }
    
    public card TopCard() {
        return pileCards.get(pileCards.size()-1);
    }
    
    public card DrawTop() {
        return pileCards.remove(pileCards.size()-1);
    }
    
    public card LastCard() {
        return TopCard();
    }
    
    public card SecondLastCard() {
        return pileCards.get(pileCards.size()-2);
    }
    
    public card ThirdLastCard() {
        return pileCards.get(pileCards.size()-3);
    }
    
    public card FourthLastCard() {
        return pileCards.get(pileCards.size()-4);
    }
    
    public void AddToBottom(card cCard) {
        pileCards.add(0, cCard);
    }
    
    public void AddToTop(card cCard) {
        pileCards.add(cCard);
    }
    public boolean Check_slap(){
        //series of checks; return true if check is true
        /*otherwise*/return false;
    }
    
    public boolean isEmpty() {
        return pileCards.isEmpty();
    }
    
    public class SlapRules {
        public boolean Double() {
            return (LastCard().rank_value() == SecondLastCard().rank_value());
        }
        
        public boolean Sandwich() {
            return (LastCard().rank_value() == ThirdLastCard().rank_value());
        }
        
        public boolean TopBottom() {
            return (TopCard().rank_value() == BottomCard().rank_value());
        }
        
        public boolean Tens() {
            if(LastCard().rank_value() + SecondLastCard().rank_value() == 10) {
                return true;
            } else if(LastCard().rank_value() + ThirdLastCard().rank_value() == 10) {
                return true;
            } else {
                return false;
            }
        }
        
        public boolean Run() {
            if(((FourthLastCard().rank_value() - 1) + 1) % NUM_RANKS == ThirdLastCard().rank_value() - 1 && 
               ((ThirdLastCard().rank_value() - 1) + 1) % NUM_RANKS == SecondLastCard().rank_value() - 1 && 
               ((SecondLastCard().rank_value() - 1) + 1) % NUM_RANKS == LastCard().rank_value() - 1) {
                return true;
            }
            return false;
        }
        
        public boolean Marriage() {
            if(LastCard().rank_value() + SecondLastCard().rank_value() == 25) { // If the last 2 cards are Queen and King
                return true;
            } else {
                return false;
            }
        }
    }
}
