package com.example.shops.ui.goShopping.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shops.R;
import com.example.shops.base.BaseActivity;
import com.example.shops.interfaces.goShopping.ShoppingConstract;
import com.example.shops.model.bean.shopping.AddressEditorBean;
import com.example.shops.model.bean.shopping.DetailAddsBean;
import com.example.shops.model.bean.shopping.ShoppingAddsBean;
import com.example.shops.persenter.shopping.AddressEditorPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressEditorActivity extends BaseActivity<ShoppingConstract.AddressEditorPresenter> implements ShoppingConstract.AddressEditorView {


    @BindView(R.id.tv_name)
    EditText tvName;
    @BindView(R.id.tv_phone)
    EditText tvPhone;
    @BindView(R.id.tv_address)
    EditText tvAddress;
    @BindView(R.id.tv_descadds)
    EditText tvDescadds;
    @BindView(R.id.ck_default)
    CheckBox ckDefault;
    @BindView(R.id.tv_cannel)
    TextView tvCannel;
    @BindView(R.id.tv_save)
    TextView tvSave;
    ShoppingAddsBean.DataBean adds;

    @Override
    protected void initData() {
        if (getIntent().hasExtra("address")) {
            adds = (ShoppingAddsBean.DataBean) getIntent().getSerializableExtra("address");
            tvName.setText(adds.getName().toString());
            tvPhone.setText(adds.getMobile().toString());
            tvAddress.setText(adds.getAddress().toString());
            tvDescadds.setText(adds.getFull_region().toString());
        }
    }

    @Override
    protected ShoppingConstract.AddressEditorPresenter createPersenter() {
        return new AddressEditorPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_address_editor;
    }

    ////获取地址编辑页面返回
    @Override
    public void getAddressEditorReturn(AddressEditorBean addressEditorBean) {

    }

    //获取详细地址返回
    @Override
    public void getDetailAddsReturn(DetailAddsBean detailAddsBean) {

    }


    @OnClick({R.id.tv_cannel, R.id.tv_save,R.id.tv_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_cannel:
                break;
            case R.id.tv_save:
                break;
            case R.id.tv_address:
                break;
        }
    }


}
