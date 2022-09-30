package com.highnote;

import org.junit.jupiter.api.Test;

import com.highnote.models.ISOMessageDataElement;
import com.highnote.parsers.CardNameParser;
import com.highnote.parsers.CardNumberParser;
import com.highnote.parsers.ExpiryDateParser;
import com.highnote.parsers.IParser;
import com.highnote.parsers.TransactionAmountParser;
import com.highnote.parsers.ZipCodeParser;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {
    @Test
    public void validateCardNumberParser() {
        IParser instance = new CardNumberParser();
        ISOMessageDataElement actual = instance.parse("164111111111111111", 0);
        assertEquals("4111111111111111",actual.toString());
    }

    @Test
    public void validateCardNameParser(){
        IParser instance = new CardNameParser();
        ISOMessageDataElement actual = instance.parse("11MASTER YODA", 0);
        assertEquals("MASTER YODA",actual.toString());

    }

    @Test
    public void validateExpiryDateParser(){
        IParser instance = new ExpiryDateParser();
        ISOMessageDataElement actual = instance.parse("1223", 0);
        assertEquals("1223",actual.toString());
    }

    @Test
    public void validateTransactionAmountParser(){
        IParser instance = new TransactionAmountParser();
        ISOMessageDataElement actual = instance.parse("0000001000", 0);
        assertEquals("0000001000",actual.toString());
    }

    @Test
    public void validateZipcode(){
        IParser instance = new ZipCodeParser();
        ISOMessageDataElement actual = instance.parse("94086", 0);
        assertEquals("94086",actual.toString());
    }

    
}
