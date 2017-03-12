package com.example.bunic.personalspendingtracker.Adapters;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.example.bunic.database.Expense;
import com.example.bunic.personalspendingtracker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jurica Bunić on 12.3.2017..
 */

public class ExpenseViewHolder extends ChildViewHolder {
    @BindView(R.id.expense_list_item_child_name)
    TextView mExpenseName;
    @BindView(R.id.expense_list_item_child_cost)
    TextView mExpenseCost;
    @BindView(R.id.expense_list_item_child_currency)
    TextView mExpenseCurrency;

    private Expense mExpense;
    View mItemView;

    public ExpenseViewHolder(@NonNull View itemView) {
        super(itemView);
        this.mItemView = itemView;
        ButterKnife.bind(this,itemView);
    }

    public void bind(Expense expense){
        mExpense = expense;
        mExpenseName.setText(expense.getName());
        mExpenseCost.setText(expense.getCost().toString());
        mExpenseCurrency.setText(expense.getCurrency());
    }
}
