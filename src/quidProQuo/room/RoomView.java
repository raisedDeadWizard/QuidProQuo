package quidProQuo.room;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

public class RoomView extends JPanel implements ActionListener{
    private Timer timer;
    private Random rand;




    private static final long serialVersionUID = 1L;

    /** Width of the window */
    private static final int WIDTH = 1920;

    /** Height of window */
    private static final int HEIGHT = 1080;



    public RoomView() {

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));


        // Image will not work right now on other devices
        timer = new Timer(25, this);
        timer.start();
        rand = new Random();




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
        repaint();
    }

    protected void handleMouseDragged(MouseEvent e) {


        repaint();
    }

    protected void handleMouseReleased(MouseEvent e) {

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);



    }


    private BufferedImage loadImage(String resourceName) {
        BufferedImage image;
        try {
            System.out.println("Loading " + resourceName);
            URL resource = RoomView.class.getResource(resourceName);
            image = ImageIO.read(resource);
        } catch (Exception e) {
            throw new IllegalStateException("Could not load " + resourceName);
        }
        return image;
    }




    @Override
    public void actionPerformed(ActionEvent e) {


        repaint();
    }
}
