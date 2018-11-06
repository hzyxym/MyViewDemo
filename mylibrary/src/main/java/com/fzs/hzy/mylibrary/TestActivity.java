package com.fzs.hzy.mylibrary;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends Activity {
    @BindView(R2.id.btn_test)
    Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test);
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.btn_test)
    public void showTest(){
        Toast.makeText(this,"test",Toast.LENGTH_SHORT).show();
    }
}
