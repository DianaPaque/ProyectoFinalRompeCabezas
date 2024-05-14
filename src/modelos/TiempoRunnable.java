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
import javax.swing.*;

public class TiempoRunnable implements Runnable {
    private int segundos;
    private boolean corriendo;
    private JLabel label;

    public TiempoRunnable(Tiempo aThis, JLabel label) {
        this.segundos = 0;
        this.corriendo = false;
        this.label = label;
    }

    public synchronized void iniciar() {
        corriendo = true;
    }

    public synchronized void pausar() {
        corriendo = false;
    }

    public synchronized void reiniciar() {
        corriendo = false;
        segundos = 0;
        actualizarLabel();
    }

    public synchronized int obtenerTiempo() {
        return segundos;
    }

    public synchronized String obtenerTiempoFormateado() {
        int minutos = segundos / 60;
        int segundosRestantes = segundos % 60;
        return String.format("%d:%02d", minutos, segundosRestantes);
    }

    private void actualizarLabel() {
        SwingUtilities.invokeLater(() -> label.setText(obtenerTiempoFormateado()));
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (this) {
                if (corriendo) {
                    segundos++;
                    actualizarLabel();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            }
        }
    }
