package com.example.shops.persenter.shopping;


import com.example.shops.base.BasePersenter;
import com.example.shops.common.CommonSubscriber;
import com.example.shops.interfaces.goShopping.ShoppingConstract;
import com.example.shops.model.HttpManager;
import com.example.shops.model.bean.shopping.CartGoodsCheckedBean;
import com.example.shops.model.bean.shopping.DeleteCartGoodsBean;
import com.example.shops.model.bean.shopping.GoShoppingBean;
import com.example.shops.model.bean.shopping.UpdateCartGoodsBean;
import com.example.shops.utils.RxUtils;

public class GoshoppingPresenter extends BasePersenter<ShoppingConstract.View>implements ShoppingConstract.Presenter {

    @Override
    public void getGoShoppingCart() {
        addSubScribe(HttpManager.getInstance().getShopApi().getGoShopping()
        .compose(RxUtils.<GoShoppingBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<GoShoppingBean>(mView) {
            @Override
            public void onNext(GoShoppingBean goShoppingBean) {
                mView.getGoShoppingCartReturn(goShoppingBean);
            }
        }));
    }

    @Override
    public void setCartGoodsChecked(String pids, int isChecked) {
        addSubScribe(HttpManager.getInstance().getShopApi().getCartGoodsChecked(pids,isChecked)
                .compose(RxUtils.<CartGoodsCheckedBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<CartGoodsCheckedBean>(mView) {
                    @Override
                    public void onNext(CartGoodsCheckedBean cartGoodsCheckedBean) {
                        mView.setCartGoodsCheckedReturn(cartGoodsCheckedBean);
                    }
                }));
    }

    @Override
    public void updateCartGoods(String pids, String goodsid, int num, int id) {
        addSubScribe(HttpManager.getInstance().getShopApi().updateCartGoods(pids,goodsid,num,id)
                .compose(RxUtils.<UpdateCartGoodsBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<UpdateCartGoodsBean>(mView) {
                    @Override
                    public void onNext(UpdateCartGoodsBean updateCartGoodsBean) {
                        mView.updateCartGoodsReturn(updateCartGoodsBean);
                    }
                }));
    }

    @Override
    public void deleteCartGoods(String productIds) {
        addSubScribe(HttpManager.getInstance().getShopApi().deleteCartGoods(productIds)
                .compose(RxUtils.<DeleteCartGoodsBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<DeleteCartGoodsBean>(mView) {
                    @Override
                    public void onNext(DeleteCartGoodsBean deleteCartGoodsBean) {
                        mView.deleteCartGoodsReturn(deleteCartGoodsBean);
                    }
                }));
    }
}