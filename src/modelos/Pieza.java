/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;
import java.awt.Color;
import static java.awt.Event.DOWN;
import static java.awt.Event.UP;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static javax.swing.JSplitPane.LEFT;
import static javax.swing.JSplitPane.RIGHT;

/**
 *
 * @author usuario
 */
public class Pieza {
    private int posx;
    private int posy;
    private Image image;

    public Pieza(Image image, int posx, int posy) {
        this.image = image;
        this.posx = posx;
        this.posy = posy;    
    }
    
    public void move(int code){
        if(code == KeyEvent.VK_UP){
            move(UP);
        }
        if(code == KeyEvent.VK_DOWN){
            move(DOWN);
        }
        if(code == KeyEvent.VK_RIGHT){
            move(RIGHT);
        }
        if(code == KeyEvent.VK_LEFT){
            move(LEFT);
        }
    }
    
    public void draw(Graphics g){
        g.drawImage(image, posx, posy, null, null);
    }

    private void move(String RIGHT) {
        
    }

    /**
     * @return the posx
     */
    public int getPosx() {
        return posx;
    }

    /**
     * @return the posy
     */
    public int getPosy() {
        return posy;
    }

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    public int getX() {
        return posx;
    }

    public int getY() {
        return posy;
    }

    /**
     * @param posx the posx to set
     */
    public void setPosx(int posx) {
        this.posx = posx;
    }

    /**
     * @param posy the posy to set
     */
    public void setPosy(int posy) {
        this.posy = posy;
    }

   
}
