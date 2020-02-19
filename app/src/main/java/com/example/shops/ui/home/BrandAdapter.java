package com.example.shops.ui.home;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shops.R;
import com.example.shops.base.BaseAdapter;
import com.example.shops.common.Constant;
import com.example.shops.model.bean.HomeIndexBean;

import java.util.List;

public class BrandAdapter extends BaseAdapter {
    public BrandAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.layout_brand_item;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        HomeIndexBean.DataBean.BrandListBean data = (HomeIndexBean.DataBean.BrandListBean) o;
        ImageView img_brand = (ImageView) holder.getView(R.id.img_brand);
        TextView txt_name = (TextView)holder.getView(R.id.txt_name);
        TextView txt_price = (TextView)holder.getView(R.id.txt_price);
        Glide.with(mContext).load(data.getNew_pic_url()).into(img_brand);
        txt_name.setText(data.getName());
        txt_price.setText(Constant.PRICE_MODEL.replace("$",data.getFloor_price()));
    }
}
