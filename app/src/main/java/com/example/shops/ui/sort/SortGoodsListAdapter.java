package com.example.shops.ui.sort;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shops.R;
import com.example.shops.base.BaseAdapter;
import com.example.shops.model.bean.sort.SortGoodsListBean;

import java.util.List;
//分类商品列表适配器
public class SortGoodsListAdapter extends BaseAdapter {
    public SortGoodsListAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.sortgoods_item;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        SortGoodsListBean.DataBean.CurrentCategoryBean.SubCategoryListBean goodslist = (SortGoodsListBean.DataBean.CurrentCategoryBean.SubCategoryListBean)o;
        ImageView iv = (ImageView) holder.getView(R.id.iv_sortgoods);
        Glide.with(mContext).load(goodslist.getImg_url()).into(iv);
        TextView tv = (TextView) holder.getView(R.id.tv_sortgoods);
        tv.setText(goodslist.getName());
    }
}
