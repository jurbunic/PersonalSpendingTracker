package com.example.bunic.personalspendingtracker;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bunic.database.ExpenseType;
import com.example.bunic.database.IncomeType;
import com.example.bunic.database.TransactionType;
import com.example.bunic.personalspendingtracker.Adapters.RecyclerAdapter;
import com.example.bunic.personalspendingtracker.Adapters.RecyclerExpandableItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jurbunic on 06.11.17..
 */

public class IncomesDetailedListFragment extends Fragment {
    @BindView(R.id.expenses_detailed_list)
    RecyclerView mRecyclerView;

    private RecyclerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expenses_detailed_list, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        List<IncomeType> transactionTypes =  IncomeType.getAll();
        List<RecyclerExpandableItem> parents =new ArrayList<>();
        if(transactionTypes != null){
            for(TransactionType type : transactionTypes){
                parents.add(new RecyclerExpandableItem(type));
            }
            if(mRecyclerView != null){
                adapter = new RecyclerAdapter(getActivity(),parents);
                mRecyclerView.setAdapter(adapter);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

            }
        }
    }
}
