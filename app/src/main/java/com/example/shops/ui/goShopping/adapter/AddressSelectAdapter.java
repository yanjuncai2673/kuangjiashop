package com.example.shops.ui.goShopping.adapter;


import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.example.shops.R;
import com.example.shops.base.BaseAdapter;
import com.example.shops.model.bean.shopping.DetailAddsBean;

import java.util.List;

public class AddressSelectAdapter extends BaseAdapter {

    public int curSelectId;
    public AddressSelectAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.layout_adds_select;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        DetailAddsBean.DataBean adds = (DetailAddsBean.DataBean) o;
        TextView name = (TextView) holder.getView(R.id.tv_name);
        if (curSelectId == adds.getId()) {
            name.setTextColor(Color.parseColor("#ff0000"));
        }else {
            name.setTextColor(Color.parseColor("#000000"));
        }
        name.setText(adds.getName());
    }
}
