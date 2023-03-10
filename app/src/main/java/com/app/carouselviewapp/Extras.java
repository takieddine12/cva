package com.app.carouselviewapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.app.carouselviewapp.models.ScrollModel;

import java.util.ArrayList;

public class Extras {


    public static void saveState(Context context , Boolean isChecked){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Prefs",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isChecked",isChecked);
        editor.apply();
    }

    public static Boolean isFabToggled(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Prefs",Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("isChecked",true);
    }


    // TEST FRAGMENT

    public static void saveUrl(Context context , String url){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Prefs",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("url1",url);
        editor.apply();
    }

    public static String getUrl(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Prefs",Context.MODE_PRIVATE);
        return sharedPreferences.getString("isChecked","");
    }

}

