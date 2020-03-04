package com.example.shops.persenter.login;

import com.example.shops.base.BasePersenter;
import com.example.shops.common.CommonSubscriber;
import com.example.shops.interfaces.login.RegistConstract;
import com.example.shops.model.HttpManager;
import com.example.shops.model.bean.login.RegistBean;
import com.example.shops.utils.RxUtils;

public class RegistPresenter extends BasePersenter<RegistConstract.View> implements RegistConstract.Presenter {
    @Override
    public void getRegistData() {
        addSubScribe(HttpManager.getInstance().getShopApi().getRegistVerify()
                .compose(RxUtils.<RegistBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<RegistBean>(mView) {
                    @Override
                    public void onNext(RegistBean registBean) {
                        mView.getRegistReturn(registBean);
                    }
                }));
    }
}
