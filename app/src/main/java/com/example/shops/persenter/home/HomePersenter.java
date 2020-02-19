package com.example.shops.persenter.home;

import com.example.shops.base.BasePersenter;
import com.example.shops.common.CommonSubscriber;
import com.example.shops.interfaces.home.HomeConstract;
import com.example.shops.model.HttpManager;
import com.example.shops.model.bean.home.HomeIndexBean;
import com.example.shops.utils.RxUtils;

public class HomePersenter extends BasePersenter<HomeConstract.View> implements HomeConstract.Persenter {
    @Override
    //获取首页数据
    public void getHomeData() {
        addSubScribe(HttpManager.getInstance().getShopApi().getIndexData()
        .compose(RxUtils.<HomeIndexBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<HomeIndexBean>(mView) {
            @Override
            public void onNext(HomeIndexBean homeIndexBean) {
                mView.getHomeDataReturn(homeIndexBean);
            }
        }));
    }
}
