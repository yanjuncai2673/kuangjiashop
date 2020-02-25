package com.example.shops.ui.home;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shops.R;
import com.example.shops.base.BaseAdapter;
import com.example.shops.model.bean.home.HomeIndexBean;

import java.util.List;

public class HotGoodsAdapter extends BaseAdapter {
    public HotGoodsAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.layout_hotgoods;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        HomeIndexBean.DataBean.HotGoodsListBean hots = (HomeIndexBean.DataBean.HotGoodsListBean) o;
        ImageView iv = (ImageView) holder.getView(R.id.iv_hotgoods);
        TextView name = (TextView) holder.getView(R.id.tv_hot_name);
        TextView desc = (TextView) holder.getView(R.id.tv_hot_desc);
        TextView price = (TextView) holder.getView(R.id.tv_hot_price);
        Glide.with(mContext).load(hots.getList_pic_url()).into(iv);
        name.setText(hots.getName());
        desc.setText(hots.getGoods_brief());
        price.setText("¥" + hots.getRetail_price());
    }
}
