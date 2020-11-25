package helloworld.bankservicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.NormalUserAction;
import com.example.helloworld.R;

public class NormalUserActivity extends AppCompatActivity {

    private static final String TAG = NormalUserActivity.class.getName();
    private NormalUserCoonnect mNormalUserCoonnect;
    private NormalUserAction mNormalUserAction;
    private boolean mIsbinded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_user);
        doBindService();
    }

    private void doBindService() {
        Log.d(TAG, "doBindService.....");
        Intent intent = new Intent();
        intent.setAction("com.chaos.ACTION_NORMAL_USER");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setPackage(this.getPackageName());
        mNormalUserCoonnect = new NormalUserCoonnect();
        mIsbinded = bindService(intent, mNormalUserCoonnect, BIND_AUTO_CREATE);
    }

    private class NormalUserCoonnect implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(TAG, "onServiceConnected.....");
            mNormalUserAction = NormalUserAction.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(TAG, "onServiceDisconnected.....");
        }
    }

    public void saveMoneyClick(View v){
        Log.d(TAG, "saveMoneyClick.....");
        try {
            mNormalUserAction.saveMoney(1000);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void getMoneyClick(View v){
        try {
            Log.d(TAG, "getMoneyClick....." + mNormalUserAction.getMoney());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void loanMoneyClick(View v){
        try {
            Log.d(TAG, "loanMoneyClick....." + mNormalUserAction.loanMoney());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mIsbinded && mNormalUserCoonnect != null) {
            Log.d(TAG, "unbind service.....");
            unbindService(mNormalUserCoonnect);
            mNormalUserCoonnect = null;
            mIsbinded = false;
        }
    }
}