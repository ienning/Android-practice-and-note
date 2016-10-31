package com.example.ienning.retrofit2test.retrofit2;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by ienning on 16-10-31.
 */

public class NetWorkRequest {
    private NetWorkRequest() {
    }
    //利用单例设计模式
    private static class NetWorkRequestUse {
        private static final Users users = Users.Factory.create();
        private static final NetWorkRequest netWorkRequest = new NetWorkRequest();
    }
    private static final Users getUsers() {
        return NetWorkRequestUse.users;
    }
    public static final NetWorkRequest getNetworkRequest() {
        return NetWorkRequestUse.netWorkRequest;
    }
    //使用RxJava进行异步处理
    private class ComposeThread<T> implements Observable.Transformer<T, T> {
        @Override
        public Observable<T> call(Observable<T> observable) {
            return observable
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    }
    //传入的Action1的参数可以进一步对UI进行操作。
    public void getCityWeather(String cityId, Action1 onNext) {
        getUsers().getWeatherService(cityId, GlobleData.HEFENG_KEY).compose(new ComposeThread<HeWeatherBean>()).subscribe(onNext);
    }
    public void getScenicWeather(String senicId, Action1 onNext) {
        getUsers().getScenicService(senicId, GlobleData.HEFENG_KEY).compose(new ComposeThread<HeWeatherBean>()).subscribe(onNext);
    }
}
