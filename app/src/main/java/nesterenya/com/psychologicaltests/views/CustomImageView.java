package nesterenya.com.psychologicaltests.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import nesterenya.com.psychologicaltests.R;

public class CustomImageView extends ImageView {

    public CustomImageView(Context context) {
        super(context);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private int mScaleX = 0;
    private int mScaleY = 0;
    private boolean isResult = false;

    public void showResult(int scaleX, int scaleY) {
        mScaleX = scaleX;
        mScaleY = scaleY;
        isResult = true;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        this.setMeasuredDimension(parentWidth, parentHeight);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private final static int COUNT_POSITION = 24;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(isResult) {
            Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mTextPaint.setColor(0XFFFF0000);

            /*числа 0,1 и 0,8 подобраны эксперементально для данной картинки*/
            float Lx = this.getWidth()*0.1f;
            float stepX = this.getWidth()*0.8f / COUNT_POSITION;
            float Ly = this.getHeight()*0.1f;
            float stepY = this.getHeight()*0.8f / COUNT_POSITION;

            float x = Lx+mScaleX*stepX;
            float y = Ly+(COUNT_POSITION-mScaleY)*stepY;

            canvas.drawCircle(x, y, 20, mTextPaint);
        }
    }
}
