package com.example.bunic.personalspendingtracker.Adapters;



import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bunic.personalspendingtracker.R;

/**
 * Created by Jurica Bunić on 4.3.2017..
 */

public class RecyclerExpensesListAdapter extends RecyclerView.Adapter<RecyclerExpensesListAdapter.ExpensesViewHolder>{

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

    public RecyclerExpensesListAdapter(Context context){
        this.context = context;
    }

    @Override
    public ExpensesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_expenses,parent,false);
        return new ExpensesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ExpensesViewHolder holder, int position) {
        holder.expenseName.setText("Gorivo");
        holder.expenseCost.setText("320.00");
        holder.expenseCurrency.setText("HRK");
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
