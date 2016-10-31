package com.example.ienning.layoutmanagerview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ienning on 16-10-31.
 */

public class FrameLayoutMa extends Activity {
    final int[] colors = new int[] {
            R.color.color1,
            R.color.color2,
            R.color.color3,
            R.color.color4,
            R.color.color5,
            R.color.color6
    };
    final int[] names = new int[] {
            R.id.view01,
            R.id.view02,
            R.id.view03,
            R.id.view04,
            R.id.view05,
            R.id.view06,
    };
    TextView[] views = new TextView[names.length];
    private int currentColor = 0;
    /*
    通过一个子线程进行UI更新,what 携带的是handler.snedEmptyMessage(0x123)传进的更新信息
    利用currentColor达到每次更新每个控件时，这些颜色变化是循环的
     */
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            //表明消息来自程序所发送
            if (msg.what == 0x123) {
                for (int i = 0; i < names.length; i++) {
                    views[i].setBackgroundResource(colors[(i+currentColor) % names.length]);
                }
                currentColor++;
            }
            super.handleMessage(msg);
        }
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_frame);
        for (int i = 0; i < names.length; i++) {
            views[i] = (TextView) findViewById(names[i]);
        }
        // 定义一个线程周期性地改变currentColor变量值
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //发送一条空消息通知系统更改６个TextView组件的背景色
                handler.sendEmptyMessage(0x123);
            }
        }, 0 , 200);
    }
}
