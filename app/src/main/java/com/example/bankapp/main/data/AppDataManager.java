package com.example.bankapp.main.data;

import android.content.Context;

import com.example.bankapp.framework.util.AppConstants;
import com.example.bankapp.main.data.local.prefs.AppPreferences;
import com.example.bankapp.main.data.local.prefs.AppPreferencesHelper;

public class AppDataManager implements DataManager {
    private AppPreferencesHelper mPrefHelper;

    public AppDataManager(Context context) {
        mPrefHelper = new AppPreferences(context, AppConstants.PREF_NAME);
    }

    @Override
    public void setNameState(Boolean isFather) {
      mPrefHelper.setNameState(isFather);
    }

    @Override
    public Boolean getNameState() {
        return mPrefHelper.getNameState();
    }

    @Override
    public void clear() {
       mPrefHelper.clear();
    }
}