package helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.example.helloworld.R;

import helloworld.interfaces.ICommunication;
import helloworld.services.FirstService;

public class ServiceActivity extends AppCompatActivity {

    private static final String TAG = ServiceActivity.class.getName();
    private boolean mIsServiceBinded;
    private ICommunication mICommunication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        Log.d(TAG, "onCreate.....");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy.....");
        super.onDestroy();
    }

    public void StartService(View v){
        Log.d(TAG, "StartService.....");
        Intent intent = new Intent();
        intent.setClass(this, FirstService.class);
        startService(intent);
    }

    public void StopService(View v){
        Log.d(TAG, "StopService.....");
        Intent intent = new Intent();
        intent.setClass(this, FirstService.class);
        stopService(intent);
    }

    public void CallServiceMethod(View v){
        Log.d(TAG, "CallServiceMethod.....");
        mICommunication.callServiceInnerMethod();
    }

    private ServiceConnection mConnect = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(TAG, "onServiceConnected.....");
            mICommunication = (ICommunication) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(TAG, "onServiceDisconnected.....");
            mICommunication = null;
        }
    };

    public void BindService(View v){
        Log.d(TAG, "BindService.....");
        Intent intent = new Intent();
        intent.setClass(this, FirstService.class);
        //选中需要变成成员的变量，ctr+alt+f
        mIsServiceBinded = bindService(intent, mConnect, BIND_AUTO_CREATE);
    }

    public void unBandService(View v){
        Log.d(TAG, "unBindService.....");

        if (mConnect != null){
            unbindService(mConnect);
        }
    }
}