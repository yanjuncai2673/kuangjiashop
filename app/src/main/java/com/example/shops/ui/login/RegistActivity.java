package com.example.shops.ui.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.shops.R;
import com.example.shops.base.BaseActivity;
import com.example.shops.interfaces.login.RegistConstract;
import com.example.shops.model.bean.login.RegistBean;

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

    }

    @Override
    protected RegistConstract.Presenter createPersenter() {
        return null;
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

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_re_regist)
    public void onViewClicked() {
    }
}
