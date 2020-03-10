package com.example.shops.ui.goShopping.activity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shops.R;
import com.example.shops.base.BaseActivity;
import com.example.shops.base.BaseAdapter;
import com.example.shops.interfaces.goShopping.ShoppingConstract;
import com.example.shops.model.bean.shopping.AddressEditorBean;
import com.example.shops.model.bean.shopping.DetailAddsBean;
import com.example.shops.model.bean.shopping.ShoppingAddsBean;
import com.example.shops.persenter.shopping.AddressEditorPresenter;
import com.example.shops.ui.goShopping.adapter.AddressSelectAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    int pid, cid, aid;//记录当前所选省级，市级，县级
    PopupWindow popupWindow;
    private TextView province;
    private TextView city;
    private TextView area;
    private TextView tvok;
    private RecyclerView rv;

    ArrayList<DetailAddsBean.DataBean> dataBeans;
    private AddressSelectAdapter addressSelectAdapter;

    ShoppingAddsBean.DataBean addsbean;

    @Override
    protected void initData() {
        if (getIntent().hasExtra("address")) {//通过intent判断是否有值  有值就是从地址列表进来编辑的
            adds = (ShoppingAddsBean.DataBean) getIntent().getSerializableExtra("address");
            tvName.setText(adds.getName());//地址编辑页面赋值
            tvPhone.setText(adds.getMobile());
            tvAddress.setText(adds.getProvince_name() + adds.getCity_name() + adds.getDistrict_name());
            tvDescadds.setText(adds.getAddress());
            ckDefault.setChecked(adds.getIs_default() == 1 ? true : false);
            pid = adds.getProvince_id();
            cid = adds.getCity_id();
            aid = adds.getDistrict_id();
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
        finish();
    }

    //获取详细地址返回
    @Override
    public void getDetailAddsReturn(DetailAddsBean detailAddsBean) {
        if (popupWindow.isShowing()) {
            addressSelectAdapter.updata(detailAddsBean.getData());
        }
    }


    @OnClick({R.id.tv_cannel, R.id.tv_save, R.id.tv_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_cannel:
                finish();
                break;
            case R.id.tv_save:
                saveAddress();
                break;
            case R.id.tv_address:
                openPopupWindow();
                break;
        }
    }

    //选中省市县
    private void openPopupWindow() {
        View view = LayoutInflater.from(this).inflate(R.layout.pop_address, null);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, 500);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        backgroundAlpha(0.5f);
        if (!popupWindow.isShowing()) {
            popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        }
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1.0f);
            }
        });

        province = view.findViewById(R.id.tv_province);
        city = view.findViewById(R.id.tv_city);
        area = view.findViewById(R.id.tv_area);
        tvok = view.findViewById(R.id.tv_true);
        rv = view.findViewById(R.id.rv_pop);

        province.setOnClickListener(clickListener);
        city.setOnClickListener(clickListener);

        dataBeans = new ArrayList<>();
        addressSelectAdapter = new AddressSelectAdapter(dataBeans, this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(addressSelectAdapter);
        //popupwindow条目点击监听
        addressSelectAdapter.setOnItemClickHandler(new BaseAdapter.ItemClickHandler() {
            @Override
            public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {
                DetailAddsBean.DataBean dataBean = dataBeans.get(position);
                int id = dataBean.getId();
                resetSelectTvStyle();
                if (dataBean.getType() == 1) {//如果某一条目选中的类型为省级
                    persenter.getDetailAddsData(id);//p层执行网络请求
                    province.setText(dataBean.getName());
                    pid = id;
                    cid = 0;
                    aid = 0;
                    city.setTextColor(Color.parseColor("#ff0000"));
                } else if (dataBean.getType() == 2) {//如果条目对象选中的是市级
                    persenter.getDetailAddsData(id);
                    area.setTextColor(Color.parseColor("#ff0000"));
                    city.setText(dataBean.getName());
                    cid = id;
                    aid = 0;
                } else {
                    area.setText(dataBean.getName());
                    aid = id;
                    addressSelectAdapter.curSelectId = aid;
                    addressSelectAdapter.notifyDataSetChanged();
                }
            }
        });

        tvok.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pid == 0 || cid == 0 || aid == 0) {
                    showMes("请选择具体的送货地址");
                    return;
                }
                tvAddress.setText(province.getText().toString() + city.getText().toString() + area.getText().toString());
                popupWindow.dismiss();
            }

        });

        //设置默认值
        if (addsbean != null) {
            province.setText(addsbean.getProvince_name());
            city.setText(adds.getCity_name());
            area.setText(addsbean.getDistrict_name());
            area.setTextColor(Color.parseColor("#ff0000"));
            persenter.getDetailAddsData(addsbean.getCity_id());
        } else {
            //设置默认省份的颜色
            province.setTextColor(Color.parseColor("#ff0000"));
            persenter.getDetailAddsData(1);
        }

    }

    ///重新设置文本样式
    private void resetSelectTvStyle() {
        province.setTextColor(Color.parseColor("#000000"));
        city.setTextColor(Color.parseColor("#000000"));
        area.setTextColor(Color.parseColor("#000000"));
    }

    //省级市级的点击监听事件
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_province:
                    break;
                case R.id.tv_city:
                    break;
            }
        }
    };


    private void backgroundAlpha(float v) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = v;
        getWindow().setAttributes(attributes);
    }

    private void saveAddress() {
        Map<String, String> map = new HashMap<>();
        if (addsbean == null) {
            map.put("id", "0");
        } else {
            map.put("id", String.valueOf(addsbean.getId()));
        }
        map.put("name", tvName.getText().toString());
        map.put("mobile", tvPhone.getText().toString());
        map.put("province_id", String.valueOf(pid));
        map.put("city_id", String.valueOf(cid));
        map.put("district_id", String.valueOf(aid));
        map.put("address", tvAddress.getText().toString());
        String defalt = ckDefault.isChecked() ? "0" : "1";
        map.put("is_default", defalt);
        persenter.getAddressEditorData(map);
    }


}
