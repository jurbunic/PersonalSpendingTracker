package com.example.bunic.personalspendingtracker;

import android.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.bunic.personalspendingtracker.Adapters.MainPagerAdapter;
import com.example.bunic.personalspendingtracker.Helpers.EventObserver;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private Toolbar toolbar;
    private FragmentManager mFragmentManager;
    EventObserver observer = EventObserver.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFragmentManager = getFragmentManager();
        mFragmentManager.addOnBackStackChangedListener(this);
        setToolbar();
        FlowManager.init(new FlowConfig.Builder(this).build());
        setupViewPager(viewPager);
        viewPager.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(viewPager);
        setupTabNames();
    }

    private Toolbar setToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(),android.R.color.white));
        toolbar.setTitle("Personal Finances");
        setSupportActionBar(toolbar);
        return toolbar;
    }

    private void setupTabNames(){
        tabLayout.getTabAt(0).setIcon(getResources().getDrawable(R.mipmap.icon_home));
        tabLayout.getTabAt(0).setText("Home");

        tabLayout.getTabAt(1).setIcon(getResources().getDrawable(R.mipmap.icon_income));
        tabLayout.getTabAt(1).setText("Incomes");

        tabLayout.getTabAt(2).setIcon(getResources().getDrawable(R.mipmap.icon_expenses));
        tabLayout.getTabAt(2).setText("Expenses");
    }

    private void setupViewPager(final ViewPager viewPager){
        final MainPagerAdapter adapter = new MainPagerAdapter(mFragmentManager);
        adapter.addFragment(new MainScreenFragment(),"Home");
        adapter.addFragment(new MainIncomeFragment(),"Incomes");
        adapter.addFragment(new MainExpensesFragment(),"Expenses");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(mFragmentManager.getBackStackEntryCount()<0){
            this.finish();
        }else{
            observer.refreshAll();
        }
    }

    @Override
    public void onBackStackChanged() {

    }
}
