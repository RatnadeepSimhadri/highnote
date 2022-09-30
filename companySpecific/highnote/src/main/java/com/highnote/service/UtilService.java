package com.highnote.service;

import com.highnote.models.TransactionDetails;
import java.util.*;
import org.apache.commons.lang3.StringUtils;

public class UtilService {
    public static char[] generateBitmap(String ISOMessageMetaData){
        String hexString = ISOMessageMetaData.substring(4,6);
        char[] bitmap = hexToBinary(hexString);
        return bitmap;
    }

    private static char[] hexToBinary(String hexString){
        String binaryString = Integer.toBinaryString(Integer.parseInt(hexString,16));
        binaryString  = StringUtils.leftPad(binaryString, 8, "0");
        int[] binary = new int[8];
        for(int i = 0 ; i < binary.length ; i++){
            binary[i] = Integer.parseInt(binaryString.substring(i,i+1));
        }

        return binaryString.toCharArray();
    }

    private static String binaryToHex(String binaryString){
        return Integer.toHexString(Integer.parseInt(binaryString,2));
    }

    public static String generateBitmap(TransactionDetails td){
       char[] bitmap = new char[8];
       Arrays.fill(bitmap,'0');
       if(td.getCardNumber() != null){
        bitmap[0] = '1';
       }

       if(td.getExpirationDate() != null){
        bitmap[1] = '1';
       }

       if(td.getAmount() != null){
        bitmap[2] = '1';
       }

       if(td.getResponseCode() != null){
        bitmap[3] = '1';
       }

       if(td.getCardHolderName() != null){
        bitmap[4] = '1';
       }

       if(td.getZipCode() != null){
        bitmap[5] = '1';
       }

       return binaryToHex(String.valueOf(bitmap));
    }
}
