package com.highnote.service;

import java.util.*;

import com.highnote.models.CardHolderName;
import com.highnote.models.CardNumber;
import com.highnote.models.ExpiryDate;
import com.highnote.models.ISOMessageDataElement;
import com.highnote.models.TransactionAmount;
import com.highnote.models.TransactionDetails;
import com.highnote.parsers.CardNameParser;
import com.highnote.parsers.CardNumberParser;
import com.highnote.parsers.ExpiryDateParser;
import com.highnote.parsers.IParser;
import com.highnote.parsers.TransactionAmountParser;
import com.highnote.parsers.ZipCodeParser;

public class ParserService {
    public static TransactionDetails parseISOMessage(String ISOMessage , char[] bitmap){
        String ISOMessageData = ISOMessage.substring(6);
        TransactionDetails td = new TransactionDetails(ISOMessage);
        Map<Integer,IParser> parserMap = new HashMap<>();
        parserMap.put(0,new CardNumberParser());
        parserMap.put(1, new ExpiryDateParser());
        parserMap.put(2, new TransactionAmountParser());
        parserMap.put(4 , new CardNameParser());
        parserMap.put(5, new ZipCodeParser());
        int startIndex = 0;
        for(int i = 0 ; i < bitmap.length; i++){
            if(bitmap[i] == '1'){
                ISOMessageDataElement element = parserMap.get(i).parse(ISOMessageData, startIndex);
                td.populateData(element);
                startIndex+= element.getNextOffset();
            }
        }

        return td;
    }

    public static String generateResponseISOMessage(TransactionDetails td){
        StringBuilder res = new StringBuilder();
        res.append("0110");
        String hexString = UtilService.generateBitmap(td);
        res.append(hexString);
        String data = generateCoreMessage(td);
        res.append(data);


        return res.toString();
    }

    private static String generateCoreMessage(TransactionDetails td){
        StringBuilder sb = new StringBuilder();
        if(td.getCardNumber() != null){
            
            sb.append(td.getCardNumber().toString().length());
            sb.append(td.getCardNumber().toString());
        }
        if(td.getExpirationDate() != null){
            sb.append(td.getExpirationDate().toString());
        }
        if(td.getAmount() != null){
            sb.append(td.getAmount().toString());
        }
        if(td.getResponseCode() != null){
            sb.append(td.getResponseCode().toString());
        }
        if(td.getCardHolderName() != null){
            sb.append(td.getCardHolderName().toString().length());
            sb.append(td.getCardHolderName().toString());
        }
        if(td.getZipCode() != null){
            sb.append(td.getZipCode().toString());
        }

        return sb.toString();
    }

   
}
