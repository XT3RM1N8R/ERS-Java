/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers;


import java.util.Scanner;

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
        players p= new players(num_of_players);
        for(int i=0;initial_deck.dsize!=0;i=(i+1)%num_of_players){
            p.plist[i].add(initial_deck.draw());
        }
    }
}
