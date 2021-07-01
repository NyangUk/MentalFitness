package com.company.mentalfitness.View;

import android.graphics.drawable.Drawable;

import java.util.Comparator;

public class ListViewItem {
    private Drawable iconBar;
    private Drawable iconFolder;
    private String titleStr;
    private String Date;
    //private String date;

    public void setIconB(Drawable icon) {
        iconBar = icon;
    }

    public void setIconF(Drawable icon) {
        iconFolder = icon;
    }

    public void setTitle(String title) {
        titleStr = title;
    }
    public void setDate(String date) {
        Date = date;
    }
    //public void setDate(String date){this.date = date;}

    public Drawable getIconB() {
        return this.iconBar;
    }

    public Drawable getIconF() {
        return this.iconFolder;
    }

    public String getTitle() {
        return this.titleStr;
    }

    public String getDate(){return this.Date;}



}