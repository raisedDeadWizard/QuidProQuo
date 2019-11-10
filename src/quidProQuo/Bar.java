package quidProQuo;

import mediaResources.Resources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Bar {

    private BufferedImage sprite;
    private int curVal, x, y;

    public Bar(int curVal,int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.curVal = curVal;
        sprite = loadImage("Bar.png");
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

    public BufferedImage getSprite(){
        return sprite;
    }

    public int getVal() {
        return curVal;
    }

    public char[] getValChar(){
        String s = curVal + "%";
        return s.toCharArray();
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getLength() {return (int)Math.floor(curVal * 3.62);}

    public void updateVal(int val) {
        curVal = val;

        if (curVal > 100){
            curVal = 100;
        }
        else if (curVal < 0){
            curVal = 0;
        }
    }
}
