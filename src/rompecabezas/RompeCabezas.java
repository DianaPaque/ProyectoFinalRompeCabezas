/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rompecabezas;

import modelos.Tiempo;
import modelos.Puntaje;
import java.util.ArrayList;
import modelos.Pieza;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author usuario
 */
public class RompeCabezas {
    private Tiempo tiempoJuego;
    private int puntajeT;
    private ArrayList<Pieza> piezas;
    private ArrayList<Puntaje> puntaje1;
    private BufferedImage imagen1;
    private int width, height;

    public RompeCabezas(Tiempo tiempoJuego, int width, int height) {
        this.tiempoJuego = tiempoJuego;
        this.puntajeT = 0;
        this.piezas = new ArrayList<>();
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
        imagen1 = ImageIO.read(new File("DisneyT1.jpg"));
        width = imagen1.getWidth(null);
        height = imagen1.getHeight(null);     

        for(int i = 0; i < 3; i++){
            for (int j = 0; j  < 3; j++){
                Pieza p = new Pieza(new FilteredImageSource(imagen1.getSource(),
                    new CropImageFilter(j * (width / 3), i * (height / 3) , width / 3, height / 3)));
                piezas.add(p);
            }
        }

    }
    
    public void partirImagenes(){
        
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
}
