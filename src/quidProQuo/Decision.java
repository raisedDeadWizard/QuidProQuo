package quidProQuo;

public class Decision {
    private String query;
    private boolean isMajor;
    private Response[] responses = new Response[3];
    private int key;

    public Decision(String query, Response one, Response two, Response three, boolean isMajor){
        this.query = query;
        this.isMajor = isMajor;
        responses[0] = one;
        responses[1] = two;
        responses[2] = three;
        key = 0;
    }

    public String toString(){
        return query;
    }

    public char[] toCharArray(){
        return query.toCharArray();
    }

    public Response getResOne(){
        return responses[0];
    }

    public Response getResTwo(){
        return responses[1];
    }

    public Response getResThree(){
        return responses[2];
    }

    public boolean isMajor(){
        return isMajor;
    }

    public int getKey(){
        return key;
    }




}
