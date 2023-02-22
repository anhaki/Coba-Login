package com.example.cobalogin;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class LoginMec {
    private SharedPreferences SP;
    private SharedPreferences.Editor SPE;

    public void setPref(Context ctx, String key, String value){
        SP = PreferenceManager.getDefaultSharedPreferences(ctx);
        SPE = SP.edit();
        SPE.putString(key, value);
        SPE.commit();
    }
    public String getPref(Context ctx, String key){
        SP = PreferenceManager.getDefaultSharedPreferences(ctx);
        String tampung = SP.getString(key,null);
        return tampung;
    }
    public Boolean isLogin(Context ctx, String key){
        if(this.getPref(ctx,key) != null){
            return true;
        }
        else{
            return false;
        }
    }
}
