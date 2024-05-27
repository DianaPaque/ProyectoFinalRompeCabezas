package presentacion;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelos.Pieza;
import rompecabezas.RompeCabezas;

public class Tablero extends JPanel {

    private BufferedImage imagenPrincipal;
    private int width;
    private int height;
    private BufferedImage imagen1;
    private String imagePath;
    private boolean listo = false;
    private RompeCabezas rompecabezas;
    private Pieza selectedPieza;
    private int selectedX, selectedY;

    public Tablero() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (listo) {
                    int mouseX = e.getX();
                    int mouseY = e.getY();
                    if (selectedPieza == null) {
                        selectedPieza = getPiezaEn(mouseX, mouseY);
                        if (selectedPieza != null) {
                            selectedX = selectedPieza.getPosx();
                            selectedY = selectedPieza.getPosy();
                        }
                    } 
                    else {
                        Pieza targetPieza = getPiezaEn(mouseX, mouseY);
                        if (targetPieza != null) {
                            intercambiarPiezas(selectedPieza, targetPieza);
                            selectedPieza = null; 
                        }
                    }
                }
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (selectedPieza != null && listo) {
                    int keyCode = e.getKeyCode();
                    switch (keyCode) {
                        case KeyEvent.VK_UP:
                            movePieza(0, -1);
                            break;
                        case KeyEvent.VK_DOWN:
                            movePieza(0, 1);
                            break;
                        case KeyEvent.VK_LEFT:
                            movePieza(-1, 0);
                            break;
                        case KeyEvent.VK_RIGHT:
                            movePieza(1, 0);
                            break;
                    }
                }
            }
        });

        setFocusable(true);
        requestFocusInWindow();
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
        this.width = this.getWidth();
        this.height = this.getHeight();
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

    private void movePieza(int dx, int dy) {
        ArrayList<ArrayList<Pieza>> piezas = this.rompecabezas.getPiezas();
        int x = selectedX / (width / piezas.get(0).size());
        int y = selectedY / (height / piezas.size());
        int newX = x + dx;
        int newY = y + dy;

        if (isValidMove(newX, newY, piezas.get(0).size(), piezas.size())) {
            selectedX = newX * (width / piezas.get(0).size());
            selectedY = newY * (height / piezas.size());
            selectedPieza.setPosx(selectedX);
            selectedPieza.setPosy(selectedY);
            repaint();
            
        }
    }
    
    public boolean verificarGanador(){
       ArrayList<ArrayList<Pieza>> piezas = this.rompecabezas.getPiezas();
       for( ArrayList<Pieza> filapiezas : piezas) {
           for(Pieza p : filapiezas){
              if( p.getPosOriginalX()!= p.getPosx()|| p.getPosOriginalY() != p.getPosy()){
                 return false; 
              }
           }
       }
       return true;
    }

    private void intercambiarPiezas(Pieza pieza1, Pieza pieza2) {
        int tempX = pieza1.getPosx();
        int tempY = pieza1.getPosy();

        pieza1.setPosx(pieza2.getPosx());
        pieza1.setPosy(pieza2.getPosy());

        pieza2.setPosx(tempX);
        pieza2.setPosy(tempY);

        repaint();
        
    }

    private Pieza getPiezaEn(int x, int y) {
        ArrayList<ArrayList<Pieza>> piezas = this.rompecabezas.getPiezas();
        int piezaWidth = width / piezas.get(0).size();
        int piezaHeight = height / piezas.size();
        for (ArrayList<Pieza> fila : piezas) {
            for (Pieza pieza : fila) {
                int piezaX = pieza.getPosx();
                int piezaY = pieza.getPosy();
                if (x >= piezaX && x < piezaX + piezaWidth && y >= piezaY && y < piezaY + piezaHeight) {
                    return pieza;
                }
            }
        }
        return null;
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
                    int x = pieza.getPosx();
                    int y = pieza.getPosy();
                    g.drawImage(img, x, y, this);
                }
            }
        }
    }

    private boolean isValidMove(int newX, int newY, int maxCols, int maxRows) {
        return newX >= 0 && newX < maxCols && newY >= 0 && newY < maxRows;
    }
}