package com.highnote.models;

public class TransactionAmount implements ISOMessageDataElement {
    public static Integer DATALENGTH = 10;
    @Override
    public int getNextOffset() {
       
        return 0;
    }
    
}
