package com.example.shops.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shops.interfaces.IBasePersenter;
import com.example.shops.interfaces.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 定义Activity的基类，用来实现mvp中V层的基础功能
 * MVP框架中BaseActivity类应该具备如下特征：
 * 1.应该包含用来处理网络数据逻辑的P层
 * 2.应该具备界面初始化的方法initView
 * 3.应该具备数据初始化的方法initData
 * 4.获取当前应该显示的xml布局页面
 * 5.生命周期结束的时候解绑p层的关联
 *abstract  抽象的BaseActivity
 */
public abstract class BaseActivity<P extends IBasePersenter> extends AppCompatActivity implements IBaseView {

    protected P persenter;
     Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());//加载布局xml
        unbinder = ButterKnife.bind(this);
        //初始化布局
        initView();
        //创建P层
        persenter = createPersenter();
        if (persenter != null) {
            persenter.attachView(this);
        }
        //初始化数据
        initData();
    }

    protected abstract void initData();

    //创建P层并返回
    protected abstract P createPersenter();

    protected abstract void initView();

    /**
     * 通过模板的设计模式，定义需要处理的方法
     */
    protected abstract int getLayout();

    @Override
    public void showMes(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    /**
     * activity移除的时候解绑persenter和v层
     * 解绑当前activity的butterknife
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (persenter != null) {
            persenter.detachView();//activity移除的时候解绑persenter和v层
        }
        if (unbinder != null) {
            unbinder.unbind();//解绑当前activity的butterknife
        }
    }
}
