package helloworld.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import helloworld.interfaces.ICommunication;
import helloworld.util.ToastUtil;

public class FirstService extends Service{

    private static final String TAG = FirstService.class.getName();


    public FirstService() {
    }

    private class InnerBinder extends Binder  implements ICommunication {
        public void callServiceInnerMethod(){
            sayHello();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind....");
        return new InnerBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate....");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand....");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy....");
    }

    private void sayHello(){
        ToastUtil.showMsg(this,"Hello....");
    }
}
