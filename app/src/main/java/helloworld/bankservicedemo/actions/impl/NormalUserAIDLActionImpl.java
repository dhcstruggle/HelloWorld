package helloworld.bankservicedemo.actions.impl;

import android.os.RemoteException;
import android.util.Log;

import com.example.helloworld.NormalUserAction;

public class NormalUserAIDLActionImpl extends NormalUserAction.Stub {
    private static final String TAG = NormalUserAIDLActionImpl.class.getName();
    @Override
    public void saveMoney(float money) {
        Log.d(TAG, "saveMoney --> " + money);
    }

    @Override
    public float getMoney() {
        Log.d(TAG, "getMoney --> 100");
        return 100.00f;
    }

    @Override
    public float loanMoney() throws RemoteException {
        Log.d(TAG, "loanMoney --> 100");
        return 100.00f;
    }
}
