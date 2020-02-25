package com.example.shops.interfaces.home;

import com.example.shops.interfaces.IBasePersenter;
import com.example.shops.interfaces.IBaseView;
import com.example.shops.model.bean.home.HomeBrandMadeBean;

public interface BrandMadeConstract {
    interface View extends IBaseView{
        //获取首页品牌制造商列表返回
        void getHomeBrandMadeReturn(HomeBrandMadeBean homeBrandMadeBean);

    }
    interface Persenter extends IBasePersenter<View>{
        //获取首页品牌制造商列表数据
        void getHomeBrandMadeData(int page,int size);
    }
}
