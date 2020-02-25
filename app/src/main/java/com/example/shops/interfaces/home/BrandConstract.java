package com.example.shops.interfaces.home;

import com.example.shops.interfaces.IBasePersenter;
import com.example.shops.interfaces.IBaseView;
import com.example.shops.model.bean.home.BrandBean;
import com.example.shops.model.bean.home.BrandGoodsBean;
import com.example.shops.model.bean.home.HomeBrandMadeBean;
import com.example.shops.ui.home.activity.HomeBrandMadeActivity;

//首页品牌接口
public interface BrandConstract {
    interface View extends IBaseView{
        //获取首页品牌详情数据返回
        void getHomeBrandDataReturn(BrandBean brandBean);
        //品牌详情页商品数据返回
        void getHomeBrandGoodsReturn(BrandGoodsBean brandGoodsBean);

    }

    interface Persenter extends IBasePersenter<View>{
        //获取品牌页数据
        void getBrandInfo(String s);
        //品牌详情列表
        void getBrandGoodsList(String brandId,int page,int size);

    }
}
