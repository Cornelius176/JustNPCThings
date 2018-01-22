package com.example.cornelius176.justnpcthings;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Let's take a look at Toast and Log in action
        Toast.makeText(this, "Can you see me",
                Toast.LENGTH_SHORT).show();

        Log.i("info", "Done creating the app");
    }


    public int GetRandoHundred() {
        Random rand = new Random();
        return rand.nextInt(100);
    }
}