package com.example.bunic.personalspendingtracker.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.example.bunic.database.Transaction;
import com.example.bunic.database.TransactionType;
import com.example.bunic.personalspendingtracker.R;

import java.util.List;

/**
 * Created by jurbunic on 06.11.17..
 */

public class RecyclerAdapter<T> extends ExpandableRecyclerAdapter<RecyclerExpandableItem, Transaction, RecyclerParentViewHolder, RecyclerChildViewHolder> {
    private LayoutInflater mInflator;
    private Context context;


    public RecyclerAdapter(Context context, @NonNull List<RecyclerExpandableItem> parentList){
        super(parentList);
        this.context = context;
        mInflator = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerParentViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        View parentViewView = mInflator.inflate(R.layout.list_item_expenses_parent, parentViewGroup, false);
        return new RecyclerParentViewHolder(parentViewView, context);
    }

    @NonNull
    @Override
    public RecyclerChildViewHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
        View childView = mInflator.inflate(R.layout.list_item_expenses_child, childViewGroup, false);
        return new RecyclerChildViewHolder(childView, this);
    }

    @Override
    public void onBindParentViewHolder(@NonNull RecyclerParentViewHolder parentViewHolder, int parentPosition, @NonNull RecyclerExpandableItem parent) {
        RecyclerExpandableItem recyclerParentItem = parent;

        parentViewHolder.bind(recyclerParentItem);
    }

    @Override
    public void onBindChildViewHolder(@NonNull RecyclerChildViewHolder childViewHolder, int parentPosition, int childPosition, @NonNull Transaction child) {
        Transaction transaction = child;
        childViewHolder.bind(transaction);
    }
}
