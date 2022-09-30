package com.highnote.models;


public class ExpiryDate implements ISOMessageDataElement {
    public static Integer DATALENGTH = 4;
    private Integer expiryMonth;
    private Integer expiryYear;

    @Override
    public int getNextOffset() {
        return DATALENGTH;
    }

    /**
     * @param expiryMonth the expiryMonth to set
     */
    public void setExpiryMonth(Integer expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    /**
     * @param expiryYear the expiryYear to set
     */
    public void setExpiryYear(Integer expiryYear) {
        this.expiryYear = expiryYear;
    }

    public ExpiryDate(String MM , String YY){
        this.expiryMonth = Integer.valueOf(MM);
        this.expiryYear = Integer.valueOf("20"+YY);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
            Integer month = expiryMonth;
            Integer year = expiryYear % 2000;
            sb.append(month);
            sb.append(year);
        return sb.toString();
    }
    
    /**
     * @return the expiryMonth
     */
    public Integer getExpiryMonth() {
        return expiryMonth;
    }

    /**
     * @return the expiryYear
     */
    public Integer getExpiryYear() {
        return expiryYear;
    }
}
