package com.kavsoftware.kaveer.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Programme fragment = new  Programme();
        android.support.v4.app.FragmentTransaction fmTransaction = getSupportFragmentManager().beginTransaction();
        fmTransaction.replace(R.id.ToReplace, fragment);
        fmTransaction.commit();
    }
}
