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
public class deck {
    card dcards[]=new card[52];
    int dsize;
    deck(){ // Initialize a new deck of 52 unique cards
        int s=0, c=52, r=0; dsize=52;
        while( s != 4){
            r=0;
            while (r!=13){
                c--;
                switch (s){
                    case 0:
                        dcards[c]=new card ('S','0');
                        break;
                    case 1:
                        dcards[c]=new card ('D','0');
                        break;
                    case 2:
                        dcards[c]=new card ('C','0');
                        break;
                    case 3:
                        dcards[c]=new card ('H','0');
                        break;
                }
                r++;
                switch(r){                    
                    case 1:
                        dcards[c].rank='A';
                        break;
                    case 11:
                        dcards[c].rank='J';
                        break;
                    case 12:
                        dcards[c].rank='Q';
                        break;
                    case 13:
                        dcards[c].rank='K';
                        break;
                    case 10:
                        dcards[c].rank='T';
                        break;
                    default:
                        dcards[c].rank=(char) (r+48);
                }
            }
            s++;
        }
    }
    public void shuffle(){ // Randomize deck
        int[] bank=new int[52];
        for (int i:bank)
            bank[i]=0;
        int x=0,r;
        while(x<dsize){
            do{
                r=(int)(Math.random()*dsize);
            }while(bank[r]!=0);
            card temp=dcards[x];
            dcards[x]=dcards[r];
            dcards[r]=temp;
            bank[x++]=1;
        }
    }
    public card draw(){ // Remove and return a card from the deck
        card temp = new card(dcards[0].suit,dcards[0].rank);
        int x = 0;
        while(x!=dsize-1){
            dcards[x]=dcards[x+1];
            x++;
        }
        dsize--;
        return temp;
    }
}