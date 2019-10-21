package quidProQuo.gui;


import quidProQuo.ImpeachmentBar;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class RoomView extends JPanel {
    private BufferedImage background;
    private ImpeachmentBar iBar;

    private static final long serialVersionUID = 1L;

    /** Width of the window */
    private static final int WIDTH = 1920;

    /** Height of window */
    private static final int HEIGHT = 1080;



    public RoomView() {

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        // Image will not work right now on other devices
        background = loadImage("ovaloffice.png");
        iBar = new ImpeachmentBar();


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
        };
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }


    protected void handleMousePressed(MouseEvent e) {

        if (e.getX() > 20 && e.getX() < 500 && e.getY() > 20 && e.getY() < 65){
            iBar.update(5);
        }

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
        // Paint background
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);

       // drawing oval office to test
        g.drawImage(iBar.getSprite(), 20,20,null);
        g.setColor(Color.RED);
        g.fillRect(iBar.getX()+8,iBar.getY()+3, Math.round(iBar.getImpeachPercent()*3), 18);
        g.setColor(Color.BLACK);
        g.drawChars(iBar.getPercent(), 0, iBar.getPercent().length,iBar.getX() + 175,iBar.getY() + 38);

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


}
