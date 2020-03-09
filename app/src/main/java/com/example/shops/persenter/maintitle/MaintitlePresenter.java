package com.example.shops.persenter.maintitle;

import com.example.shops.base.BasePersenter;
import com.example.shops.common.CommonSubscriber;
import com.example.shops.interfaces.maintitle.MainTitleConstract;
import com.example.shops.model.HttpManager;
import com.example.shops.model.bean.maintitle.MainTitleBean;
import com.example.shops.utils.RxUtils;

public class MaintitlePresenter extends BasePersenter<MainTitleConstract.View>implements MainTitleConstract.Presenter {
    @Override
    public void getMainTitleData(int page, int size) {
        addSubScribe(HttpManager.getInstance().getShopApi().getMainTitleData(page,size)
        .compose(RxUtils.<MainTitleBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<MainTitleBean>(mView) {
            @Override
            public void onNext(MainTitleBean mainTitleBean) {
                mView.getMainTitleDataReturn(mainTitleBean);
            }
        }));
    }
}
