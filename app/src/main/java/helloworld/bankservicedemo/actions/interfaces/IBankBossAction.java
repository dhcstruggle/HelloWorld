package helloworld.bankservicedemo.actions.interfaces;

public interface IBankBossAction extends IBankWorkerAction {
    //修改用户金额
    void modifyUserAccountMoney(float money);
}
