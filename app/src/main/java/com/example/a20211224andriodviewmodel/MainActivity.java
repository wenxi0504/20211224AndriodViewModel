package com.example.a20211224andriodviewmodel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MyViewModel myViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 1.1 In order to Access global resource files
       // myViewModel.application=getApplication();

        //2.0 in order to access global resource files bc:Applcation is inherited from Context
        myViewModel.context = getApplicationContext();
    }
}