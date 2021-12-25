package com.example.a20211224andriodviewmodel;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    //1.0 in order to access global resource files
    //Application application;

    //2.0 in order to access global resource files bc:Applcation is inherited from Context
    Context context;
    //2.1 to get sharedPreferences
    /*
    void foo()
    {
        context.getSharedPreferences();
    }
     */


}
