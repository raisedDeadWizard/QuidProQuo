package quidProQuo;

import java.awt.image.BufferedImage;

public class Bar {

    private BufferedImage sprite;
    private int curVal;

    public Bar(BufferedImage sprite) {
        curVal = 0;
        this.sprite = sprite;
    }

    public int getVal() {
        return curVal;
    }

    public void updateVal(int val) {
        curVal = val;
    }
}
