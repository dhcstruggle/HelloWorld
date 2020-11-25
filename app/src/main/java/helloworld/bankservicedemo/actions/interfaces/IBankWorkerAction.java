package helloworld.bankservicedemo.actions.interfaces;

public interface IBankWorkerAction extends INormalUserAction {
    //获取用户信用
    void checkUserCredit();

    //冻结用户账户
    void freezeUserAccount();

}
