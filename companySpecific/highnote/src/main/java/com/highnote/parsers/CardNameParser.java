package com.highnote.parsers;

import com.highnote.models.CardHolderName;
import com.highnote.models.ISOMessageDataElement;

public class CardNameParser implements IParser {

    @Override
    public ISOMessageDataElement parse(String message, int startIndex) {
        int length = Integer.valueOf(message.substring(startIndex,(startIndex + CardHolderName.METADATA_LENGTH)));
        String name = message.substring((startIndex + CardHolderName.METADATA_LENGTH), (startIndex + CardHolderName.METADATA_LENGTH + length));
        return new CardHolderName(name);
    }
    
}
