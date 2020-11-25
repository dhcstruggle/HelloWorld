package helloworld.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class MyButton extends androidx.appcompat.widget.AppCompatButton {

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
//        Log.d("MyButton", "--dispatchTouchEvent-- ");
//        return super.dispatchTouchEvent(event);
//    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("My Button", "My--onTouchEvent--");
                //ToastUtil.showMsg(mActivity, "My--onTouchEvent--");
                break;
        }

        return super.onTouchEvent(event);

        //继续往外传播
        //return false;

        //这边已经消费掉了
        //return true;

    }
}
