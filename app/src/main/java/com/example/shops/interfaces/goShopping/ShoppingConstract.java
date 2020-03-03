package com.example.shops.interfaces.goShopping;

import com.example.shops.interfaces.IBasePersenter;
import com.example.shops.interfaces.IBaseView;
import com.example.shops.model.bean.GoShoppingBean;

public interface ShoppingConstract {

    interface View extends IBaseView{
        //购物车Fragment界面接口
        void getGoShoppingCartReturn(GoShoppingBean goShoppingBean);
    }
    interface Presenter extends IBasePersenter<View>{
        ////得到购物车Fragment界面数据
        void getGoShoppingCart();
    }

}
