package helloworld.bankservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;

import helloworld.bankservicedemo.actions.impl.BankBossActionImpl;
import helloworld.bankservicedemo.actions.impl.BankWokerActionImpl;
import helloworld.bankservicedemo.actions.impl.NormalUserAIDLActionImpl;

public class BankService extends Service {
    public BankService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        String action = intent.getAction();
        if (!TextUtils.isEmpty(action)) {
            if ("com.chaos.ACTION_NORMAL_USER".equals(action)) {
                return new NormalUserAIDLActionImpl();
            }else if ("com.chaos.ACTION_BANK_WORKER".equals(action)) {
                return new BankWokerActionImpl();
            }else if ("com.chaos.ACTION_BANK_BOSS".equals(action)) {
                return new BankBossActionImpl();
            }
        }
        return null;
    }
}



//ctrl + shift + u  转换选中的大小写