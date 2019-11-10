package quidProQuo;

public class Highlight {
    private String blurb, key, link;


    public Highlight( String key, String blurb, String link){
        this.blurb = blurb;
        this.key = key;
        this.link = link;
    }

    public String getKey(){
        return key;
    }

    public String getBlurb(){
        return blurb;
    }

    public String getLink(){
        return link;
    }


}
