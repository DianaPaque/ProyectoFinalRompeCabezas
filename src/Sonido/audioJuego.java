/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sonido;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class audioJuego {

    private Clip juego;

    public void getAudios() {
        try {
            juego = loadClip("/Sonido/Audio.WAV"); 
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace();
            System.out.println("Error al cargar los audios");
        }
    }

    private Clip loadClip(String path) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        URL url = getClass().getResource(path);
        if (url == null) {
            throw new IOException("Audio file not found: " + path);
        }
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.addLineListener(new LineListener() {
            @Override
            public void update(LineEvent event) {
                if (event.getType() == LineEvent.Type.START) {
                    System.out.println("Playback started for: " + path);
                }
            }
        });
        return clip;
    }

    public void playClip(Clip clip, boolean loop) {
        if (clip != null) {
            clip.setFramePosition(0);
            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.start();
            }
        }
    }

    public void playJuego() {
        playClip(juego, true);
        System.out.println("Reproduciendo audio del juego");
    }

}
