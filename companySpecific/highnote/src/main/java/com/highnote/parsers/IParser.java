package com.highnote.parsers;

import com.highnote.models.ISOMessageDataElement;

public interface IParser {    
    ISOMessageDataElement parse(String message , int startIndex);
}
