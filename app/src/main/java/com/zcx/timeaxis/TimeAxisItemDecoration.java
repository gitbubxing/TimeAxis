package com.zcx.timeaxis;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

/**
 *  Administrator on 2017/8/5.
 */

public class TimeAxisItemDecoration extends RecyclerView.ItemDecoration {
    private Paint paint;
    //绘制文字使用的画笔
    private Paint textPaint;
    //原点距离左边的距离
    private int circleLeft;
    //圆点距离上边的高度
    private int circleTop;
    //圆点的半径
    private int circleRadius;
    //远点距离右边文字的距离
    private int margin;
  //连接线的宽度
    private int lineWidth=3;
    private boolean isFirst;
    private List<TimeState>times;

    public  TimeAxisItemDecoration(List<TimeState>times){
        this.times= times;
        paint= new Paint();
        textPaint= new Paint();
        textPaint.setTextSize(30.0f);
        paint.setColor(Color.RED);
        //抗锯齿
        paint.setAntiAlias(true);
        textPaint.setAntiAlias(true);
        circleLeft= 200;
        circleTop= 200;
        circleRadius= 20;
        margin= 10;


    }
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int count = parent.getChildCount();
        for (int i = 0; i <count ; i++) {
            if ( i ==0){
                paint.setColor(Color.RED);
                textPaint.setColor(Color.RED);
            }else {
                paint.setColor(Color.GRAY);
                textPaint.setColor(Color.GRAY);
            }
              View view=  parent.getChildAt(i);
            // 轴点 = 圆 = 圆心(x,y)
            float centerx = view.getLeft()-circleRadius-margin ;
            float centery = view.getTop()+view.getHeight()/3 ;
            // 绘制轴点圆
            c.drawCircle(centerx, centery, circleRadius, paint);

            //绘制左边的时间
           TimeState timeState=  times.get(i);
            c.drawText(timeState.getTime(),margin,centery,textPaint);
            c.drawText(timeState.getDetialTime(),margin-5,centery+30,textPaint);
            if (i < count-1){//第一条状态不绘制连接线

                //绘制上下连接线
                Rect rect= new Rect();
                //位置：左边为圆点的中心点，起始点为圆点的中心
                rect.set((int) centerx,view.getTop()+circleRadius,(int)centerx+lineWidth,view.getBottom()+circleTop+view.getHeight()/3);
                c.drawRect(rect,paint);
            }


        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //设置所需要绘制的内容区域

        if (isFirst){
            //这里我添加了一个boolean 变量来区分是否是最新的一条状态，如果是则不显示顶部空白区域，如果有其他的方法还请大家指教
            outRect.set(circleLeft,circleTop,0,0);
        }else {
            outRect.set(circleLeft,0,0,0);
            isFirst=true;
        }
    }

}
