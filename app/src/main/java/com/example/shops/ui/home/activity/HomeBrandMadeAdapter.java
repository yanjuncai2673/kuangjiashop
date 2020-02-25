package com.example.shops.ui.home.activity;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shops.R;
import com.example.shops.base.BaseAdapter;
import com.example.shops.model.bean.home.HomeBrandMadeBean;

import java.util.List;

import butterknife.BindView;

public class HomeBrandMadeAdapter extends BaseAdapter {
    @BindView(R.id.iv_made)
    ImageView ivMade;
    @BindView(R.id.tv_made)
    TextView tvMade;

    public HomeBrandMadeAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.layout_homebrandmade;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        HomeBrandMadeBean.DataBeanX.DataBean bean = (HomeBrandMadeBean.DataBeanX.DataBean) o;
        ImageView iv = (ImageView) holder.getView(R.id.iv_made);
        TextView tv = (TextView) holder.getView(R.id.tv_made);
        Glide.with(mContext).load(bean.getApp_list_pic_url()).into(iv);
        tv.setText(bean.getName()+"   |   "+bean.getFloor_price());
    }
}
