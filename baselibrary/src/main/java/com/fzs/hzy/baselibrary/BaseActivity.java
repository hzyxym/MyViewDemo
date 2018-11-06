package com.fzs.hzy.baselibrary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;


import com.fzs.hzy.mylibrary.TestActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BaseActivity extends Activity {
    @BindView(R2.id.btn_base)
    Button btn_base;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_base);
        ButterKnife.bind(this);
        btn_base.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });
    }
}
