package com.example.shops.interfaces.home;

import com.example.shops.interfaces.IBasePersenter;
import com.example.shops.interfaces.IBaseView;
import com.example.shops.model.bean.home.HomeNewGoodsDetailBean;

//定义接口类 （首页新品 居家等详情）
public interface HomeNewgoodsDetailConstract {

    interface View extends IBaseView{
        void getHomeNewgoddsDetailReturn(HomeNewGoodsDetailBean homeNewGoodsDetailBean);
    }

    interface Persenter extends IBasePersenter<View>{
        void getHomeNewgoodsDetailData(int id);
    }
}
