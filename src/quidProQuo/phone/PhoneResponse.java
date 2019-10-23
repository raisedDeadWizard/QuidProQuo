package quidProQuo.phone;

import quidProQuo.Response;

public class PhoneResponse implements Response {

    private String response;
    private int imVal, popVal, proVal, conVal;

    public PhoneResponse(String response, int imVal, int popVal, int proVal, int conVal) {
        this.response = response;
        this.imVal = imVal;
        this.popVal = popVal;
        this.proVal = proVal;
        this.conVal = conVal;
    }


    @Override
    public char[] getResponseToPrint() {
        return response.toCharArray();
    }

    @Override
    public int getImVal() {
        return imVal;
    }

    @Override
    public int getPopVal() {
        return popVal;
    }

    @Override
    public int getProVal() {
        return proVal;
    }

    @Override
    public int getConVal() {
        return conVal;
    }
}
