package com.example.shops.ui.goShopping;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shops.R;
import com.example.shops.base.BaseAdapter;
import com.example.shops.base.BaseFragment;
import com.example.shops.interfaces.goShopping.ShoppingConstract;
import com.example.shops.interfaces.sort.cart.CartConstart;
import com.example.shops.model.bean.shopping.CartGoodsCheckedBean;
import com.example.shops.model.bean.shopping.GoShoppingBean;
import com.example.shops.model.bean.shopping.UpdateCartGoodsBean;
import com.example.shops.persenter.shopping.GoshoppingPresenter;
import com.example.shops.ui.goShopping.adapter.GoShoppingAdapter;
import com.example.shops.ui.login.LoginActivity;
import com.example.shops.utils.SpUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GoShoppingFragment extends BaseFragment<ShoppingConstract.Presenter> implements ShoppingConstract.View, BaseAdapter.ItemClickHandler {
    @BindView(R.id.rv_shopping)
    RecyclerView rvShopping;
    @BindView(R.id.ck_allselect)
    CheckBox ckAllselect;
    @BindView(R.id.tv_allprice)
    TextView tvAllprice;
    @BindView(R.id.tv_buy)
    TextView tvBuy;
    @BindView(R.id.tv_edit)
    TextView tvEdit;
    @BindView(R.id.con_select)
    ConstraintLayout conSelect;

    GoShoppingAdapter goShoppingAdapter;
    List<GoShoppingBean.DataBean.CartListBean> cartListBeans;

    @Override
    protected int getLayout() {
        return R.layout.fragment_shopping;
    }

    @Override//加载数据
    protected void initData() {
        //切换到购物车界面先判断是否登录  登录之后记录token
        String token = SpUtils.getInstance().getString("token");
        //先判断是否token为空
        if (TextUtils.isEmpty(token)) {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivityForResult(intent,200);
        }else {//已经登录
            persenter.getGoShoppingCart();
        }
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        if (requestCode == 200) {
            if (persenter != null) {
                persenter.getGoShoppingCart();
            }
        }
    }

    //购物界面初适化
    @Override
    protected void initView() {
        cartListBeans = new ArrayList<>();
        goShoppingAdapter = new GoShoppingAdapter(cartListBeans, getActivity());
        rvShopping.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvShopping.setAdapter(goShoppingAdapter);

        goShoppingAdapter.setOnItemClickHandler(this);

    }

    @Override
    protected ShoppingConstract.Presenter createPersenter() {
        return new GoshoppingPresenter();
    }

//获取购物车商品界面数据返回
    @Override
    public void getGoShoppingCartReturn(GoShoppingBean goShoppingBean) {
        goShoppingAdapter.updata(goShoppingBean.getData().getCartList());
        //判断当前的类型数据是否全部选中
        int totailPrice = 0;
        int nums = 0;
        boolean isSelectAll = true;
        for (GoShoppingBean.DataBean.CartListBean cart:goShoppingBean.getData().getCartList()) {
            if (isSelectAll) {
                if(!cart.isSelect){
                    isSelectAll = false;
                }
            }
            if (cart.isSelect) {
                totailPrice += cart.getRetail_price()*cart.getNumber();
                nums += cart.getNumber();
            }
        }
        if (isSelectAll) {
            ckAllselect.setChecked(true);
        }
        tvAllprice.setText("¥ "+totailPrice);
        ckAllselect.setText("全选("+nums+")");
    }
//购物车商品数据是否被选中返回
    @Override
    public void setCartGoodsCheckedReturn(CartGoodsCheckedBean cartGoodsCheckedReturn) {

    }
//购物车更新数据返回
    @Override
    public void updateCartGoodsReturn(UpdateCartGoodsBean updateCartGoodsBean) {

    }

    @Override
    public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {

    }
}
