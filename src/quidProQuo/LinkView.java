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

public class LinkView extends JPanel {
    private static final int WIDTH = 1480;
    private static final int HEIGHT = 825;

    public LinkView() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        int startX = 50;
        int startY = 50;
        for(Highlight h : Topics.highlights) {
            JLink link = new JLink(h.getLink(), h.getLink());
            Main.frame.add(link);
            if(startX < 1200) {
                link.setBounds(startX, startY, 200, 30);
                startX += 200;
            } else {
                startX = 50;
                startY += 50;
                link.setBounds(startX, startY, 200, 30);
            }
        }
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

        Main.frame.setContentPane(new StartView());
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
        g.drawString("Highlights", WIDTH/2, 20);
    }

}