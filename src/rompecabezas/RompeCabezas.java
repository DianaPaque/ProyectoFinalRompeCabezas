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

public class RompeCabezas {
    private Tiempo tiempoJuego;
    private int puntajeT;
    private ArrayList<ArrayList<Pieza>> piezas;
    private ArrayList<ArrayList<Pieza>> disposicionOriginal;
    private ArrayList<Puntaje> puntaje1;
    private BufferedImage imagen1;
    private int width, height;

    public RompeCabezas() {
        this.tiempoJuego = tiempoJuego;
        this.puntajeT = 0;
        this.piezas = new ArrayList<ArrayList<Pieza>>();
         this.disposicionOriginal = new ArrayList<>();
        this.puntaje1 = new ArrayList<>();
        this.imagen1 = imagen1;
        this.width = width;
        this.height = height;
    }

    public boolean iniciarJuego() {
        return true;
    }

    public boolean resolverRompecabezas() {
        return true;
    }

    public void cargarImagen(String imagePath) throws IOException {
    imagen1 = ImageIO.read(new File(imagePath));
    width = imagen1.getWidth(null);
    height = imagen1.getHeight(null);

    ArrayList<Pieza> piezasList = new ArrayList<>();
    disposicionOriginal = new ArrayList<>();

    for(int i = 0; i < 3; i++){
        ArrayList<Pieza> parcialOriginal = new ArrayList<>();
        for (int j = 0; j < 3; j++){
            Image image = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(imagen1.getSource(),
                new CropImageFilter(j * (width / 3), i * (height / 3), width / 3, height / 3)));
            Pieza p = new Pieza(image, j * (width / 3), i * (height / 3));
            piezasList.add(p);
            parcialOriginal.add(p);
        }
        disposicionOriginal.add(parcialOriginal);
    }

    Collections.shuffle(piezasList);

    int index = 0;
    for (int i = 0; i < 3; i++) {
        ArrayList<Pieza> parcial = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            Pieza p = piezasList.get(index);
            p.setPosx(j * (width / 3));
            p.setPosy(i * (height / 3));
            parcial.add(p);
            index++;
        }
        piezas.add(parcial);
    }
}

    public void desordenarPiezas() {
        for (ArrayList<Pieza> fila : piezas) {
            Collections.shuffle(fila);
        }
        Collections.shuffle(piezas);
    }

    public int calcularPuntajeTotal() {
        for(int i = 0; i < 3; i++){
            Tiempo tiempo = null;
            Puntaje p = new Puntaje(tiempo);
            p.calcularPuntajeActual();
            puntaje1.add(p);
        }

        for(int i = 0; i < puntaje1.size(); i++){
            this.puntajeT += (int)(puntaje1.get(i).calcularPuntajeActual());
        }

        return puntajeT;
    }

    public ArrayList<ArrayList<Pieza>> getPiezas() {
        return piezas;
    }

}