package quidProQuo.room;


import quidProQuo.aid.Aid;
import quidProQuo.impeach.ImpeachmentBar;
import quidProQuo.phone.Phone;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;

public class RoomView extends JPanel {
    private BufferedImage background;
    private ImpeachmentBar iBar;
    private Phone phone;
    private Aid aid;
    private JButton phoneButton;
    private boolean isPhoneSelected;

    private static final long serialVersionUID = 1L;

    /** Width of the window */
    private static final int WIDTH = 1280;

    /** Height of window */
    private static final int HEIGHT = 920;



    public RoomView() {

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        // Image will not work right now on other devices
        background = loadImage("OvalOfficePixelated.png");
        iBar = new ImpeachmentBar();
        phone = new Phone();
        isPhoneSelected = false;


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
        if (isOnPhone(e)){
            isPhoneSelected = true;
        }
        else {
            isPhoneSelected = false;
        }
        repaint();
    }


    protected void handleMousePressed(MouseEvent e) {

        if (e.getX() > 20 && e.getX() < 500 && e.getY() > 20 && e.getY() < 65){
            iBar.update(5);
        }

        repaint();
    }

    protected void handleMouseDragged(MouseEvent e) {

        System.out.println("X: " + e.getX() + " Y: " + e.getY());
        repaint();
    }

    protected void handleMouseReleased(MouseEvent e) {

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Paint background
        g.drawImage(background, 0, 0, null);

       // draw objects
       drawPhone(g, phone, isPhoneSelected);
       drawImpeachmentBar(g, iBar);

    }

    private void drawPhone(Graphics g, Phone phone, boolean isPhoneSelected){
        g.drawImage(phone.getState(isPhoneSelected), phone.getX(isPhoneSelected), phone.getY(isPhoneSelected), null);
    }

    private void drawImpeachmentBar(Graphics g, ImpeachmentBar impeachmentBar){
        g.drawImage(iBar.getSprite(), iBar.getX(),iBar.getY(),null);
        g.setColor(Color.RED);
        g.fillRect(iBar.getX()+8,iBar.getY()+3, iBar.getImpeachPercent()*3, 18);
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

    private boolean isOnPhone(MouseEvent e){
        if (e.getX() > phone.getX() && e.getX() < phone.getX() + 75 && e.getY() > phone.getY() && e.getY() < phone.getY() + 60){
            return true;
        }
        else {
            return false;
        }
    }


}
