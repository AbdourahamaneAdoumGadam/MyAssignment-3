package com.example.myassignment3;

import android.content.Context;
import android.content.SharedPreferences;

public class ThemePreferences {
    private static final String PREF_NAME = "theme_prefs";
    private static final String KEY_THEME_MODE = "theme_mode";

    private SharedPreferences sharedPreferences;

    public ThemePreferences(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void setThemeMode(boolean isDarkMode) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_THEME_MODE, isDarkMode);
        editor.apply();
    }

    public boolean getThemeMode() {
        return sharedPreferences.getBoolean(KEY_THEME_MODE, false); // Default to light mode
    }
}

