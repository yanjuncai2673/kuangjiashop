package com.example.shops.ui.goShopping;

import com.example.shops.R;
import com.example.shops.base.BaseFragment;
import com.example.shops.interfaces.IBasePersenter;
import com.example.shops.interfaces.goShopping.ShoppingConstract;
import com.example.shops.model.bean.GoShoppingBean;

public class GoShoppingFragment extends BaseFragment<ShoppingConstract.Presenter>implements ShoppingConstract.View {
    @Override
    protected int getLayout() {
        return R.layout.fragment_shopping;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected ShoppingConstract.Presenter createPersenter() {
        return null;
    }


    @Override
    public void getGoShoppingCartReturn(GoShoppingBean goShoppingBean) {

    }
}
