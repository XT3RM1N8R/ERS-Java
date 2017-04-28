/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author shadows97_7
 */
public class DrawingComponent extends JComponent{
    Rectangle background= new Rectangle(0,0,800,600);
    Rectangle card= new Rectangle(335,200,150,250);
    card ref;
    File file= new File(pick_card());
    BufferedImage img;
    
        try {
            img = ImageIO.read(file);
        } catch (IOException ex) {
            Logger.getLogger(DrawingComponent.class.getName()).log(Level.SEVERE, null, ex);
        }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fill(background);
        g2.setColor(Color.black);
        g2.draw(card);
        
        
    }
    public void setRank (card c){
        ref.rank=c.rank;
    }
    public void setSuit (card c){
        ref.suit=c.suit;
    }
    private String pick_card(){
        String x="";
        switch (ref.rank_value()){
            case 1:
                x=x.concat("a");
                break;
            case 13:
                x=x.concat("k");
                break;
            case 12:
                x=x.concat("q");
                break;
            case 11:
                x=x.concat("j");
                break;
            default:
                x=x.concat(String.valueOf(ref.rank_value()));
                break;
            
        }
        x=x.concat(String.valueOf(ref.suit));
        x=x.toLowerCase();
        return x+".png";
    }
}