package com.example.shops.interfaces.goShopping;

import com.example.shops.interfaces.IBasePersenter;
import com.example.shops.interfaces.IBaseView;
import com.example.shops.model.bean.shopping.CartGoodsCheckedBean;
import com.example.shops.model.bean.shopping.DeleteCartGoodsBean;
import com.example.shops.model.bean.shopping.GoShoppingBean;
import com.example.shops.model.bean.shopping.UpdateCartGoodsBean;

public interface ShoppingConstract {

    interface View extends IBaseView{
        //购物车Fragment界面接口
        void getGoShoppingCartReturn(GoShoppingBean goShoppingBean);

        //设置购物车商品数据选中状态的返回
        void setCartGoodsCheckedReturn(CartGoodsCheckedBean cartGoodsCheckedReturn);

        //更新购物车列表商品数据返回
        void updateCartGoodsReturn(UpdateCartGoodsBean updateCartGoodsBean);

        //删除购物车列表数据返回接口
        void deleteCartGoodsReturn(DeleteCartGoodsBean deleteCartGoodsBean);
    }
    interface Presenter extends IBasePersenter<View>{
        ////得到购物车Fragment界面数据
        void getGoShoppingCart();

        //设置购物车选中商品数据
        void setCartGoodsChecked(String pids,int isChecked);

        //获取购物车更新数据
        void updateCartGoods(String pids,String goodsid,int num,int id);

        //购物车删除数据
        void deleteCartGoods(String productIds);
    }

}
