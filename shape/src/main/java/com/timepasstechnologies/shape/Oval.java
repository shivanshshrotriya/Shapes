package com.timepasstechnologies.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;


public class Oval extends View {

    //circle and text colors
    private int circleCol, labelCol;
    //label text
    private String circleText;
    //paint for drawing custom view
    private Paint circlePaint;

    public Oval(Context context, AttributeSet attrs){
        super(context, attrs);
        circlePaint = new Paint();

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.round, 0, 0);

        try {
            //get the text and colors specified using the names in attrs.xml
            circleText = a.getString(R.styleable.round_circleLabel);
            circleCol = a.getInteger(R.styleable.round_circleColor, 0);//0 is default
            labelCol = a.getInteger(R.styleable.round_labelColor, 0);
        } finally {
            a.recycle();
        }

    }
    @Override
    protected void onDraw(Canvas canvas) {
        //draw the View

        int viewWidthHalf = this.getMeasuredWidth()/2;
        int viewHeightHalf = this.getMeasuredHeight()/2;
        int radius = 10;
        if(viewWidthHalf>viewHeightHalf)
            radius=viewHeightHalf-10;
        else
            radius=viewWidthHalf-10;

        circlePaint.setStyle(Style.FILL);
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(circleCol);
        canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, circlePaint);
        circlePaint.setColor(labelCol);
        circlePaint.setTextAlign(Paint.Align.CENTER);
        circlePaint.setTextSize(50);
        canvas.drawText(circleText, viewWidthHalf, viewHeightHalf, circlePaint);

    }

    public int getCircleColor(){
        return circleCol;
    }

    public int getLabelColor(){
        return labelCol;
    }

    public String getLabelText(){
        return circleText;
    }


    public void setCircleColor(int newColor){
        //update the instance variable
        circleCol=newColor;
        //redraw the view
        invalidate();
        requestLayout();
    }
    public void setLabelColor(int newColor){
        //update the instance variable
        labelCol=newColor;
        //redraw the view
        invalidate();
        requestLayout();
    }

    public void setLabelText(String newLabel){
        //update the instance variable
        circleText=newLabel;
        //redraw the view
        invalidate();
        requestLayout();
    }

}
