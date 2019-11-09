package quidProQuo;

import mediaResources.Resources;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class StartView extends JPanel{
    // Listener for user interaction

    private static final int WIDTH = 1480;
    private static final int HEIGHT = 825;

    private Clip openingTrack;

    public StartView(){

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        openingTrack = loadSound("hailToCheif.wav");
        FloatControl volume = (FloatControl) openingTrack.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(-20);
        openingTrack.loop(Clip.LOOP_CONTINUOUSLY);


    MouseAdapter listener = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            handleMousePressed(e);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            handleMouseDragged(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            handleMouseReleased(e);
        }

        @Override
        public void mouseMoved(MouseEvent e) { handleMouseMoved(e);}

    };
    addMouseListener(listener);
    addMouseMotionListener(listener);



    }

    protected void handleMouseMoved(MouseEvent e){
        repaint();
    }


    protected void handleMousePressed(MouseEvent e) {
        Main.frame.setContentPane(new RoomView());
        Main.frame.pack();
        Main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main.frame.setVisible(true);
        openingTrack.stop();

    }

    protected void handleMouseDragged(MouseEvent e) {
        repaint();
    }

    protected void handleMouseReleased(MouseEvent e) {
        repaint();
    }


    private Clip loadSound(String resourceName) {
        Clip clip;
        try {
            System.out.println("Loading " + resourceName);
            URL resource = Resources.class.getResource(resourceName);
            AudioInputStream stream = AudioSystem.getAudioInputStream(resource);
            clip = AudioSystem.getClip();
            clip.open(stream);
        } catch (Exception e) {
            throw new IllegalStateException("Could not load " + resourceName);
        }
        return clip;
    }

}

