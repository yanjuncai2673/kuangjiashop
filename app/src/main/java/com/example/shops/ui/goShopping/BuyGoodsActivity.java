package com.example.shops.ui.goShopping;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shops.R;
import com.example.shops.base.BaseActivity;
import com.example.shops.interfaces.goShopping.ShoppingConstract;
import com.example.shops.model.bean.shopping.BuyGoodsBean;
import com.example.shops.persenter.sort.cart.BuyGoodsPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BuyGoodsActivity extends BaseActivity<ShoppingConstract.BuyGoodsPresenter> implements ShoppingConstract.BuyGoodsView {
    @BindView(R.id.tv_buy_noadds)
    TextView tvBuyNoadds;
    @BindView(R.id.tv_buy_name)
    TextView tvBuyName;
    @BindView(R.id.tv_buy_phone)
    TextView tvBuyPhone;
    @BindView(R.id.tv_buy_default)
    TextView tvBuyDefault;
    @BindView(R.id.tv_buy_adds)
    TextView tvBuyAdds;
    @BindView(R.id.con_adds)
    ConstraintLayout conAdds;
    @BindView(R.id.tv_couponnums)
    TextView tvCouponnums;
    @BindView(R.id.con_coupon)
    ConstraintLayout conCoupon;
    @BindView(R.id.tv_buy_price)
    TextView tvBuyPrice;
    @BindView(R.id.tv_buy_fright)
    TextView tvBuyFright;
    @BindView(R.id.tv_buy_coupon)
    TextView tvBuyCoupon;
    @BindView(R.id.con_goodsinfo)
    ConstraintLayout conGoodsinfo;
    @BindView(R.id.rv_buy)
    RecyclerView rvBuy;
    @BindView(R.id.tv_buy_finalprice)
    TextView tvBuyFinalprice;
    @BindView(R.id.tv_buy_go)
    TextView tvBuyGo;
    @BindView(R.id.con_pay)
    ConstraintLayout conPay;
    @BindView(R.id.tv_adds_select)
    TextView tvAddsSelect;
    @BindView(R.id.tv_coupon_select)
    TextView tvCouponSelect;

    int addressId = 0;
    int couponId = 0;
    @BindView(R.id.con_addsinfo)
    ConstraintLayout conAddsinfo;

    @Override
    protected void initData() {
        persenter.getBuygoodsData(addressId, couponId);
    }

    @Override
    protected ShoppingConstract.BuyGoodsPresenter createPersenter() {
        return new BuyGoodsPresenter();
    }

    @Override
    protected void initView() {
        String user = tvBuyName.getText().toString();
        if (TextUtils.isEmpty(user)) {
            tvBuyNoadds.setVisibility(View.VISIBLE);
            conAddsinfo.setVisibility(View.GONE);
        }else {
            tvBuyNoadds.setVisibility(View.GONE);
            conAddsinfo.setVisibility(View.VISIBLE);
        }

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_buygoods;
    }

    //获取商品下单的返回
    @Override
    public void getBuyGoodsReturn(BuyGoodsBean buyGoodsBean) {

        //刷新地址
        updateAdds(buyGoodsBean.getData().getCheckedAddress());

        //优惠券返回
        updateCoupon(buyGoodsBean.getData().getCouponList());

        //订单信息返回
        updateBuyInfo(buyGoodsBean.getData());

        //已下单的商品集合
        updateCheckedGoodsInfo(buyGoodsBean.getData().getCheckedGoodsList());
    }

    private void updateCheckedGoodsInfo(List<BuyGoodsBean.DataBean.CheckedGoodsListBean> checkedGoodsList) {
    }

    //订单信息返回
    private void updateBuyInfo(BuyGoodsBean.DataBean data) {
    }

    //优惠券返回
    private void updateCoupon(List<BuyGoodsBean.DataBean.CouponListBean> couponList) {
    }

    //地址信息
    private void updateAdds(BuyGoodsBean.DataBean.CheckedAddressBean checkedAddress) {
    }


    @OnClick({R.id.tv_buy_noadds, R.id.con_adds, R.id.con_coupon, R.id.tv_buy_go})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_buy_noadds:
                break;
            case R.id.con_adds://添加收获地址
               addAddress();
                break;
            case R.id.con_coupon:
                break;
            case R.id.tv_buy_go:
                break;
        }
    }

    private void addAddress() {
        Intent intent = new Intent(this,ShoppingAddsActivity.class);
        startActivity(intent);
    }


}
