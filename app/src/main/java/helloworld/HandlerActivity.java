package helloworld;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

import helloworld.util.ToastUtil;

public class HandlerActivity extends AppCompatActivity {

    private final Handler mHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    ToastUtil.showMsg(HandlerActivity.this, "线程通信成功1");
                    break;
                case 2:
                    ToastUtil.showMsg(HandlerActivity.this, "线程通信成功2");
                    break;
                default:
                    break;
            }

        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        new Thread(){
            @Override
            public void run() {
                super.run();
                Message message = new Message();
                message.what = 1;
                mHandler.sendMessage(message);
                mHandler.sendEmptyMessageDelayed(2, 2000);
            }
        }.start();

    }
}