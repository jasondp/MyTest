package com.mytest.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jason on 2016/11/28.
 */

public class PreferencesUtils {

    private static SharedPreferences preferences;

    private static SharedPreferences init(Context context) {
        if (preferences == null) {
            preferences = context.getSharedPreferences(Constants.PREFERENCES_NAME, Context.MODE_PRIVATE);
        }
        return preferences;
    }

    public static void saveUserAccount(Context context, String email) {
        init(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Constants.SAVE_USER_EMAIL, email).apply();
    }

    public static String getUserAccount(Context context) {
        init(context);
        return preferences.getString(Constants.SAVE_USER_EMAIL, null);
    }

    public static void savePassword(Context context, String password) {
        init(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Constants.SAVE_USER_PASSWORD, password).apply();
    }

    public static String getUserPassword(Context context) {
        init(context);
        return preferences.getString(Constants.SAVE_USER_PASSWORD, null);
    }
}
