package com.example.shops.ui.goShopping;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shops.R;
import com.example.shops.base.BaseActivity;
import com.example.shops.base.BaseAdapter;
import com.example.shops.interfaces.goShopping.ShoppingConstract;
import com.example.shops.model.bean.shopping.ShoppingAddsBean;
import com.example.shops.persenter.shopping.ShoppingAddsPresenter;
import com.example.shops.ui.goShopping.activity.AddressEditorActivity;
import com.example.shops.ui.goShopping.adapter.ShoppingAddsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShoppingAddsActivity extends BaseActivity<ShoppingConstract.ShoppingAddsPresenter> implements ShoppingConstract.ShoppingAddsView, BaseAdapter.ItemClickHandler {


    @BindView(R.id.rv_shop_adds)
    RecyclerView rvShopAdds;
    @BindView(R.id.tv_new_create)
    TextView tvNewCreate;
    List<ShoppingAddsBean.DataBean> dataBeans;
    ShoppingAddsAdapter shoppingAddsAdapter;

    @Override
    protected void initData() {
        persenter.getShoppingAddsData();
    }

    @Override
    protected ShoppingConstract.ShoppingAddsPresenter createPersenter() {
        return new ShoppingAddsPresenter();
    }

    @Override
    protected void initView() {
        rvShopAdds.setLayoutManager(new LinearLayoutManager(this));
        dataBeans = new ArrayList<>();
        shoppingAddsAdapter = new ShoppingAddsAdapter(dataBeans, this);
        rvShopAdds.setAdapter(shoppingAddsAdapter);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_shopping_adds;
    }

    @Override//获取数据返回刷新界面
    public void getShoppingAddsReturn(ShoppingAddsBean shoppingAddsBean) {
shoppingAddsAdapter.updata(shoppingAddsBean.getData());
    }

//新建点击事件跳转
    @OnClick(R.id.tv_new_create)
    public void onViewClicked() {
        Intent intent = new Intent(this, AddressEditorActivity.class);
        startActivityForResult(intent,210);
    }

    @Override
    public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {
        ShoppingAddsBean.DataBean dataBean = dataBeans.get(position);
        //点击条目进入地址编辑页面
        Intent intent = new Intent(this, AddressEditorActivity.class);
        intent.putExtra("address",dataBean);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            if (requestCode == 210 && resultCode==230) {
                String name = data.getStringExtra("name");
                String phone = data.getStringExtra("phone");
                String addrs = data.getStringExtra("addrs");
                String descadds = data.getStringExtra("descadds");
                String defalt = data.getStringExtra("defalt");

            }
        }
    }
}
