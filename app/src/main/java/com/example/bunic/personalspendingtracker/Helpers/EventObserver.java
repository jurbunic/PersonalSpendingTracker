package com.example.bunic.personalspendingtracker.Helpers;

import java.util.HashMap;

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
}
