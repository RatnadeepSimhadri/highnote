package com.highnote.models;

public class CardNumber implements ISOMessageDataElement{

    private String cardNumber;
    public static Integer METADATA_LENGTH = 2;
    public CardNumber(String cardNumber){
        this.cardNumber = cardNumber;
    }

    public CardNumber(){

    }
   
    /**
     * @param cardNumber the cardNumber to set
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * @return the cardNumber
     */
    public String getCardNumber() {
        return cardNumber;
    }
    @Override
    public int getNextOffset() {
        return this.cardNumber.length()+ METADATA_LENGTH;
    }

    @Override
    public String toString(){
        return this.cardNumber;
    }

    
}
