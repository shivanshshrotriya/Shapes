package com.timepasstechnologies.shape;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;


public class Oval extends View {

    private int shapeCol, labelCol;
    private String shapeText;
    private Paint shapePaint;

    public Oval(Context context, AttributeSet attrs) {
        super(context, attrs);
        shapePaint = new Paint();

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.shapeValue, 0, 0);

        try {
            shapeText = a.getString(R.styleable.shapeValue_shapeLabel);
            shapeCol = a.getInteger(R.styleable.shapeValue_shapeColor, 0);//0 is default
            labelCol = a.getInteger(R.styleable.shapeValue_labelColor, 0);
        } finally {
            a.recycle();
        }
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {

        int viewWidthHalf = this.getMeasuredWidth()/2;
        int viewHeightHalf = this.getMeasuredHeight()/2;


        shapePaint.setStyle(Paint.Style.FILL);
        shapePaint.setAntiAlias(true);
        shapePaint.setColor(shapeCol);
        canvas.drawOval(new RectF(0,0,getWidth(),getHeight()),shapePaint);

        shapePaint.setColor(labelCol);
        shapePaint.setTextAlign(Paint.Align.CENTER);
        shapePaint.setTextSize(50);
        canvas.drawText(shapeText, viewWidthHalf, viewHeightHalf, shapePaint);

    }

    public int getshapeColor(){
        return shapeCol;
    }

    public int getLabelColor(){
        return labelCol;
    }

    public String getLabelText(){
        return shapeText;
    }


    public void setshapeColor(int newColor){
        shapeCol=newColor;
        invalidate();
        requestLayout();
    }
    public void setLabelColor(int newColor){
        labelCol=newColor;
        invalidate();
        requestLayout();
    }

    public void setLabelText(String newLabel){
        shapeText=newLabel;
        invalidate();
        requestLayout();
    }

}



