package quidProQuo;

public class Response {
    private String res, impact;
    private int dem, rep, nat;

    public Response(String res, int dem, int rep, int nat, String impact){
        this.res = res;
        this.dem = dem;
        this.rep = rep;
        this.nat = nat;
        this.impact = impact;
    }

    public String toString(){
        return res;
    }

    public char[] toCharArray(){
        return res.toCharArray();
    }

    public String getImpact(){
        return impact;
    }

    public int getDem(){
        return dem;
    }

    public int getRep(){
        return rep;
    }

    public int getNat(){
        return nat;
    }

}
