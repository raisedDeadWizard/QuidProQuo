package quidProQuo;

import mediaResources.Resources;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;

public class HighlightView extends JPanel{
    private static final int WIDTH = 1480;
    private static final int HEIGHT = 825;

    public HighlightView() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        int score = Main.dem * Main.rep * Main.nat;

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

        if (isOnView1(e)){
            Main.frame.setContentPane(new StateOfTheUnionView(4, Main.decisions.get(0), Main.responses.get(0), 1));
            Main.frame.pack();
            Main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Main.frame.setVisible(true);
        }
        else if (isOnView2(e)){
            Main.frame.setContentPane(new StateOfTheUnionView(4, Main.decisions.get(2), Main.responses.get(1), 2));
            Main.frame.pack();
            Main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Main.frame.setVisible(true);
        }
        else if (isOnView3(e)){
            Main.frame.setContentPane(new StateOfTheUnionView(4, Main.decisions.get(Main.decisions.size() - 1), Main.responses.get(2), 3));
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
        g.drawString("Highlights", 540, 100);

        g.setColor(Color.GRAY);
        g.fillRect(80,150,250,100);
        g.setColor(Color.BLACK);
        g.drawRect(80,150,250,100);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
        g.drawString("View Year 1", 105, 210);

        g.setColor(Color.GRAY);
        g.fillRect(615,150,250,100);
        g.setColor(Color.BLACK);
        g.drawRect(615,150,250,100);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
        g.drawString("View Year 2", 640, 210);

        g.setColor(Color.GRAY);
        g.fillRect(1150,150,250,100);
        g.setColor(Color.BLACK);
        g.drawRect(1150,150,250,100);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
        g.drawString("View Year 3", 1175, 210);
    }

    private boolean isOnView1(MouseEvent e){
        if (e.getX() > 80 && e.getX() < 330 && e.getY()>150 && e.getY() < 250){
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isOnView2(MouseEvent e){
        if (e.getX() > 615 && e.getX() < 865 && e.getY()>150 && e.getY() < 250){
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isOnView3(MouseEvent e){
        if (e.getX() > 1150 && e.getX() < 1400 && e.getY()>150 && e.getY() < 250){
            return true;
        }
        else {
            return false;
        }
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
