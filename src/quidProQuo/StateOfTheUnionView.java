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
    private BufferedImage stateBox, resBox, descBox;

    public StateOfTheUnionView(int year, ArrayList<Decision> yearHighlights, ArrayList<Response> highlightResponses) {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        this.yearHighlights = yearHighlights;
        this.highlightResponses = highlightResponses;

        stateBox = loadImage("stateBox.png");
        descBox = loadImage("Impact.png");
        resBox = loadImage("resBox.png");
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

        if (Main.year < 4) {
            Main.frame.setContentPane(new RoomView(Main.year, Main.dem, Main.rep, Main.nat));
            Main.frame.pack();
            Main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Main.frame.setVisible(true);
        }
        else {
            Main.frame.setContentPane(new HighlightView());
            Main.frame.pack();
            Main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Main.frame.setVisible(true);
        }



    }

    protected void handleMouseDragged(MouseEvent e) {
        repaint();
    }

    protected void handleMouseReleased(MouseEvent e) {
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0,WIDTH,HEIGHT);
        g.setColor(Color.WHITE);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 72));
        g.drawString("Year " + year + " Summary", WIDTH/2 - 300, 100);

        g.drawImage(stateBox, 20, 390, null);
        g.drawImage(stateBox, 495, 390, null);
        g.drawImage(stateBox, 980, 390, null);

        g.drawImage(resBox, 50, 270, null);
        g.drawImage(resBox, 525, 270, null);
        g.drawImage(resBox, 1010, 270, null);


        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 30));

        g.drawImage(descBox, 60, 120, null);
        g.drawString("Decision 1", 60 + 100, 120 + 45);

        g.drawImage(descBox, 535, 120, null);
        g.drawString("Decision 2", 535 + 100, 120 + 45);

        g.drawImage(descBox, 1020, 120, null);
        g.drawString("Decision 3", 1020 + 100, 120 + 45);


        g.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
        String line = "";
        int jump = 0;
        for (String word : yearHighlights.get(0).toString().split(" ")) {
            if (line.length() + word.length() <= 35) {
                line += word + " ";
            } else {

                g.drawString(line, 60 + 30, 120 + 100 + g.getFontMetrics().getHeight() * jump);
                jump++;
                line = word + " ";
            }
        }
        g.drawString(line, 60 + 30, 120 + 100 + g.getFontMetrics().getHeight() * jump);
        line = "";
        jump = 0;
        for (String word : yearHighlights.get(1).toString().split(" ")) {
            if (line.length() + word.length() <= 35) {
                line += word + " ";
            } else {

                g.drawString(line, 535 + 30, 120 + 100 + g.getFontMetrics().getHeight() * jump);
                jump++;
                line = word + " ";
            }
        }
        g.drawString(line, 535 + 30, 120 + 100 + g.getFontMetrics().getHeight() * jump);
        line = "";
        jump = 0;
        for (String word : yearHighlights.get(2).toString().split(" ")) {
            if (line.length() + word.length() <= 35) {
                line += word + " ";
            } else {

                g.drawString(line, 1020 + 30, 120 + 100 + g.getFontMetrics().getHeight() * jump);
                jump++;
                line = word + " ";
            }
        }
        g.drawString(line, 1020 + 30, 120 + 100 + g.getFontMetrics().getHeight() * jump);

        /**   Response Box Text   **/
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
        line = "Your Response: ";
        jump = 0;
        for (String word : highlightResponses.get(0).toString().split(" ")) {
            if (line.length() + word.length() <= 35) {
                line += word + " ";
            } else {

                g.drawString(line, 50 + 30, 270 + 120 + g.getFontMetrics().getHeight() * jump);
                jump++;
                line = word + " ";
            }
        }
        g.drawString(line, 50 + 30, 270 + 120 + g.getFontMetrics().getHeight() * jump);
        line = "Your Response: ";
        jump = 0;
        for (String word : highlightResponses.get(1).toString().split(" ")) {
            if (line.length() + word.length() <= 35) {
                line += word + " ";
            } else {

                g.drawString(line, 525 + 30, 270 + 120 + g.getFontMetrics().getHeight() * jump);
                jump++;
                line = word + " ";
            }
        }
        g.drawString(line, 525 + 30, 270 + 120 + g.getFontMetrics().getHeight() * jump);
        line = "Your Response: ";
        jump = 0;
        for (String word : highlightResponses.get(2).toString().split(" ")) {
            if (line.length() + word.length() <= 35) {
                line += word + " ";
            } else {

                g.drawString(line, 1010 + 30, 270 + 120 + g.getFontMetrics().getHeight() * jump);
                jump++;
                line = word + " ";
            }
        }
        g.drawString(line, 1010 + 30, 270 + 120 + g.getFontMetrics().getHeight() * jump);

        g.setColor(Color.WHITE);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
        g.drawString("Click Anywhere to Continue", 525, 810);


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

