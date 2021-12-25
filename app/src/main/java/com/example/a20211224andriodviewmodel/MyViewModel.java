package com.example.a20211224andriodviewmodel;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends AndroidViewModel {
    //1.0 in order to access global resource files
    //Application application;

    //2.0 in order to access global resource files bc:Applcation is inherited from Context
    //Context context;

    //2.1 to get sharedPreferences
    /*
    void foo()
    {
        context.getSharedPreferences();
    }
     */
    SavedStateHandle handle;
    String key = getApplication().getResources().getString(R.string.data_key);
    String shpName = getApplication().getResources().getString(R.string.shp_name);

    public MyViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        this.handle = handle;
        // if the handle is null, get the data from data file
        // Set varibale in string.xml first
        if (!handle.contains(key)) {  // call load method to load data from data file
            load();
        }
        ;
    }

    // get live data
    public LiveData<Integer> getNumber() {
        return handle.getLiveData(key);

    }

    void load() {
        //get data from SharePreferences
        SharedPreferences shp = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
        // read data
        int x = shp.getInt(key, 0);
        // write it to the handle
        handle.set(key, x);
    }

     void save() {
        //get data from SharePreferences
        SharedPreferences shp = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putInt(key, getNumber().getValue());// from live data
        editor.apply();


    }

    public void add(int x) {
        handle.set(key, getNumber().getValue() + x);
        //Method1:Savest way to save data, but sometimes too much if the data is changing frequently
        //save();
    }

    public void minus(int x){
        handle.set(key,getNumber().getValue()-x);
       // save();
    }

}




