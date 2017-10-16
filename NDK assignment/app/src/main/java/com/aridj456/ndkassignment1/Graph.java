package com.aridj456.ndkassignment1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

public class Graph extends View {

    private NativeWrapper nw = new NativeWrapper();

    private Point a,b,c;
    private Paint paint;
    private boolean isPoint1;
    private boolean isPoint2;
    private int radius = 20;

    public Graph(Context context,Point a,Point b) {
        super(context);
        this.a = a;
        this.b = b;
        this.c = nw.getMidPoint(a,b);
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setTextSize(30);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(5);
        canvas.drawLine(a.getX(),a.y,b.getX(),b.y,paint);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(a.getX(), a.y, radius, paint);
        paint.setColor(Color.GREEN);
        canvas.drawCircle(b.getX(), b.y, radius, paint);
        paint.setColor(Color.RED);
        canvas.drawCircle(c.getX(), c.y, radius, paint);
        paint.setColor(Color.BLACK);
        canvas.drawText("("+a.getX()+","+a.y+")",a.getX(),a.y,paint);
        canvas.drawText("("+b.getX()+","+b.y+")",b.getX(),b.y,paint);
        canvas.drawText("("+c.getX()+","+c.y+")",c.getX(),c.y,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        Point d = new Point(x,y);

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            if(nw.distance(a,d)<radius){
                isPoint1 = true;
            }else if(nw.distance(b,d)<radius){
                isPoint2 = true;
            }

        }else if(event.getAction() == MotionEvent.ACTION_UP){
            if(nw.distance(a,d)<radius){
                isPoint1 = false;
            }else if(nw.distance(b,d)<radius){
                isPoint2 = false;
            }

        }else if(event.getAction() == MotionEvent.ACTION_MOVE){
            if(isPoint1){
                a = new Point(x,y);

            }else if(isPoint2){
                b = new Point(x,y);
            }

            c = nw.getMidPoint(a,b);

        }

        invalidate();
        return true;
    }
}
