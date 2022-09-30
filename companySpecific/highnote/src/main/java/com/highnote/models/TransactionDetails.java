package com.highnote.models;

import java.time.LocalDate;
import java.util.*;

public class TransactionDetails {
    private String originalMessage;
    private ISOMessageDataElement cardNumber;
    private ISOMessageDataElement expirationDate;
    private ISOMessageDataElement amount;
    private ISOMessageDataElement responseCode;
    private ISOMessageDataElement cardHolderName;
    private ISOMessageDataElement zipCode;


    public TransactionDetails(String ISOMessage){
        this.originalMessage = ISOMessage;
    }
    /**
     * @param originalMessage the originalMessage to set
     */
    public void setOriginalMessage(String originalMessage) {
        this.originalMessage = originalMessage;
    }

    /**
     * @return the originalMessage
     */
    public String getOriginalMessage() {
        return originalMessage;
    }
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
        } else if (element instanceof CardHolderName){
            setCardHolderName(element);
        } else if (element instanceof ZipCode){
            setZipCode(element);
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
        StringBuilder sb = new StringBuilder();
        if(cardNumber != null){
            sb.append(cardNumber.toString() + " ");
        }
        if(expirationDate != null){
            sb.append(expirationDate.toString() + " ");
        }
        if(amount != null){
            sb.append(amount.toString() + " ");
        }
        if(responseCode != null){
            sb.append(responseCode.toString() + " ");
        }
        if(cardHolderName != null){
            sb.append(cardHolderName.toString() + " ");
        }
        if(zipCode != null){
            sb.append(zipCode.toString() + " ");
        }

        return sb.toString();
    }

    public char[] generateResponseBitmap(){
        char[] bitmap = new char[8];
        Arrays.fill(bitmap,'0');
        if(cardNumber != null){
            bitmap[0] = '1';
        }
        if(expirationDate != null){
            bitmap[1] = '1';
        }
        if(amount != null){
            bitmap[2] = '1';
        }
        if(responseCode != null){
            bitmap[3] = '1';
        }
        if(cardHolderName != null){
            bitmap[4] = '1';
        }
        if(zipCode != null){
            bitmap[5] = '1';
        }

        return bitmap;
    }

    /**
     * Validates the Transaction based on the Transaction Details captured
     */
    public void validateTransaction(){
        ResponseCode tResponse = null;
        ZipCode tZipCode = (ZipCode) this.zipCode;
        TransactionAmount tAmount = (TransactionAmount) this.amount;
        ExpiryDate tDate = (ExpiryDate) this.expirationDate;
        LocalDate today = LocalDate.now();
        CardNumber card = (CardNumber) this.cardNumber;
        if(this.cardNumber == null || this.expirationDate == null || this.amount == null){
            tResponse = new ResponseCode("ER");
            this.setResponseCode(tResponse);
            return;
        } 

        tResponse = new ResponseCode("OK");
        if(tZipCode == null){
            if(tAmount.getAmount() >= 10000){
                tResponse.setResponseCode("DE");
                this.setResponseCode(tResponse);
                return;
            } 
        } else {
            if(tAmount.getAmount() >= 20000){
                tResponse.setResponseCode("DE");
                this.setResponseCode(tResponse);
                return;
            }
        }

        int currentMonth = today.getMonthValue();
        int currentYear = today.getYear();

        if(tDate.getExpiryYear() < currentYear){
            tResponse.setResponseCode("DE");
            this.setResponseCode(tResponse);
            return;
        } else if (tDate.getExpiryYear() == currentYear && tDate.getExpiryMonth() < currentMonth){
            tResponse.setResponseCode("DE");
            this.setResponseCode(tResponse);
            return;
        }

        Accounts accounts = Accounts.getAccountsInstance();
        Long outstandingBalance = accounts.getBalance(card.getCardNumber());
        if(tAmount.getAmount() <= outstandingBalance){
            tResponse.setResponseCode("OK");
            this.setResponseCode(tResponse);
            outstandingBalance = outstandingBalance - tAmount.getAmount();
            accounts.updateBalance(card.getCardNumber(), outstandingBalance);
            return;
        } else {
            tResponse.setResponseCode("DE");
            this.setResponseCode(tResponse);
            return;
        }

    }
    
}
