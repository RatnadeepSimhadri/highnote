package com.highnote;

import org.junit.jupiter.api.Test;

import com.highnote.models.TransactionDetails;
import com.highnote.models.ZipCode;
import com.highnote.models.CardHolderName;
import com.highnote.models.CardNumber;
import com.highnote.models.ExpiryDate;
import com.highnote.models.TransactionAmount;


import static org.junit.jupiter.api.Assertions.*;


public class ModelTest {
    @Test
    public void generateResponseBitmapShouldReturnResponse() {
        TransactionDetails td = new TransactionDetails("");
        td.populateData(new CardNumber("4111111111111111"));
        td.populateData(new ExpiryDate("12", "25"));
        td.populateData(new TransactionAmount("11000"));
        td.validateTransaction();
        char[] actual = td.generateResponseBitmap();
        char[] expected = {'1','1','1','1','0','0','0','0'};
        assertArrayEquals(expected, actual , "generateResponseBitmap returns appropriate reponse");
    }

    @Test
    public void generateResponseBitmapShouldReturnResponseWithZip() {
        TransactionDetails td = new TransactionDetails("");
        td.populateData(new CardNumber("4111111111111111"));
        td.populateData(new ExpiryDate("12", "25"));
        td.populateData(new TransactionAmount("11000"));
        CardHolderName name = new CardHolderName("");
        name.setCardHolderName("MASTER YODA");
        td.populateData(name);
        td.populateData(new ZipCode("90089"));
        td.validateTransaction();
        char[] actual = td.generateResponseBitmap();
        char[] expected = {'1','1','1','1','1','1','0','0'};
        assertArrayEquals(expected, actual , "generateResponseBitmap returns appropriate reponse");
    }


    @Test
    public void validateOriginalMessageGetterAndSetter(){
        TransactionDetails td = new TransactionDetails("");
        td.setOriginalMessage("0100e016411111111111111112250000001000");
        assertEquals("0100e016411111111111111112250000001000", td.getOriginalMessage());
    }

    @Test
    public void validateExpiryDateGetterAndSetter(){
        ExpiryDate date = new ExpiryDate("12","22");
        date.setExpiryMonth(01);
        date.setExpiryYear(23);
        assertEquals(01, date.getExpiryMonth());
        assertEquals(23, date.getExpiryYear());

    }

    
}
