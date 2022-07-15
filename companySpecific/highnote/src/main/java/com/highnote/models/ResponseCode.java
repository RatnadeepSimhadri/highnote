package com.highnote.models;

public class ResponseCode implements ISOMessageDataElement {
    public static Integer DATA_LENGTH = 2;
    public String responseCode;
    /**
     * @param responseCode the responseCode to set
     */

     public ResponseCode(String responseCode){
        this.responseCode = responseCode;
     }
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
    /**
     * @return the responseCode
     */
    public String getResponseCode() {
        return responseCode;
    }
    @Override
    public int getNextOffset(){
        return DATA_LENGTH;
    }

    public String toString(){
        return responseCode;
    }
    
}
