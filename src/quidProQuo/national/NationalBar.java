package quidProQuo.national;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class NationalBar {
    private int natPercent;
    private BufferedImage sprite;
    private URL path;
    private int pos[];

    public NationalBar(){
        pos = new int[2];
        pos[0] = 20;
        pos[1] = 120;
        this.natPercent = 51;
        try{
            path = NationalBar.class.getResource("nationalPopularity.png");
            sprite = ImageIO.read(path);
        }
        catch (Exception e){
            System.out.println("National Bar Image not Loaded");
        }
    }

    public void update (int val){

        natPercent += val;

        if (natPercent > 100){
            natPercent = 100;
        }
        else if (natPercent < 0){
            natPercent = 0;
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

    public char[] getPercent(){
        String p = natPercent + "%";
        return p.toCharArray();
    }

    public int getNatPercent(){
        return natPercent;
    }
}
