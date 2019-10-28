package quidProQuo.proparty;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class ProPartyBar {
    private int proPartyPercent;
    private BufferedImage sprite;
    private URL path;
    private int pos[];

    public ProPartyBar(){
        pos = new int[2];
        pos[0] = 20;
        pos[1] = 170;
        this.proPartyPercent = 80;
        try{
            path = ProPartyBar.class.getResource("ProPartyReputation.png");
            sprite = ImageIO.read(path);
        }
        catch (Exception e){
            System.out.println("Impeachment Bar Image not Loaded");
        }
    }

    public void update (int val){

        proPartyPercent += val;

        if (proPartyPercent > 100){
            proPartyPercent = 100;
        }
        else if (proPartyPercent < 0){
            proPartyPercent = 0;
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
        String p = proPartyPercent + "%";
        return p.toCharArray();
    }

    public int getProPartyPercent(){
        return proPartyPercent;
    }
}
