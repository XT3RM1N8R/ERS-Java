/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers;

/**
 *
 * @author shadows97_7
 */
public class hand {

    //backs up top card hcards[0]
    card hcards[];
    int hsize;
    int player_number;
    boolean can_slap;
    hand(){ // Initialize a player(hand) by granting a deck of 52 null cards.
        hcards=new card[52];
    }
  
    hand(deck d,int drw){ // Initialize a player(hand) by giving the player a given number of cards that are draw from a given deck.
        hsize=0;
        can_slap=true;

        hcards=new card[52];
        while(hsize<drw){
            hcards[hsize++]=d.draw();
        }
    }

    public void mill(ers.pile p){ // Remove a card from the player(hand) and add it to the pile.

        card temp = new card(hcards[0].suit,hcards[0].rank);
        int x=0;
        while(x!=hsize-1){
            hcards[x]=hcards[x+1];
            x++;
        }
        hsize--;
        p.AddToBottom(temp);
    }
  
    public void slap(ers.pile p){ // Slap the pile and check if any slap rules are satisfied
        if (p.Check_slap()){
            while (!p.IsEmpty()){ // "TakePile"; takes the entire pile and adds it to the deck of the player(hand)
                add(p.DrawBottom());
            }
            ERS.isFaceOff = false;
        }
        else if(hsize!=0) { // If no slap rules are satisfied, the player(hand) loses 2 cards to the pile
            mill(p);
            if (hsize!=0)
                mill(p);
        }
        else // If the slap fails and the pile is empty, then it is not possible to slap; thus, we address the situation accordingly.
            can_slap=false;

    }
    
    public void TakePile() { // Takes the pile and adds it to the player(hand)
        while (!ERS.play_here.IsEmpty()){
            add(ERS.play_here.DrawBottom());
        }
    }
  
    public void add(card c){ // Adds a card to the player(hand)
        hcards[hsize++]=c;
    }

    public void add(card c1, card c2){ // Adds two cards to the player(hand)
        add(c1);
        add(c2);
    }
    public void play(ers.pile p){ // Takes card from player(hand) and adds to the top of the pile
        card temp = new card(hcards[0].suit,hcards[0].rank);
        int x=0;
        while(x!=hsize-1){ // Manual re-adjustment of array to account for lost card
            hcards[x]=hcards[x+1];
            x++;
        }
        hsize--;
        p.AddToTop(temp);
    }
}
