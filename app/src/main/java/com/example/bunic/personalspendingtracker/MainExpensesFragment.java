package com.example.bunic.personalspendingtracker;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bunic.personalspendingtracker.Adapters.RecyclerExpensesListAdapter;
import com.example.bunic.personalspendingtracker.Charts.ChartMainClass;
import com.github.mikephil.charting.charts.BarChart;

import butterknife.ButterKnife;

/**
 * Created by Jurica Bunić on 4.3.2017..
 */

public class MainExpensesFragment extends Fragment{

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
}
