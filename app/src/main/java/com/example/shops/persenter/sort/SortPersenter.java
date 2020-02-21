package com.example.shops.persenter.sort;

import com.example.shops.base.BasePersenter;
import com.example.shops.common.CommonSubscriber;
import com.example.shops.interfaces.sort.SortConstract;
import com.example.shops.model.HttpManager;
import com.example.shops.model.bean.sort.SortDataBean;
import com.example.shops.model.bean.sort.SortGoodsListBean;
import com.example.shops.utils.RxUtils;
//获取数据并返回view层
public class SortPersenter extends BasePersenter<SortConstract.View>implements SortConstract.Persenter {
    @Override
    public void getSortDatas() {//获取分类数据
        addSubScribe(HttpManager.getInstance().getShopApi().getSortData()
        .compose(RxUtils.<SortDataBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<SortDataBean>(mView) {
            @Override
            public void onNext(SortDataBean sortDataBean) {
                mView.getSortDataReturn(sortDataBean);
            }
        }));
    }

    @Override//分类列表数据
    public void getSortGoodsList(int id) {
        addSubScribe(HttpManager.getInstance().getShopApi().getSortGoodsList(id)
            .compose(RxUtils.<SortGoodsListBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<SortGoodsListBean>(mView) {
            @Override
            public void onNext(SortGoodsListBean sortGoodsListBean) {
                mView.getSortGoodsListReturn(sortGoodsListBean);
            }
        }));
    }
}
