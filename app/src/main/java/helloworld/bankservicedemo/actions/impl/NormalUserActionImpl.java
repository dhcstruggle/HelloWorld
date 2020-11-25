package helloworld.bankservicedemo.actions.impl;

import android.os.Binder;
import android.util.Log;

import helloworld.bankservicedemo.actions.interfaces.INormalUserAction;

public class NormalUserActionImpl extends Binder implements INormalUserAction {

    private static final String TAG = NormalUserActionImpl.class.getName();

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
    public float loanMoney() {
        Log.d(TAG, "loanMoney --> 100");
        return 100.00f;
    }
}
