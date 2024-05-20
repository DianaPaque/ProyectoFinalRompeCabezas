/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import modelos.Pieza;
import rompecabezas.RompeCabezas;

/**
 *
 * @author usuario
 */
public class Panel extends JPanel {

    private BufferedImage imagenPrincipal;
    private int width, height;
    //private ArrayList<ArrayList<Pieza>> piezas;
    private BufferedImage imagen1;
    private String imagePath;
    private boolean listo = false;
    private RompeCabezas rompecabezas;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) throws IOException {
        this.imagePath = imagePath;
        this.rompecabezas = new RompeCabezas();
        this.rompecabezas.cargarImagen(imagePath);
        this.listo = true;
        repaint();
    }
    
    
    public BufferedImage convertUsingConstructor(Image image) throws IllegalArgumentException {
    int width = image.getWidth(null);
    int height = image.getHeight(null);
    if (width <= 0 || height <= 0) {
        throw new IllegalArgumentException("Image dimensions are invalid");
    }
    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    bufferedImage.getGraphics().drawImage(image, 0, 0, null);
    return bufferedImage;
}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);



        if (listo) {
            ArrayList<ArrayList<Pieza>> piezas = this.rompecabezas.getPiezas();
            for (int i = 0; i < piezas.size(); i++) {
                for (int j = 0; j < piezas.get(i).size(); j++) {
                    Pieza pieza = piezas.get(i).get(j);
                    
                    BufferedImage img = convertUsingConstructor(pieza.getImage());

                            
                    // BufferedImage img = (BufferedImage) pieza.getImage();
                    int x = pieza.getX();
                    int y = pieza.getY();
                            
  //                   if(j % 9 == 0)
                      g.drawImage(img, x, y, this);
                }
            }
        }
    }
}
