package com.example.shops.ui.goShopping;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.shops.R;
import com.example.shops.base.BaseActivity;
import com.example.shops.interfaces.goShopping.ShoppingConstract;
import com.example.shops.model.bean.shopping.ShoppingAddsBean;

public class ShoppingAddsActivity extends BaseActivity<ShoppingConstract.ShoppingAddsPresenter>implements ShoppingConstract.ShoppingAddsView {


    @Override
    protected void initData() {

    }

    @Override
    protected ShoppingConstract.ShoppingAddsPresenter createPersenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_shopping_adds;
    }

    @Override
    public void getShoppingAddsReturn(ShoppingAddsBean shoppingAddsBean) {

    }
}
