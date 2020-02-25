package com.example.shops.ui.home;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shops.R;
import com.example.shops.base.BaseAdapter;
import com.example.shops.model.bean.home.HomeIndexBean;

import java.util.List;

public class TopicListAdapter extends BaseAdapter {
    public TopicListAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.layout_topic;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        HomeIndexBean.DataBean.TopicListBean tops = (HomeIndexBean.DataBean.TopicListBean) o;
        ImageView iv = (ImageView) holder.getView(R.id.iv_topic);
        TextView name = (TextView) holder.getView(R.id.tv_topic_name);
        TextView desc = (TextView) holder.getView(R.id.tv_topic_desc);
        TextView price = (TextView) holder.getView(R.id.tv_topic_price);
        Glide.with(mContext).load(tops.getItem_pic_url()).into(iv);
        name.setText(tops.getTitle());
        desc.setText(tops.getSubtitle());
        price.setText("¥" + tops.getPrice_info()+"起");

    }
}
