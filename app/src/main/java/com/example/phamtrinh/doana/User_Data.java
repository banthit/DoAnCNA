package com.example.phamtrinh.doana;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 8/22/2017.
 */

public class User_Data {
     Drawable Icon;
     String Text;

    public User_Data(Drawable icon, String text) {
        Icon = icon;
        Text = text;
    }

    public Drawable getIcon() {
        return Icon;
    }

    public void setIcon(Drawable icon) {
        Icon = icon;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
