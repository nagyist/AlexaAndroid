package com.willblaschko.android.alexa.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import java.util.UUID;

/**
 * A collection of utility functions.
 *
 * @author wblaschko on 8/13/15.
 */
public class Util {
    private static SharedPreferences mPreferences;
    public static final String IDENTIFIER = "identifier";

    /**
     * Show an authorization toast on the main thread to make sure the user sees it
     * @param context local context
     * @param message the message to show the user
     */
    public static void showAuthToast(final Context context, final String message){
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast authToast = Toast.makeText(context, message, Toast.LENGTH_LONG);
                authToast.show();
            }
        });
    }


    /**
     * Get our default shared preferences
     * @param context local/application context
     * @return default shared preferences
     */
    public static SharedPreferences getPreferences(Context context) {
        if (mPreferences == null) {
            mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return mPreferences;
    }

    public static String getUuid(){
        String prefix = (mPreferences != null) ? mPreferences.getString(IDENTIFIER, "")+"." : "";
        String uuid = prefix + UUID.randomUUID().toString();
        Log.i("Util", uuid);
        return uuid;
    }
}
