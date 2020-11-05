package com.example.contactme;

import android.app.Application;
import android.content.SharedPreferences;

public class MyPrefrence extends Application {

    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;


    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferences = getSharedPreferences("mycon", MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    public static void setbtn(boolean btn) {
        editor.putBoolean("btn", btn).commit();
    }

    public static boolean getbtn() {
        return sharedPreferences.getBoolean("btn", false);

    }

    public static void setLogin(boolean login) {
        editor.putBoolean("login", login).commit();
    }

    public static boolean getLogin() {
        return sharedPreferences.getBoolean("login", false);

    }


    public static void setemail(String email) {
        editor.putString("email", email).commit();
    }

    public static String getemail() {
        return sharedPreferences.getString("email", "");
    }

    public static void setpass(String pass) {
        editor.putString("pass", pass).commit();
    }

    public static String getpass() {
        return sharedPreferences.getString("pass", "");
    }

    public static void setname(String name) {
        editor.putString("name", name).commit();
    }

    public static String getname() {
        return sharedPreferences.getString("name", "");
    }

    public static void setmobile(String mobile) {
        editor.putString("mobile", mobile).commit();
    }

    public static String getmobile() {
        return sharedPreferences.getString("mobile", "");
    }

 public static void setsname(String sname) {
        editor.putString("sname", sname).commit();
    }

    public static String getsname() {
        return sharedPreferences.getString("sname", "");
    }


}
