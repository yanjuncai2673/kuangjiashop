package com.example.shops.persenter.login;

import com.example.shops.base.BasePersenter;
import com.example.shops.common.CommonSubscriber;
import com.example.shops.interfaces.login.LoginConstract;
import com.example.shops.model.HttpManager;
import com.example.shops.model.bean.login.UserLoginBean;
import com.example.shops.utils.RxUtils;

public class LoginPresenter extends BasePersenter<LoginConstract.View> implements LoginConstract.Presenter {
    @Override
    public void getLoginData(String username, String password) {
        addSubScribe(HttpManager.getInstance().getShopApi().getLogin(username, password)
                .compose(RxUtils.<UserLoginBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<UserLoginBean>(mView) {
                    @Override
                    public void onNext(UserLoginBean userLoginBean) {
                        if (userLoginBean.getErrno() == 0) {
                            mView.getLoginReturn(userLoginBean);
                        }else {
                            mView.showMes(userLoginBean.getErrmsg());
                        }
                    }
                }));
    }
}
