package com.example.ienning.retrofit2test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.ienning.retrofit2test.retrofit2.HeWeatherBean;
import com.example.ienning.retrofit2test.retrofit2.NetWorkRequest;

import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void retrofit2() {
        NetWorkRequest netWorkRequest = NetWorkRequest.getNetworkRequest();
        Action1<HeWeatherBean> onNext = new Action1<HeWeatherBean>() {
            @Override
            public void call(HeWeatherBean heWeatherBean) {
                Log.i("Ienning", "call: the result is ok");
            }
        };
        netWorkRequest.getCityWeather("CN101240102", onNext);
    }
}
