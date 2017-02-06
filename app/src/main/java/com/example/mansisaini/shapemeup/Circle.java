package com.example.mansisaini.shapemeup;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Random;

public class Circle extends Shape
{
    public Circle(Context context)
    {
        super(context);
    }

    Random random = new Random();
    Paint paint = new Paint();

    @Override
    String getShapeType()
    {
        return "Circle";
    }
    @Override
    public void onDraw(Canvas canvas)
    {
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        int color = Color.rgb(red, green, blue);
        paint.setColor(color);

        int x = random.nextInt(getWidth());
        int y = random.nextInt(getHeight());
        int radius = random.nextInt(200);

        canvas.drawCircle(x, y, radius, paint);
    }
}
