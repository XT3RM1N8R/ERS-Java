/*
Names:          Darrel Donald & Darien Sokolov
Course:         Object Oriented Programming
Date:           5/10/2017
Description:    ERS-Java is a console-based, GUI-supplemented playable game inspired by the Egyptian Rat Screw (ERS) card game.
Input:          Numbers 1-4 representing the desired number of players; The rest of the input commands are explained at program runtime.
Output:         Input-dependent GUI representations of the game events, supplemented with useful game state information in the console, for debugging or additional information during gameplay.
Runtime Brief:  Prompt for number of players; game ensues; winner arises; end of game is announced.
Test Cases:     The nature of this game is based both on random number generation and the overall cunning of each player. The quickest way to test the end-game prompt is to force strategic behavior on a single player, with opposite behavior for the rest.
Artifacts:      The images used within the GUI are explicitly created for use in the public domain. We are not the creators of these resources.
Contributions:  It may be noted that certain parts of the project were mostly--not exclusively--developed by certain members; Darrel Donald - DrawingComponent.java, Darien Sokolov - pile.java
Contributions:  Most parts of this application were developed and modified by both members in this team. The actual contributions may be tracked in the timeline at: https://github.com/XT3RM1N8R/ERS-Java/
 */
package ers;


import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;

/**
 *
 * @author shadows97_7
 */
public class ERS {
    public static boolean started;
    public static pile play_here;
    public static boolean isFaceOff;
    public static int numFaceOffTriesLeft;
    public static int faceOffInitiatingPlayerIndex;
    public static all_players playerList;
    public static int turn;
    public static int num_of_players;
    public static boolean ended; 
    public static int winner;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        started=false;
        ended=false;
        System.out.println("Welcome to ERS-Java. Maximum of 4 players supported.\nSlap Keys:\n\tPlayer1: Q\n\tPlayer2: P\n\tPlayer3: Z\n\tPlayer4: M\nMill Key: SPACE");
        System.out.println("How many players?: ");
        Scanner scan = new Scanner(System.in);
        num_of_players = scan.nextInt();
        deck initial_deck = new deck();
        initial_deck.shuffle();
        playerList = new all_players(num_of_players);
        turn = 1;
        play_here = new pile();
        for(int i=0;initial_deck.dsize!=0;i=(i+1)%num_of_players){
            System.out.println(i+1);
            playerList.plist[i].add(initial_deck.draw());
        }
        JFrame window=new JFrame();
        window.setTitle("ERS");
        window.setSize(819, 648);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.addKeyListener(playerList);
        DrawingComponent DC = new DrawingComponent();
        /*File img =new File("as");
        BufferedImage card = Image(img);*/
        window.add(DC);
        for(;;){ // Game Loop Here
            if(playerList.GameOver()) {
                ended=true;
                break;
            }
            TimeUnit.MILLISECONDS.sleep(100);
            while(playerList.plist[currentPlayerIndex()].hsize == 0) { // If the current player is out of cards, it is the next player's turn. 
                NextTurn();
            }
            System.out.println("Player" + turn + " turn.");
            if (playerList.turn_flag == false) { // Wait for player to press SPACE
                playerList.plist[currentPlayerIndex()].play(play_here);
                started = true;         // The game has started
                DC.setRank(play_here.TopCard());
                DC.setSuit(play_here.TopCard());
                if(play_here.IsFaceOffStart()) {    // Checks at end of every turn; Initiates a new Face Off
                    faceOffInitiatingPlayerIndex = currentPlayerIndex();
                    numFaceOffTriesLeft = play_here.NumFaceOffTries();
                    isFaceOff = true;
                    NextTurn();
                } else if(isFaceOff) {
                    if(numFaceOffTriesLeft == 0) {
                        isFaceOff = false;
                        playerList.plist[faceOffInitiatingPlayerIndex].TakePile();
                    } else {
                        numFaceOffTriesLeft--;
                    }
                } else {
                    NextTurn();
                }
            }
            else
                continue;
            playerList.turn_flag = true;
            window.repaint();
        }
        System.out.println("Game Over.");
    }
    
    public static int currentPlayerIndex() { // Return the index of the current player within the array of players.
        return turn-1;
    }
    
    public static void NextTurn() { // Proceed to the next turn.
        if (num_of_players == turn)
                turn=0;
        turn++;
    }

    /*private static BufferedImage Image(File img) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
