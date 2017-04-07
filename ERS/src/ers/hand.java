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
    hand(){
        
    }
    hand(deck d,int drw){
        hsize=0;
        hcards=new card[52];
        while(hsize<drw){
            hcards[hsize++]=d.draw();
        }
    }
    public card mill(){
        card temp = new card(hcards[0].suit,hcards[0].rank);
        int x=0;
        while(x!=hsize-1){
            hcards[x]=hcards[x+1];
            x++;
        }
        hsize--;
        return temp;
    }
    public void add(card c){
        hcards[hsize++]=c;
    }
    public void add(card c1, card c2){
        add(c1);
        add(c2);
    }
}
