package com.example.shops.ui.home;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.example.shops.R;
import com.example.shops.base.BaseAdapter;
import com.example.shops.model.bean.home.HomeIndexBean;

import java.util.List;

import butterknife.BindView;

public class HomeCategoryPeijAdapter extends BaseAdapter {

    @BindView(R.id.iv_goods)
    ImageView ivGoods;
    @BindView(R.id.con_iv)
    ConstraintLayout conIv;
    @BindView(R.id.tv_goods_name)
    TextView tvGoodsName;
    @BindView(R.id.tv_goods_price)
    TextView tvGoodsPrice;

    public HomeCategoryPeijAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.layout_homecategory;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        HomeIndexBean.DataBean.CategoryListBean.GoodsListBean goods = (HomeIndexBean.DataBean.CategoryListBean.GoodsListBean) o;

            TextView name = (TextView) holder.getView(R.id.tv_goods_name);
            TextView price = (TextView) holder.getView(R.id.tv_goods_price);
            ImageView iv = (ImageView) holder.getView(R.id.iv_goods);
            Glide.with(mContext).load(goods.getList_pic_url()).into(iv);
            name.setText(goods.getName());
            price.setText("¥"+goods.getRetail_price());

    }
}
