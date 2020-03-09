package com.example.shops.ui.goShopping.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shops.R;
import com.example.shops.base.BaseAdapter;
import com.example.shops.model.bean.shopping.ShoppingAddsBean;

import java.util.List;

public class ShoppingAddsAdapter extends BaseAdapter {
    public ShoppingAddsAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.layout_address_item;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        ShoppingAddsBean.DataBean bean = (ShoppingAddsBean.DataBean) o;
        TextView name = (TextView) holder.getView(R.id.tv_addsitem_name);
        TextView phone = (TextView) holder.getView(R.id.tv_addsitem_phone);
        TextView defaults = (TextView) holder.getView(R.id.tv_addsitem_default);
        TextView address = (TextView) holder.getView(R.id.tv_addsitem_address);
        ImageView iv = (ImageView) holder.getView(R.id.iv_editor);
        name.setText(bean.getName());
        defaults.setVisibility(bean.getIs_default() == 1 ? View.VISIBLE : View.GONE);
        phone.setText(bean.getMobile());
        address.setText(bean.getCity_name()+bean.getDistrict_name()+bean.getFull_region());
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickHandler != null) {
                    itemClickHandler.itemClick(holder.getLayoutPosition(),holder);
                }
            }
        });
        
    }
}
