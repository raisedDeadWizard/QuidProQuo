package quidProQuo.phone;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Random;

public class PhoneDialogue {
    private BufferedImage[] sprites;
    private Random rand;
    private int[] pos;
    private final int startX = 200;
    private final int startY = 80;

    public PhoneDialogue()

    {
        sprites = new BufferedImage[4];
        pos = new int[2];
        pos[0] = startX;
        pos[1] = startY;

        try{
            URL spritePath = PhoneDialogue.class.getResource("DialogueBox.png");
            sprites[0] = ImageIO.read(spritePath);
        }
        catch (Exception e){
            System.out.println("Phone Image not Loaded");
        }

        try{
            URL selectedPath = PhoneDialogue.class.getResource("DialogueBoxSelected0.png");
            sprites[1] = ImageIO.read(selectedPath);
        }
        catch (Exception e){
            System.out.println("Phone (Selected) Image not Loaded");
        }

        try{
            URL selectedPath = PhoneDialogue.class.getResource("DialogueBoxSelected1.png");
            sprites[2] = ImageIO.read(selectedPath);
        }
        catch (Exception e){
            System.out.println("Phone (Selected) Image not Loaded");
        }

        try{
            URL selectedPath = PhoneDialogue.class.getResource("DialogueBoxSelected2.png");
            sprites[3] = ImageIO.read(selectedPath);
        }
        catch (Exception e){
            System.out.println("Phone (Selected) Image not Loaded");
        }

        rand = new Random();

    }





    public int getX(){
        return pos[0];
    }

    public int getY(){
        return pos[1];
    }



    public BufferedImage getSprite(int index){
        if(index < 0 || index > 3){
            return sprites[0];
        }
        else {
            return sprites[index];
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
