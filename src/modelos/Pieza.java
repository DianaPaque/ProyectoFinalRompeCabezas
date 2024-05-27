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
    private int height;
    private int width;

    public Pieza(Image image, int posx, int posy, int height, int width) {
        this.posx = posx;
        this.posy = posy;
        this.image = image;
        this.height = height;
        this.width = width;
    }
    
    public void draw(Graphics g){
        g.drawImage(image, posx, posy, null, null);
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
    
     /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return the widht
     */
    public int getWidth() {
        return width;
    }
    
    public void move(){
        
    }
    
    public void rotar(){
        
    }
    
    public boolean checkHit(int x, int y) {
        return x >= this.getX() && x <= this.getX() + this.getWidth() && y >= this.getY() && y <= this.getY() + this.getHeight();
    }

}
