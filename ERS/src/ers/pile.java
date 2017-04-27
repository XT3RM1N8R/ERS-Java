/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers;
import java.util.*;

/**
 *
 * @author shadows97_7
 */
public class pile {
    static ArrayList<card> pil;//static
    pile(){
        pil = new ArrayList<card>();
    }
    
    public card bottom() {
        return pil.get(0);
    }
    
    public card drawBottom() {
        return pil.remove(0);
    }
    
    public card top() {
        return pil.get(pil.size()-1);
    }
    
    public card drawTop() {
        return pil.remove(pil.size()-1);
    }
    
    public void addToBottom(card cCard) {
        pil.add(0, cCard);
    }
    
    public void addToTop(card cCard) {
        pil.add(cCard);
    }
    public boolean check_slap(){
        //series of checks; return true if check is true
        /*otherwise*/return false;
    }
}
