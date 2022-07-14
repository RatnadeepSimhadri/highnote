package com.highnote.parsers;

import com.highnote.models.CardNumber;
import com.highnote.models.ISOMessageDataElement;

public class CardNumberParser implements IParser{

    @Override
    public ISOMessageDataElement parse(String message, int startIndex) {
        CardNumber card = new CardNumber();
        int length = Integer.valueOf(message.substring(startIndex,(startIndex+ CardNumber.METADATA_LENGTH)));
        int start = (startIndex+ CardNumber.METADATA_LENGTH);
        card.setCardNumber(message.substring(start,start+length));

        return card;
    }
    
}
