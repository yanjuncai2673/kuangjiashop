package com.example.shops.ui.mainTitle;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shops.R;
import com.example.shops.base.BaseAdapter;
import com.example.shops.model.bean.maintitle.MainTitleBean;

import java.util.List;

import butterknife.BindView;

public class MainTitleAdapter extends BaseAdapter {
    @BindView(R.id.iv_main)
    ImageView ivMain;
    @BindView(R.id.tv_main_name)
    TextView tvMainName;
    @BindView(R.id.tv_main_desc)
    TextView tvMainDesc;
    @BindView(R.id.tv_main_price)
    TextView tvMainPrice;

    public MainTitleAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.maintitle_item;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        MainTitleBean.DataBeanX.DataBean bean = (MainTitleBean.DataBeanX.DataBean) o;
        TextView name = (TextView) holder.getView(R.id.tv_main_name);
        TextView price = (TextView) holder.getView(R.id.tv_main_price);
        TextView desc = (TextView) holder.getView(R.id.tv_main_desc);
        ImageView iv = (ImageView) holder.getView(R.id.iv_main);
        Glide.with(mContext).load(bean.getScene_pic_url()).into(iv);
            name.setText(bean.getTitle());
            desc.setText(bean.getSubtitle());
            price.setText("¥ "+bean.getPrice_info());

    }
}
