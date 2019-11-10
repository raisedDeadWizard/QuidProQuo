package quidProQuo;

import java.awt.image.BufferedImage;

public class Aid {
    private BufferedImage sprite;
    private int x, y;
    private boolean isFront;

    public Aid(BufferedImage sprite, int x, int y){
        this.sprite = sprite;
        this.x = x;
        this.y = y;
        isFront = false;
    }

    public BufferedImage getSprite(){
        return sprite;
    }

    public int getX(){return x;}

    public int getY(){return y;}

    public void moveX(int i){
        x += i;
    }
    public void moveY(int i){
        y += i;
    }

    public boolean isFront(){
        return isFront;
    }


}
