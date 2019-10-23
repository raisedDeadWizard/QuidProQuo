package quidProQuo.phone;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Random;

public class Phone {
    private BufferedImage sprite, selectedSprite;
    private URL spritePath, selectedPath;
    private Random rand;
    private int pos[];
    private final int startX = 428;
    private final int startY = 445;
    private PhoneTopics topics;

    public Phone(PhoneTopics topics)

    {
        pos = new int[2];
        pos[0] = startX;
        pos[1] = startY;

        try{
            spritePath = Phone.class.getResource("PhoneSpritePixel.png");
            sprite = ImageIO.read(spritePath);
        }
        catch (Exception e){
            System.out.println("Phone Image not Loaded");
        }

        try{
            selectedPath = Phone.class.getResource("PhoneSelectedPixel.png");
            selectedSprite = ImageIO.read(selectedPath);
        }
        catch (Exception e){
            System.out.println("Phone (Selected) Image not Loaded");
        }

        this.topics = topics;
        rand = new Random();

    }

    public String getLine(){
        return topics.getTopic(rand.nextInt(topics.getNumTopics()));
    }

    public PhoneResponse[] getResponses(String key){
        return topics.getResponses(key);
    }

    public int getX(){
        return pos[0];
    }

    public int getY(){
        return pos[1];
    }

    public int getX(boolean isSelected){
       if (isSelected){
           return pos[0];
       }
       else {
            return pos[0];
       }

    }

    public int getY(boolean isSelected){
        if (isSelected){
            return pos[1];
        }
        else {
            return pos[1];
        }
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
