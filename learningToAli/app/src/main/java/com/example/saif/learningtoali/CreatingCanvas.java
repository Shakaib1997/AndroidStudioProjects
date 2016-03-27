package com.example.saif.learningtoali;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by Saif on 28/05/2015.
 */
public class CreatingCanvas extends View {
    String colour ;
    Integer startXCoor;
    Integer startYCoor;
    Integer lastXCoor;
    Integer lastYCoor;

    public CreatingCanvas(Context context, String col, Integer startXCoor, Integer startYCoor, Integer lastXCoor, Integer lastYCoor)
    {
        super(context);
        this.colour = col;
        this.startXCoor = startXCoor;
        this.startYCoor = startYCoor;
        this.lastXCoor = lastXCoor;
        this.lastYCoor = lastYCoor;

    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Paint blockColour = new Paint();
        blockColour.setStyle(Paint.Style.FILL);


        if(this.colour == "red")
        {
            blockColour.setColor(Color.RED);
        }
        else if (this.colour == "blue")
        {
            blockColour.setColor(Color.BLUE);
        }

        Rect snakeHead = new Rect();
        snakeHead.set(this.startXCoor,this.startYCoor,this.lastXCoor,this.lastYCoor);
        canvas.drawRect(snakeHead,blockColour);

    }
}
