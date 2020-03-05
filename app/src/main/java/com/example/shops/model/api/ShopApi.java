package com.example.shops.model.api;

import com.example.shops.model.bean.home.BrandBean;
import com.example.shops.model.bean.home.BrandGoodsBean;
import com.example.shops.model.bean.home.HomeBrandMadeBean;
import com.example.shops.model.bean.home.HomeIndexBean;
import com.example.shops.model.bean.home.HomeNewGoodsDetailBean;
import com.example.shops.model.bean.login.RegistBean;
import com.example.shops.model.bean.login.UserLoginBean;
import com.example.shops.model.bean.shopping.CartGoodsCheckedBean;
import com.example.shops.model.bean.shopping.DeleteCartGoodsBean;
import com.example.shops.model.bean.shopping.GoShoppingBean;
import com.example.shops.model.bean.shopping.UpdateCartGoodsBean;
import com.example.shops.model.bean.sort.SortDataBean;
import com.example.shops.model.bean.sort.SortDetailDataBean;
import com.example.shops.model.bean.sort.SortDetailTabBean;
import com.example.shops.model.bean.sort.SortGoodsListBean;
import com.example.shops.model.bean.sort.cart.JobGoShoppingBean;
import com.example.shops.model.bean.sort.cart.SortDetailItemBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

    //获取首页品牌制造商列表接口
    @GET("brand/list")
    Flowable<HomeBrandMadeBean>getHomeBrandMadeData(@Query("page")int page,@Query("size")int size);

    //获取首页新品 居家 餐厨等详情接口
    @GET("goods/related")
    Flowable<HomeNewGoodsDetailBean>getHomeNewgoodsDetailData(@Query("id")int id);

    //登录接口
    @POST("auth/login")
    @FormUrlEncoded
    Flowable<UserLoginBean>getLogin(@Field("nickname")String nickname,@Field("password")String password);

    //注册验证码接口
    @GET("auth/verify")
    Flowable<RegistBean> getRegistVerify();

    //获取购物车界面数据接口
    @GET("cart/index")
    Flowable<GoShoppingBean>getGoShopping();

    //获取购物车商品是否是选中状态的接口
    @POST("cart/checked")
    @FormUrlEncoded//post方式需要form表单url
    Flowable<CartGoodsCheckedBean>getCartGoodsChecked(@Field("productIds")String pids,@Field("isChecked")int isChecked);

    //获取购物车更新数据接口
    @POST("cart/update")
    @FormUrlEncoded
    Flowable<UpdateCartGoodsBean>updateCartGoods(@Field("productId")String productId,@Field("goodsId")String goodsId,@Field("number")int number,@Field("id")int id);

    //获取购物车删除数据接口
    @POST("cart/delete")
    @FormUrlEncoded
    Flowable<DeleteCartGoodsBean> deleteCartGoods(@Field("productIds")String productIds);

    //加入到购物车接口
    @POST("cart/add")
    @FormUrlEncoded
    Flowable<JobGoShoppingBean>getJobGoShopping(@Field("goodsId")int goodsId,@Field("number")int number,@Field("productId")int productId);
}
