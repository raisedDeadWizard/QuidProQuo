package quidProQuo;

public class ImpeachmentBar {
    private int impeachPercent;

    public ImpeachmentBar(){
        this.impeachPercent = 0;
    }

    public void update (int val){
        impeachPercent += val;

        if (impeachPercent > 100){
            impeachPercent = 100;
        }
        else if (impeachPercent < 0){
            impeachPercent = 0;
        }
    }

    public int getImpeachPercent(){
        return impeachPercent;
    }
}
