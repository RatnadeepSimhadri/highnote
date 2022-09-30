package com.highnote;



import java.util.Collections;
import java.util.*;
import com.highnote.models.TransactionDetails;
import com.highnote.service.ParserService;
import com.highnote.service.UtilService;
import com.highnote.models.Accounts;;
/**
 * Hello world!
 */
public class Highnote {

    Accounts cardAccounts = Accounts.getAccountsInstance();

    public Highnote(){
        cardAccounts.setupAccounts(Collections.synchronizedMap(new HashMap<>()), 50000l);
    }

    public Highnote(Map<String,Long> accountsBalance, Long defaultBalance){
        cardAccounts.setupAccounts(Collections.synchronizedMap(accountsBalance),defaultBalance);
    }

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

    
    

}
