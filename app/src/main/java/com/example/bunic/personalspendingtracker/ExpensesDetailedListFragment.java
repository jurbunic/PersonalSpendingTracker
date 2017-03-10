package com.example.bunic.personalspendingtracker;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jurica Bunić on 9.3.2017..
 */

public class ExpensesDetailedListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expenses_detailed_list, container, false);
        return view;
    }
}
