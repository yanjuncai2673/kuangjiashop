package com.example.shops.persenter.home;

import com.example.shops.base.BasePersenter;
import com.example.shops.common.CommonSubscriber;
import com.example.shops.interfaces.home.BrandConstract;
import com.example.shops.model.HttpManager;
import com.example.shops.model.bean.home.BrandBean;
import com.example.shops.model.bean.home.BrandGoodsBean;
import com.example.shops.utils.RxUtils;

public class BrandPersenter extends BasePersenter<BrandConstract.View> implements BrandConstract.Persenter {

    @Override
    public void getBrandInfo(String s) {
        addSubScribe(HttpManager.getInstance().getShopApi().getBrandInfo(s)
                .compose(RxUtils.<BrandBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<BrandBean>(mView){

                    @Override
                    public void onNext(BrandBean brandBean) {
                        mView.getHomeBrandDataReturn(brandBean);
                    }
                }));
    }

    @Override
    public void getBrandGoodsList(String brandId, int page, int size) {
        addSubScribe(HttpManager.getInstance().getShopApi().getBrandGoods(brandId,page,size)
                .compose(RxUtils.<BrandGoodsBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<BrandGoodsBean>(mView){

                    @Override
                    public void onNext(BrandGoodsBean brandGoodsBean) {
                        mView.getHomeBrandGoodsReturn(brandGoodsBean);
                    }
                }));

    }
}
