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
    ArrayList<card> pileCards;//static
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
        if(Double())
            return true;
        if(Sandwich())
            return true;
        /*if(TopBottom())
            return true;*/
        if(Tens())
            return true;
        if(Run())
            return true;
        return Marriage();
    }
    
    public boolean IsEmpty() {
        return pileCards.isEmpty();
    }
    
    
        public boolean Double() {
            if (pileCards.size()>1)
                return (LastCard().rank_value() == SecondLastCard().rank_value());
            return false;
        }
        
        public boolean Sandwich() {
            if (pileCards.size()>2)
                return (LastCard().rank_value() == ThirdLastCard().rank_value());
            return false;
        }
        
        /*public boolean TopBottom() {
            return (TopCard().rank_value() == BottomCard().rank_value());
        }*/ //i took this out because i feel it breaks the game
        
        public boolean Tens() {
            if(pileCards.size()>1){
                if(LastCard().rank_value() + SecondLastCard().rank_value() == 10) {
                    return true;}//end if
            } if(pileCards.size()>2) 
                return LastCard().rank_value() + ThirdLastCard().rank_value() == 10;
            return false;
        }
        
        public boolean Run() {
            System.out.println(pileCards.size());
            if (pileCards.size()>3){
            return (FourthLastCard().rank_value() + 1)  == ThirdLastCard().rank_value() && 
                    (ThirdLastCard().rank_value() + 1)  == SecondLastCard().rank_value() &&
                    (SecondLastCard().rank_value() + 1)  == LastCard().rank_value();}//end if
            return false;
        }
        
        public boolean Marriage() {
            if (pileCards.size()>1)
                return LastCard().rank_value() + SecondLastCard().rank_value() == 25; // If the last 2 cards are Queen and King
            return false;
        }
    
}
