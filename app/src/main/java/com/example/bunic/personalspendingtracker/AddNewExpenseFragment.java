package com.example.bunic.personalspendingtracker;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.bunic.database.Expense;
import com.example.bunic.database.ExpenseType;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Jurica Bunić on 6.3.2017..
 */

public class AddNewExpenseFragment extends Fragment{

    @BindView(R.id.spinner_cost_type)
    Spinner costType;
    @BindView(R.id.edit_cost_name)
    EditText costName;
    @BindView(R.id.edit_financial_cost)
    EditText financialCost;

    @BindView(R.id.switch_reacuring_expense)
    SwitchCompat reacuringSwitch;
    @BindView(R.id.recurrence_options)
    LinearLayout reaccurenceLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expenses_add_new,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @OnClick(R.id.switch_reacuring_expense)
    public void onSwitchClick(){
        if(reacuringSwitch.isChecked()){
            reaccurenceLayout.setVisibility(View.VISIBLE);
        }else {
            reaccurenceLayout.setVisibility(View.GONE);
        }
    }
    @OnClick(R.id.expense_new_add_button)
    public void onAddNewClick(){
        Expense newExpense = new Expense();
        newExpense.setExpenseType(ExpenseType.expenseType(costType.getSelectedItem().toString()));
        newExpense.setName(costName.getText().toString());
        newExpense.setCost(Float.parseFloat(financialCost.getText().toString()));
        newExpense.setCurrency("HRK");
        newExpense.setDate(Calendar.getInstance().getTime());
        newExpense.insert();

        getActivity().getFragmentManager().popBackStackImmediate();
        refresh();
    }
    @OnClick(R.id.expense_new_cancel_button)
    public void onCancelClick(){
        getActivity().getFragmentManager().popBackStackImmediate();
        refresh();
    }

    public void refresh(){
        Fragment f = getFragmentManager().findFragmentById(R.id.fragment_container);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(f).attach(f).commit();
    }

}
