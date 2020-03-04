package com.example.shops.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.example.shops.R;
import com.example.shops.base.BaseActivity;
import com.example.shops.interfaces.login.RegistConstract;
import com.example.shops.model.bean.login.RegistBean;
import com.example.shops.persenter.login.RegistPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistActivity extends BaseActivity<RegistConstract.Presenter> implements RegistConstract.View {
    @BindView(R.id.tv_regist_user)
    TextView tvRegistUser;
    @BindView(R.id.et_regist_name)
    EditText etRegistName;
    @BindView(R.id.con_regist_name)
    ConstraintLayout conRegistName;
    @BindView(R.id.tv_regist_pwd)
    TextView tvRegistPwd;
    @BindView(R.id.et_regist_pwd)
    EditText etRegistPwd;
    @BindView(R.id.con_regist_pwd)
    ConstraintLayout conRegistPwd;
    @BindView(R.id.tv_regist_repwd)
    TextView tvRegistRepwd;
    @BindView(R.id.et_regist_repwd)
    EditText etRegistRepwd;
    @BindView(R.id.con_regist_repwd)
    ConstraintLayout conRegistRepwd;
    @BindView(R.id.btn_re_regist)
    Button btnReRegist;
    @BindView(R.id.con_regist_btn)
    ConstraintLayout conRegistBtn;

    @Override
    protected void initData() {
        persenter.getRegistData();
    }

    @Override
    protected RegistConstract.Presenter createPersenter() {
        return new RegistPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_regist;
    }

    @Override
    public void getRegistReturn(RegistBean registBean) {
updataRegist(registBean);
    }

    private void updataRegist(RegistBean registBean) {
      //  Toast.makeText(this, ""+registBean.getData().getCode(), Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.btn_re_regist)
    public void onViewClicked() {
        String name = etRegistName.getText().toString();
        String pwd = etRegistPwd.getText().toString();
        String repwd = etRegistRepwd.getText().toString();
        if (!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(pwd)&&!TextUtils.isEmpty(repwd)) {
            if (pwd.equals(repwd)) {
                Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.putExtra("name",name);
                intent.putExtra("pwd",pwd);
                intent.putExtra("repwd",repwd);
                setResult(220,intent);
                finish();
            }else {
                Toast.makeText(this, "密码输入有误，请重新输入", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
        }
    }
}
