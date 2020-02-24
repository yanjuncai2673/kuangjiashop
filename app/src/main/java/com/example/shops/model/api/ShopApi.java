package com.example.shops.model.api;

import com.example.shops.model.bean.home.BrandBean;
import com.example.shops.model.bean.home.BrandGoodsBean;
import com.example.shops.model.bean.home.HomeIndexBean;
import com.example.shops.model.bean.sort.SortDataBean;
import com.example.shops.model.bean.sort.SortDetailDataBean;
import com.example.shops.model.bean.sort.SortDetailTabBean;
import com.example.shops.model.bean.sort.SortGoodsListBean;
import com.example.shops.model.bean.sort.cart.SortDetailItemBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
//Api接口类
public interface ShopApi {
    //首页接口Api
    @GET("index")
    Flowable<HomeIndexBean> getIndexData();

    //品牌直供的详情页数据接口
    @GET("brand/detail")
    Flowable<BrandBean> getBrandInfo(@Query("id") String id);
    //品牌直供详情的商品列表数据接口
    @GET("goods/list")
    Flowable<BrandGoodsBean> getBrandGoods(@Query("brandId") String brandId, @Query("page") int page, @Query("size") int size);
    //分类页面tab接口
    @GET("catalog/index")
    Flowable<SortDataBean>getSortData();
//获取分类页面网格数据
    @GET("catalog/current")
    Flowable<SortGoodsListBean>getSortGoodsList(@Query("id")int id);

    //获取分类详情tab接口
    @GET("goods/category")
    Flowable<SortDetailTabBean>getSortDetailTabDatas(@Query("id")int id);
    //获取分类详情接口
    @GET("goods/list")
    Flowable<SortDetailDataBean>getSortDetailDatas(@Query("categoryId")int id,@Query("page")int page,@Query("size")int size);

    //获取分类详情条目内的接口   商品购买
    @GET("goods/detail")
    Flowable<SortDetailItemBean>getSortDetailItemData(@Query("id")int id);
}
