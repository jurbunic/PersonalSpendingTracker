package com.example.bunic.personalspendingtracker.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import com.example.bunic.database.Expense;
import com.example.bunic.database.ExpenseType;
import com.example.bunic.database.Transaction;
import com.example.bunic.database.TransactionType;
import com.example.bunic.personalspendingtracker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jurbunic on 06.11.17..
 */

public class RecyclerParentViewHolder extends ParentViewHolder {
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

    public RecyclerParentViewHolder(View itemView, Context context) {
        super(itemView);
        mItemView = itemView;
        this.context = context;
        ButterKnife.bind(this,itemView);
    }

    public void bind(TransactionType transactionType){
        Float totalCost = 0f;
        int id = context.getResources().getIdentifier(transactionType.getImage(),"mipmap", context.getPackageName());
        parentIcon.setImageResource(id);
        parentType.setText(transactionType.getTypeName());
        for(int i=0;i<transactionType.getTransactionList().size();i++){
            Transaction transaction = transactionType.getTransactionList().get(i);
            totalCost += transaction.getCost();
        }
        parentTotal.setText(totalCost.toString());
        parentCurrency.setText("HRK");
    }

    public void bind(RecyclerExpandableItem expandableItem){
        TransactionType transactionType = expandableItem.getTransactionType();
        bind(transactionType);
    }
}
