package com.example.shops.ui.home.activity;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shops.R;
import com.example.shops.base.BaseAdapter;
import com.example.shops.model.bean.home.BrandGoodsBean;
import com.example.shops.model.bean.home.HomeNewGoodsDetailBean;

import java.util.List;

public class HomeNewgoodsDetailAdapter extends BaseAdapter{
    public HomeNewgoodsDetailAdapter(List data, Context context) {
        super(data, context);
    }
    @Override
    public int getLayout() {
        return R.layout.home_news_detail;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        HomeNewGoodsDetailBean.DataBean.GoodsListBean bean= (HomeNewGoodsDetailBean.DataBean.GoodsListBean) o;
        ImageView img = (ImageView)holder.getView(R.id.iv_news);
        TextView txt_name = (TextView)holder.getView(R.id.tv_news_name);
        TextView txt_price = (TextView)holder.getView(R.id.tv_news_price);
        Glide.with(mContext).load(bean.getList_pic_url()).into(img);
        txt_name.setText(bean.getName());
        String price = mContext.getResources().getString(R.string.price_news_model);
        txt_price.setText(price.replace("$",String.valueOf(bean.getRetail_price())));
    }
}
