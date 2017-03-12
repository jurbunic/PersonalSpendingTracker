package com.example.bunic.personalspendingtracker.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.example.bunic.database.Expense;
import com.example.bunic.personalspendingtracker.R;

import java.util.List;

/**
 * Created by Jurica Bunić on 12.3.2017..
 */

public class ExpensesRecyclerAdapter extends ExpandableRecyclerAdapter<ExpandableExpenseTypeItem, Expense, ExpenseTypeViewHolder, ExpenseViewHolder>{
    private LayoutInflater mInflator;
    private Context context;


    public ExpensesRecyclerAdapter(Context context, @NonNull List<ExpandableExpenseTypeItem> parentList){
        super(parentList);
        this.context = context;
        mInflator = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ExpenseTypeViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        View expenseTypeView = mInflator.inflate(R.layout.list_item_expenses_parent, parentViewGroup, false);
        return new ExpenseTypeViewHolder(expenseTypeView, context);
    }

    @NonNull
    @Override
    public ExpenseViewHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
        View expenseView = mInflator.inflate(R.layout.list_item_expenses_child, childViewGroup, false);
        return new ExpenseViewHolder(expenseView);
    }

    @Override
    public void onBindParentViewHolder(@NonNull ExpenseTypeViewHolder parentViewHolder, int parentPosition, @NonNull ExpandableExpenseTypeItem parent) {
        ExpandableExpenseTypeItem expandableExpenseTypeItem = (ExpandableExpenseTypeItem) parent;
        parentViewHolder.bind(expandableExpenseTypeItem);
    }

    @Override
    public void onBindChildViewHolder(@NonNull ExpenseViewHolder childViewHolder, int parentPosition, int childPosition, @NonNull Expense child) {
        Expense expense = child;
        childViewHolder.bind(expense);
    }
}
