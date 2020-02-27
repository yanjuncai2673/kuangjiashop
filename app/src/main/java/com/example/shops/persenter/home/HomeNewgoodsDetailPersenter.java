package com.example.shops.persenter.home;

import com.example.shops.base.BasePersenter;
import com.example.shops.common.CommonSubscriber;
import com.example.shops.interfaces.home.HomeNewgoodsDetailConstract;
import com.example.shops.model.HttpManager;
import com.example.shops.model.bean.home.HomeNewGoodsDetailBean;
import com.example.shops.utils.RxUtils;

public class HomeNewgoodsDetailPersenter extends BasePersenter<HomeNewgoodsDetailConstract.View>implements HomeNewgoodsDetailConstract.Persenter {
    @Override
    public void getHomeNewgoodsDetailData(int id) {
        addSubScribe(HttpManager.getInstance().getShopApi().getHomeNewgoodsDetailData(id)
        .compose(RxUtils.<HomeNewGoodsDetailBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<HomeNewGoodsDetailBean>(mView) {

            @Override
            public void onNext(HomeNewGoodsDetailBean homeNewGoodsDetailBean) {
                mView.getHomeNewgoddsDetailReturn(homeNewGoodsDetailBean);
            }
        }));
    }
}
