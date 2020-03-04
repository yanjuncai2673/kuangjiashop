package com.example.shops.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.shops.R;
import com.example.shops.base.BaseActivity;
import com.example.shops.interfaces.login.LoginConstract;
import com.example.shops.model.bean.login.UserLoginBean;
import com.example.shops.persenter.login.LoginPresenter;
import com.example.shops.utils.SpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginConstract.Presenter> implements LoginConstract.View {
    @BindView(R.id.tv_login_user)
    TextView tvLoginUser;
    @BindView(R.id.et_login_name)
    EditText etLoginName;
    @BindView(R.id.con_login_name)
    ConstraintLayout conLoginName;
    @BindView(R.id.tv_login_pwd)
    TextView tvLoginPwd;
    @BindView(R.id.et_login_pwd)
    EditText etLoginPwd;
    @BindView(R.id.con_login_pwd)
    ConstraintLayout conLoginPwd;
    @BindView(R.id.btn_login_regist)
    Button btnLoginRegist;
    @BindView(R.id.btn_login_lo)
    Button btnLoginLo;
    @BindView(R.id.con_login_btn)
    ConstraintLayout conLoginBtn;

    @Override
    protected void initData() {

    }

    @Override
    protected LoginConstract.Presenter createPersenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void getLoginReturn(UserLoginBean userLoginBean) {
        //登录成功将token存入sp
        SpUtils.getInstance().setValue("token", userLoginBean.getData().getToken());
        finish();
    }



    @OnClick({R.id.btn_login_regist, R.id.btn_login_lo})
    public void onViewClicked(View view) {
        String name = etLoginName.getText().toString();
        String pwd = etLoginPwd.getText().toString();

        switch (view.getId()) {
            case R.id.btn_login_regist:
                regist();
                break;
            case R.id.btn_login_lo:
                if (!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(pwd)) {
                    showMes("登录成功");
                    persenter.getLoginData(name, pwd);
                }else {
                    showMes("账号或密码不能为空");
                }
                break;
        }
    }

    private void regist() {
        Intent intent = new Intent(this, RegistActivity.class);
        startActivityForResult(intent,210);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 210&&resultCode==220) {
            if(data!=null) {
                String name = data.getStringExtra("name");
                String pwd = data.getStringExtra("pwd");
                String repwd = data.getStringExtra("repwd");
                etLoginName.setText(name);
                etLoginPwd.setText(pwd);
            }
        }
    }
}
