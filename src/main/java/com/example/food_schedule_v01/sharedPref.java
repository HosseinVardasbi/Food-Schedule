package com.example.food_schedule_v01;

import android.content.Context;
import android.content.SharedPreferences;

public class sharedPref {
    Context context;
    public sharedPref(Context context){
        this.context = context;
    }
    public void saveLoginDetails(String name, String pass){
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name", name);
        editor.putString("Pass", pass);
        editor.commit();
    }

    public String getName(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Name", "");
    }
    public String getPass(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Pass", "");
    }
    public boolean isUserLogedOut(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        boolean isNameEmpty = sharedPreferences.getString("Name", "").isEmpty();
        boolean isPassEmpty = sharedPreferences.getString("Pass", "").isEmpty();
        return isNameEmpty || isPassEmpty;
    }
}
