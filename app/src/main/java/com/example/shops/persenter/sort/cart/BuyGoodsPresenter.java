package com.example.shops.persenter.sort.cart;

import com.example.shops.base.BasePersenter;
import com.example.shops.common.CommonSubscriber;
import com.example.shops.interfaces.goShopping.ShoppingConstract;
import com.example.shops.model.HttpManager;
import com.example.shops.model.bean.shopping.BuyGoodsBean;
import com.example.shops.utils.RxUtils;

public class BuyGoodsPresenter extends BasePersenter<ShoppingConstract.BuyGoodsView> implements ShoppingConstract.BuyGoodsPresenter {
    @Override
    public void getBuygoodsData(int addressId, int couponId) {
        addSubScribe(HttpManager.getInstance().getShopApi().getBuyGoodsData(addressId,couponId)
        .compose(RxUtils.<BuyGoodsBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<BuyGoodsBean>(mView) {
            @Override
            public void onNext(BuyGoodsBean buyGoodsBean) {
                mView.getBuyGoodsReturn(buyGoodsBean);
            }
        }));
    }
}
