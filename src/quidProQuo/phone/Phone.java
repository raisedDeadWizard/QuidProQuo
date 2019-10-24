package quidProQuo.phone;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Random;

public class Phone {
    private BufferedImage sprite, selectedSprite;
    private Random rand;
    private int[] pos;
    private final int startX = 428;
    private final int startY = 445;
    private PhoneTopics topics;
    private PhoneResponse currentResponse;

    public Phone(PhoneTopics topics)

    {
        pos = new int[2];
        pos[0] = startX;
        pos[1] = startY;

        try{
            URL spritePath = Phone.class.getResource("PhoneSpritePixel.png");
            sprite = ImageIO.read(spritePath);
        }
        catch (Exception e){
            System.out.println("Phone Image not Loaded");
        }

        try{
            URL selectedPath = Phone.class.getResource("PhoneSelectedPixel.png");
            selectedSprite = ImageIO.read(selectedPath);
        }
        catch (Exception e){
            System.out.println("Phone (Selected) Image not Loaded");
        }

        this.topics = topics;
        rand = new Random();

    }

    public String getLine(){
        return topics.getTopic(0);
        //return topics.getTopic(rand.nextInt(topics.getNumTopics()));
    }

    public PhoneResponse[] getResponses(String key){
        PhoneResponse[] r = topics.getResponses(key);
        currentResponse = r[0];
        return r;
    }

    public String getCaller(){
        if (currentResponse == null){
            return "There is no one calling";
        }
        else {
            return currentResponse.getCaller();
        }
    }

    public BufferedImage getCallerAvatar(){
        if (currentResponse == null){
            return null;
        }
        else {
            return currentResponse.getAvatar();
        }
    }


    public int getX(){
        return pos[0];
    }

    public int getY(){
        return pos[1];
    }

    public BufferedImage getSprite(){
        return sprite;
    }
    public BufferedImage getSelectedSprite(){
        return selectedSprite;
    }

    public BufferedImage getState(boolean isSelected){
        if (isSelected){
            return selectedSprite;
        }
        else {
            return sprite;
        }
    }

    public void setPos(int x, int y) {
        pos[0] = x;
        pos[1] = y;
    }

    public int getStartX(){
        return startX;
    }

    public int getStartY(){
        return startY;
    }
}
