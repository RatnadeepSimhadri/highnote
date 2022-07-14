package com.highnote.models;


public class TransactionDetails {
    private ISOMessageDataElement cardNumber;
    private ISOMessageDataElement expirationDate;
    private ISOMessageDataElement amount;
    private ISOMessageDataElement responseCode;
    private ISOMessageDataElement cardHolderName;
    private ISOMessageDataElement zipCode;

    /**
     * @return the amount
     */
    public ISOMessageDataElement getAmount() {
        return amount;
    }
    /**
     * @param amount the amount to set
     */
    private void setAmount(ISOMessageDataElement amount) {
        this.amount = amount;
    }
    /**
     * @return the cardHolderName
     */
    public ISOMessageDataElement getCardHolderName() {
        return cardHolderName;
    }
    /**
     * @param cardHolderName the cardHolderName to set
     */
    private void setCardHolderName(ISOMessageDataElement cardHolderName) {
        this.cardHolderName = cardHolderName;
    }
    /**
     * @return the cardNumber
     */
    public ISOMessageDataElement getCardNumber() {
        return cardNumber;
    }
    /**
     * @param cardNumber the cardNumber to set
     */
    private void setCardNumber(ISOMessageDataElement cardNumber) {
        this.cardNumber = cardNumber;
    }
    /**
     * @return the expirationDate
     */
    public ISOMessageDataElement getExpirationDate() {
        return expirationDate;
    }
    /**
     * @param expirationDate the expirationDate to set
     */
    private void setExpirationDate(ISOMessageDataElement expirationDate) {
        this.expirationDate = expirationDate;
    }
    /**
     * @return the zipCode
     */
    public ISOMessageDataElement getZipCode() {
        return zipCode;
    }
    /**
     * @param zipCode the zipCode to set
     */
    private void setZipCode(ISOMessageDataElement zipCode) {
        this.zipCode = zipCode;
    }

    public void populateData(ISOMessageDataElement element){
        if(element instanceof CardNumber){
            setCardNumber(element);
        } else if ( element instanceof ExpiryDate){
            setExpirationDate(element);
        } else if (element instanceof TransactionAmount){
            setAmount(element);
        }
    }

    /**
     * @param responseCode the responseCode to set
     */
    public void setResponseCode(ISOMessageDataElement responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * @return the responseCode
     */
    public ISOMessageDataElement getResponseCode() {
        return responseCode;
    }

    public String toString(){
        return cardNumber.toString() + " " + expirationDate.toString();
    }
}
