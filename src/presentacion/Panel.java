/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.awt.Graphics;
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

//    public Panel() {
//        this.imagenPrincipal = imagenPrincipal;
//        this.width = width;
//        this.height = height;
//        //this.piezas = new ArrayList<ArrayList<Pieza>>();
//        this.imagen1 = imagen1;
//    }
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) throws IOException {
        this.imagePath = imagePath;
        this.rompecabezas = new RompeCabezas();
        this.rompecabezas.cargarImagen();
        this.listo = true;
        repaint();
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (listo) {
            ArrayList<ArrayList<Pieza>> piezas = this.rompecabezas.getPiezas();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; i++) {
                    RompeCabezas r = new RompeCabezas();
                    try {
                        r.cargarImagen();
                    } catch (IOException ex) {
                        Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    /*
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
    
    public void drawR(Graphics g){
        int iter = 0;
        long seed = System.nanoTime();
            Collections.shuffle(piezas, new Random(seed));
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                g.drawImage((Image) piezas.iterator(), i * (width / 3), j * (height / 3), null);
                iter++;
            }
        }
    }


    public void draw(Graphics g){
        for(ArrayList<Pieza> piezas : piezas){
            for(Pieza pieza : piezas){
              pieza.draw(g);
            }
        }
    }
     */
}
