package com.example.shops.ui.home.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shops.R;
import com.example.shops.base.BaseActivity;
import com.example.shops.base.BaseAdapter;
import com.example.shops.interfaces.home.BrandMadeConstract;
import com.example.shops.model.bean.home.HomeBrandMadeBean;
import com.example.shops.persenter.home.HomeBrandMadePersenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeBrandMadeActivity extends BaseActivity<BrandMadeConstract.Persenter> implements BrandMadeConstract.View, BaseAdapter.ItemClickHandler {
    @BindView(R.id.rv_brandmade)
    RecyclerView rvBrandmade;
    List<HomeBrandMadeBean.DataBeanX.DataBean> mades;
    HomeBrandMadeAdapter homeBrandMadeAdapter;

    @Override
    protected void initData() {
        persenter.getHomeBrandMadeData(1, 1000);

    }

    @Override
    protected BrandMadeConstract.Persenter createPersenter() {
        return new HomeBrandMadePersenter();
    }

    @Override
    protected void initView() {
        rvBrandmade.setLayoutManager(new LinearLayoutManager(this));
        mades = new ArrayList<>();
        homeBrandMadeAdapter = new HomeBrandMadeAdapter(mades, this);
        rvBrandmade.setAdapter(homeBrandMadeAdapter);
        homeBrandMadeAdapter.setOnItemClickHandler(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_brandmade;
    }

    @Override
    public void getHomeBrandMadeReturn(HomeBrandMadeBean homeBrandMadeBean) {
        homeBrandMadeAdapter.updata(homeBrandMadeBean.getData().getData());
    }


    @Override
    public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {
        int id = mades.get(position).getId();
        Intent intent = new Intent(this, BrandActivity.class);
        intent.putExtra("brandId",id);
        startActivity(intent);

    }
}
