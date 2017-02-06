package com.example.mansisaini.shapemeup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.widget.Toast;

import java.util.Random;

public class Rectangle extends Shape
{
    public Rectangle(Context context)
    {
        super(context);
    }

    Paint paint = new Paint();
    Random random = new Random();

    @Override
    String getShapeType()
    {
        return "Rectangle";
    }

    @Override
    public void onDraw(Canvas canvas)
    {
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);

            int color = Color.rgb(red, green, blue);
            paint.setColor(color);

            int left = random.nextInt(getWidth());
            int top = random.nextInt(getHeight());
            int right = random.nextInt(getWidth() -left) + left;
            int bottom = random.nextInt(getHeight()- top) + top;

            canvas.drawRect(left, top, right, bottom, paint);

    }
}
