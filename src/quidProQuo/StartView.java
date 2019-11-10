package quidProQuo;

import mediaResources.Resources;

import javax.imageio.ImageIO;
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
import java.awt.image.BufferedImage;
import java.net.URL;

public class StartView extends JPanel{
    // Listener for user interaction

    private static final int WIDTH = 1480;
    private static final int HEIGHT = 825;
    private BufferedImage background;
    private BufferedImage[] playButton = new BufferedImage[2];
    private boolean isOnPlay = false;

    private Clip openingTrack;

    public StartView(){

        background = loadImage("StartMenu.png");
        playButton[0] = loadImage("playbutton.png");
        playButton[1] = loadImage("playbutton1.png");
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
        if (isOnPlay(e)){
            isOnPlay = true;
        }
        else {
            isOnPlay = false;
        }

        repaint();
    }


    protected void handleMousePressed(MouseEvent e) {
        if (isOnPlay){
            Main.frame.setContentPane(new RoomView());
            Main.frame.pack();
            Main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Main.frame.setVisible(true);
            openingTrack.stop();
        }


    }

    protected void handleMouseDragged(MouseEvent e) {
        repaint();
    }

    protected void handleMouseReleased(MouseEvent e) {
        repaint();
    }

    /** Paint Component **/
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(background, 0, 0, null);
        if (isOnPlay){
            g.drawImage(playButton[1], 275, 650, null);
        }
        else {
            g.drawImage(playButton[0], 275, 650, null);
        }

    }

    private boolean isOnPlay(MouseEvent e){
        if (e.getX() > 275 && e.getX() < 675 && e.getY() > 650 && e.getY() < 750){
            return true;
        }
        else {
            return false;
        }
    }
    private BufferedImage loadImage(String resourceName) {
        BufferedImage image;
        try {
            System.out.println("Loading " + resourceName);
            URL resource = Resources.class.getResource(resourceName);
            image = ImageIO.read(resource);
        } catch (Exception e) {
            throw new IllegalStateException("Could not load " + resourceName);
        }
        return image;
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

