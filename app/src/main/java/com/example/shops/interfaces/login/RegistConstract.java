package com.example.shops.interfaces.login;

import com.example.shops.interfaces.IBasePersenter;
import com.example.shops.interfaces.IBaseView;
import com.example.shops.model.bean.login.RegistBean;

//注册界面的契约类
public interface RegistConstract {
    interface View extends IBaseView{
        void getRegistReturn(RegistBean registBean);
    }
    interface Presenter extends IBasePersenter<View>{

        void getRegistData();
    }
}
