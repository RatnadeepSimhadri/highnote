package com.highnote.service;

import java.util.*;

import com.highnote.models.ISOMessageDataElement;
import com.highnote.models.TransactionDetails;
import com.highnote.parsers.CardNumberParser;
import com.highnote.parsers.ExpiryDateParser;
import com.highnote.parsers.IParser;

public class ParserService {
    public static String parseISOMessage(String ISOMessage , int[] bitmap){
        String ISOMessageData = ISOMessage.substring(6);
        TransactionDetails td = new TransactionDetails();
        Map<Integer,IParser> parserMap = new HashMap<>();
        parserMap.put(0,new CardNumberParser());
        parserMap.put(1, new ExpiryDateParser());
        int startIndex = 0;
        for(int i = 0 ; i < bitmap.length; i++){
            if(bitmap[i] == 1){
                ISOMessageDataElement element = parserMap.get(i).parse(ISOMessageData, startIndex);
                td.populateData(element);
                startIndex+= element.getNextOffset();
            }
        }

        return td.toString();
    }
}
