package quidProQuo;

import com.sun.tools.internal.jxc.ap.Const;
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
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Random;

public class RoomView extends JPanel implements ActionListener{

    // Timer to manage game runtime, and animation frequency
    private Timer timer;
    private int ticks = 0, blinkTick = 120;


    // Random variable member
    private Random rand;
    private Topics topics;
    private Font font;
    private boolean blink = false;
    private BufferedImage background, desk, coke;
    private BufferedImage[] donald = new BufferedImage[2];

    private Clip cokeClip, soundTrack;
    // Width of the window
    private static final int WIDTH = 1480;
    //Height of window
    private static final int HEIGHT = 825;



    public RoomView() {

        // Sets the background color of the window
        setBackground(Color.WHITE);

        // Sets the window size
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        background = loadImage("OvalOffice.png");
        desk = loadImage("Desk.png");
        coke = loadImage("DietCoke.png");
        cokeClip = loadSound("DietCoke.wav");
        soundTrack = loadSound("newGame.wav");
        FloatControl volume = (FloatControl) soundTrack.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(-20);
        soundTrack.loop(Clip.LOOP_CONTINUOUSLY);


        donald[0] = loadImage("Donald.png");
        donald[1] = loadImage("DonaldBlinking.png");

        try {
            String fontName = "PressStart2P-Regular.ttf";
            InputStream is = RoomView.class.getResourceAsStream(fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Initalize timer, with ticks interating ever *25* miliseconds
        timer = new Timer(25, this);
        timer.start();

        //Initialize random variable
        rand = new Random();

        topics = new Topics();

        // Listener for user interaction
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
        if (isOnCan(e)) {
            cokeClip.setFramePosition(0);
            cokeClip.start();
        }
        repaint();
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
        g.setFont(font);

        // Background image
        g.drawImage(background, 0, 0,null);

        //TODO: Donald Trump Sprite

        //Desk sprite
        g.drawImage(desk, Constants.deskX, Constants.deskY, null);

        if (blink){
            g.drawImage(donald[1], Constants.donaldX, Constants.donaldY, null);
        }
        else {
            g.drawImage(donald[0], Constants.donaldX, Constants.donaldY, null);
        }


        //Diet Coke
        g.drawImage(coke, Constants.cokeX, Constants.cokeY, null);

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

    public boolean isOnCan(MouseEvent e){
        if (e.getX() > Constants.cokeX && e.getX() < Constants.cokeX + 80 && e.getY() > Constants.cokeY && e.getY() < Constants.cokeY + 100){
            return true;
        }
        else {
            return false;
        }
    }

    /** reoccuring events to animate go in this function**/
    @Override
    public void actionPerformed(ActionEvent e) {
        ticks++;

        if (ticks > blinkTick){
            blink = true;
        }

        if (ticks > blinkTick + 5){
            blink = false;
            ticks = 0;
        }

        repaint();
    }
}
