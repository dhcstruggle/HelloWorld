// IMyAidlInterface.aidl
package com.example.helloworld;

// Declare any non-default types here with import statements

interface NormalUserAction {

    void saveMoney(in float money);
    float getMoney();
    float loanMoney();
}
