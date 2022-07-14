package com.highnote.parsers;

import com.highnote.models.ExpiryDate;
import com.highnote.models.ISOMessageDataElement;

public class ExpiryDateParser implements IParser {

    @Override
    public ISOMessageDataElement parse(String message, int startIndex) { 
        return new ExpiryDate(message.substring(startIndex,(startIndex+ExpiryDate.DATALENGTH)));
    }
    
}
