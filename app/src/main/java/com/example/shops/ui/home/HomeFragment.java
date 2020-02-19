package com.example.shops.ui.home;

import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shops.R;
import com.example.shops.base.BaseAdapter;
import com.example.shops.base.BaseFragment;
import com.example.shops.interfaces.home.HomeConstract;
import com.example.shops.model.bean.home.HomeIndexBean;
import com.example.shops.persenter.home.HomePersenter;
import com.example.shops.ui.home.activity.BrandActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<HomeConstract.Persenter> implements HomeConstract.View, BaseAdapter.ItemClickHandler {


    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.txt_news)
    TextView txtNews;
    @BindView(R.id.recyclerView_News)
    RecyclerView recyclerViewNews;

    BrandAdapter brandAdapter;
    List<HomeIndexBean.DataBean.BrandListBean> list;

    NewGoodsAdapter newgoodsAdapter;
    List<HomeIndexBean.DataBean.NewGoodsListBean> newsList;

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        persenter.getHomeData();
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        brandAdapter = new BrandAdapter(list, context);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerView.setAdapter(brandAdapter);
        brandAdapter.setOnItemClickHandler(this);

        //初始化新品列表
        newsList = new ArrayList<>();
        newgoodsAdapter = new NewGoodsAdapter(newsList, context);
        recyclerViewNews.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerViewNews.setAdapter(newgoodsAdapter);
        //避免当前类中多个列表的点击接口回调的冲突，建议使用匿名的类实例
        newgoodsAdapter.setOnItemClickHandler(new BaseAdapter.ItemClickHandler() {
            @Override
            public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {
                Log.i("newsItemClick", String.valueOf(position));
            }
        });
    }

    @Override
    protected HomeConstract.Persenter createPersenter() {
        return new HomePersenter();
    }

    @Override
    public void getHomeDataReturn(HomeIndexBean indexbean) {
//刷新Brand列表数据
        brandAdapter.updata(indexbean.getData().getBrandList());
        //刷新新品发布列表数据
        newgoodsAdapter.updata(indexbean.getData().getNewGoodsList());
    }

    @Override//接口回调跳转详情
    public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {
        HomeIndexBean.DataBean.BrandListBean bean = list.get(position);
        ((TextView)holder.getView(R.id.txt_name)).setText(bean.getName()+"新的名字");
        Log.i("brand-click",String.valueOf(position));
        //跳转到brand详情页
        Intent intent = new Intent(getContext(), BrandActivity.class);
        intent.putExtra("brandId",bean.getId());
        startActivity(intent);
    }
}