package org.androidtown.lab4_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Paint pnt = new Paint();
    Path path = new Path();
    float x, y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView mv = new MyView(this);
        setContentView(mv);
    }

    protected class MyView extends View {
        public MyView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            x = event.getX();
            y = event.getY();
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                path.moveTo(x, y);
                invalidate();
            }
            else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                path.lineTo(x, y);
                invalidate();
            }
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            pnt.setColor(Color.BLUE);
            pnt.setStrokeWidth(20);
            pnt.setStyle(Paint.Style.STROKE);
            pnt.setStrokeCap(Paint.Cap.ROUND);

            canvas.drawPath(path, pnt);
        }
    }

}
