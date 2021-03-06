package com.example.shops.persenter.sort.cart;

import com.example.shops.base.BasePersenter;
import com.example.shops.common.CommonSubscriber;
import com.example.shops.interfaces.sort.cart.CartConstart;
import com.example.shops.model.HttpManager;
import com.example.shops.model.bean.sort.cart.JobGoShoppingBean;
import com.example.shops.model.bean.sort.cart.SortDetailItemBean;
import com.example.shops.utils.RxUtils;

public class CartPersenter extends BasePersenter<CartConstart.View>implements CartConstart.Persenter {
    @Override
    public void getSortDetailItemData(int id) {
        addSubScribe(HttpManager.getInstance().getShopApi().getSortDetailItemData(id)
        .compose(RxUtils.<SortDetailItemBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<SortDetailItemBean>(mView) {
            @Override
            public void onNext(SortDetailItemBean sortDetailItemBean) {
                mView.getSortDetailItemDataReturn(sortDetailItemBean);
            }
        }));
    }

    @Override
    public void getJobGoShopping(int goodsId, int number, int productId) {
        addSubScribe(HttpManager.getInstance().getShopApi().getJobGoShopping(goodsId,number,productId)
                .compose(RxUtils.<JobGoShoppingBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<JobGoShoppingBean>(mView) {
                    @Override
                    public void onNext(JobGoShoppingBean jobGoShoppingBean) {
                        mView.getJobGoShoppingReturn(jobGoShoppingBean);
                    }
                }));
    }

}
