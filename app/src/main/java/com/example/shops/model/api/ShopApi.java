package com.example.shops.model.api;

import com.example.shops.model.bean.home.BrandBean;
import com.example.shops.model.bean.home.BrandGoodsBean;
import com.example.shops.model.bean.home.HomeIndexBean;
import com.example.shops.model.bean.sort.SortDataBean;
import com.example.shops.model.bean.sort.SortGoodsListBean;

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
    //分类页面接口
    @GET("catalog/index")
    Flowable<SortDataBean>getSortData();
//获取分类详细数据
    @GET("catalog/current")
    Flowable<SortGoodsListBean>getSortGoodsList(@Query("id")int id);
}
