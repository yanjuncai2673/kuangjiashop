package com.example.shops.persenter.sort;

import com.example.shops.base.BasePersenter;
import com.example.shops.common.CommonSubscriber;
import com.example.shops.interfaces.sort.SortConstract;
import com.example.shops.model.HttpManager;
import com.example.shops.model.bean.sort.SortDetailDataBean;
import com.example.shops.model.bean.sort.SortDetailTabBean;
import com.example.shops.utils.RxUtils;

public class SortDetailPersenter extends BasePersenter<SortConstract.SortDetailView> implements SortConstract.SortDetailPersenter {
    @Override
    public void getSortDetailTabDatas(int id) {
        addSubScribe(HttpManager.getInstance().getShopApi().getSortDetailTabDatas(id)
        .compose(RxUtils.<SortDetailTabBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<SortDetailTabBean>(mView) {
            @Override
            public void onNext(SortDetailTabBean sortDetailTabBean) {
                mView.getSortDetailTabReturn(sortDetailTabBean);
            }
        }));
    }

    @Override
    public void getSortDetailDatas(int catagoryId, int page, int size) {
        addSubScribe(HttpManager.getInstance().getShopApi().getSortDetailDatas(catagoryId,page,size)
                .compose(RxUtils.<SortDetailDataBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<SortDetailDataBean>(mView) {
                    @Override
                    public void onNext(SortDetailDataBean sortDetailDataBean) {
                        mView.getSortDetailDataReturn(sortDetailDataBean);
                    }
                }));
    }


}
