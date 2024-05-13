/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;
import java.awt.Color;
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
            posy += 20;
        }
        if(code == KeyEvent.VK_DOWN){
            posy -= 20;
        }
        if(code == KeyEvent.VK_RIGHT){
            posx += 20;
        }
        if(code == KeyEvent.VK_LEFT){
            posx -= 20;
        }
    }
    
    public void draw(Graphics g){
        g.drawImage(image, posx, posy, null, null);
    }
}
