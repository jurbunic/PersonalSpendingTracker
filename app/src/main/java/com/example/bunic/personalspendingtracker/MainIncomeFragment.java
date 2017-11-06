package com.example.bunic.personalspendingtracker;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.bunic.database.Income;
import com.example.bunic.database.IncomeType;
import com.example.bunic.database.static_data.IncomeTypesData;
import com.example.bunic.database.views.Top3IncomeTypes;
import com.example.bunic.personalspendingtracker.Adapters.IncomesTop3RecyclerAdapter;
import com.example.bunic.personalspendingtracker.Helpers.EventObserver;
import com.example.bunic.personalspendingtracker.Helpers.FragmentRefresher;
import com.example.bunic.personalspendingtracker.Helpers.StartFragment;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Jurica Bunić on 5.3.2017..
 */

public class MainIncomeFragment extends Fragment implements FragmentRefresher{

    @BindView(R.id.income_nav_menu)
    LinearLayout income_menu;

    IncomesTop3RecyclerAdapter incomesListAdapter;
    RecyclerView recyclerView;

    List<Top3IncomeTypes> incomeTypes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_income_main, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EventObserver ev = EventObserver.getInstance();
        ev.addFragmentToHashMap("MAIN_INCOME", this);
    }

    @Override
    public void onStart() {
        super.onStart();
        incomeTypes = new ArrayList<>();
        List<Income> incomeList = new ArrayList<>();

        if(SQLite.select().from(IncomeType.class).queryList().isEmpty()){
            IncomeTypesData.writeIncomeTypesToDb();
            incomeTypes = Top3IncomeTypes.getTop3Types();
        }else {
            incomeList = Income.getAll();
            incomeList.size();
            incomeTypes = Top3IncomeTypes.getTop3Types();
        }

        recyclerView = (RecyclerView) getView().findViewById(R.id.income_list_top3);
        incomesListAdapter = new IncomesTop3RecyclerAdapter(getActivity().getApplicationContext(), incomeTypes );
        incomesListAdapter.notifyDataSetChanged();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(incomesListAdapter);
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

    @OnClick(R.id.income_nav_add_new_income)
    public void onNavAddNewIncomeClick(){
        AddNewIncomeFragment anef = new AddNewIncomeFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("REFRESHER", this);
        anef.setArguments(bundle);
        StartFragment.ReplaceFragmentInViewPager(anef,getActivity(), R.id.root_main_income);
    }

    @OnClick(R.id.income_nav_detailed_list)
    public void onNavDetailedListClick(){
        IncomesDetailedListFragment idlf = new IncomesDetailedListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("REFRESHER", this);
        idlf.setArguments(bundle);
        StartFragment.ReplaceFragmentInViewPager(idlf,getActivity(), R.id.root_main_income);
    }

    @Override
    public void refreshFragment() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }
}
