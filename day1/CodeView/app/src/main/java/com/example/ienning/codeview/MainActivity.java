package com.example.ienning.codeview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        root = (LinearLayout) findViewById(R.id.root);
        /*
        创建DrawableView对象，设置最小宽度和高度，然后添加这个控件到LinearLayout上
         */
        final DrawableView  draw = new DrawableView(this);
        draw.setMinimumWidth(500);
        draw.setMinimumWidth(300);
        root.addView(draw);
    }
}
