package helloworld;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

import helloworld.util.ToastUtil;
import helloworld.util.Utils;

public class MyTestActivity extends AppCompatActivity {

    private TextView mTvSdk;
    private Handler mHandler;
    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_test);

        mTvSdk = findViewById(R.id.tv_sdk);
        mTvSdk.setText("");

//        //获取设备的CPU厂商信息
//        String osPlatform = null;
//        ShellUtils.CommandResult result = ShellUtils.execCommand("getprop|grep ro.board.platform", false);
//        String[] strResult = result.successMsg.split(":");
//        if (strResult.length > 1) {
//            osPlatform = strResult[1];
//            osPlatform = osPlatform.substring(2, osPlatform.length() - 1);
//        }
//        mTvSdk.append(osPlatform);
//        mTvSdk.append("\n");
//
//        //获取SDK版本信息
//        String osSDK = android.os.Build.VERSION.SDK;
//        mTvSdk.append(osSDK);
//        mTvSdk.append("\n");
//
//        //获取外部存储路径
//        String ExternalStorageDirectory = Environment.getExternalStorageDirectory().getAbsolutePath();
//        mTvSdk.append(ExternalStorageDirectory);
//        mTvSdk.append("\n");
//
//        //获取内部存储路径
//        String StorageDirectory = Environment.getStorageDirectory().getAbsolutePath();
//        mTvSdk.append(StorageDirectory);
//        mTvSdk.append("\n");
//
//        //获取内部存储路径
//        String DataDirectory = Environment.getDataDirectory().getAbsolutePath();
//        mTvSdk.append(DataDirectory);
//        mTvSdk.append("\n");
//
//        //文件存储路径
//        String FilesDir = getFilesDir().getAbsolutePath();
//        mTvSdk.append(FilesDir);
//        mTvSdk.append("\n");

        mHandler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 1:
                        ToastUtil.showMsg(MyTestActivity.this, "Telnet 端口未打开");
                        break;
                    case 2:
                        ToastUtil.showMsg(MyTestActivity.this, "Telnet 端口已打开");
                        break;
                }

            }
        };

        new Thread(){
            @Override
            public void run() {
                Message message = new Message();

                if (Utils.isHostConnectable(23)){
                    message.what = 2;
                }else{
                    message.what = 1;
                }
                mHandler.sendMessage(message);
            }
        }.start();
    }
}