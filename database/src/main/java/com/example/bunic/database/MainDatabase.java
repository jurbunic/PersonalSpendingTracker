package com.example.bunic.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Jurica Bunić on 8.3.2017..
 */

@Database(name = MainDatabase.NAME, version = MainDatabase.VERSION)
public class MainDatabase {
    public static final String NAME = "main";
    public static final int VERSION = 1;
}
