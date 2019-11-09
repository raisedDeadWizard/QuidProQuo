package quidProQuo;

public class Response {
    private String res;
    private int dem, rep, nat;

    public Response(String res, int dem, int rep, int nat){
        this.res = res;
        this.dem = dem;
        this.rep = rep;
        this.nat = nat;
    }

    public String toString(){
        return res;
    }

    public char[] toCharArray(){
        return res.toCharArray();
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
