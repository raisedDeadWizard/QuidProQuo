package quidProQuo;

import mediaResources.Resources;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;

public class StateOfTheUnionView extends JPanel {
    private static final int WIDTH = 1480;
    private static final int HEIGHT = 825;
    private static int year;
    private Clip newTrack;
    private FloatControl volume;
    private ArrayList<Decision> yearHighlights;
    private ArrayList<Response> highlightResponses;

    public StateOfTheUnionView(int year, ArrayList<Decision> yearHighlights, ArrayList<Response> highlightResponses) {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        this.yearHighlights = yearHighlights;
        this.highlightResponses = highlightResponses;

        StateOfTheUnionView.year = year;
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

        Main.frame.setContentPane(new RoomView(Main.year, Main.dem, Main.rep, Main.nat));
        Main.frame.pack();
        Main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main.frame.setVisible(true);




    }

    protected void handleMouseDragged(MouseEvent e) {
        repaint();
    }

    protected void handleMouseReleased(MouseEvent e) {
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH,HEIGHT);
        g.setColor(Color.WHITE);
        g.drawString("Year " + year, WIDTH/2, 20);
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
}

