package com.example.shops.ui.home.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shops.R;
import com.example.shops.base.BaseActivity;
import com.example.shops.interfaces.home.HomeNewgoodsDetailConstract;
import com.example.shops.model.bean.home.HomeNewGoodsDetailBean;
import com.example.shops.persenter.home.HomeNewgoodsDetailPersenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeNewgoodsDetailActivity extends BaseActivity<HomeNewgoodsDetailConstract.Persenter> implements HomeNewgoodsDetailConstract.View {
    @BindView(R.id.con_one)
    ConstraintLayout conOne;
    @BindView(R.id.tv_hd_name)
    TextView tvHdName;
    @BindView(R.id.tv_hd_desc)
    TextView tvHdDesc;
    @BindView(R.id.tv_hd_price)
    TextView tvHdPrice;
    @BindView(R.id.tv_hd_num)
    TextView tvHdNum;
    @BindView(R.id.iv_hd_select)
    ImageView ivHdSelect;
    @BindView(R.id.rv_hd)
    RecyclerView rvHd;
    @BindView(R.id.scro_homegoods)
    ScrollView scroHomegoods;
    @BindView(R.id.iv_hd_job)
    ImageView ivHdJob;
    @BindView(R.id.iv_hd_shop)
    ImageView ivHdShop;
    @BindView(R.id.tv_hd_liji)
    TextView tvHdLiji;
    @BindView(R.id.tv_hd_job)
    TextView tvHdJob;
     List<HomeNewGoodsDetailBean.DataBean.GoodsListBean> beans;
    HomeNewgoodsDetailAdapter homeNewgoodsDetailAdapter;
    private int id;

    @Override
    protected void initData() {
        //跳转到此界面传入id获取数据
        id = getIntent().getIntExtra("id", 0);
        persenter.getHomeNewgoodsDetailData(id);
    }

    @Override
    protected HomeNewgoodsDetailConstract.Persenter createPersenter() {
        return new HomeNewgoodsDetailPersenter();
    }

    @Override
    protected void initView() {

        rvHd.setLayoutManager(new GridLayoutManager(this,2));
        beans = new ArrayList<>();
        homeNewgoodsDetailAdapter = new HomeNewgoodsDetailAdapter(beans, this);
        rvHd.setAdapter(homeNewgoodsDetailAdapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_homenewgoodsdetail;
    }

    @Override
    public void getHomeNewgoddsDetailReturn(HomeNewGoodsDetailBean homeNewGoodsDetailBean) {
        homeNewgoodsDetailAdapter.updata(homeNewGoodsDetailBean.getData().getGoodsList());
        List<HomeNewGoodsDetailBean.DataBean.GoodsListBean> list = homeNewGoodsDetailBean.getData().getGoodsList();
        for (int i = 0; i <list.size() ; i++) {
            if (id == list.get(i).getId()) {
                tvHdName.setText(list.get(i).getName());
                tvHdPrice.setText(list.get(i).getRetail_price()+"元");
            }
        }

    }


}
