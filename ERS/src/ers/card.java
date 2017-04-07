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
public class card {
    public char suit;
    public char rank;
    card (char csuit, char crank){
        suit=csuit;
        rank=crank;
    }
    public int rank_value(){
        int r;
        switch (rank){
                case 'A':
                    r=14;
                    break;
                case 'K':
                    r=13;
                    break;
                case 'Q':
                    r=12;
                    break;
                case 'J':
                    r=11;
                    break;
                case 'T':
                    r=10;
                    break;
                default:
                    r=(int)(rank-48);
                    break;
            }
        return r;
    }

    
}
