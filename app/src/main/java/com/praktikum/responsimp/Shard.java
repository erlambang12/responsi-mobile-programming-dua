package com.praktikum.responsimp;

import android.content.Context;
import android.content.SharedPreferences;

public class Shard {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public Shard(MainActivity mainActivity) {
        sharedPreferences = mainActivity.getSharedPreferences("ResponsiMp",mainActivity.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public Shard(sign_up sign_up) {
        sharedPreferences = sign_up.getSharedPreferences("ResponsiMp",sign_up.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void Shard(Context context){
        sharedPreferences = context.getSharedPreferences("ResponsiMp",context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public void saveString(String value){
        editor.putString("string",value);
        editor.commit();
}
    public String getString(){return sharedPreferences.getString("string","");}

    public String getUsername(){
        return sharedPreferences.getString("sp_username", "erlambang");
    }

    public String getPassword(){
        return sharedPreferences.getString("sp_password", "2000");
    }

    public void saveIsLogin(Boolean value){
        editor.putBoolean("sp_islogin",value);
        editor.commit();
    }

    public Boolean getIsLogin(){
        return sharedPreferences.getBoolean("sp_islogin", false);
    }

}
