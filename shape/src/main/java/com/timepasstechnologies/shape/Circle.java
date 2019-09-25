package com.timepasstechnologies.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Circle extends View {


    private int shapeCol, labelCol;
    private String shapeText;
    private Paint shapePaint;

    public Circle(Context context, AttributeSet attrs){
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
    @Override
    protected void onDraw(Canvas canvas) {

        int viewWidthHalf = this.getMeasuredWidth()/2;
        int viewHeightHalf = this.getMeasuredHeight()/2;
        int radius = 10;
        if(viewWidthHalf>viewHeightHalf)
            radius=viewHeightHalf-10;
        else
            radius=viewWidthHalf-10;

        shapePaint.setStyle(Paint.Style.FILL);
        shapePaint.setAntiAlias(true);
        shapePaint.setColor(shapeCol);
        canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, shapePaint);
        shapePaint.setColor(labelCol);
        shapePaint.setTextAlign(Paint.Align.CENTER);
        shapePaint.setTextSize(50);
        canvas.drawText(shapeText, viewWidthHalf, viewHeightHalf, shapePaint);

    }

    public int getCircleColor(){
        return shapeCol;
    }

    public int getLabelColor(){
        return labelCol;
    }

    public String getLabelText(){
        return shapeText;
    }


    public void setCircleColor(int newColor){
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
