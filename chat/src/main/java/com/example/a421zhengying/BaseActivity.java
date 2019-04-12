package com.example.a421zhengying;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 郑莹 on 2019/4/12.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
