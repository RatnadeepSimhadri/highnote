package com.highnote.service;

public class UtilService {
    public static char[] generateBitmap(String ISOMessageMetaData){
        String hexString = ISOMessageMetaData.substring(4,6);
        char[] bitmap = hexToBinary(hexString);
        return bitmap;
    }

    private static char[] hexToBinary(String hexString){
        String binaryString = Integer.toBinaryString(Integer.parseInt(hexString,16));
        int[] binary = new int[8];
        for(int i = 0 ; i < binary.length ; i++){
            binary[i] = Integer.parseInt(binaryString.substring(i,i+1));
        }

        return binaryString.toCharArray();
    }

    private static String binaryToHex(String binaryString){
        return Integer.toHexString(Integer.parseInt(binaryString,2));
    }
}
