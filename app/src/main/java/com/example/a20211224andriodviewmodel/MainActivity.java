package com.example.a20211224andriodviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.a20211224andriodviewmodel.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MyViewModel myViewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 1.1 In order to Access global resource files
       // myViewModel.application=getApplication();

        //2.0 in order to access global resource files bc:Applcation is inherited from Context
        //myViewModel.context = getApplicationContext();


        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        myViewModel= new ViewModelProvider(this,new SavedStateViewModelFactory(getApplication(),this)).get(MyViewModel.class);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);
    }
}