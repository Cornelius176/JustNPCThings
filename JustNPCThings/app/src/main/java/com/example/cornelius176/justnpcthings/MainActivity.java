package com.example.cornelius176.justnpcthings;

import android.database.Cursor;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //@Override
    //protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        // Let's take a look at Toast and Log in action
        //Toast.makeText(this, "Can you see me",
                //Toast.LENGTH_SHORT).show();

        //Log.i("info", "Done creating the app");
    //}



    private Cursor employees;
    private DataManager db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DataManager(this);
        employees = db.getEmployees(); // you would not typically call this on the main thread

        ListAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                employees,
                new String[] {"FirstName"},
                new int[] {android.R.id.text1});

        //getListView().setAdapter(adapter);
        Toast.makeText(this, "Much Success!",
        Toast.LENGTH_SHORT).show();

        Log.i("info", "Done creating the app");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        employees.close();
        db.close();
    }

    public void clickRando(View view) {
        TextView randoText = findViewById(R.id.randoText);
        randoText.setText(Integer.toString(GetRandoHundred()));
    }

    public void clickQuery(View view) {
        TextView randoText = findViewById(R.id.randoText);
        DataManager dm = new DataManager(this);
        //randoText.setText(dm.testGetFirstProfession("BlackSmith"));
    }

    public int GetRandoHundred() {
        Random rand = new Random();
        return (rand.nextInt(100) + 1);
    }
}