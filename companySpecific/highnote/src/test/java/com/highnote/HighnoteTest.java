package com.highnote;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
class HighnoteTest {
    Highnote instance = new Highnote();

    @Test
    public void processTransactionsShouldReturnValidResponse() {
        String[] transactions = {
                "0100e016411111111111111112250000001000",
                "0100e016401288888888188112250000011000",
                "0100ec1651051051051051001225000001100011MASTER YODA90089",
                "0100e016411111111111111112180000001000",
                "01006012250000001000"
        };

        String[] expected = {
                "0110f016411111111111111112250000001000OK",
                "0110f016401288888888188112250000011000DE",
                "0110fc16510510510510510012250000011000OK11MASTER YODA90089",
                "0110f016411111111111111112180000001000DE",
                "01107012250000001000ER"
        };
        String[] actual = instance.processTransactions(transactions);
        assertArrayEquals(expected, actual , "processTransactions returns appropriate reponse");
    }
    @Test
    public void demoTest(){
        assertTrue(true, "Demo Test Case");

    }

    @Test
    public void processTransactionsShouldReturnValidResponseWithoutZip() {
        String[] transactions = {
                "0100e016411111111111111112250000001000"
        };

        String[] expected = {
                "0110f016411111111111111112250000001000OK"
        };
        String[] actual = instance.processTransactions(transactions);
        assertArrayEquals(expected, actual , "processTransactions returns appropriate reponse");
    }
    @Test
    public void processTransactionsShouldReturnValidResponseShouldDecline() {
        String[] transactions = {
                "0100e016401288888888188112250000011000"
        };

        String[] expected = {
                "0110f016401288888888188112250000011000DE"
        };
        String[] actual = instance.processTransactions(transactions);
        assertArrayEquals(expected, actual , "processTransactions returns appropriate reponse");
    }
    @Test
    public void processTransactionsShouldReturnValidResponseWithZip() {
        String[] transactions = {
                "0100ec1651051051051051001225000001100011MASTER YODA90089"
        };

        String[] expected = {
                "0110fc16510510510510510012250000011000OK11MASTER YODA90089"
        };
        String[] actual = instance.processTransactions(transactions);
        assertArrayEquals(expected, actual , "processTransactions returns appropriate reponse");
    }
    @Test
    public void processTransactionsShouldDeclineTheTransaction() {
        String[] transactions = {
                "0100e016411111111111111112180000001000"
        };

        String[] expected = {
                "0110f016411111111111111112180000001000DE"
        };
        String[] actual = instance.processTransactions(transactions);
        assertArrayEquals(expected, actual , "processTransactions returns appropriate reponse");
    }

    @Test
    public void processTransactionsShouldReturnErrorResponse() {
        String[] transactions = {
                "01006012250000001000"
        };

        String[] expected = {
                "01107012250000001000ER"
        };
        String[] actual = instance.processTransactions(transactions);
        assertArrayEquals(expected, actual , "processTransactions returns appropriate reponse");
    }

    @Test
    public void processTransactionsHighAmountValue() {
        String[] transactions = {
                "0100ec1651051051051051001225000002100011MASTER YODA90089"
        };

        String[] expected = {
                "0110fc16510510510510510012250000021000DE11MASTER YODA90089"
        };
        String[] actual = instance.processTransactions(transactions);
        assertArrayEquals(expected, actual , "processTransactions returns appropriate reponse");
    }
}
