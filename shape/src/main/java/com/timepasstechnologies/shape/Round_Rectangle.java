package com.timepasstechnologies.shape;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class Round_Rectangle extends View {

    private int shapeCol, labelCol;
    private String shapeText;
    private Paint shapePaint,paint;

    public Round_Rectangle(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();

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


        paint.setColor(shapeCol);
        paint.setStrokeWidth(3);
        int a = 0;
        int b = 0;
        int c = getWidth();
        int d = getHeight();
        canvas.drawRoundRect(new RectF(a,b,c,d),50,50,paint);

        paint.setColor(labelCol);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(50);
        canvas.drawText(shapeText, c/2,d/2, paint);

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



