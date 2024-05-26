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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author usuario
 */
public class Panel extends JPanel implements KeyListener{

    private BufferedImage imagenPrincipal;
    private int width, height;
    //private ArrayList<ArrayList<Pieza>> piezas;
    private BufferedImage imagen1;
    private String imagePath;
    private boolean listo = false;
    private RompeCabezas rompecabezas;
    private Pieza piezaSeleccionada;

    public Panel() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addMouseListener(new MouseAdapter(){
            @Override
                public void mouseClicked(MouseEvent e){
                    int x = e.getX();
                    int y = e.getY();
                    Pieza pieza = getPiezaEn(x, y);
                    if(pieza != null){
                        setPiezaSeleccionada(pieza);
                    }
                }
        });
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) throws IOException {
        this.imagePath = imagePath;
        this.rompecabezas = new RompeCabezas();
        this.rompecabezas.cargarImagen(imagePath);
        this.rompecabezas.desordenarPiezas();
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
            int a;
            int b;
            for (int i = 0; i < piezas.size(); i++) {
                for (int j = 0; j < piezas.get(i).size(); j++) {
                    Pieza pieza = piezas.get(i).get(j);
                    
                    BufferedImage img = convertUsingConstructor(pieza.getImage());

                    int x = pieza.getX();
                    int y = pieza.getY();
                            
  //                   if(j % 9 == 0)
                      g.drawImage(img, x, y, this);
                      System.out.println(j);
                }
                System.out.println(i);
            }
        }
    }
    
    public void move(int code) {
        if (piezaSeleccionada != null) {
            int x = piezaSeleccionada.getPosx();
            int y = piezaSeleccionada.getPosy();

            switch (code) {
                case KeyEvent.VK_UP:
                    if (y > 0) {
                        movePieza(x, y, x, y - 1);
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (y < rompecabezas.getPiezas().size() - 1) {
                        movePieza(x, y, x, y + 1);
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if (x > 0) {
                        movePieza(x, y, x - 1, y);
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (x < rompecabezas.getPiezas().get(0).size() - 1) {
                        movePieza(x, y, x + 1, y);
                    }
                    break;
                default:
                    break;
            }
        }
    }
 
    // las piezas se guardan en un mismo array, más sin embargo se manejan arriba 2, para x y y
    // arreglar
    
    private void movePieza(int x, int y, int newX, int newY) {
    ArrayList<ArrayList<Pieza>> piezas = this.rompecabezas.getPiezas();

    if (isValidMove(newX, newY, piezas.get(0).size(), piezas.size())) {
        Pieza temp = piezas.get(y).get(x);
        piezas.get(y).set(x, piezas.get(newY).get(newX));
        piezas.get(newY).set(newX, temp);

        temp.setPosx(newX);
        temp.setPosy(newY);

        repaint();
    }
}
    
    /*private void movePieza(int x, int y, int newX, int newY) {
        ArrayList<ArrayList<Pieza>> piezas = this.rompecabezas.getPiezas();

        if (isValidMove(newX, newY, piezas.size(), piezas.get(0).size())) {
            Pieza temp = piezas.get(y).get(x);
            piezas.get(x).set(x, piezas.get(newY).get(newX));
            piezas.get(newY).set(newX, temp);

            piezas.get(y).get(x).setPosx(x);
            piezas.get(y).get(x).setPosy(y);
            piezas.get(newY).get(newX).setPosx(newX);
            piezas.get(newY).get(newX).setPosy(newY);

            repaint();
        }
    }*/

// Helper method to check if a new position is valid
    private boolean isValidMove(int newX, int newY, int puzzleWidth, int puzzleHeight) {
        return newX >= 0 && newX < puzzleWidth && newY >= 0 && newY < puzzleHeight;
    }
    
    private Pieza getPiezaEn(int x, int y) {
        ArrayList<ArrayList<Pieza>> piezas = this.rompecabezas.getPiezas();
        for (ArrayList<Pieza> fila : piezas) {
            for (Pieza pieza : fila) {
                int piezaX = pieza.getX();
                int piezaY = pieza.getY();
                int piezaWidth = pieza.getImage().getWidth(this) / piezas.size();
                int piezaHeight = pieza.getImage().getHeight(this) / piezas.get(0).size();
                if (x >= piezaX && x < piezaX + piezaWidth && y >= piezaY && y < piezaY + piezaHeight) {
                    return pieza;
                }
            }
        }
        return null;
    }

    /**
     * @param piezaSeleccionada the piezaSeleccionada to set
     */
    public void setPiezaSeleccionada(Pieza piezaSeleccionada) {
        this.piezaSeleccionada = piezaSeleccionada;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        // Maneja los eventos de presionar teclas aquí
        int code = e.getKeyCode();
        move(code);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Maneja los eventos de soltar teclas aquí
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Maneja los eventos de escribir teclas aquí
    }
}
