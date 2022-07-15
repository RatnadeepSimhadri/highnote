package com.highnote.parsers;

import com.highnote.models.ISOMessageDataElement;
import com.highnote.models.TransactionAmount;

public class TransactionAmountParser implements IParser {

    @Override
    public ISOMessageDataElement parse(String message, int startIndex) {
        String amount = message.substring(startIndex,(startIndex + TransactionAmount.DATALENGTH));
        return new TransactionAmount(amount);
    }
    
}
