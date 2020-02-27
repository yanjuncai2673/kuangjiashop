package com.example.shops.ui.home;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
import com.example.shops.ui.home.activity.HomeNewgoodsDetailActivity;
import com.example.shops.ui.sort.activity.cart.GlidImageLoad;
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
    @BindView(R.id.txt_popular)
    TextView txtPopular;
    @BindView(R.id.recyclerView_populer)
    RecyclerView recyclerViewPopuler;
    @BindView(R.id.txt_topiclist)
    TextView txtTopiclist;
    @BindView(R.id.recyclerView_topiclist)
    RecyclerView recyclerViewTopiclist;

    @BindView(R.id.tv_family_name)
    TextView tvFamilyName;
    @BindView(R.id.rv_homeca_family)
    RecyclerView rvHomecaFamily;
    @BindView(R.id.tv_food_name)
    TextView tvFoodName;
    @BindView(R.id.rv_homeca_food)
    RecyclerView rvHomecaFood;
    @BindView(R.id.tv_drink_name)
    TextView tvDrinkName;
    @BindView(R.id.rv_homeca_drink)
    RecyclerView rvHomecaDrink;
    @BindView(R.id.tv_peij_name)
    TextView tvPeijName;
    @BindView(R.id.rv_homeca_peij)
    RecyclerView rvHomecaPeij;
    @BindView(R.id.tv_cloth_name)
    TextView tvClothName;
    @BindView(R.id.rv_homeca_cloth)
    RecyclerView rvHomecaCloth;
    @BindView(R.id.tv_child_name)
    TextView tvChildName;
    @BindView(R.id.rv_homeca_child)
    RecyclerView rvHomecaChild;
    @BindView(R.id.tv_zawu_name)
    TextView tvZawuName;
    @BindView(R.id.rv_homeca_zawu)
    RecyclerView rvHomecaZawu;
    @BindView(R.id.tv_xihu_name)
    TextView tvXihuName;
    @BindView(R.id.rv_homeca_xihu)
    RecyclerView rvHomecaXihu;
    @BindView(R.id.tv_like_name)
    TextView tvLikeName;
    @BindView(R.id.rv_homeca_like)
    RecyclerView rvHomecaLike;


    @BindView(R.id.tv_tab_family)
    TextView tvTabFamily;
    @BindView(R.id.tv_tab_food)
    TextView tvTabFood;
    @BindView(R.id.tv_tab_parts)
    TextView tvTabParts;
    @BindView(R.id.tv_tab_clothing)
    TextView tvTabClothing;
    @BindView(R.id.tv_tab_likes)
    TextView tvTabLikes;


    BrandAdapter brandAdapter;
    List<HomeIndexBean.DataBean.BrandListBean> list;

    NewGoodsAdapter newgoodsAdapter;
    List<HomeIndexBean.DataBean.NewGoodsListBean> newsList;

    HotGoodsAdapter hotGoodsAdapter;
    List<HomeIndexBean.DataBean.HotGoodsListBean> hotGoodsList;

    TopicListAdapter topicListAdapter;
    List<HomeIndexBean.DataBean.TopicListBean> topicListBeanList;

    //居家
    HomeCategoryAdapter homeCategoryAdapter;
    List<HomeIndexBean.DataBean.CategoryListBean> goodsList;

    HomeCategoryFoodAdapter homeCategoryFoodAdapter;
    List<HomeIndexBean.DataBean.CategoryListBean> goodsList2;

    HomeCategoryDrinkAdapter homeCategoryDrinkAdapter;
    List<HomeIndexBean.DataBean.CategoryListBean> goodsList3;

    HomeCategoryPeijAdapter homeCategoryPeijAdapter;
    List<HomeIndexBean.DataBean.CategoryListBean> goodsList4;

    HomeCategoryClothAdapter homeCategoryClothAdapter;
    List<HomeIndexBean.DataBean.CategoryListBean> goodsList5;

    HomeCategoryChildAdapter homeCategoryChildAdapter;
    List<HomeIndexBean.DataBean.CategoryListBean> goodsList6;

    HomeCategoryZawuAdapter homeCategoryZawuAdapter;
    List<HomeIndexBean.DataBean.CategoryListBean> goodsList7;

    HomeCategoryXihuAdapter homeCategoryXihuAdapter;
    List<HomeIndexBean.DataBean.CategoryListBean> goodsList8;

    HomeCategoryLikeAdapter homeCategoryLikeAdapter;
    List<HomeIndexBean.DataBean.CategoryListBean> goodsList9;
    private List<HomeIndexBean.DataBean.CategoryListBean> categoryList;


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
                //新品点击监听
                HomeIndexBean.DataBean.NewGoodsListBean newgoods = newsList.get(position);
                Intent intent1 = new Intent(getActivity(), HomeNewgoodsDetailActivity.class);
                intent1.putExtra("id",newgoods.getId());
                startActivity(intent1);
            }
        });

        //人气推荐
        recyclerViewPopuler.setLayoutManager(new LinearLayoutManager(getActivity()));
        hotGoodsList = new ArrayList<>();
        hotGoodsAdapter = new HotGoodsAdapter(hotGoodsList, getActivity());
        recyclerViewPopuler.setAdapter(hotGoodsAdapter);
        hotGoodsAdapter.setOnItemClickHandler(new BaseAdapter.ItemClickHandler() {
            @Override
            public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {
                HomeIndexBean.DataBean.HotGoodsListBean hotGoodsListBean = hotGoodsList.get(position);
                Intent intent2 = new Intent(getActivity(), HomeNewgoodsDetailActivity.class);
                intent2.putExtra("id",hotGoodsListBean.getId());
                startActivity(intent2);
            }
        });

        //专题精选
        recyclerViewTopiclist.setLayoutManager(new GridLayoutManager(getActivity(), 1, LinearLayoutManager.HORIZONTAL, true));
        topicListBeanList = new ArrayList<>();
        topicListAdapter = new TopicListAdapter(topicListBeanList, getActivity());
        recyclerViewTopiclist.setAdapter(topicListAdapter);


        //首页居家 餐厨 等
        rvHomecaFamily.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvHomecaChild.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvHomecaCloth.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvHomecaDrink.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvHomecaFood.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvHomecaLike.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvHomecaPeij.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvHomecaXihu.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvHomecaZawu.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        goodsList = new ArrayList<>();
        goodsList2 = new ArrayList<>();
        goodsList3 = new ArrayList<>();
        goodsList4 = new ArrayList<>();
        goodsList5 = new ArrayList<>();
        goodsList6 = new ArrayList<>();
        goodsList7 = new ArrayList<>();
        goodsList8 = new ArrayList<>();
        goodsList9 = new ArrayList<>();
        homeCategoryAdapter = new HomeCategoryAdapter(goodsList, getActivity());
        homeCategoryFoodAdapter = new HomeCategoryFoodAdapter(goodsList2, getActivity());
        homeCategoryDrinkAdapter = new HomeCategoryDrinkAdapter(goodsList3, getActivity());
        homeCategoryPeijAdapter = new HomeCategoryPeijAdapter(goodsList4, getActivity());
        homeCategoryClothAdapter = new HomeCategoryClothAdapter(goodsList5, getActivity());
        homeCategoryChildAdapter = new HomeCategoryChildAdapter(goodsList6, getActivity());
        homeCategoryZawuAdapter = new HomeCategoryZawuAdapter(goodsList7, getActivity());
        homeCategoryXihuAdapter = new HomeCategoryXihuAdapter(goodsList8, getActivity());
        homeCategoryLikeAdapter = new HomeCategoryLikeAdapter(goodsList9,getActivity());

        rvHomecaFamily.setAdapter(homeCategoryAdapter);
        rvHomecaFood.setAdapter(homeCategoryFoodAdapter);
        rvHomecaDrink.setAdapter(homeCategoryDrinkAdapter);
        rvHomecaPeij.setAdapter(homeCategoryPeijAdapter);
        rvHomecaCloth.setAdapter(homeCategoryClothAdapter);
        rvHomecaChild.setAdapter(homeCategoryChildAdapter);
        rvHomecaLike.setAdapter(homeCategoryLikeAdapter);
        rvHomecaZawu.setAdapter(homeCategoryZawuAdapter);
        rvHomecaXihu.setAdapter(homeCategoryXihuAdapter);

        homeCategoryAdapter.setOnItemClickHandler(new BaseAdapter.ItemClickHandler() {
            @Override
            public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {
                int id = categoryList.get(0).getGoodsList().get(position).getId();
                Intent intent3 = new Intent(getActivity(), HomeNewgoodsDetailActivity.class);
                intent3.putExtra("id",id);
                startActivity(intent3);
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
//刷新banner数据
        updatahomebanners(indexbean.getData().getBanner());


        //刷新人气推荐数据
        hotGoodsAdapter.updata(indexbean.getData().getHotGoodsList());

        //专题精选
        topicListAdapter.updata(indexbean.getData().getTopicList());


        categoryList = indexbean.getData().getCategoryList();


        homeCategoryAdapter.updata(categoryList.get(0).getGoodsList());
        homeCategoryFoodAdapter.updata(categoryList.get(1).getGoodsList());
        homeCategoryDrinkAdapter.updata(categoryList.get(2).getGoodsList());
        homeCategoryPeijAdapter.updata(categoryList.get(3).getGoodsList());
        homeCategoryClothAdapter.updata(categoryList.get(4).getGoodsList());
        homeCategoryChildAdapter.updata(categoryList.get(5).getGoodsList());
        homeCategoryZawuAdapter.updata(categoryList.get(6).getGoodsList());
        homeCategoryXihuAdapter.updata(categoryList.get(7).getGoodsList());
        homeCategoryLikeAdapter.updata(categoryList.get(8).getGoodsList());



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