package com.example.bunic.personalspendingtracker;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.bunic.personalspendingtracker.Adapters.RecyclerExpensesListAdapter;
import com.example.bunic.personalspendingtracker.Charts.ChartMainClass;
import com.github.mikephil.charting.charts.BarChart;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Jurica Bunić on 4.3.2017..
 */

public class MainExpensesFragment extends Fragment{

    @BindView(R.id.expense_nav_menu)
    LinearLayout expense_menu;

    BarChart chart;
    RecyclerExpensesListAdapter expensesListAdapter;
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expenses_main,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        ChartMainClass chartMainClass = new ChartMainClass(getView());
        chart = chartMainClass.getChartData();

        recyclerView = (RecyclerView) getView().findViewById(R.id.expenses_list);
        expensesListAdapter = new RecyclerExpensesListAdapter(getActivity().getApplicationContext());
        expensesListAdapter.notifyDataSetChanged();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(expensesListAdapter);

    }

    //----------------------Floating Action Menu Navigation-----------------------

    @OnClick(R.id.expense_nav_base_button)
    public void onNavBaseClick(){
        if(expense_menu.getVisibility() == View.GONE){
            expense_menu.setVisibility(View.VISIBLE);
        }else {
            expense_menu.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.expense_nav_add_new_expense)
    public void onNavAddNewExpenseClick(){
        Toast.makeText(getActivity().getApplicationContext(),"First option",Toast.LENGTH_SHORT).show();
    }

}
