package quidProQuo;

public class Decision {
    private String query;
    private boolean isMajor;
    private Response[] responses = new Response[3];

    public Decision(String query, Response one, Response two, Response three, boolean isMajor){
        this.query = query;
        this.isMajor = isMajor;
        responses[0] = one;
        responses[1] = two;
        responses[2] = three;
    }

    public String toString(){
        return query;
    }

    public char[] toCharArray(){
        return query.toCharArray();
    }

    public Response getDemRes(){
        return responses[0];
    }

    public Response getModRes(){
        return responses[1];
    }

    public Response getRepRes(){
        return responses[2];
    }




}
