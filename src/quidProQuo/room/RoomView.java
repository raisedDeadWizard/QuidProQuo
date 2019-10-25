package quidProQuo.room;


import quidProQuo.aid.Aid;
import quidProQuo.impeach.ImpeachmentBar;
import quidProQuo.phone.Phone;
import quidProQuo.phone.PhoneDialogue;
import quidProQuo.phone.PhoneResponse;
import quidProQuo.phone.PhoneTopics;

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
    private BufferedImage background;
    private Timer timer;
    private int secsToTicks = 40;
    private ImpeachmentBar iBar;
    private Phone phone;
    private PhoneTopics phoneTopics;
    private String currentPhoneTopic;
    private PhoneResponse[] currentResponseSet;
    private JButton phoneButton;
    private boolean isPhoneSelected;
    private int phoneTime = 0;
    private boolean phoneCall = false;
    private boolean isOnCall = false;
    private PhoneDialogue dialogueBox;
    private int dialogueOption = 0;
    private Random rand;
    private Font font;

    private Aid aid;

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
        phoneTopics = new PhoneTopics();
        phone = new Phone(phoneTopics);
        isPhoneSelected = false;
        dialogueBox = new PhoneDialogue();
        timer = new Timer(25, this);
        timer.start();
        rand = new Random();

        /*try {
            //Returned font is of pt size 1
            URL path = RoomView.class.getResource("ARCADECLASSIC.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, new File(path.getFile()));

            //Derive and return a 12 pt version:
            //Need to use float otherwise
            //it would be interpreted as style

            font = font.deriveFont(20f);

        } catch (IOException|FontFormatException e) {

        }*/

        font = new Font(Font.DIALOG, Font.BOLD, 12);


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
        System.out.println("X: " + e.getX() + " Y: " + e.getY());

        if (isOnPhone(e)){
            isPhoneSelected = true;
        }
        else {
            isPhoneSelected = false;
        }

        if (isOnCall){
            if (isOnOption0(e)){
                dialogueOption = 1;
            }
            else if (isOnOption1(e)){
                dialogueOption = 2;
            }
            else if (isOnOption2(e)){
                dialogueOption = 3;
            }
            else {
                dialogueOption = 0;
            }
        }
        repaint();
    }


    protected void handleMousePressed(MouseEvent e) {

        if (isOnPhone(e) && !isOnCall && phoneCall){
            phoneCall = false;
            phoneTime = 0;
            isOnCall = true;

            currentPhoneTopic = phone.getLine();
            currentResponseSet = phone.getResponses(currentPhoneTopic);
        }

        if (isOnCall){
            if (isOnOption0(e)){


                iBar.update(currentResponseSet[0].getImVal());
                isOnCall = false;
            }
            else if (isOnOption1(e)){

                iBar.update(currentResponseSet[1].getImVal());
                isOnCall = false;
            }
            else if (isOnOption2(e)){

                iBar.update(currentResponseSet[2].getImVal());
                isOnCall = false;
            }
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
        super.paintComponent(g);
        g.setFont(font);

        // Paint background
        g.drawImage(background, 0, 0, null);

       // draw objects
       if(isOnCall){
           drawPhoneResponseWindow(g, dialogueBox.getSprite(dialogueOption), currentPhoneTopic, currentResponseSet);
       }
       drawPhone(g, phone, isPhoneSelected);
       drawImpeachmentBar(g, iBar);

    }

    private void drawPhone(Graphics g, Phone phone, boolean isPhoneSelected){
        g.drawImage(phone.getState(isPhoneSelected), phone.getX(), phone.getY(), null);
    }

    private void drawPhoneResponseWindow(Graphics g, BufferedImage window, String line, PhoneResponse[] responses ){
        g.setColor(Color.GRAY);
        //g.fillRect(200, 80, 880, 150);
        g.drawImage(responses[0].getAvatar(),dialogueBox.getX() + 24,dialogueBox.getY()+23,null);
        g.drawImage(window, dialogueBox.getX(),dialogueBox.getY(), null);

        g.setColor(Color.BLACK);
        //g.drawChars(responses[0].getCaller().toCharArray(), 0, responses[0].getCaller().length(), 970, 200);


        g.drawChars(line.toCharArray(), 0, line.length(),dialogueBox.getX()+160, dialogueBox.getY()+25);
        g.drawChars(responses[0].getResponseToPrint(), 0, responses[0].getResponseToPrint().length,dialogueBox.getX()+185, dialogueBox.getY()+55);
        g.drawChars(responses[1].getResponseToPrint(), 0, responses[1].getResponseToPrint().length,dialogueBox.getX()+185, dialogueBox.getY()+85);
        g.drawChars(responses[2].getResponseToPrint(), 0, responses[2].getResponseToPrint().length,dialogueBox.getX()+185, dialogueBox.getY()+115);

    }

    private void drawImpeachmentBar(Graphics g, ImpeachmentBar impeachmentBar){
        g.drawImage(iBar.getSprite(), iBar.getX(),iBar.getY(),null);

        g.setColor(new Color(impeachmentBar.getImpeachPercent() * 2, 200 - impeachmentBar.getImpeachPercent()* 2,0));

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
 //350 1040 120/20/10
    private boolean isOnOption0(MouseEvent e){
        if (e.getX() > dialogueBox.getX() + 150 && e.getX() < dialogueBox.getX() + 1030 && e.getY() > dialogueBox.getY() + 40 && e.getY() < dialogueBox.getY() + 60){
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isOnOption1(MouseEvent e){
        if (e.getX() > dialogueBox.getX() + 150 && e.getX() < dialogueBox.getX() + 1030 && e.getY() > dialogueBox.getY() + 70 && e.getY() < dialogueBox.getY() + 90){
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isOnOption2(MouseEvent e){
        if (e.getX() > dialogueBox.getX() + 150 && e.getX() < dialogueBox.getX() + 1030 && e.getY() > dialogueBox.getY() + 100 && e.getY() < dialogueBox.getY() + 120){
            return true;
        }
        else {
            return false;
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        phoneTime++;

        if (phoneTime < 1.5*secsToTicks && phoneCall) {
            phone.setPos(phone.getX(), phone.getY() - 2);

            if (phone.getY() < phone.getStartY() - 5) {
                phone.setPos(phone.getStartX(), phone.getStartY());
            }
        }

        if (phoneTime / (2 *secsToTicks) == 1 && phoneCall){
            phoneTime = 0;
        }

        if (phoneTime > rand.nextInt(8*secsToTicks) + 14*secsToTicks){
            phoneCall = true;
            phoneTime = 0;
        }

        repaint();
    }
}
