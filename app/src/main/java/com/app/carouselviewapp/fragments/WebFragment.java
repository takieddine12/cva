package com.app.carouselviewapp.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.app.carouselviewapp.R;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class WebFragment extends Fragment  {
    
    private WebView webView1,webView2,webView3,webView4;
    public DrawerLayout drawerLayout;
    public NavigationView navigationView;
    private final String[] _urls = new String[]{
            "https://www.google.com",
            "https://www.yahoo.com",
            "https://www.baidu.com",
            "https://www.facebook.com"};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.web_fragment_layout, container, false);
        webView1 = view.findViewById(R.id.webView1);
        webView2 = view.findViewById(R.id.webView2);
        webView3 = view.findViewById(R.id.webView3);
        webView4 = view.findViewById(R.id.webView4);
        drawerLayout = view.findViewById(R.id.drawerLayout);
        navigationView = view.findViewById(R.id.navigationView);
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).hide();
       return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initWebViews();
        createDrawer();
    }


    private void createDrawer(){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.view1: {
                        showWebView1();
                    }
                    break;
                    case R.id.view2: {
                        showWebView2();
                    }
                    break;
                    case R.id.view3: {
                        showWebView3();
                    }
                    break;
                    case R.id.view4: {
                        showWebView4();
                    }
                    break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
    @SuppressLint("SetJavaScriptEnabled")
    private void initWebViews(){
        // WEB 1
        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.setWebViewClient(new XYWebViewClient());
        webView1.loadUrl(_urls[0]);

        // WEB 2
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.setWebViewClient(new XYWebViewClient());
        webView2.loadUrl(_urls[1]);

        // WEB 3
        webView3.getSettings().setJavaScriptEnabled(true);
        webView3.setWebViewClient(new XYWebViewClient());
        webView3.loadUrl(_urls[2]);

        // WEB 4
        webView4.getSettings().setJavaScriptEnabled(true);
        webView4.setWebViewClient(new XYWebViewClient());
        webView4.loadUrl(_urls[3]);
    }
    private void showWebView1(){
        webView1.setVisibility(View.VISIBLE);
        webView2.setVisibility(View.GONE);
        webView3.setVisibility(View.GONE);
        webView4.setVisibility(View.GONE);
    }
    private void showWebView2(){
        webView1.setVisibility(View.GONE);
        webView2.setVisibility(View.VISIBLE);
        webView3.setVisibility(View.GONE);
        webView4.setVisibility(View.GONE);
    }
    private void showWebView3(){
        webView1.setVisibility(View.GONE);
        webView2.setVisibility(View.GONE);
        webView3.setVisibility(View.VISIBLE);
        webView4.setVisibility(View.GONE);

    }
    private void showWebView4(){
        webView1.setVisibility(View.GONE);
        webView2.setVisibility(View.GONE);
        webView3.setVisibility(View.GONE);
        webView4.setVisibility(View.VISIBLE);
    }
    private static class XYWebViewClient extends  WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
    @Override
    public void onDestroy() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onDestroy();
        }

    }
}
