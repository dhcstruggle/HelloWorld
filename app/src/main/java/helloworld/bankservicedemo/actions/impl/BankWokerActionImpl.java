package helloworld.bankservicedemo.actions.impl;

import android.os.Binder;
import android.util.Log;

import helloworld.bankservicedemo.actions.interfaces.IBankWorkerAction;

public class BankWokerActionImpl extends Binder implements IBankWorkerAction {
    private static final String TAG = BankWokerActionImpl.class.getName();

    @Override
    public void checkUserCredit() {
        Log.d(TAG, "checkUserCredit --> 780");
    }

    @Override
    public void freezeUserAccount() {
        Log.d(TAG, "freezeUserAccount --> 0");
    }

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
