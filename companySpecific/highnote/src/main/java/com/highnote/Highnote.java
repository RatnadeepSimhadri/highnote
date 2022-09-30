package com.highnote;


import com.highnote.models.TransactionDetails;
import com.highnote.service.ParserService;
import com.highnote.service.UtilService;

/**
 * Hello world!
 */
public class Highnote {
    public String[] processTransactions(String[] transactions) {
        String[] responses = new String[transactions.length];
        for(int i = 0 ; i < transactions.length; i++){
            String ISOMessage = transactions[i];
            char[] bitmap = UtilService.generateBitmap(ISOMessage.substring(0,6));
            TransactionDetails transactionDetails = ParserService.parseISOMessage(ISOMessage, bitmap);
            transactionDetails.validateTransaction();
            String ISOMessageResponse = ParserService.generateResponseISOMessage(transactionDetails);
            responses[i] = ISOMessageResponse;

        }
        return responses;
    }

    /**
     * 
     * @param ISOMessage
     * @return
     */
    

    // public static void main(String[] args) {
       
    //     String ISOMessage = "0100ec1651051051051051001225000001100011MASTER YODA90089";
    //     char[] bitmap = UtilService.generateBitmap(ISOMessage.substring(0,6));
    //     TransactionDetails transactionDetails = ParserService.parseISOMessage(ISOMessage, bitmap);
    //     System.out.println(transactionDetails.toString());
       
    // }
}
