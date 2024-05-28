/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import javax.swing.JLabel;

/**
 *
 * @author usuario
 */
public class Puntaje {
    private int puntajeActual;
    private JLabel label;

    public Puntaje(Tiempo tiempo, JLabel jLabel) {
        this.puntajeActual = 0;
    }

    /**
     * @return the puntajeActual
     */
    public int getPuntajeActual() {
        return puntajeActual;
    }
    
    public int calcularPuntajeActual(){
        
        Tiempo t = new Tiempo(label);
        
        if(t.obtenerTiempo() > 0 && t.obtenerTiempo() <= 30){
            this.puntajeActual += 200;
        }
        else if(t.obtenerTiempo() > 30 && t.obtenerTiempo() <= 60){
            this.puntajeActual += 150;
        }
        else if(t.obtenerTiempo() > 60 && t.obtenerTiempo() <= 90){
            this.puntajeActual += 100;
        }
        else if(t.obtenerTiempo() > 90 && t.obtenerTiempo() <= 120){
            this.puntajeActual += 50;
        }
        else{
            this.puntajeActual += 20;
        }
        
        return (int) puntajeActual;
    }
    
    
}
