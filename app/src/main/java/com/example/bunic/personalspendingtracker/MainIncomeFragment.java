package com.example.bunic.personalspendingtracker;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Jurica Bunić on 5.3.2017..
 */

public class MainIncomeFragment extends Fragment {

    @BindView(R.id.income_nav_menu)
    LinearLayout income_menu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_income_main, container, false);
        ButterKnife.bind(this,view);
        return view;
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
