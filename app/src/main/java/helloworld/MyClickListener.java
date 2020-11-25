package helloworld;

import android.app.Activity;
import android.view.View;

import helloworld.util.ToastUtil;

public class MyClickListener implements View.OnClickListener {

    private Activity mActivity;
    public MyClickListener(Activity activity){
        this.mActivity = activity;
    }
    @Override
    public void onClick(View view) {
        ToastUtil.showMsg(mActivity, "外部实现方法实现");
    }
}
