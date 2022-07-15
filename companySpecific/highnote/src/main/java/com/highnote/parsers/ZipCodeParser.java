package com.highnote.parsers;

import com.highnote.models.ISOMessageDataElement;
import com.highnote.models.ZipCode;

public class ZipCodeParser implements IParser {

    @Override
    public ISOMessageDataElement parse(String message, int startIndex) {
        String zipcode = message.substring(startIndex,(startIndex + ZipCode.DATA_ELEMENT_LENGTH));
        return new ZipCode(zipcode);
    }
    
}
