package com.example.bunic.personalspendingtracker.Adapters;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.example.bunic.database.Expense;
import com.example.bunic.database.ExpenseType;
import com.example.bunic.personalspendingtracker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnLongClick;

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

    ExpensesRecyclerAdapter mAdapter;
    private Expense mExpense;
    View mItemView;

    public ExpenseViewHolder(@NonNull View itemView, ExpensesRecyclerAdapter adapter) {
        super(itemView);
        this.mItemView = itemView;
        mAdapter = adapter;
        ButterKnife.bind(this,itemView);
    }

    public void bind(Expense expense){
        mExpense = expense;
        mExpenseName.setText(expense.getName());
        mExpenseCost.setText(expense.getCost().toString());
        mExpenseCurrency.setText(expense.getCurrency());
    }

    @OnLongClick(R.id.expense_list_item_child)
    public boolean onChildClick(){
        final AlertDialog alertDialog = new AlertDialog.Builder(mItemView.getContext()).create();
        final int parentPosition = getParentAdapterPosition();

        alertDialog.setTitle("Do you wish to remove this item?");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Deleting expense from local database
                mExpense.delete();
                // Deleting in list items
                mAdapter.getParentList().get(getParentAdapterPosition()).getChildList().remove(getChildAdapterPosition());
                mAdapter.notifyChildRemoved(getParentAdapterPosition(), getChildAdapterPosition());
                mAdapter.notifyDataSetChanged();
                alertDialog.dismiss();
            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
        return true;
    }
}
