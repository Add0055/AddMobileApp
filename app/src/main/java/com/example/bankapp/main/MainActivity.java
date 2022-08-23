package com.example.bankapp.main;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.bankapp.databinding.ActivityMainBinding;
import com.example.bankapp.main.UI.MainViewModel;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MainViewModel mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.txtName.observe(this, binding.textMainActivity::setText);

        binding.textMainActivity.setOnClickListener(view -> {
            mainViewModel.onClickName();
        });

    }
}
