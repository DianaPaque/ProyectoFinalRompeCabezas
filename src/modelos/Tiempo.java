/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;
import java.util.Timer;
import java.io.IOException;
import java.util.TimerTask;

/**
 *
 * @author usuario
 */
public class Tiempo {
    private int minutos;
    private int segundos;
    private Timer timer;

    public Tiempo() {
        this.minutos = 0;
        this.segundos = 0;
    }

    public int getSegundos() {
        return segundos;
    }
    
    public boolean iniciar(){
       timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                segundos++;
            }
        }, 1000, 1000);
        return true; 
    }
    public boolean pausar(){
      timer.cancel();
      return true;
    }
    public boolean reiniciar(){
       segundos = 0;
       return true;
    }
    public int ObtenerTiempo(){
        return segundos;
    }
    public int obtenerTiempo() {

    int minutos = segundos / 60;
    int segundosRestantes = segundos % 60;

    int tiempoTotalEnSegundos = (minutos * 60) + segundosRestantes;

    return tiempoTotalEnSegundos;
    }
}
