package com.example.user.listaconvidados.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Maximo on 28/12/2017.
 */

public class SecurityPreferences {

    private final SharedPreferences mSharedPreferences;

    public SecurityPreferences(Context context) {
        this.mSharedPreferences = context.getSharedPreferences("Evento", Context.MODE_PRIVATE);
    }

    public void storeString(String key, String value) {
        this.mSharedPreferences.edit().putString(key, value).apply();
    }

    public String getStoredString(String key) {
        return this.mSharedPreferences.getString(key, "");
    }

}
