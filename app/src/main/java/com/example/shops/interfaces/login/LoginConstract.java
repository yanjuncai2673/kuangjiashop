package com.example.shops.interfaces.login;

import com.example.shops.interfaces.IBasePersenter;
import com.example.shops.interfaces.IBaseView;
import com.example.shops.model.bean.login.UserLoginBean;

//登录契约类接口
public interface LoginConstract {

    interface View extends IBaseView {//v层用于返回登录对象

        void getLoginReturn(UserLoginBean userLoginBean);
    }

    //"username": "a878f5fa-9fd7-461a-82cc-1af52492e0d2",
    //            "nickname": "qq1",
    interface Presenter extends IBasePersenter<View> {
        void getLoginData(String username,String password);//用于登录获取数据 将用户名密码传入
    }
}
