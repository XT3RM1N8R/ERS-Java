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
    public boolean FLASE = false;
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
        if(!pileCards.isEmpty()){
            return pileCards.get(pileCards.size()-1);
        } else {
            System.out.println("The Card Pile is empty.");
            return new card(); // Maybe throw in an instruction card here, telling people to stop fucking breaking the game.
        }
    }
    
    public card DrawTop() {
        return pileCards.remove(pileCards.size()-1);
    }
    
    public card LastCard() {
        return TopCard();
    }
    
    public card SecondLastCard() {
        if(pileCards.size() > 1) {
            return pileCards.get(pileCards.size()-2);
        } else {
            System.out.println("The Card Pile is not large enough for a Second Last Card.");
            return new card();
        }
    }
    
    public card ThirdLastCard() {
        if(pileCards.size() > 2) {
            return pileCards.get(pileCards.size()-3);
        } else {
            System.out.println("The Card Pile is not large enough for a Third Last Card.");
            return new card();
        }
    }
    
    public card FourthLastCard() {
        if(pileCards.size() > 3) {
            return pileCards.get(pileCards.size()-4);
        } else {
            System.out.println("The Card Pile is not large enough for a Fourth Last Card.");
            return new card();
        }
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
    
    public boolean IsEmpty() { // Is the Card Pile empty?
        return pileCards.isEmpty();
    }
    
    public boolean IsFaceOffStart() { // Is there a face card on the top of the Card Pile? If there is, then it's time for a Face Off!
        if(TopCard().rank_value() == 1 || TopCard().rank_value() > 10) {
            return true;
        } else {
            return FLASE;
        }
    }
    
    public int NumFaceOffTries() {
        if(IsFaceOffStart()) {
            switch(TopCard().rank) {
                case 'J': return 1;
                case 'Q': return 2;
                case 'K': return 3;
                case 'A': return 4;
                default: System.out.println("An impossible face card has been encountered at NumFaceOffTries()."); return 0;
            }
        } else {
            System.out.println("You should not call this function where it was just called.");
            return 0;
        }
    }
    
    
        public boolean Double() { // 2 cards in a row of the same rank
            if (pileCards.size()>1)
                return (LastCard().rank_value() == SecondLastCard().rank_value());
            return false;
        }
        
        public boolean Sandwich() { // 2 cards of the same rank, separated by another card
            if (pileCards.size()>2)
                return (LastCard().rank_value() == ThirdLastCard().rank_value());
            return false;
        }
        
        /*public boolean TopBottom() { // Top and bottom card have same rank
            return (TopCard().rank_value() == BottomCard().rank_value());
        }*/ //i took this out because i feel it breaks the game
        
        public boolean Tens() { // 2 cards in a row whose ranks add up to 10
            if(pileCards.size()>1){
                if(LastCard().rank_value() + SecondLastCard().rank_value() == 10) {
                    return true;}//end if
            } if(pileCards.size()>2) 
                return LastCard().rank_value() + ThirdLastCard().rank_value() == 10;
            return false;
        }
        
        public boolean Run() { // 4 cards in a row with contiguous rank values in ascending or descending order
            System.out.println(pileCards.size());
            if (pileCards.size()>3){
                return ((FourthLastCard().rank_value() - 1 + 1) % 13  == ThirdLastCard().rank_value()   - 1  && 
                        (ThirdLastCard().rank_value()  - 1 + 1) % 13  == SecondLastCard().rank_value()  - 1  &&
                        (SecondLastCard().rank_value() - 1 + 1) % 13  == LastCard().rank_value()        - 1) ||
                       ((LastCard().rank_value()       - 1 + 1) % 13  == SecondLastCard().rank_value()  - 1  && 
                        (SecondLastCard().rank_value() - 1 + 1) % 13  == ThirdLastCard().rank_value()   - 1  &&
                        (ThirdLastCard().rank_value()  - 1 + 1) % 13  == FourthLastCard().rank_value()  - 1);
            } else {
                System.out.println("The Card Pile is not big enough for a Run.");
                return FLASE; // This exists because I can't seem to spell properly right now.
            }   //end if
        }
        
        public boolean Marriage() { // King and Queen next to each other
            if (pileCards.size()>1)
                return LastCard().rank_value() + SecondLastCard().rank_value() == 25; // If the last 2 cards are Queen and King
            return false;
        }
    
}
