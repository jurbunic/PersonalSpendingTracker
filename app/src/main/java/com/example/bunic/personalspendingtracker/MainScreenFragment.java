package com.example.bunic.personalspendingtracker;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bunic.personalspendingtracker.Helpers.StartFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Jurica Bunić on 2.3.2017..
 */

public class MainScreenFragment extends Fragment{



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_screen,container,false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.button_expenses)
    public void onButtonExpensesClick(){
        MainExpensesFragment mef = new MainExpensesFragment();
        StartFragment.StartNewFragment(mef,getActivity(),"2");
    }

}