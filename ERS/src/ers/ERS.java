/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers;


import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author shadows97_7
 */
public class ERS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("How many players?: ");
        Scanner scan=new Scanner(System.in);
        int num_of_players=scan.nextInt();
        deck initial_deck=new deck();
        all_players p= new all_players(num_of_players);
        int turn = 1;
        pile play_here= new pile();
        for(int i=0;initial_deck.dsize!=0;i=(i+1)%num_of_players){
            p.plist[i].add(initial_deck.draw());
        }
        /*JFrame window=new JFrame();
        window.setTitle("ERS");
        window.setSize(819, 648);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DrawingComponent DC = new DrawingComponent();
        /*File img =new File("as");
        BufferedImage card = Image(img);*/
        //window.add(DC);*/
        for(;;){
            if (p.turn_flag==false)
                p.plist[turn-1].play(play_here);
            else
                continue;
            if (num_of_players==turn)
                turn=0;
            turn++;
        }
    }

    /*private static BufferedImage Image(File img) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
