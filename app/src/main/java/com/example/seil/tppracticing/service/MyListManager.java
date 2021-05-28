package com.example.seil.tppracticing.service;

import android.content.Context;
import android.database.Cursor;

import com.example.seil.tppracticing.db.TestAdapter;

import java.util.HashMap;

/**
 * Created by Seil on 2020-11-12.
 */

public class MyListManager {

    private static MyListManager myListManager;
    private static TestAdapter dbAdapter;

    public static HashMap<Long, Integer> idMap = new HashMap<>();

    public MyListManager(Context context) {
        dbAdapter = new TestAdapter(context);
    }

    public static MyListManager getInstance(Context context) {
        if (myListManager == null)
            myListManager = new MyListManager(context);
        return myListManager;
    }

    public void getFromLocalDB() {

        idMap.clear();

        Cursor cr = dbAdapter.getMyList();

        if (cr.getCount() != 0) {
            do {
                idMap.put(Long.parseLong(cr.getString(1)), 1);
            }
            while (cr.moveToNext());
        }

    }

    public void addToLocalDB(Long id) {
        if (dbAdapter.AddMyList(id) == true) {
            idMap.put(id, 1);
        }
    }

    public void deleteToLocalDB(Long id) {
        if (dbAdapter.DeleteMyList(id) == true) {
            idMap.remove(id);
        }
    }
}
