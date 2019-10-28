package quidProQuo.conparty;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class ConPartyBar {
    private int conParty;
    private BufferedImage sprite;
    private URL path;
    private int pos[];

    public ConPartyBar(){
        pos = new int[2];
        pos[0] = 20;
        pos[1] = 220;
        this.conParty = 20;
        try{
            path = ConPartyBar.class.getResource("conPartyReputation.png");
            sprite = ImageIO.read(path);
        }
        catch (Exception e){
            System.out.println("Impeachment Bar Image not Loaded");
        }
    }

    public void update (int val){

        conParty += val;

        if (conParty > 100){
            conParty = 100;
        }
        else if (conParty < 0){
            conParty = 0;
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
        String p = conParty + "%";
        return p.toCharArray();
    }

    public int getConParty(){
        return conParty;
    }
}
