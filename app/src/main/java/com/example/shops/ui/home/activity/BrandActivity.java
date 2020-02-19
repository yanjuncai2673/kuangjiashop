package com.example.shops.ui.home.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shops.R;
import com.example.shops.base.BaseActivity;
import com.example.shops.interfaces.home.BrandConstract;
import com.example.shops.model.bean.BrandBean;
import com.example.shops.model.bean.BrandGoodsBean;
import com.example.shops.persenter.BrandPersenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BrandActivity extends BaseActivity<BrandConstract.Persenter> implements BrandConstract.View {
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.img_bg)
    ImageView imgBg;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.layout_infos)
    ConstraintLayout layoutInfos;
    @BindView(R.id.txt_des)
    TextView txtDes;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    int brandId;
    BrandGoodsAdapter brandGoodsAdapter;
    List<BrandGoodsBean.DataBeanX.GoodsListBean> goodsList;

    @Override
    protected void initData() {
        brandId = getIntent().getIntExtra("brandId", 0);
        persenter.getBrandInfo(String.valueOf(brandId));
        persenter.getBrandGoodsList(String.valueOf(brandId), 1, 1000);
    }

    @Override
    protected BrandConstract.Persenter createPersenter() {
        return new BrandPersenter();
    }

    @Override
    protected void initView() {
        goodsList = new ArrayList<>();
        brandGoodsAdapter = new BrandGoodsAdapter(goodsList,this);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(brandGoodsAdapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.brand_detail;
    }

    @Override
    public void getHomeBrandDataReturn(BrandBean brandBean) {
        Glide.with(this).load(brandBean.getData().getBrand().getNew_pic_url()).into(imgBg);
        txtName.setText(brandBean.getData().getBrand().getName());
        txtDes.setText(brandBean.getData().getBrand().getSimple_desc());
    }

    @Override
    public void getHomeBrandGoodsReturn(BrandGoodsBean brandGoodsBean) {
        brandGoodsAdapter.updata(brandGoodsBean.getData().getGoodsList());
    }


}
