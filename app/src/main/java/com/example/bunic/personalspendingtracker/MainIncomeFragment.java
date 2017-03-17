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

import com.example.bunic.database.IncomeType;
import com.example.bunic.database.static_data.IncomeTypesData;
import com.example.bunic.personalspendingtracker.Adapters.IncomesTop3RecyclerAdapter;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Jurica Bunić on 5.3.2017..
 */

public class MainIncomeFragment extends Fragment {

    @BindView(R.id.income_nav_menu)
    LinearLayout income_menu;

    IncomesTop3RecyclerAdapter adapter;
    RecyclerView recyclerView;

    List<IncomeType> incomeTypes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_income_main, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        incomeTypes = new ArrayList<>();
        if(SQLite.select().from(IncomeType.class).queryList().isEmpty()){
            IncomeTypesData.writeIncomeTypesToDb();
            incomeTypes = IncomeType.getAll();
        }else {
            incomeTypes = IncomeType.getAll();
        }

        recyclerView = (RecyclerView) getView().findViewById(R.id.income_list_top3);
        adapter = new IncomesTop3RecyclerAdapter(getActivity().getApplicationContext(),incomeTypes);
        adapter.notifyDataSetChanged();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(true);
        recyclerView.setAdapter(adapter);

    }

    //----------------------Floating Action Menu Navigation-----------------------

    @OnClick(R.id.income_nav_base_button)
    public void onNavBaseClick(){
        if(income_menu.getVisibility() == View.GONE){
            income_menu.setVisibility(View.VISIBLE);
        }else {
            income_menu.setVisibility(View.GONE);
        }
    }

}
