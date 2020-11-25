package helloworld.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.helloworld.R;

public class CustomDialog extends Dialog implements View.OnClickListener {

    private TextView mTvTitle,mTvMesg,mTvOK,mTvCancel;

    private String title,msg,cancel,ok;

    private IOnCancelListener cancelListener;
    private IOnOKListener OKListener;

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeID) {
        super(context,themeID);
    }

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public CustomDialog setCancel(String cancel, IOnCancelListener cancelListener) {
        this.cancel = cancel;
        this.cancelListener = cancelListener;
        return this;
    }

    public CustomDialog setOk(String ok, IOnOKListener onOKListener) {
        this.ok = ok;
        this.OKListener = onOKListener;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);

        //设置宽度
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size = new Point();
        d.getSize(size);
        p.width = (int) (size.x * 0.8);
        getWindow().setAttributes(p);

        mTvTitle = findViewById(R.id.tv_title);
        mTvMesg = findViewById(R.id.tv_msg);
        mTvOK = findViewById(R.id.tv_OK);
        mTvCancel = findViewById(R.id.tv_Cancel);

        if (!TextUtils.isEmpty(title)){
            mTvTitle.setText(title);
        }

        if (!TextUtils.isEmpty(msg)){
            mTvMesg.setText(msg);
        }

        if (!TextUtils.isEmpty(cancel)){
            mTvCancel.setText(cancel);
        }

        if (!TextUtils.isEmpty(ok)){
            mTvOK.setText(ok);
        }

        mTvOK.setOnClickListener(this);
        mTvCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.tv_OK:
                if (OKListener != null){
                    OKListener.onOK(this);
                }
                dismiss();
                break;
            case R.id.tv_Cancel:
                if (cancelListener != null){
                    cancelListener.onCancel(this);
                }
                dismiss();
                break;
            default:
                break;
        }

    }

    public interface IOnCancelListener{
        void onCancel(CustomDialog dg);
    }

    public interface IOnOKListener{
        void onOK(CustomDialog dg);
    }
}
