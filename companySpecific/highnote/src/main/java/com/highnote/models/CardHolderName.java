package com.highnote.models;

public class CardHolderName implements ISOMessageDataElement{
    private String name;
    public static Integer METADATA_LENGTH = 2;

    /**
     * @return the cardHolderName
     */
    public String getCardHolderName() {
        return name;
    }
    /**
     * @param cardHolderName the cardHolderName to set
     */
    public void setCardHolderName(String cardHolderName) {
        this.name = cardHolderName;
    }

    public CardHolderName(String name){
        this.name = name;
    }
    @Override
    public int getNextOffset() {
        
        return name.length() + METADATA_LENGTH;
    }

    public String toString(){
        return this.name.toString();
    }
    
}
