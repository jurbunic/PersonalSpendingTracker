package com.example.bunic.database;

import java.util.Date;

/**
 * Created by jurbunic on 06.11.17..
 */

public interface Transaction {
    int getId();
    String getName();
    Float getCost();
    String getCurrency();
    TransactionType getTransactionType();
    Date getDate();
    boolean delete();
}
