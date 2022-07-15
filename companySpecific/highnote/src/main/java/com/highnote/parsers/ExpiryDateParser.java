package com.highnote.parsers;

import com.highnote.models.ExpiryDate;
import com.highnote.models.ISOMessageDataElement;

public class ExpiryDateParser implements IParser {

    @Override
    public ISOMessageDataElement parse(String message, int startIndex) { 
        String MMYY = message.substring(startIndex,(startIndex+ExpiryDate.DATALENGTH));
        return new ExpiryDate(MMYY.substring(0,2),MMYY.substring(2,4));
    }
    
}
