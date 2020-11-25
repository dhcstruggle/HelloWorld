package helloworld.bankservicedemo.actions.impl;

import android.os.Binder;
import android.util.Log;

import helloworld.bankservicedemo.actions.interfaces.IBankBossAction;

public class BankBossActionImpl extends Binder implements IBankBossAction {

    private static final String TAG = BankBossActionImpl.class.getName();
    @Override
    public void modifyUserAccountMoney(float money) {
        Log.d(TAG, "modifyUserAccountMoney --> " + money);
    }

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
