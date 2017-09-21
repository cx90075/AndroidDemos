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
 * Created by iochen on 2017/9/6 17:03
 * email：hjty225@gmail.com
 */

public class BezierCurveView2 extends View {

    private DataPoint start,control1,control2,end;

    private int centerX,centerY;

    private Paint mPaint;

    private boolean isControl1;
    public BezierCurveView2(Context context) {
        super(context,null);
    }

    public BezierCurveView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint =new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);

        start= new DataPoint(0,0);
        control1= new DataPoint(0,0);
        control2= new DataPoint(0,0);
        end= new DataPoint(0,0);

    }

    public void setControl(boolean flag){
        this.isControl1 = flag;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(isControl1){
            control1.setX(event.getX());
            control1.setY(event.getY());
        }else{
            control2.setX(event.getX());
            control2.setY(event.getY());

        }
        invalidate();

        return true;
    }

    /**
     * ----*c1---o---*c2-----
     *
     * -*s-------o------*e----
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        centerX = w / 2;
        centerY = h / 2 ;

        start.setX(centerX-200);
        start.setY(centerY);

        control1.setX(centerX-100);
        control1.setY(centerY-100);

        control2.setX(centerX+100);
        control2.setY(centerY-100);

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
        canvas.drawPoint(control1.getX(),control1.getY(),mPaint);
        canvas.drawPoint(control2.getX(),control2.getY(),mPaint);
        canvas.drawPoint(end.getX(),end.getY(),mPaint);

        //draw lines
        mPaint.setStrokeWidth(5);
        canvas.drawLine(start.getX(),start.getY(),control1.getX(),control1.getY(),mPaint);
        canvas.drawLine(control1.getX(),control1.getY(),control2.getX(),control2.getY(),mPaint);
        canvas.drawLine(control2.getX(),control2.getY(),end.getX(),end.getY(),mPaint);

        //draw bezier
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(8);

        Path path =new Path();
        path.moveTo(start.getX(),start.getY());
        path.cubicTo(control1.getX(),control1.getY(),control2.getX(),control2.getY(),end.getX(),end.getY());
        canvas.drawPath(path,mPaint);
    }


}
