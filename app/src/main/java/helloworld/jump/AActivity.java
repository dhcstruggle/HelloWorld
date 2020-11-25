package helloworld.jump;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;
import helloworld.util.ToastUtil;

public class AActivity extends AppCompatActivity {

    private Button mBtnJumpB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        Log.d("OnCreate", "Start...");
        Log.d("AActivity", "taskid:" + getTaskId() + ", hash" + hashCode());
        logtaskName();

        mBtnJumpB = findViewById(R.id.btn_a_jump);
        mBtnJumpB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                //显式1
//                Intent intent = new Intent(AActivity.this, BActivity.class);
//                startActivity(intent);

                //显式2
//                Intent intent = new Intent();
//                intent.setClass(AActivity.this, BActivity.class);
//                startActivity(intent);

//                //显式3
//                Intent intent = new Intent();
//                intent.setClassName(AActivity.this,"com.example.helloworld.jump.BActivity");
//                startActivity(intent);

//                //显式4
//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this, "com.example.helloworld.jump.BActivity"));
//                startActivity(intent);

//                //隐式1
//                Intent intent = new Intent();
//                intent.setAction("com.example.helloworld.test.BActivity");
//                startActivity(intent);


                //数据传递
                Intent intent = new Intent(AActivity.this, BActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", "chaos");
                bundle.putInt("num", 66);
                intent.putExtras(bundle);
                //startActivity(intent);
                startActivityForResult(intent, 0);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ToastUtil.showMsg(AActivity.this, data.getExtras().getString("title"));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("onNewIntent", "Start...");
        Log.d(Thread.currentThread().getStackTrace()[2].getMethodName(), "taskid:" + getTaskId() + ", hash" + hashCode());
        logtaskName();
    }

    private void logtaskName(){
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("A logtaskName", info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}