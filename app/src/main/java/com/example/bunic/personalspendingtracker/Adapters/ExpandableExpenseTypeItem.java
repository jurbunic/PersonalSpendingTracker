package com.example.bunic.personalspendingtracker.Adapters;

import com.bignerdranch.expandablerecyclerview.model.Parent;
import com.example.bunic.database.Expense;
import com.example.bunic.database.ExpenseType;

import java.util.List;

/**
 * Created by Jurica Bunić on 12.3.2017..
 */

public class ExpandableExpenseTypeItem extends ExpenseType implements Parent<Expense> {

    private List<Expense> expenses;

    public ExpandableExpenseTypeItem(ExpenseType expenseType){
        super(expenseType);
        this.expenses = expenseType.getExpenseList();
    }

    @Override
    public List<Expense> getChildList() {
        return expenses;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
