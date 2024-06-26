/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Tiempo {
    private int segundos;
    private boolean corriendo;
    private JLabel label;
    private Thread hilo;

    public Tiempo(JLabel label) {
        this.segundos = 0;
        this.corriendo = false;
        this.label = label;
        this.hilo = new Thread(new TiempoRunnable(this));
    }

    public synchronized boolean iniciar() {
        if (corriendo) {
            return false; // El tiempo ya está corriendo
        }
        corriendo = true;
        if (!hilo.isAlive()) {
            hilo.start();
        }
        return true;
    }

    public synchronized boolean pausar() {
        if (!corriendo) {
            return false;
        }
        corriendo = false;
        return true;
    }

    public synchronized boolean reiniciar() {
        pausar();
        segundos = 0;
        actualizarLabel();
        return true;
    }

    public synchronized int obtenerTiempo() {
        return segundos;
    }

    public synchronized String obtenerTiempoFormateado() {
        int minutos = segundos / 60;
        int segundosRestantes = segundos % 60;
        return String.format("%d:%02d", minutos, segundosRestantes);
    }

    public synchronized boolean estaCorriendo() {
        return corriendo;
    }

    public synchronized void incrementarSegundos() {
        segundos++;
    }

    public void actualizarLabel() {
        if (label != null) {
            SwingUtilities.invokeLater(() -> label.setText(obtenerTiempoFormateado()));
        }
    }
}

