package com.example.cornelius176.justnpcthings;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cornelius176 on 11/18/2017.
 */

public class DatabaseManager extends SQLiteAssetHelper {
    private static String DATABASE_NAME;
    private static int DATABASE_VERSION;

    public DatabaseManager(Context context, String databaseName, int databaseVersion) {
        super(context, databaseName, null, databaseVersion);
        DATABASE_NAME = databaseName;
        DATABASE_VERSION = databaseVersion;
    }

    public List<String> getEmployees() {
        List<String> list = new ArrayList<>();
        if (DATABASE_NAME == "northwind.db") {
            SQLiteDatabase db = getReadableDatabase();
            SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

            String[] sqlSelect = {"0 _id", "FirstName", "LastName"};
            String sqlTables = "Employees";

            qb.setTables(sqlTables);
            Cursor c = qb.query(db, sqlSelect, null, null,
                    null, null, null);

            c.moveToFirst();
            list = new ArrayList<>();
            while (!c.isAfterLast()) {
                list.add(c.getString(1));
                c.moveToNext();
            }
            c.close();
            db.close();
        }
        return list;
    }
}
