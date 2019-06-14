package in.indilabz.skeleton.utils;

import android.app.Activity;
import android.content.SharedPreferences;

import in.indilabz.skeleton.INDIMaster;


public class INDIPreferences implements Constants {

    private static SharedPreferences getPreferences() {
        return INDIMaster.applicationContext.getSharedPreferences(APP_NAME, Activity.MODE_PRIVATE);
    }

    public static SharedPreferences.Editor preferenceEditor() {
        return INDIMaster.applicationContext.getSharedPreferences(APP_NAME, Activity.MODE_PRIVATE).edit();
    }

    //// Add following lines to store and retrieve String

    public static void saveAppSession(boolean value) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putBoolean("APP_SESSION", value);
        editor.commit();
    }

    public static boolean getAppSession() {
        SharedPreferences mSharedPreferences = getPreferences();
        return mSharedPreferences.getBoolean("APP_SESSION", false);
    }

    public static void saveUserOTP( String value) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putString("USER_OTP", value);
        editor.commit();
    }

    public static String getToken() {
        SharedPreferences mSharedPreferences = getPreferences();
        return mSharedPreferences.getString("USER_TOKEN", "");
    }

    public static void saveToken( String value) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putString("USER_TOKEN", value);
        editor.commit();
    }

    public static void saveBackPress(boolean value) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putBoolean("BACK_PRESS", value);
        editor.commit();
    }

    public static boolean getBackPress() {
        SharedPreferences mSharedPreferences = getPreferences();
        return mSharedPreferences.getBoolean("BACK_PRESS", false);
    }


    ////////////////////////////// FRAGMENT NAME
    public static void saveFragmentName( String value) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putString("FRAGMENT_NAME", value);
        editor.commit();
    }

    public static String getFragmentName() {
        SharedPreferences mSharedPreferences = getPreferences();
        return mSharedPreferences.getString("FRAGMENT_NAME", "");
    }

    /*public static void saveUserDetails(ModelUsers value){
        SharedPreferences.Editor editor = getPreferences().edit();
        Gson gson = new Gson();
        String json = gson.toJson(value);
        editor.putString("USER_DETAILS", json);
        editor.commit();
    }

    public static ModelUsers getUserDetails(){
        SharedPreferences mSharedPreferences = getPreferences();
        Gson gson = new Gson();
        String json = mSharedPreferences.getString("USER_DETAILS", "");
        Log.d("json", "getUserDetails: "+json);

        return gson.fromJson(json, ModelUsers.class);
    }
*/
}