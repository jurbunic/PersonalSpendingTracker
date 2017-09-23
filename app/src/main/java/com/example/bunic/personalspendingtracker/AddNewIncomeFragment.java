package com.example.bunic.personalspendingtracker;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.bunic.database.Income;
import com.example.bunic.database.IncomeType;
import com.example.bunic.personalspendingtracker.Helpers.DateConverter;
import com.example.bunic.personalspendingtracker.Helpers.FragmentRefresher;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jurbunic on 20.09.17..
 */

public class AddNewIncomeFragment extends Fragment{
    @BindView(R.id.spinner_income_type)
    Spinner incomeType;
    @BindView(R.id.edit_income_name)
    EditText incomeName;
    @BindView(R.id.edit_financial_income)
    EditText financialincome;

    FragmentRefresher fr;

    @BindView(R.id.switch_reacuring_income)
    SwitchCompat reacuringSwitch;
    @BindView(R.id.recurrence_options)
    LinearLayout reaccurenceLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_income_add_new,container,false);
        ButterKnife.bind(this,view);
        fr = (FragmentRefresher) getArguments().getSerializable("REFRESHER");
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @OnClick(R.id.switch_reacuring_income)
    public void onSwitchClick(){
        if(reacuringSwitch.isChecked()){
            reaccurenceLayout.setVisibility(View.VISIBLE);
        }else {
            reaccurenceLayout.setVisibility(View.GONE);
        }
    }
    @OnClick(R.id.income_new_add_button)
    public void onAddNewClick(){
        Income newIncome = new Income();
        newIncome.setType(IncomeType.incomeType(incomeType.getSelectedItem().toString()));
        newIncome.setName(incomeName.getText().toString());
        newIncome.setCost(Float.parseFloat(financialincome.getText().toString()));
        newIncome.setCurrency("HRK");
        newIncome.setDate(DateConverter.timestampToDate(Calendar.getInstance().getTime()));
        newIncome.insert();
        getActivity().getFragmentManager().popBackStackImmediate();
        fr.refreshFragment();
    }
    @OnClick(R.id.income_new_cancel_button)
    public void onCancelClick(){
        getActivity().getFragmentManager().popBackStackImmediate();
        fr.refreshFragment();
    }

}
