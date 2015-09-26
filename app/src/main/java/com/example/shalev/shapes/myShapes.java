package com.example.shalev.shapes;
import android.content.Context;
import android.graphics.Color;
import android.view.View;

public class myShapes extends View {
    private int x;
    private int y;
    private int color;

    public myShapes(Context context) {
        super(context);
        x=0;
        y=0;
        color= Color.GREEN;
    }

    public myShapes(int x,int y, int color,Context context) {
        super(context);
        this.x=x;
        this.y=y;
        this.color=color;
    }

    public int gety() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getx() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}

