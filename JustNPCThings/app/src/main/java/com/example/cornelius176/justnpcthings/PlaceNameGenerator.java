package com.example.cornelius176.justnpcthings;

/**
 * Created by Cornelius176 on 11/16/2017.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;

public class PlaceNameGenerator {


    public int GetRando(int wordCount) {
        Random rand = new Random();
        return rand.nextInt(wordCount);
    }
}
