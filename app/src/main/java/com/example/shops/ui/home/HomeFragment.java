package com.example.shops.ui.home;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shops.R;
import com.example.shops.base.BaseAdapter;
import com.example.shops.base.BaseFragment;
import com.example.shops.interfaces.home.HomeConstract;
import com.example.shops.model.bean.home.HomeIndexBean;
import com.example.shops.persenter.home.HomePersenter;
import com.example.shops.ui.home.activity.BrandActivity;
import com.example.shops.ui.home.activity.HomeBrandMadeActivity;
import com.example.shops.ui.sort.activity.cart.GlidImageLoad;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<HomeConstract.Persenter> implements HomeConstract.View, BaseAdapter.ItemClickHandler, View.OnClickListener {


    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.txt_news)
    TextView txtNews;
    @BindView(R.id.recyclerView_News)
    RecyclerView recyclerViewNews;
    @BindView(R.id.baner_home)
    Banner banerHome;
    @BindView(R.id.tab_home)
    TabLayout tabHome;
    @BindView(R.id.txt_popular)
    TextView txtPopular;
    @BindView(R.id.recyclerView_populer)
    RecyclerView recyclerViewPopuler;
    @BindView(R.id.txt_topiclist)
    TextView txtTopiclist;
    @BindView(R.id.recyclerView_topiclist)
    RecyclerView recyclerViewTopiclist;

    @BindView(R.id.txt_family)
    TextView txtFamily;
    @BindView(R.id.recyclerView_family)
    RecyclerView recyclerViewFamily;
    @BindView(R.id.txt_food)
    TextView txtFood;
    @BindView(R.id.recyclerView_food)
    RecyclerView recyclerViewFood;


    BrandAdapter brandAdapter;
    List<HomeIndexBean.DataBean.BrandListBean> list;

    NewGoodsAdapter newgoodsAdapter;
    List<HomeIndexBean.DataBean.NewGoodsListBean> newsList;

    HotGoodsAdapter hotGoodsAdapter;
    List<HomeIndexBean.DataBean.HotGoodsListBean> hotGoodsList;

    TopicListAdapter topicListAdapter;
    List<HomeIndexBean.DataBean.TopicListBean> topicListBeanList;

   /* FamilyAdapter familyAdapter;
    List<HomeIndexBean.DataBean.CategoryListBean.GoodsListBean> familylist;

    FoodAdapter foodAdapter;
    List<HomeIndexBean.DataBean.CategoryListBean.GoodsListBean> topicListBeanList;*/



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
//品牌制造商直供
        list = new ArrayList<>();
        brandAdapter = new BrandAdapter(list, context);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerView.setAdapter(brandAdapter);
        brandAdapter.setOnItemClickHandler(this);
        txtTitle.setOnClickListener(this);

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

        //人气推荐
        recyclerViewPopuler.setLayoutManager(new LinearLayoutManager(getActivity()));
        hotGoodsList = new ArrayList<>();
        hotGoodsAdapter = new HotGoodsAdapter(hotGoodsList, getActivity());
        recyclerViewPopuler.setAdapter(hotGoodsAdapter);

        //专题精选
        recyclerViewTopiclist.setLayoutManager(new GridLayoutManager(getActivity(), 1, LinearLayoutManager.HORIZONTAL, true));
        topicListBeanList = new ArrayList<>();
        topicListAdapter = new TopicListAdapter(topicListBeanList, getActivity());
        recyclerViewTopiclist.setAdapter(topicListAdapter);


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
//刷新banner数据
        updatahomebanners(indexbean.getData().getBanner());
        //刷新TabLayout数据
        updatahomeTabs(indexbean.getData().getChannel());

        //刷新人气推荐数据
        hotGoodsAdapter.updata(indexbean.getData().getHotGoodsList());

        //专题精选
        topicListAdapter.updata(indexbean.getData().getTopicList());

    }


    private void updatahomeTabs(List<HomeIndexBean.DataBean.ChannelBean> channel) {
        for (int i = 0; i < channel.size(); i++) {
            String name = channel.get(i).getName();
        }

    }

    private void updatahomebanners(List<HomeIndexBean.DataBean.BannerBean> banner) {
        List<String> imgs = new ArrayList<>();
        for (int i = 0; i < banner.size(); i++) {
            imgs.add(banner.get(i).getImage_url());
        }
        banerHome.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setImages(imgs)
                .setImageLoader(new GlidImageLoad())
                .start();
    }


    @Override//接口回调跳转详情
    public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {
        HomeIndexBean.DataBean.BrandListBean bean = list.get(position);
        ((TextView) holder.getView(R.id.txt_name)).setText(bean.getName() + "新的名字");
        Log.i("brand-click", String.valueOf(position));
        //跳转到brand详情页
        Intent intent = new Intent(getContext(), BrandActivity.class);
        intent.putExtra("brandId", bean.getId());
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), HomeBrandMadeActivity.class);
        startActivity(intent);
    }
}