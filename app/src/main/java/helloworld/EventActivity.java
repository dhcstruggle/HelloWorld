package helloworld;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

import helloworld.util.ToastUtil;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnInside,mBtnInsideNoname,mBtnSource,mBtnOutside,mBtnXML,mBtnMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        mBtnInside = findViewById(R.id.btn_inside);
        //内部类实现
        mBtnInside.setOnClickListener(new OnClick());

        mBtnInsideNoname = findViewById(R.id.btn_inside_noname);
        //匿名内部类实现
        mBtnInsideNoname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showMsg(EventActivity.this, "匿名内部类实现");
            }
        });

        mBtnSource = findViewById(R.id.btn_source);
        //通过事件源所在类实现
        mBtnSource.setOnClickListener(EventActivity.this);

        mBtnOutside = findViewById(R.id.btn_ouside);
        //通过外部类实现
        mBtnOutside.setOnClickListener(new MyClickListener(EventActivity.this));


        mBtnXML = findViewById(R.id.btn_xml);

        mBtnMy = findViewById(R.id.btn_my);
        //监听器优先调用
        mBtnMy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Listenner", "--onTouch--");
                        break;
                }
                return false;
            }
        });

        mBtnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Listenner", "--onClick--");
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_source:
                ToastUtil.showMsg(EventActivity.this, "事件源所在类实现");
                break;
        }
    }

    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_inside:
                    ToastUtil.showMsg(EventActivity.this, "内部类实现");
                    break;
            }
        }
    }
    public void xmlshow(View v){
        ToastUtil.showMsg(EventActivity.this, "XML方法实现");
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("Event Activity", "--onTouchEvent--");
                ToastUtil.showMsg(this, "Event Activity --onTouchEvent--");
                break;
        }
        return false;
    }
}