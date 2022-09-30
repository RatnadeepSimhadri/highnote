package com.highnote;
import org.junit.jupiter.api.*;

import com.highnote.models.TransactionDetails;
import com.highnote.service.ParserService;
import com.highnote.service.UtilService;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {
    
    @Test
    public void validateParserServiceWithoutZip(){
        String ISOMessage = "0100e016411111111111111112250000001000";
        char[] bitmap = {'1','1','1','0','0','0','0','0'};
        TransactionDetails transactionDetailsActual = ParserService.parseISOMessage(ISOMessage, bitmap);
        assertEquals("4111111111111111 1225 0000001000", transactionDetailsActual.toString().trim());
    }

    @Test
    public void validateGenerateBitmap(){
        String ISOMessageMetaData = "0100e0";
        char[] expected = {'1','1','1','0','0','0','0','0'};
        char[] actual = UtilService.generateBitmap(ISOMessageMetaData);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void validateParserServiceWithZip(){
        String ISOMessage = "0100ec1651051051051051001225000000100011MASTER YODA90089";
        char[] bitmap = {'1','1','1','0','1','1','0','0'};
        TransactionDetails transactionDetailsActual = ParserService.parseISOMessage(ISOMessage, bitmap);
        assertEquals("5105105105105100 1225 0000001000 MASTER YODA 90089", transactionDetailsActual.toString().trim());
    }

}
