package com.example.vkwall.util;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPreference {

    public static void saveToken(String token, Context context) {
        SharedPreferences preferences = context.getSharedPreferences("MY_TOKEN", Context.MODE_PRIVATE);
        preferences.edit().putString("access_token", token).apply();
    }

    public static String loadToken(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("MY_TOKEN", Context.MODE_PRIVATE);
        return preferences.getString("access_token", "");
    }

}
