package com.example.bunic.personalspendingtracker;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.bunic.database.views.WeeklyBalance;
import com.example.bunic.personalspendingtracker.Helpers.CurrentWeek;
import com.example.bunic.personalspendingtracker.Helpers.EventObserver;
import com.example.bunic.personalspendingtracker.Helpers.FragmentRefresher;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jurica Bunić on 2.3.2017..
 */

public class MainScreenFragment extends Fragment implements FragmentRefresher {

    @BindView(R.id.txt_weekly_balance)
    TextView weeklyBalance;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_screen,container,false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventObserver ev = EventObserver.getInstance();
        ev.addFragmentToHashMap("MAIN_SCREEN", this);
        weeklyBalance.setText(WeeklyBalance.getWeeklyBalance(CurrentWeek.getDateStart(),CurrentWeek.getDateEnd()));
    }

    @Override
    public void refreshFragment() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }
}
