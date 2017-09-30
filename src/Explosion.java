/**
 * Created by henryboswell on 7/25/17.
 */

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Explosion extends Sprite {
    private int stage = 0;


    public Explosion(int x, int y) {
        super(x, y, 0);

        initExplosion();
    }

    private void initExplosion() {

        loadImage("Resources/frames/0.png");

        getImageDimensions();
/*
        try {
            // Open an audio input stream.
            File soundFile = new File("Resources/Explosion_large.wav"); //you could also get the sound file with an URL
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        */




    }



    public int cycle() {
        loadImage("Resources/spaceExplosion/e" + stage + ".png");
        stage = stage + 1;
        getImageDimensions();

        if(stage >= 11) return 2;
        else return 1;


    }



}
