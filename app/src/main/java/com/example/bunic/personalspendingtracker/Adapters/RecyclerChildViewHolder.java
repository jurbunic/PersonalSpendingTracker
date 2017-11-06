package com.example.bunic.personalspendingtracker.Adapters;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.example.bunic.database.Transaction;
import com.example.bunic.personalspendingtracker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnLongClick;

/**
 * Created by jurbunic on 06.11.17..
 */

public class RecyclerChildViewHolder extends ChildViewHolder {
    @BindView(R.id.expense_list_item_child_name)
    TextView mExpenseName;
    @BindView(R.id.expense_list_item_child_cost)
    TextView mExpenseCost;
    @BindView(R.id.expense_list_item_child_currency)
    TextView mExpenseCurrency;

    RecyclerAdapter mAdapter;
    private Transaction mTransaction;
    View mItemView;

    public RecyclerChildViewHolder(@NonNull View itemView, RecyclerAdapter adapter) {
        super(itemView);
        this.mItemView = itemView;
        mAdapter = adapter;
        ButterKnife.bind(this,itemView);
    }

    public void bind(Transaction transaction){
        mTransaction = transaction;
        mExpenseName.setText(transaction.getName());
        mExpenseCost.setText(transaction.getCost().toString());
        mExpenseCurrency.setText(transaction.getCurrency());
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
                mTransaction.delete();
                // Deleting in list items
                ((RecyclerExpandableItem) mAdapter.getParentList().get(getParentAdapterPosition())).getChildList().remove(getChildAdapterPosition());
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
