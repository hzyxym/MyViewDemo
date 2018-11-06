package com.fzs.hzy.myviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.fzs.hzy.mylibrary.AutoImage;
import com.fzs.hzy.mylibrary.GlideApp;
import com.fzs.hzy.myviewdemo.entity.NavExtendParameters;
import com.fzs.hzy.myviewdemo.view.LoadingView;
import com.google.gson.Gson;
import com.socks.library.KLog;


import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.viewpager)
    Button vpBtn;

    @BindView(R.id.imageView)
    AutoImage imageView;
    @BindView(R.id.iv_corner)
    ImageView iv_corner;

    @BindView(R.id.loading)
    LoadingView loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        vpBtn.setOnClickListener(this);
        KLog.i("hello");

//        loading.postDelayed(new Runnable() {
//            @Override
//            public void run() {
////                loading.setVisibility(View.INVISIBLE);
//                loading.setVisibility(View.VISIBLE);
//            }
//        },5000);

        /*RoundedCorners roundedCorners= new RoundedCorners(12);
        //通过RequestOptions扩展功能
        RequestOptions options = new RequestOptions()
                .bitmapTransform(roundedCorners);*/
//        GlideApp.with(this)
//                .load("https://goss4.veer.com/creative/vcg/veer/612/veer-142464656.jpg")
//                .optionalTransform(new RoundedCorners(12))
//                .into(imageView);

//        GlideApp.with(this.getApplicationContext())
//                .load("https://goss4.veer.com/creative/vcg/veer/612/veer-142464656.jpg")
//                .optionalTransform(new RoundedCorners(12))
//                .into(imageView);
        GlideApp.with(this)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539926328125&di=5577bd088da47ecccc457856aba3b085&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0157d959ccc890a801218e18235ad0.gif")
                .into(iv_corner);


//        RequestOptions options = new RequestOptions()
//                .centerCrop()
//                //.placeholder(R.mipmap.ic_launcher_round)
//                .error(android.R.drawable.stat_notify_error)
//                .priority(Priority.HIGH)
//                //.skipMemoryCache(true)
//                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
        Glide.with(this)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539926328125&di=5577bd088da47ecccc457856aba3b085&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0157d959ccc890a801218e18235ad0.gif")
                .into(imageView);



        String json =  "{ \"action\": \"junmpApp\", \"actionPars\": { \"androidClass\": \"com.phone580.appMarket.ui.activity.Model.ModelVirtualDetailActivity\", \"categoryId\": \"FZSAZ_LPK_SUNING_A\" } }";
        NavExtendParameters parameters = resolveNavJson(json);
        Log.i("resolveNavJson","ActionParams :"+ parameters.getActionParams());
        Log.i("resolveNavJson","CalssPath :"+ parameters.getCalssPath());
        Log.i("resolveNavJson","isLogin :"+ parameters.isLogin());
        reSetTime(357579946);
    }

    private void reSetTime(long ms) {
        int day = 0;
        int hour;

//        if (!mCountdown.isConvertDaysToHours) {
            day = (int) (ms / (1000 * 60 * 60 * 24));
            hour = (int) ((ms % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
//        } else {
//            hour = (int) (ms / (1000 * 60 * 60));
//        }

        int minute = (int)((ms % (1000 * 60 * 60)) / (1000 * 60));
        int second = (int)((ms % (1000 * 60)) / 1000);
        int millisecond = (int)(ms % 1000);

        KLog.i("second:"+second+",minute:"+minute+",hour:"+hour+",day:"+day);
//        mCountdown.setTimes(day, hour, minute, second, millisecond);
    }

    private NavExtendParameters resolveNavJson(String json){
        Gson gson = new Gson();
        NavExtendParameters navExtendParameters =  gson.fromJson(json,NavExtendParameters.class);
        Object object = navExtendParameters.getActionPars();
        try {
            String params = gson.toJson(object);
            navExtendParameters.setActionParams(params);
            JSONObject jsonObject = new JSONObject(params);
            if(jsonObject.has("androidClass")){
                String className = jsonObject.getString("androidClass");
                navExtendParameters.setCalssPath(className);
            }
            if(jsonObject.has("isLogin")){
                boolean isLogin = jsonObject.getBoolean("isLogin");
                navExtendParameters.setLogin(isLogin);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return navExtendParameters;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.viewpager:
//                Intent intent = new Intent(this, BaseActivity.class);
//                startActivity(intent);
                if (View.VISIBLE == loading.getVisibility()) {
                    vpBtn.setText("开始加载");
                    loading.setVisibility(View.INVISIBLE);
                } else {
                    vpBtn.setText("停止加载");
                    loading.setVisibility(View.VISIBLE);
                }
                break;
            default:
                break;
        }

    }
}
