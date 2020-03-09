package com.example.shops.persenter.shopping;

import com.example.shops.base.BasePersenter;
import com.example.shops.common.CommonSubscriber;
import com.example.shops.interfaces.goShopping.ShoppingConstract;
import com.example.shops.model.HttpManager;
import com.example.shops.model.bean.shopping.GoShoppingBean;
import com.example.shops.model.bean.shopping.ShoppingAddsBean;
import com.example.shops.utils.RxUtils;

public class ShoppingAddsPresenter extends BasePersenter<ShoppingConstract.ShoppingAddsView>implements ShoppingConstract.ShoppingAddsPresenter {
    @Override
    public void getShoppingAddsData() {
        addSubScribe(HttpManager.getInstance().getShopApi().getShoppingAdds()
                .compose(RxUtils.<ShoppingAddsBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<ShoppingAddsBean>(mView) {
                    @Override
                    public void onNext(ShoppingAddsBean shoppingAddsBean) {
                        mView.getShoppingAddsReturn(shoppingAddsBean);
                    }
                }));
    }
}
