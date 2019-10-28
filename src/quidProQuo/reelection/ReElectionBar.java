package quidProQuo.reelection;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class ReElectionBar {
    private int reElectPercent;
    private BufferedImage sprite;
    private URL path;
    private int pos[];

    public ReElectionBar(){
        pos = new int[2];
        pos[0] = 20;
        pos[1] = 70;
        this.reElectPercent = 50;
        try{
            path = ReElectionBar.class.getResource("reElectionBar.png");
            sprite = ImageIO.read(path);
        }
        catch (Exception e){
            System.out.println("Re-election Bar Image not Loaded");
        }
    }

    public void update (int val){

        reElectPercent += val;

        if (reElectPercent > 100){
            reElectPercent = 100;
        }
        else if (reElectPercent < 0){
            reElectPercent = 0;
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
        String p = reElectPercent + "%";
        return p.toCharArray();
    }

    public int getReElectPercent(){
        return reElectPercent;
    }
}
