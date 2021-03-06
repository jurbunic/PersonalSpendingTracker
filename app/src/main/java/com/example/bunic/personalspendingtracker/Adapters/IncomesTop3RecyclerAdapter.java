package com.example.bunic.personalspendingtracker.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bunic.database.views.Top3IncomeTypes;
import com.example.bunic.personalspendingtracker.R;

import java.util.List;

/**
 * Created by Jurica Bunić on 17.3.2017..
 */

public class IncomesTop3RecyclerAdapter extends RecyclerView.Adapter<IncomesTop3RecyclerAdapter.IncomeViewHolder>{
    private List<Top3IncomeTypes> incomeTypes;
    Context context;

    public static class IncomeViewHolder extends RecyclerView.ViewHolder{
        ImageView incomeIcon;
        TextView incomeName;
        TextView incomeCost;
        TextView incomeCurrency;

        public IncomeViewHolder(View view){
            super(view);
            incomeIcon = (ImageView) view.findViewById(R.id.income_list_item_icon);
            incomeName = (TextView) view.findViewById(R.id.income_list_item_name);
            incomeCost = (TextView) view.findViewById(R.id.income_list_item_cost);
            incomeCurrency = (TextView) view.findViewById(R.id.income_list_item_currency);
        }
    }

    public IncomesTop3RecyclerAdapter(Context context, List<Top3IncomeTypes> incomeTypes){
        this.context = context;
        this.incomeTypes = incomeTypes;
    }

    @Override
    public IncomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_incomes,parent,false);
        return new IncomeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(IncomeViewHolder holder, int position) {
        Top3IncomeTypes expenseType = incomeTypes.get(position);
        int id = context.getResources().getIdentifier(expenseType.getIncomeTypeIcon(),"mipmap", context.getPackageName());
        holder.incomeIcon.setImageResource(id);
        holder.incomeName.setText(expenseType.getIncomeTypeName());
        holder.incomeCost.setText(expenseType.getIncomeTypeCost().toString());
        holder.incomeCurrency.setText("HRK");
    }

    @Override
    public int getItemCount() {
        return incomeTypes.size();
    }
}
