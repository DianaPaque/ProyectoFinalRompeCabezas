/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rompecabezas;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import modelos.Tiempo;
import modelos.Puntaje;
import java.util.ArrayList;
import modelos.Pieza;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author usuario
 */
public class RompeCabezas{
    private Tiempo tiempoJuego;
    private int puntajeT;
    private ArrayList<ArrayList<Pieza>> piezas;
    private ArrayList<Puntaje> puntaje1;
    private BufferedImage imagen1;
    private int width, height;

    public RompeCabezas() {
        this.tiempoJuego = tiempoJuego;
        this.puntajeT = 0;
        this.piezas = new ArrayList<ArrayList<Pieza>>();
        this.puntaje1 = new ArrayList<>();
        this.imagen1 = imagen1;
        this.width = width;
        this.height = height;
    }
    
    public boolean iniciarJuego(){
        return true;
    }
    
    public boolean resolverRompecabezas(){
        return true;
    }
    
    public void cargarImagen() throws IOException{
        imagen1 = ImageIO.read(new File("src\\imagenesTableros\\IDisney\\DisneyT1.jpg"));
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
            getPiezas().add(parcial);
        }

    }
    
    public int calcularPuntajeTotal(){
        
        for(int i = 0; i < 3; i++){
            Puntaje p = new Puntaje();
            p.calcularPuntajeActual();
            puntaje1.add(p);
        }
        
        for(int i = 0; i < puntaje1.size(); i++){
            this.puntajeT += (int)(puntaje1.get(i).calcularPuntajeActual());
        }
        
        return puntajeT;
    }

    /**
     * @return the piezas
     */
    public ArrayList<ArrayList<Pieza>> getPiezas() {
        return piezas;
    }
}
