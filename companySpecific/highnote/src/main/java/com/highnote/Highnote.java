package com.highnote;

import com.highnote.service.ParserService;
import com.highnote.service.UtilService;
/**
 * Hello world!
 */
public class Highnote {
    public String[] processTransactions(String[] transactions) {
        return transactions;
    }

    /**
     * 
     * @param ISOMessage
     * @return
     */
    

    public static void main(String[] args) {
        String ISOString = "0100e016411111111111111112250000001000";
        int[] bitmap = UtilService.generateBitmap(ISOString);
        System.out.println(ParserService.parseISOMessage(ISOString,bitmap));
    }
}
