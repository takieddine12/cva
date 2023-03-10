package com.app.carouselviewapp.models;

import android.graphics.drawable.Drawable;

public class ScrollModel {
    int drawable;
    String title;
    String url;

    public ScrollModel(int drawable, String title, String url) {
        this.drawable = drawable;
        this.title = title;
        this.url = url;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
