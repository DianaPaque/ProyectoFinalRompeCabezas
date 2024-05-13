/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author usuario
 */
public class Panel  extends JPanel{
    private BufferedImage imagenPrincipal;
    private int width, height;
    private ArrayList<ArrayList<Pieza>> piezas;
    private BufferedImage imagen1;

    public Panel() {
        this.imagenPrincipal = imagenPrincipal;
        this.width = width;
        this.height = height;
        this.piezas = new ArrayList<ArrayList<Pieza>>();
        this.imagen1 = imagen1;
    }

    public void cargarImagen() throws IOException{
        imagen1 = ImageIO.read(new File("DisneyT1.jpg"));
        width = imagen1.getWidth(null);
        height = imagen1.getHeight(null);     

        for(int i = 0; i < 3; i++){
            ArrayList<Pieza>parcial = new ArrayList();
            for (int j = 0; j  < 3; j++){
                Image image = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(imagen1.getSource(),
                    new CropImageFilter(j * (width / 3), i * (height / 3) , width / 3, height / 3)));
                Pieza p = new Pieza(image, j*(width/3), i * (height / 3));
                parcial.add(p);
            }
            piezas.add(parcial);
        }

    }
    
    /*
    public void draw(Graphics g){
        int iter = 0;
        long seed = System.nanoTime();
            Collections.shuffle(piezas, new Random(seed));
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                g.drawImage(piezas.get(iter), i * (width / 5), j * (height / 5), null);
                iter++;
            }
        }
    }
    */
    
    public void draw(Graphics g){
        for(ArrayList<Pieza> piezas : piezas){
            for(Pieza pieza : piezas){
              pieza.draw(g);
            }
        }
    }
    
    
}
