package com.example.bankapp.data.local.prefs;

public interface AppPreferencesHelper {
    void setLogin(Boolean isLogin);


    Boolean getLogin();

    void clear();
}
