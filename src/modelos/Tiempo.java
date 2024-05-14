/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;
import java.util.Timer;
import java.io.IOException;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author usuario
 */
public class Tiempo {
    private int segundos;
    private boolean corriendo;
    private JLabel label;
    private TiempoRunnable tiempoRunnable;
    private Thread hilo;

    public Tiempo(JLabel label) {
        this.segundos = 0;
        this.corriendo = false;
        this.label = label;
        this.tiempoRunnable = new TiempoRunnable(this, label);
        this.hilo = new Thread((Runnable) tiempoRunnable);
    }

    public int getSegundos() {
        return segundos;
    }

    public synchronized boolean iniciar() {
        if (corriendo) {
            return false;
        }
        corriendo = true;
        if (!hilo.isAlive()) {
            hilo = new Thread((Runnable) tiempoRunnable);
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

    private void actualizarLabel() {
        SwingUtilities.invokeLater(() -> label.setText(obtenerTiempoFormateado()));
    }

    public synchronized void incrementarSegundos() {
        segundos++;
        actualizarLabel();
    }

    public synchronized boolean CorriendoTiempo() {
        return corriendo;
    }
}

