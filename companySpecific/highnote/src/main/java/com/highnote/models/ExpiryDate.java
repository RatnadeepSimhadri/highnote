package com.highnote.models;

import java.time.*;

public class ExpiryDate implements ISOMessageDataElement {
    public static Integer DATALENGTH = 4;
    private LocalDateTime expiryDate;

    public ExpiryDate(String MMYY){
        this.expiryDate = LocalDateTime.now();
    }
    /**
     * @param expiryDate the expiryDate to set
     */
    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }
    /**
     * @return the expiryDate
     */
    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    @Override
    public int getNextOffset() {
       
        return DATALENGTH;
    }

    public String toString(){
        return this.expiryDate.toString();
    }
    
}
