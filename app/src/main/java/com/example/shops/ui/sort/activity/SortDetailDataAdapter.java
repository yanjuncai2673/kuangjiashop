package com.example.shops.ui.sort.activity;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shops.R;
import com.example.shops.base.BaseAdapter;
import com.example.shops.model.bean.sort.SortDetailDataBean;

import java.util.List;

public class SortDetailDataAdapter extends BaseAdapter {
    public SortDetailDataAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.layout_sortdetail;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        SortDetailDataBean.DataBeanX.GoodsListBean lists = (SortDetailDataBean.DataBeanX.GoodsListBean)o;
        ImageView iv_sort = (ImageView) holder.getView(R.id.iv_sortdetail);
        Glide.with(mContext).load(lists.getList_pic_url()).into(iv_sort);
        TextView tv_sortName = (TextView) holder.getView(R.id.tv_sortName);
        TextView tv_sortPrice = (TextView) holder.getView(R.id.tv_sortPrice);
        tv_sortName.setText(lists.getName());
        String price = mContext.getResources().getString(R.string.price_news_model);
        tv_sortPrice.setText(price.replace("$",String.valueOf(lists.getRetail_price())));


    }
}
