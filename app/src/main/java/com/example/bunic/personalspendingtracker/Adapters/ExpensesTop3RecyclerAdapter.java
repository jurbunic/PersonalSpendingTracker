package com.example.bunic.personalspendingtracker.Adapters;



import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bunic.database.ExpenseType;
import com.example.bunic.personalspendingtracker.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jurica Bunić on 4.3.2017..
 */

public class ExpensesTop3RecyclerAdapter extends RecyclerView.Adapter<ExpensesTop3RecyclerAdapter.ExpensesViewHolder>{

    private List<ExpenseType> expenseTypes;
    Context context;

    public static class ExpensesViewHolder extends RecyclerView.ViewHolder{
        ImageView expenseIcon;
        TextView expenseName;
        TextView expenseCost;
        TextView expenseCurrency;

        public ExpensesViewHolder(View view){
            super(view);
            expenseIcon = (ImageView) view.findViewById(R.id.expense_list_item_icon);
            expenseName = (TextView) view.findViewById(R.id.expense_list_item_name);
            expenseCost = (TextView) view.findViewById(R.id.expense_list_item_cost);
            expenseCurrency = (TextView) view.findViewById(R.id.expense_list_item_currency);
        }
    }

    public ExpensesTop3RecyclerAdapter(Context context, List<ExpenseType> expenseTypes){
        this.context = context;
        this.expenseTypes = expenseTypes;
    }

    @Override
    public ExpensesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_expenses,parent,false);
        return new ExpensesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ExpensesViewHolder holder, int position) {
        ExpenseType expenseType = expenseTypes.get(position);
        holder.expenseName.setText(expenseType.getTypeName());
        holder.expenseCost.setText("320.00");
        holder.expenseCurrency.setText("HRK");
    }

    @Override
    public int getItemCount() {
        return expenseTypes.size();
    }
}