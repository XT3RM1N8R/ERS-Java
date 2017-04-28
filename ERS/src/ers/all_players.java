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
    all_players(){
        
    }
    all_players(int num_o_p){
        plist=new hand[num_o_p];
        for(int i=0;i<num_o_p;i++){
            plist[i]=new hand();
            plist[i].player_number=i+1;
        }
    }
    pile plile;//THIS THING AND EVERYTIME I USED IT
    
    public boolean GameOver() {
        for(int playerIndex = 0; playerIndex < ERS.nop; playerIndex++) {
            System.out.println("Cylcle"+playerIndex);
            if(plist[playerIndex].hsize == 52 && plile.IsEmpty()) { // NUM_CARDS is 52
                return true;
            } else if(plist[playerIndex].hsize == 52) {
                System.out.println("Game Broken by impossible card stacks.");
                return false;
            }
        }
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_Q:
                plist[0].slap(plile);
                break;
            case KeyEvent.VK_P:
                plist[1].slap(plile);
                break;
            case KeyEvent.VK_Z:
                plist[2].slap(plile);
                break;
            case KeyEvent.VK_M:
                plist[3].slap(plile);
                break;
            case KeyEvent.VK_SPACE:
                turn_flag=false;
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
