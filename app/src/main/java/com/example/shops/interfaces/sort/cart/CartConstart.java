package com.example.shops.interfaces.sort.cart;

import com.example.shops.interfaces.IBasePersenter;
import com.example.shops.interfaces.IBaseView;
import com.example.shops.model.bean.sort.cart.JobGoShoppingBean;
import com.example.shops.model.bean.sort.cart.SortDetailItemBean;

//分类里边详情列表购买数据接口
public interface CartConstart {
    interface View extends IBaseView{
        //分类详情购买返回
        void getSortDetailItemDataReturn(SortDetailItemBean sortDetailItemBean);

        //加入到购物车
        void getJobGoShoppingReturn(JobGoShoppingBean jobGoShoppingBean);
    }
    interface  Persenter extends IBasePersenter<View>{
        void getSortDetailItemData(int id);

        void getJobGoShopping(int goodsId,int number,int productId);
    }
}
