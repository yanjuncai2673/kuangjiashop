package com.example.shops.ui.home;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shops.R;
import com.example.shops.base.BaseAdapter;
import com.example.shops.model.bean.HomeIndexBean;

import java.util.List;

public class NewGoodsAdapter extends BaseAdapter {
    public NewGoodsAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.layout_newgoods_item;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        HomeIndexBean.DataBean.NewGoodsListBean bean = (HomeIndexBean.DataBean.NewGoodsListBean) o;
        ImageView img_news = (ImageView)holder.getView(R.id.img_news);
        TextView txt_name = (TextView)holder.getView(R.id.txt_name);
        TextView txt_price = (TextView)holder.getView(R.id.txt_price);
        //数据填充
        Glide.with(mContext).load(bean.getList_pic_url()).into(img_news);
        txt_name.setText(bean.getName());
        String price = mContext.getResources().getString(R.string.price_news_model);
        txt_price.setText(price.replace("$",bean.getRetail_price()));
    }
}
