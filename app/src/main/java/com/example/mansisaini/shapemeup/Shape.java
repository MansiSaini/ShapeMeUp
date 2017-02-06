package com.example.mansisaini.shapemeup;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public abstract class Shape extends View
{
    public Shape(Context context)
    {
        super(context);
    }

    void setShapeAlpha (float alpha)
    {
        setAlpha(alpha);
    }

    float getShapeAlpha ()
    {
        return getAlpha();
    }

    void removeShape ()
    {
        setVisibility(GONE);
        destroyDrawingCache();
    }

    //abstract methods that will be implemented in Rectangle and Circle class
    abstract String getShapeType ();

    public abstract void onDraw (Canvas canvas);
}