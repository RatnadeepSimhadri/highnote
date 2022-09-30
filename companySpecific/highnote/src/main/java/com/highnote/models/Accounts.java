package com.highnote.models;
import java.util.*;

public class Accounts {
    
    private static Accounts INSTANCE = new Accounts();
    private Map<String,Long> accounts = null;
    private Long defaultBalance = null;
    private Accounts(){

    }

    public void setupAccounts(Map<String,Long> accounts, Long defaultBalance){
        this.accounts = accounts;
        this.defaultBalance = defaultBalance;
    }


    public void updateBalance(String pan, Long newBalance){
        accounts.put(pan,newBalance);
    }

    public Long getBalance(String pan){
        Long balance = accounts.getOrDefault(pan, defaultBalance);
        return balance;
    }

    public static Accounts getAccountsInstance(){
        return INSTANCE;
    }
}
