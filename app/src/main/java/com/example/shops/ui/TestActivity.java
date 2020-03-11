package com.example.shops.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shops.R;
import com.example.shops.common.Constant;
import com.example.shops.model.api.ShopApi;
import com.google.gson.JsonObject;
import com.wildma.pictureselector.PictureSelector;

import org.json.JSONObject;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.btn_up)
    Button btnUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        applogin();//测试传递json数据

    }

    private void applogin() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_SHOP_URL)
                .build();
        ShopApi shopApi = retrofit.create(ShopApi.class);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("class", "1905A");
            jsonObject.put("number", "30");
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), jsonObject.toString());
        Call<ResponseBody> call = shopApi.applogin(requestBody);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.i("success", response.body().toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i("Fail", t.getMessage());
            }
        });
    }

    @OnClick(R.id.btn_up)
    public void onViewClicked() {
        uploadImage();//点击按钮上传图片

    }

    private void uploadImage() {//第三方选择图片
        PictureSelector.create(this,PictureSelector.SELECT_REQUEST_CODE)
                .selectPicture(200,200,1,1);
    }

    @Override//结果回调
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PictureSelector.SELECT_REQUEST_CODE) {
            if (data != null) {//获取图片本地地址
                String path = data.getStringExtra(PictureSelector.PICTURE_PATH);
                upload(path);
            }
        }

    }

    private void upload(String path) {
        File file = new File(path);                                //图片格式
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://yun918.cn/study/public/")
                .build();
        RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), "part");
        Call<ResponseBody> bodyCall = retrofit.create(ShopApi.class).uploadImage(body, part);
        bodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.i("successful",response.body().toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i("failed",t.getMessage());
            }
        });
    }
}
