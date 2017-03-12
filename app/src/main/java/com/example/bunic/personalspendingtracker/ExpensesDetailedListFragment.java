package com.example.bunic.personalspendingtracker;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bunic.database.ExpenseType;
import com.example.bunic.personalspendingtracker.Adapters.ExpandableExpenseTypeItem;
import com.example.bunic.personalspendingtracker.Adapters.ExpensesRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jurica Bunić on 9.3.2017..
 */

public class ExpensesDetailedListFragment extends Fragment {

    @BindView(R.id.expenses_detailed_list)
    RecyclerView mRecyclerView;

    private ExpensesRecyclerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expenses_detailed_list, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        List<ExpenseType> expenseTypes = ExpenseType.getAll();
        List<ExpandableExpenseTypeItem> expandableExpenseTypeItems = new ArrayList<>();
        if(expenseTypes != null){
            for (ExpenseType type: expenseTypes){
                expandableExpenseTypeItems.add(new ExpandableExpenseTypeItem(type));
            }
            if(mRecyclerView != null){
                adapter = new ExpensesRecyclerAdapter(getActivity(),expandableExpenseTypeItems);
                mRecyclerView.setAdapter(adapter);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

            }
        }

    }
}
