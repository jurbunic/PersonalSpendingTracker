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

import com.example.bunic.database.Expense;
import com.example.bunic.database.ExpenseType;
import com.example.bunic.database.static_data.ExpenseTypesData;
import com.example.bunic.database.Top3ExpenseTypes;
import com.example.bunic.personalspendingtracker.Adapters.ExpensesTop3RecyclerAdapter;
import com.example.bunic.personalspendingtracker.Charts.ChartMainClass;
import com.example.bunic.personalspendingtracker.Helpers.StartFragment;
import com.github.mikephil.charting.charts.BarChart;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Jurica Bunić on 4.3.2017..
 */

public class MainExpensesFragment extends Fragment {

    @BindView(R.id.expense_nav_menu)
    LinearLayout expense_menu;

    BarChart chart;
    ExpensesTop3RecyclerAdapter expensesListAdapter;
    RecyclerView recyclerView;

    List<Top3ExpenseTypes> top3ExpenseTypes;

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

        top3ExpenseTypes = new ArrayList<>();
        List<Expense> expenseList = new ArrayList<>();

        if(SQLite.select().from(ExpenseType.class).queryList().isEmpty()){
            ExpenseTypesData.writeExpenseTypesToDb();
        }else {
            expenseList = Expense.getAll();
            top3ExpenseTypes = Top3ExpenseTypes.getTop3Types();
            expenseList.size();
        }

        recyclerView = (RecyclerView) getView().findViewById(R.id.expenses_list_top3);

        expensesListAdapter = new ExpensesTop3RecyclerAdapter(getActivity().getApplicationContext(), top3ExpenseTypes );
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
        AddNewExpenseFragment anef = new AddNewExpenseFragment();
        StartFragment.StartNewFragmentBackstack(anef,getActivity());
    }

    @OnClick(R.id.expense_nav_detailed_list)
    public void onNavDetailedListClick(){
        ExpensesDetailedListFragment edlf = new ExpensesDetailedListFragment();
        StartFragment.StartNewFragmentBackstack(edlf,getActivity());
    }


}
