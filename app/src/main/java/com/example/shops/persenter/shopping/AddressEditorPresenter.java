package com.example.shops.persenter.shopping;

import com.example.shops.base.BasePersenter;
import com.example.shops.common.CommonSubscriber;
import com.example.shops.interfaces.goShopping.ShoppingConstract;
import com.example.shops.model.HttpManager;
import com.example.shops.model.bean.shopping.AddressEditorBean;
import com.example.shops.model.bean.shopping.DetailAddsBean;
import com.example.shops.utils.RxUtils;

import java.util.Map;

public class AddressEditorPresenter extends BasePersenter<ShoppingConstract.AddressEditorView>implements ShoppingConstract.AddressEditorPresenter {

    @Override
    public void getAddressEditorData(Map map) {
        addSubScribe(HttpManager.getInstance().getShopApi().saveAddress(map)
        .compose(RxUtils.<AddressEditorBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<AddressEditorBean>(mView) {
            @Override
            public void onNext(AddressEditorBean addressEditorBean) {
                mView.getAddressEditorReturn(addressEditorBean);
            }
        }));
    }

    @Override
    public void getDetailAddsData(int parentId) {
        addSubScribe(HttpManager.getInstance().getShopApi().getDetailAdds(parentId)
                .compose(RxUtils.<DetailAddsBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<DetailAddsBean>(mView) {
                    @Override
                    public void onNext(DetailAddsBean detailAddsBean) {
                        mView.getDetailAddsReturn(detailAddsBean);
                    }
                }));
    }
}
