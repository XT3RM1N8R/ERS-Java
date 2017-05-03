/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    public static int nop;
    public static boolean started;
    public static pile play_here;
    public static int turn;
    public static all_players p;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        started=false;
        System.out.println("Welcome to ERS-Java. Maximum of 4 players supported.\nSlap Keys:\n\tPlayer1: Q\n\tPlayer2: P\n\tPlayer3: Z\n\tPlayer4: M\nMill Key: SPACE");
        System.out.println("How many players?: ");
        Scanner scan=new Scanner(System.in);
        int num_of_players=scan.nextInt();
        ERS.nop=num_of_players;
        deck initial_deck=new deck();
        initial_deck.shuffle();
        p= new all_players(num_of_players);
        turn = 1;
        play_here= new pile();
        for(int i=0;initial_deck.dsize!=0;i=(i+1)%num_of_players){
            System.out.println(i+1);
            p.plist[i].add(initial_deck.draw());
        }
        JFrame window=new JFrame();
        window.setTitle("ERS");
        window.setSize(819, 648);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.addKeyListener(p);
        DrawingComponent DC = new DrawingComponent();
        /*File img =new File("as");
        BufferedImage card = Image(img);*/
        window.add(DC);
        card viewing;
        for(;;){ // Game Loop Here
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("Player" + turn + " turn.");
            if (p.turn_flag==false) {
                p.plist[turn-1].play(play_here);
                started=true;
                DC.setRank(play_here.TopCard());
                DC.setSuit(play_here.TopCard());
            }
            else
                continue;
            if (num_of_players==turn)
                turn=0;
            turn++;
            p.turn_flag = true;
            if(p.GameOver()) {
                break;
            }
            window.repaint();
        }
        System.out.println("Game Over.");
    }

    /*private static BufferedImage Image(File img) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
