package com.highnote.models;
import org.apache.commons.lang3.StringUtils;
public class TransactionAmount implements ISOMessageDataElement {
    public static Integer DATALENGTH = 10;
    
    private Long amount;

    public TransactionAmount(String amount){
        this.amount = Long.valueOf(amount);
    }
    /**
     * @return the amount
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }
    @Override
    public int getNextOffset() {
       
        return DATALENGTH;
    }

    public String toString(){
            int amountInCents = (int)Math.round(amount);
            String amountCentsString = String.valueOf(amountInCents);
            return StringUtils.leftPad(amountCentsString, DATALENGTH, "0");
    }
    
}
