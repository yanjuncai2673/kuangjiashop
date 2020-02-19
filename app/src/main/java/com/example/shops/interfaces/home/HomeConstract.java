package com.example.shops.interfaces.home;

import com.example.shops.interfaces.IBasePersenter;
import com.example.shops.interfaces.IBaseView;
import com.example.shops.model.bean.HomeIndexBean;

//首页接口契约类
public interface HomeConstract {
    interface View extends IBaseView{
        //首页数据返回
        void getHomeDataReturn(HomeIndexBean indexbean);
    }
    interface  Persenter extends IBasePersenter<View>{
        void getHomeData();
    }
}
