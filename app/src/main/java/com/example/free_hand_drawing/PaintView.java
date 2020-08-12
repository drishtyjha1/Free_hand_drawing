package com.example.free_hand_drawing;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.graphics.Path;


public class PaintView extends View {
    public LayoutParams params;
    private Path path = new Path();
    private Paint brush = new Paint();

    public PaintView(Context context) {
        super(context);

        brush.setAntiAlias(true);
        brush.setColor(Color.MAGENTA);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeJoin(Paint.Join.ROUND);
        brush.setStrokeWidth(8F);

        params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float PointX = event.getX();
        float PointY = event.getY();

        switch ((event.getAction())) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(PointX, PointY);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(PointX, PointY);
                break;
            default:
                return false;
        }
    postInvalidate();
        return false;

}
protected void onDraw(Canvas canvas){
        canvas.drawPath(path,brush);
}
}

