package com.example.bankapp.data;

import android.content.Context;

import com.example.bankapp.framework.util.AppConstants;
import com.example.bankapp.data.local.prefs.AppPreferences;
import com.example.bankapp.data.local.prefs.AppPreferencesHelper;

public class AppDataManager implements DataManager {
    private AppPreferencesHelper mPrefHelper;

    public AppDataManager(Context context) {
        mPrefHelper = new AppPreferences(context, AppConstants.PREF_NAME);
    }

    @Override
    public void setLogin(Boolean isLogin) {
      mPrefHelper.setLogin(isLogin);
    }

    @Override
    public Boolean getLogin() {
        return mPrefHelper.getLogin();
    }

    @Override
    public void clear() {
       mPrefHelper.clear();
    }
}