package com.example.shops.persenter.home;

import com.example.shops.base.BasePersenter;
import com.example.shops.common.CommonSubscriber;
import com.example.shops.interfaces.home.BrandMadeConstract;
import com.example.shops.model.HttpManager;
import com.example.shops.model.bean.home.HomeBrandMadeBean;
import com.example.shops.utils.RxUtils;

public class HomeBrandMadePersenter extends BasePersenter<BrandMadeConstract.View>implements BrandMadeConstract.Persenter {
    @Override
    public void getHomeBrandMadeData(int page, int size) {
        addSubScribe(HttpManager.getInstance().getShopApi().getHomeBrandMadeData(page,size)
        .compose(RxUtils.<HomeBrandMadeBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<HomeBrandMadeBean>(mView) {
            @Override
            public void onNext(HomeBrandMadeBean homeBrandMadeBean) {
                mView.getHomeBrandMadeReturn(homeBrandMadeBean);
            }
        }));
    }
}
