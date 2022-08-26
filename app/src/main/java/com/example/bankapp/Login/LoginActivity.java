package com.example.bankapp.Login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.bankapp.App;
import com.example.bankapp.Login.uI.LoginViewModel;
import com.example.bankapp.R;
import com.example.bankapp.databinding.ActivityLoginBinding;
import com.example.bankapp.framework.util.AppConstants;
import com.example.bankapp.main.MainActivity;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        LoginViewModel loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        mBinding.btnLogin.setOnClickListener(view -> checkInput());

        if (App.getInstance().getDataManager().getLogin()) {
            openMain();
        }
    }

        private void checkInput () {
            if (mBinding.editTextTextPersonName.getText() == null ||
                    mBinding.editTextTextPersonName.getText().toString().trim().isEmpty()) {
                mBinding.editTextTextPersonName.setError(getString(R.string.err_usernsme));
            } else if (mBinding.editTextTextPassword.getText() == null ||
                    mBinding.editTextTextPassword.getText().toString().trim().isEmpty()) {

                mBinding.editTextTextPassword.setError((getString(R.string.err_password)));
            } else if (mBinding.editTextTextPersonName.getText().toString().equals(AppConstants.username)
                    && mBinding.editTextTextPassword.getText().toString().equals(AppConstants.password)) {
                App.getInstance().getDataManager().setLogin(mBinding.checkBox.isChecked());
                openMain();
            } else
                Toast.makeText(this,
                                getString(R.string.err_Login),
                        Toast.LENGTH_SHORT).show();
        }
        private void openMain ()
        {
            Intent intent = new Intent(this, MainActivity.class);

            startActivity(intent);
            finishAffinity();

        }
    }
