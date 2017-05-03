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
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorModel;
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
    card ref=new card();
    File file= new File("placeholder.png");
    
    public BufferedImage whatever() throws IOException{
        BufferedImage img;
        if (ERS.started)
            file=new File(pick_card());
        img = ImageIO.read(file);
        return img;
    }
    
    BufferedImage cimg;
        

    public void paintComponent(Graphics g){
        String px="player ";
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fill(background);
        g2.setColor(Color.CYAN);
        switch (ERS.turn){
            case 1:
                g2.fillOval(10, 0, 60, 60);
                break;
            case 2:
                g2.fillOval(690, 0, 60, 60);
                break;
            case 3:
                g2.fillOval(10, 530, 60, 60);
                break;
            case 4:
                g2.fillOval(690, 530, 60, 60);
                break;
        }
        g2.setColor(Color.black);
        g2.drawString(px.concat("1"), 20, 20);
        g2.drawString(String.valueOf(ERS.p.plist[0].hsize),30,35);
        g2.drawString(px.concat("2"), 700, 20);
        g2.drawString(String.valueOf(ERS.p.plist[1].hsize),710,35);
        if (ERS.nop>2){
            g2.drawString(px.concat("3"), 20, 550);
            g2.drawString(String.valueOf(ERS.p.plist[2].hsize),30,565);
        }
        if (ERS.nop>3){
            g2.drawString(px.concat("4"), 700, 550);
            g2.drawString(String.valueOf(ERS.p.plist[2].hsize),710,565);
        }
        if (!ERS.started||(ERS.started&&!(ERS.play_here.pileCards.size()==0))){
        try {
            cimg=whatever();
        } catch (IOException ex) {
            Logger.getLogger(DrawingComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(ERS.started)
            g2.drawImage(cimg, 335, 200, 150, 250, this);
        else
            g2.drawImage(cimg, 0, 0, 800, 600, this);
        //g2.drawImage(cimg, null, 150, 250);
        }//close if
        else
            g2.fill(background);
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