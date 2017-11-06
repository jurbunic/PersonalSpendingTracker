package com.example.bunic.personalspendingtracker.Adapters;

import com.bignerdranch.expandablerecyclerview.model.Parent;


import com.example.bunic.database.Transaction;
import com.example.bunic.database.TransactionType;

import java.util.List;

/**
 * Created by jurbunic on 06.11.17..
 */

public class RecyclerExpandableItem implements Parent<Transaction>{
    private List<? extends Transaction> transactions;
    private TransactionType transactionType;

    public RecyclerExpandableItem(TransactionType transactionType){
        this.transactions = transactionType.getTransactionList();
        this.transactionType = transactionType;
    }

    @Override
    public List<Transaction> getChildList() {
        return (List<Transaction>) transactions;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }

    public TransactionType getTransactionType(){
        return transactionType;
    }
}
