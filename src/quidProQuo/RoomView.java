package quidProQuo;

//import com.sun.tools.internal.jxc.ap.Const;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RoomView extends JPanel implements ActionListener{

    // Timer to manage game runtime, and animation frequency
    private Timer timer;
    private int ticks = 0, blinkTick = 120, aidTicks = 0, aidCount = 0;


    // Random variable member
    private Decision currentDesc;
    private Random rand;
    private int i = 0;
    private Topics topics;
    private Font font;
    private boolean blink = false;
    private boolean aidLeaving = false;
    private boolean aidMoving = false;
    private boolean dialogue = false;
    private boolean isOnResOne = false, isOnResTwo = false, isOnResThree = false;
    private boolean aidOne = false, aidTwo = false, aidThree = false;
    private BufferedImage background, desk, coke;
    private BufferedImage[] donald = new BufferedImage[2];
    private BufferedImage[] dialogueBox = new BufferedImage[4];
    private ArrayList<Aid> aids = new ArrayList<Aid>();
    private Bar demBar, repBar, natBar;
    private Aid currentAidOne;
    private ArrayList<Decision> year;
    private ArrayList<Decision> year1;
    private ArrayList<Decision> year2;
    private ArrayList<Decision> year3;
    private ArrayList<Decision> yearAll;
    private int yearValue;





    private Clip cokeClip, soundTrack;
    // Width of the window
    private static final int WIDTH = 1480;
    //Height of window
    private static final int HEIGHT = 825;



    public RoomView(int yearValue, int dem, int rep, int nat) {
        this.yearValue = yearValue;
        // Sets the background color of the window
        setBackground(Color.WHITE);

        // Sets the window size
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        background = loadImage("OvalOffice.png");
        desk = loadImage("Desk.png");
        coke = loadImage("DietCoke.png");
        cokeClip = loadSound("DietCoke.wav");
        FloatControl cokeVolume = (FloatControl) cokeClip.getControl(FloatControl.Type.MASTER_GAIN);
        cokeVolume.setValue(-15);
        soundTrack = loadSound("newGame.wav");
        FloatControl volume = (FloatControl) soundTrack.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(-20);
        soundTrack.loop(Clip.LOOP_CONTINUOUSLY);
        demBar = new Bar(dem,Constants.demBarX, Constants.demBarY);
        repBar = new Bar(rep,Constants.repBarX, Constants.repBarY);
        natBar = new Bar(nat,Constants.natBarX, Constants.natBarY);


        donald[0] = loadImage("Donald.png");
        donald[1] = loadImage("DonaldBlinking.png");

        aids.add(new Aid(loadImage("Aid1.png"), 0, 850));
        aids.add(new Aid(loadImage("Aid2.png"), 0, 850));
        aids.add(new Aid(loadImage("Aid3.png"), 0, 850));
        aids.add(new Aid(loadImage("Aid4.png"), 0, 850));
        aids.add(new Aid(loadImage("Aid5.png"), 0, 850));
        aids.add(new Aid(loadImage("Aid6.png"), 0, 850));

        Collections.shuffle(aids);

        currentAidOne = aids.get(0);

        dialogueBox[0] = loadImage("speechBubble.png");
        dialogueBox[1] = loadImage("speechBubble1.png");
        dialogueBox[2] = loadImage("speechBubble2.png");
        dialogueBox[3] = loadImage("speechBubble3.png");



        // Initalize timer, with ticks interating ever *25* miliseconds
        timer = new Timer(25, this);
        timer.start();

        //Initialize random variable
        rand = new Random();

        //each .getYearX randomly picks 3 major topics and 7 minor topics for each year
        topics = new Topics();
        year1 = topics.getYear1();
        year2 = topics.getYear2();
        year3 = topics.getYear3();
        yearAll = topics.getAllResponses();

        //combines all of the randomly assigned decisions into one arraylist, sorted by year
        if (yearValue == 1){
            year = new ArrayList<Decision>(year1);
        }
        else if (yearValue == 2){
            year = new ArrayList<Decision>(year2);
        }
        else {
            year = new ArrayList<Decision>(year3);
        }



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
        if (isOnResOne(e)){
            isOnResOne = true;
        }
        else {
            isOnResOne = false;
        }

        if (isOnResTwo(e)){
            isOnResTwo = true;
        }
        else {
            isOnResTwo = false;
        }

        if (isOnResThree(e)){
            isOnResThree = true;
        }
        else {
            isOnResThree = false;
        }

        repaint();
    }


    protected void handleMousePressed(MouseEvent e) {
        if (isOnCan(e)) {

            cokeClip.setFramePosition(0);
            cokeClip.start();
        }
        if (dialogue) {
            if (isOnResOne(e)) {
                dialogue = false;
                aidLeaving = true;
                Response a = currentDesc.getResOne();
                demBar.updateVal(demBar.getVal() + a.getDem());
                repBar.updateVal(repBar.getVal() + a.getRep());
                natBar.updateVal(natBar.getVal() + a.getNat());

            } else if (isOnResTwo(e)) {
                Response a = currentDesc.getResTwo();
                dialogue = false;
                aidLeaving = true;
                demBar.updateVal(demBar.getVal() + a.getDem());
                repBar.updateVal(repBar.getVal() + a.getRep());
                natBar.updateVal(natBar.getVal() + a.getNat());

            } else if (isOnResThree(e)) {
                Response a = currentDesc.getResThree();
                dialogue = false;
                aidLeaving = true;
                demBar.updateVal(demBar.getVal() + a.getDem());
                repBar.updateVal(repBar.getVal() + a.getRep());
                natBar.updateVal(natBar.getVal() + a.getNat());

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

    /** Paint Component **/
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        // Background image
        g.drawImage(background, 0, 0,null);

        // demBar sprite
        g.drawImage(demBar.getSprite(), demBar.getX(), demBar.getY(), null);
        g.setColor(Color.BLUE);
        g.fillRect(demBar.getX()+24, demBar.getY()+12, demBar.getLength(), 62);
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 36));
        g.drawChars(demBar.getValChar(), 0, demBar.getValChar().length, demBar.getX()+176, demBar.getY()+55);
        String d = "Reputation with Democrats";
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
        g.drawChars(d.toCharArray(), 0, d.length(), demBar.getX()+35, demBar.getY()+110);

        // repBar sprite
        g.drawImage(repBar.getSprite(), repBar.getX(), repBar.getY(), null);
        g.setColor(Color.RED);
        g.fillRect(repBar.getX()+24, repBar.getY()+12, repBar.getLength(), 62);
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 36));
        g.drawChars(repBar.getValChar(), 0, repBar.getValChar().length, repBar.getX()+176, repBar.getY()+55);
        String s = "Reputation with Republicans";
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
        g.drawChars(s.toCharArray(), 0, s.length(), repBar.getX()+25, repBar.getY()+110);

        // natBar sprite
        g.drawImage(natBar.getSprite(), natBar.getX(), natBar.getY(), null);
        g.setColor(Color.GREEN);
        g.fillRect(natBar.getX()+24, natBar.getY()+12, natBar.getLength(), 62);
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 36));
        g.drawChars(natBar.getValChar(), 0, natBar.getValChar().length, natBar.getX()+176, natBar.getY()+55);
        String a = "Approval Rating";
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
        g.drawChars(a.toCharArray(), 0, a.length(), natBar.getX()+105, natBar.getY()+110);


        //Desk sprite
        g.drawImage(desk, Constants.deskX, Constants.deskY, null);


        //Donald trump sprite
        if (blink){
            g.drawImage(donald[1], Constants.donaldX, Constants.donaldY, null);
        }
        else {
            g.drawImage(donald[0], Constants.donaldX, Constants.donaldY, null);
        }

        //create Year X box
        g.setColor(Color.GRAY);
        g.fillRect(1330, 20, 100, 50);
        g.setColor(Color.BLACK);
        g.drawRect(1330, 20, 100, 50);
        g.drawString("Year " + getYear(), 1340, 55);
        if(year.size() == 0) {
            Main.dem = demBar.getVal();
            Main.rep = repBar.getVal();
            Main.nat = natBar.getVal();
            Main.year = yearValue+1;
            Main.frame.setContentPane(new StateOfTheUnionView(yearValue));
            Main.frame.pack();
            Main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Main.frame.setVisible(true);
        }

        //Diet Coke
        g.drawImage(coke, Constants.cokeX, Constants.cokeY, null);

        g.drawImage(currentAidOne.getSprite(), currentAidOne.getX(), currentAidOne.getY(), null);

        if (dialogue && !aidLeaving && !aidMoving) {

            if (isOnResOne) {
                g.drawImage(dialogueBox[1], Constants.dialogueBoxX, Constants.dialogueBoxY, null);


            } else if (isOnResTwo) {
                g.drawImage(dialogueBox[2], Constants.dialogueBoxX, Constants.dialogueBoxY, null);
            } else if (isOnResThree) {
                g.drawImage(dialogueBox[3], Constants.dialogueBoxX, Constants.dialogueBoxY, null);
            } else {
                g.drawImage(dialogueBox[0], Constants.dialogueBoxX, Constants.dialogueBoxY, null);
            }

            g.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
            String line = "";
            int jump = 0;
            for (String word : currentDesc.toString().split(" ")) {
                if (line.length() + word.length() <= 38) {
                    line += word + " ";
                }
                else {

                    g.drawString(line, Constants.dialogueBoxX + 70, Constants.dialogueBoxY + 45 + g.getFontMetrics().getHeight() * jump);
                    jump++;
                    line = word +  " ";
                }
            }
            g.drawString(line, Constants.dialogueBoxX + 70, Constants.dialogueBoxY + 45 + g.getFontMetrics().getHeight() * jump);
            g.setFont(new Font(Font.DIALOG, Font.BOLD, 14));

            line = "";
            jump = 0;
            for (String word : currentDesc.getResOne().toString().split(" ")) {
                if (line.length() + word.length() <= 40) {
                    line += word + " ";
                }
                else {

                    g.drawString(line, Constants.dialogueBoxX + 70, Constants.dialogueBoxY + 250 + g.getFontMetrics().getHeight() * jump);
                    jump++;
                    line = word + " ";
                }
                /*z += c;
                len++;

                if (len > 40) {

                    g.drawString(z + "-" , Constants.dialogueBoxX + 70, Constants.dialogueBoxY + 250 + g.getFontMetrics().getHeight() * jump);
                    jump++;
                    z = "";
                    len = 0;
                }*/
            }
            g.drawString(line, Constants.dialogueBoxX + 70, Constants.dialogueBoxY + 250 + g.getFontMetrics().getHeight() * jump);

            line = "";
            jump = 0;
            for (String word : currentDesc.getResTwo().toString().split(" ")) {
                if (line.length() + word.length() <= 40) {
                    line += word + " ";
                }
                else {

                    g.drawString(line, Constants.dialogueBoxX + 70, Constants.dialogueBoxY + 370 + g.getFontMetrics().getHeight() * jump);
                    jump++;
                    line = word + " ";
                }
                /*z += c;
                len++;

                if (len > 40) {

                    g.drawString(z + "-" , Constants.dialogueBoxX + 70, Constants.dialogueBoxY + 370 + g.getFontMetrics().getHeight() * jump);
                    jump++;
                    z = "";
                    len = 0;
                }*/
            }
            g.drawString(line, Constants.dialogueBoxX + 70, Constants.dialogueBoxY + 370 + g.getFontMetrics().getHeight() * jump);
            line = "";
            jump = 0;
            for (String word : currentDesc.getResThree().toString().split(" ")) {
                if (line.length() + word.length() <= 38) {
                    line += word + " ";
                }
                else {

                    g.drawString(line, Constants.dialogueBoxX + 70, Constants.dialogueBoxY + 490 + g.getFontMetrics().getHeight() * jump);
                    jump++;
                    line = word + " ";
                }
                /*z += c;
                len++;

                if (len > 40) {

                    g.drawString(z + "-" , Constants.dialogueBoxX + 70, Constants.dialogueBoxY + 490 + g.getFontMetrics().getHeight() * jump);
                    jump++;
                    z = "";
                    len = 0;
                }*/
            }
            g.drawString(line, Constants.dialogueBoxX + 70, Constants.dialogueBoxY + 490 + g.getFontMetrics().getHeight() * jump);
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

    public boolean isOnCan(MouseEvent e){
        if (e.getX() > Constants.cokeX && e.getX() < Constants.cokeX + 80 && e.getY() > Constants.cokeY && e.getY() < Constants.cokeY + 100){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isOnResOne(MouseEvent e){
        if (e.getX() > Constants.dialogueBoxX + 55 && e.getX() < Constants.dialogueBoxX + 410 && e.getY() > Constants.dialogueBoxY + 225 && e.getY() < Constants.dialogueBoxY + 312){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isOnResTwo(MouseEvent e){
        if (e.getX() > Constants.dialogueBoxX + 55 && e.getX() < Constants.dialogueBoxX + 410 && e.getY() > Constants.dialogueBoxY + 345 && e.getY() < Constants.dialogueBoxY + 435){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isOnResThree(MouseEvent e){
        if (e.getX() > Constants.dialogueBoxX + 55 && e.getX() < Constants.dialogueBoxX + 410 && e.getY() > Constants.dialogueBoxY + 465 && e.getY() < Constants.dialogueBoxY + 555){
            return true;
        }
        else {
            return false;
        }
    }

    public int getYear() {
        return yearValue;
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


        if (!dialogue && !aidLeaving && !aidMoving && year.size() != 0){
            currentAidOne = new Aid(aids.get(rand.nextInt(6)).getSprite(), 0, 825);
            // comment out following line to test all responses
            currentDesc = year.remove(0);
            // uncomment following line to test all responses
            //currentDesc = yearAll.remove(0);
            aidMoving = true;
        }

        if (aidMoving && currentAidOne.getX() < 400){
            currentAidOne.moveX(5);
            currentAidOne.moveY(-7);
        }
        else if (aidMoving && currentAidOne.getX() > 390){
            aidMoving = false;
            dialogue = true;
        }

        if (aidLeaving && currentAidOne.getY() < 840){
            currentAidOne.moveY(5);
        }
        else if (aidLeaving && currentAidOne.getY() > 825){
            aidLeaving = false;
        }
        repaint();
    }
}
