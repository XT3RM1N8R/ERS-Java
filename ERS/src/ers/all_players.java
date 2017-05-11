/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author shadows97_7
 */

public class all_players implements KeyListener{
    hand plist[];
    boolean turn_flag=true;
    all_players(){ // Empty initialization
        
    }
    all_players(int num_of_players){ // Initializes list of players dependent upon the given desired number of players
        plist=new hand[num_of_players];
        for(int i=0;i<num_of_players;i++){
            plist[i]=new hand();
            plist[i].player_number=i+1;
        }
    }
    
    public boolean GameOver() { // Checks if the game state is such that the game has ended
        for(int playerIndex = 0; playerIndex < ERS.num_of_players; playerIndex++) {
            System.out.println("Cycle "+playerIndex);
            if(plist[playerIndex].hsize == 52 && ERS.play_here.IsEmpty()) { // If any player(hand) has a full deck and the pile is empty
                ERS.winner = playerIndex+1;
                System.out.println("Game Over.");
                return true;
            } else if(plist[playerIndex].hsize == 52) { // If any player(hand) has a full deck, but the pile is not empty; Something has gone wrong
                System.out.println("Game Broken by impossible card stacks.");
                return false;
            } else if(ERS.play_here.pileCards.size() == 52) { // If the pile somehow wins the game by all players forfeiting their cards in a very specific scenario. The likelihood of this happening by coincidence is extremely low.
                ERS.winner = 5;
                System.out.println("Everyone lost their cards to the pile. Everyone is disappointed. Game Over.");
                return true;
            } else {
                System.out.println("Pile Size is currently = " + ERS.play_here.pileCards.size());
            }
        }
        System.out.println("Not Game Over.");
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) { // We didn't need this function
    }

    @Override
    public void keyPressed(KeyEvent e) { // Logic to detect if certain keys are pressed
        switch(e.getKeyCode()){
            case KeyEvent.VK_Q:
                plist[0].slap(ERS.play_here);
                break;
            case KeyEvent.VK_P:
                plist[1].slap(ERS.play_here);
                break;
            case KeyEvent.VK_Z:
                plist[2].slap(ERS.play_here);
                break;
            case KeyEvent.VK_M:
                plist[3].slap(ERS.play_here);
                break;
            case KeyEvent.VK_SPACE:
                turn_flag=false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { // We didn't need this function
    }
}
