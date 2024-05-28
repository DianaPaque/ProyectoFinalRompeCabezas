package rompecabezas;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
import modelos.Pieza;

public class RompeCabezas {
    private BufferedImage imagen;
    private int width, height;
    private ArrayList<ArrayList<Pieza>> piezas;
    private ArrayList<ArrayList<Pieza>> disposicionOriginal;

    public RompeCabezas() {
        this.piezas = new ArrayList<>();
        this.disposicionOriginal = new ArrayList<>();
    }

    public void cargarImagen(String imagePath, int nivel) throws IOException {
    piezas.clear(); // Limpiar la lista antes de cargar la imagen
    disposicionOriginal.clear(); // Limpiar la lista antes de cargar la imagen

    imagen = ImageIO.read(new File(imagePath));
    width = imagen.getWidth();
    height = imagen.getHeight();

    int divisiones;
    if (imagePath.contains("IDisney")) {
        divisiones = 3; // Disney -> 3x3
    } else if (imagePath.contains("IMarvel")) {
        divisiones = 4; // Marvel -> 4x4
    } else if (imagePath.contains("IPixar")) {
        divisiones = 5; // Pixar -> 5x5
    } else {
        // Por defecto, si no se reconoce el tipo de imagen, se utilizará 3 divisiones
        divisiones = 3;
    }

    ArrayList<Pieza> piezasList = new ArrayList<>();

    for (int i = 0; i < divisiones; i++) {
        for (int j = 0; j < divisiones; j++) {
            Image imagenPieza = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(
                    imagen.getSource(), new CropImageFilter(j * (width / divisiones), i * (height / divisiones),
                            width / divisiones, height / divisiones)));
            Pieza pieza = new Pieza(imagenPieza, j * (width / divisiones), i * (height / divisiones));
            piezasList.add(pieza);
        }
    }

    Collections.shuffle(piezasList);

    piezas = new ArrayList<>();
    int index = 0;
    for (int i = 0; i < divisiones; i++) {
        ArrayList<Pieza> parcial = new ArrayList<>();
        for (int j = 0; j < divisiones; j++) {
            Pieza p = piezasList.get(index);
            p.setPosx(j * (width / divisiones));
            p.setPosy(i * (height / divisiones));
            parcial.add(p);
            index++;
        }
        piezas.add(parcial);
    }
}

    public void desordenarPiezas() {
        if (piezas.isEmpty()) {
            System.err.println("Error: La lista de piezas está vacía. Debe cargar una imagen primero.");
            return;
        }
        
        for (ArrayList<Pieza> fila : piezas) {
            Collections.shuffle(fila);
        }
        Collections.shuffle(piezas);
    }

    // Otros métodos según necesidades adicionales
    
    // Getter para obtener la imagen
    public BufferedImage getImagen() {
        return imagen;
    }

    // Getter para obtener el ancho de la imagen
    public int getWidth() {
        return width;
    }

    // Getter para obtener la altura de la imagen
    public int getHeight() {
        return height;
    }

    // Getter para obtener las piezas
    public ArrayList<ArrayList<Pieza>> getPiezas() {
        return piezas;
    }

    // Getter para obtener la disposición original de las piezas
    public ArrayList<ArrayList<Pieza>> getDisposicionOriginal() {
        return disposicionOriginal;
    }
}