package com.example.bunic.personalspendingtracker.Helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Jurica Bunić on 23.10.2017..
 */

public class EventObserver {

    private static EventObserver INSTANCE = new EventObserver();
    private HashMap<String, FragmentRefresher > hashOfFragments = new HashMap<>();

    private EventObserver() {
    }

    public static EventObserver getInstance(){
        return INSTANCE;
    }

    public void addFragmentToHashMap(String name, FragmentRefresher fr){
        hashOfFragments.put(name,fr);
    }
    public void refreshFragment(FragmentRefresher fragmentRefresher){
        fragmentRefresher.refreshFragment();
    }

    public boolean refreshFragment(String fragmentName){
        FragmentRefresher fr = hashOfFragments.get(fragmentName);
        if(fr == null){
            return false;
        }else{
            fr.refreshFragment();
            return true;
        }
    }

    public void refreshAll(){
        List<FragmentRefresher> refreshers = new ArrayList<>(hashOfFragments.values());
        for (FragmentRefresher fragmentRefresher : refreshers){
            fragmentRefresher.refreshFragment();
        }
    }
}
