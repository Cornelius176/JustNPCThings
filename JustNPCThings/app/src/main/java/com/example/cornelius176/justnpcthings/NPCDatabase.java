package com.example.cornelius176.justnpcthings;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cornelius176 on 1/28/2018.
 */

public class NPCDatabase {
    private static final String DATABASE_NAME = "testnpc.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public NPCDatabase(Context context) {
        DatabaseManager dbm = new DatabaseManager(context, DATABASE_NAME, DATABASE_VERSION);
        db = dbm.getWritableDatabase();
    }

    public List<String> getAllItems() {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"0 _id", "name"};
        String sqlTables = "item";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);

        c.moveToFirst();
        List<String> list = new ArrayList<>();
        while (!c.isAfterLast()) {
            list.add(c.getString(1));
            c.moveToNext();
        }
        c.close();
        db.close();
        return list;
    }

    public void close() {
        db.close();
    }
}
