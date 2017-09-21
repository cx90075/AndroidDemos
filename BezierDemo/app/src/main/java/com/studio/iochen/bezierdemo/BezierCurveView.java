package com.studio.iochen.bezierdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 *
 * Created by iochen on 2017/9/6 13:09
 * email：hjty225@gmail.com
 */

public class BezierCurveView extends View {

    private Paint mPaint;

    private DataPoint start,control,end; //startpoint，controlpoint，endpoint

    private int centerX,centerY; //center x,cener y


    public BezierCurveView(Context context) {
        super(context,null);

    }

    public BezierCurveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint =new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        start =new DataPoint(0,0);
        end =new DataPoint(0,0);
        control =new DataPoint(0,0);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        centerX = w / 2;
        centerY = h / 2;

        start.setX(centerX-200);
        start.setY(centerY);

        control.setX(centerX);
        control.setY(centerY-200);

        end.setX(centerX+200);
        end.setY(centerY);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //draw points
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(20);
        canvas.drawPoint(start.getX(),start.getY(),mPaint);
        canvas.drawPoint(control.getX(),control.getY(),mPaint);
        canvas.drawPoint(end.getX(),end.getY(),mPaint);

        //draw lines
        mPaint.setStrokeWidth(5);
        canvas.drawLine(start.getX(),start.getY(),control.getX(),control.getY(),mPaint);
        canvas.drawLine(control.getX(),control.getY(),end.getX(),end.getY(),mPaint);

        //draw bezier
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(8);

        Path path =new Path();
        path.moveTo(start.getX(),start.getY());
        path.quadTo(control.getX(),control.getY(),end.getX(),end.getY());
        canvas.drawPath(path,mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        control.setX(event.getX());
        control.setY(event.getY());
        invalidate();
        return true;
    }

}
