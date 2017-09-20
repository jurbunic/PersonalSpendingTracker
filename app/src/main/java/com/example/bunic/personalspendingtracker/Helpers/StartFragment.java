package com.example.bunic.personalspendingtracker.Helpers;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import com.example.bunic.personalspendingtracker.R;

/**
 * Created by Jurica Bunić on 7.2.2017..
 */

public class StartFragment {
    public static void StartNewFragment(Fragment fragment, Activity mActivity, String tag){
        if(mActivity.getFragmentManager().getBackStackEntryCount()>1){

            FragmentManager fragmentManager = mActivity.getFragmentManager();
            fragmentManager.popBackStack();
            fragmentManager.beginTransaction()
                    .replace(R.id.viewpager, fragment)
                    .addToBackStack("2")
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit();
        }else {
            FragmentTransaction fm = mActivity.getFragmentManager().beginTransaction();
            fm.replace(R.id.viewpager, fragment);
            fm.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fm.addToBackStack(tag);
            fm.commit();
        }
    }

    public static void StartNewFragmentBackstack(Fragment fragment,Activity mActivity){
        FragmentTransaction fm = mActivity.getFragmentManager().beginTransaction();
        fm.replace(R.id.viewpager, fragment);
        fm.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fm.addToBackStack("1");
        fm.commit();
    }

    public static void ReplaceFragmentInViewPager(Fragment fragment, Activity mActivity, int fragmentLayoutId){
        FragmentTransaction fm = mActivity.getFragmentManager().beginTransaction();
        fm.replace(fragmentLayoutId, fragment);
        fm.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fm.addToBackStack("1");
        fm.commit();
    }
}
