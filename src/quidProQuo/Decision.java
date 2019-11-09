package quidProQuo;

public class Decision {
    private String query;
    private Response[] responses = new Response[3];

    public Decision(String query, Response one, Response two, Response three){
        this.query = query;
        responses[0] = one;
        responses[1] = two;
        responses[2] = three;
    }
}
