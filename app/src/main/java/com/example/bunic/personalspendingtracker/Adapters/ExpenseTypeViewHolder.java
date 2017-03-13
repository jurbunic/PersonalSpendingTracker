package com.example.bunic.personalspendingtracker.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import com.example.bunic.database.Expense;
import com.example.bunic.database.ExpenseType;
import com.example.bunic.personalspendingtracker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.OnLongClick;

/**
 * Created by Jurica Bunić on 12.3.2017..
 */

public class ExpenseTypeViewHolder extends ParentViewHolder {
    @BindView(R.id.expense_list_item_parent_type)
    TextView parentType;
    @BindView(R.id.expense_list_item_parent_icon)
    ImageView parentIcon;
    @BindView(R.id.expense_list_item_parent_total)
    TextView parentTotal;
    @BindView(R.id.expense_list_item_parent_currency)
    TextView parentCurrency;

    View mItemView;
    Context context;

    public ExpenseTypeViewHolder(View itemView, Context context) {
        super(itemView);
        mItemView = itemView;
        this.context = context;
        ButterKnife.bind(this,itemView);
    }

    public void bind(ExpenseType expenseType){
        Float totalCost = 0f;
        int id = context.getResources().getIdentifier(expenseType.getImage(),"mipmap", context.getPackageName());
        parentIcon.setImageResource(id);
        parentType.setText(expenseType.getTypeName());
        for(int i=0;i<expenseType.getExpenseList().size();i++){
            Expense expense = expenseType.getExpenseList().get(i);
            totalCost += expense.getCost();
        }
        parentTotal.setText(totalCost.toString());
        parentCurrency.setText("HRK");
    }
}

