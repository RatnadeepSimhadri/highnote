package com.highnote.models;

public class ZipCode implements ISOMessageDataElement {
    public static Integer DATA_ELEMENT_LENGTH = 5;
    private Integer zipCode;

    public ZipCode(String zipCode){
            this.zipCode = Integer.valueOf(zipCode);
    }
    /**
     * @return the zipCode
     */
    public Integer getZipCode() {
        return zipCode;
    }
    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }
    @Override
    public int getNextOffset() {
       
        return DATA_ELEMENT_LENGTH;
    }

    public String toString(){
        return zipCode.toString();
    }
    
}
