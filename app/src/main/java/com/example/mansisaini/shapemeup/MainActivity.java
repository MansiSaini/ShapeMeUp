package com.example.mansisaini.shapemeup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Vector;

public class MainActivity extends AppCompatActivity
{
    public Button rect;
    public Button circ;
    public Button clear;
    public RelativeLayout Rlayout;
    public TextView textView;

    //holds the shapes
    Vector<Shape> myVector = new Vector<>();

    //Like the main program:
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rect = (Button)findViewById(R.id.rect);
        circ = (Button)findViewById(R.id.circ);
        clear = (Button)findViewById(R.id.clear);
        Rlayout = (RelativeLayout)findViewById(R.id.Relayout1);

        rect.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //what happens when the rect button is clicked:
                adjustShapeAlpha();
                Shape myRectangle = new ShapeFactory().getShape(v.getContext(), "Rectangle");
                myVector.add(myRectangle);
                Rlayout.addView(myRectangle);
                updateShapeCount();
            }
        });

        circ.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //what happens when the circ button is pressed.
                adjustShapeAlpha();
                Shape myCircle = new ShapeFactory().getShape(v.getContext(), "Circle");
                myVector.add(myCircle);
                Rlayout.addView(myCircle);
                updateShapeCount();
            }
        });

        clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //what happens when the clear button is clicked
                myVector.clear();
                Rlayout.removeAllViews();
                updateShapeCount();
            }
        });
    }

    void adjustShapeAlpha ()
    {
        for (Shape shape : myVector)
        {
            shape.setShapeAlpha(shape.getShapeAlpha() - 0.077f);

            if(shape.getShapeAlpha() < 0.1f)
            {
                shape.removeShape();
            }
        }
    }

   void updateShapeCount ()
   {
       int total_rectangles = 0;
       int total_circles = 0;

       textView = (TextView) findViewById(R.id.textView);

       for (Shape shape : myVector)
       {
           if(shape.getShapeType().equalsIgnoreCase("Rectangle"))
           {
               total_rectangles++;
               if (shape.getShapeAlpha() < 0.1f)
               {
                   total_rectangles--;
               }
           }
           else if (shape.getShapeType().equalsIgnoreCase("Circle"))
           {
               total_circles++;
               if (shape.getShapeAlpha() < 0.1f)
               {
                   total_circles--;
               }
           }
       }
       textView.setText("Rectangles: " + total_rectangles + " " + "Circles: " + total_circles);
   }
}

