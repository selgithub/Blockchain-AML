package com.example.myapplication;


import android.content.Context;
import android.content.SharedPreferences;


public class TokenManager {
    private Context context;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private static final String REFNAME = "Bearer";
    private static final String KEY_USER_NAME = "username";
    private static final String KEY_JWT_TOKEN = "jwttoken";
    private static TokenManager INSTANCE = null;
    int Mode = 0;

    public TokenManager(Context context) {
        this.context = context;
        prefs = context.getSharedPreferences(REFNAME, Mode);
        editor = prefs.edit();
    }

    public TokenManager() {

    }

    public void createSession(String username, String jwt) {
        editor.putString(KEY_USER_NAME, username);
        editor.putString(KEY_JWT_TOKEN, jwt);
        editor.commit();
    }


}
