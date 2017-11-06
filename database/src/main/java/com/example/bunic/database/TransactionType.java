package com.example.bunic.database;

import java.util.List;

/**
 * Created by jurbunic on 06.11.17..
 */

public interface TransactionType {
    int getId();
    String getTypeName();
    String getImage();
    List<? extends Transaction> getTransactionList();
}
