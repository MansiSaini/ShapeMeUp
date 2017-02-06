package com.example.mansisaini.shapemeup;

import android.content.Context;

public class ShapeFactory
{
    public Shape getShape(Context context, String shape)
    {
        if (shape == null)
        {
            return null;
        }
        if (shape.equalsIgnoreCase("Rectangle"))
        {
            return new Rectangle(context);
        }
        else if (shape.equalsIgnoreCase("Circle"))
        {
            return new Circle(context);
        }

        return null;
    }
}

