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
public class TiempoRunnable implements Runnable {
    private Tiempo tiempo;

    public TiempoRunnable(Tiempo tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (tiempo) {
                if (tiempo.estaCorriendo()) {
                    tiempo.incrementarSegundos();
                    tiempo.actualizarLabel();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
