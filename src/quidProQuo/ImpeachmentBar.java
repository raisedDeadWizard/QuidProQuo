package quidProQuo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class ImpeachmentBar {
    private int impeachPercent;
    private BufferedImage sprite;
    private double percent;
    private URL path;
    private int pos[];

    public ImpeachmentBar(){
        pos = new int[2];
        pos[0] = 20;
        pos[1] = 20;
        this.impeachPercent = 0;
        try{
            path = ImpeachmentBar.class.getResource("Impeachment Bar Sprite.png");
            sprite = ImageIO.read(path);
        }
        catch (Exception e){
            System.out.println("Impeachment Bar Image not Loaded");
        }
    }

    public void update (int val){

        impeachPercent += val;

        if (impeachPercent > 123){
            impeachPercent = 123;
        }
        else if (impeachPercent < 0){
            impeachPercent = 0;
        }

        percent = (impeachPercent * 100) / 123.0;
        percent = Math.round(percent);
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

    public char[] getPercent(){
        String p = Double.toString(percent);
        return p.toCharArray();
    }

    public int getImpeachPercent(){
        return impeachPercent;
    }
}
