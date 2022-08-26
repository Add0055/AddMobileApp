package com.example.bankapp.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.bankapp.App;
import com.example.bankapp.Login.LoginActivity;
import com.example.bankapp.databinding.ActivityMainBinding;
import com.example.bankapp.main.UI.MainViewModel;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mbinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mbinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mbinding.getRoot());

        MainViewModel mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);


        mbinding.btnMain.setOnClickListener(view -> openlogin());



    }
    private void openlogin(){
        App.getInstance().getDataManager().clear();
        Intent intent = new Intent(this, LoginActivity.class);

        startActivity(intent);
        finishAffinity();

    }
}
