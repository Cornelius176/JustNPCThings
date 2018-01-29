package com.example.cornelius176.justnpcthings;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
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

    private List<String> employees;
    private DatabaseManager db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseManager(this, "northwind.db", 1);

        Toast.makeText(this, "Much Success!",
        Toast.LENGTH_SHORT).show();

        Log.i("info", "Done creating the app");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }

    public void clickRando(View view) {
        TextView randoText = findViewById(R.id.randoText);
        randoText.setText(Integer.toString(GetRandoHundred()));
    }

    public void clickQuery(View view) {
        NPCDatabase ndb = new NPCDatabase(this);
        ListView listView = findViewById(R.id.listView);
        List<String> items = ndb.getAllItems();
        ndb.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
    }

    public int GetRandoHundred() {
        Random rand = new Random();
        return (rand.nextInt(100) + 1);
    }
}