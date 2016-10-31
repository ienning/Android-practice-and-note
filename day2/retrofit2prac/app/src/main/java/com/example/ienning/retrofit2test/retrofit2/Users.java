package com.example.ienning.retrofit2test.retrofit2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ienning on 16-10-31.
 */

public interface Users {
    @GET("x3/weather")
    Observable<HeWeatherBean> getWeatherService(@Query("cityid") String cityid, @Query("key") String key);
    @GET("x3/attractions")
    Observable<HeWeatherBean> getScenicService(@Query("cityid") String cityid, @Query("key") String key);

    String BASE_URL = "https://api.heweather.com";
    class Factory {
        public static final Users create() {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            // 拦截器的可以当网络出问题是，进行连接重试，比如一个token如果过期了，可以使用使用拦截器进行重新登录，获取新的有效Token
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .addNetworkInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            //进行重定向操作，比如上面所说的Token过期问题，可以使用这种方法
                            return chain.proceed(chain.request());
                        }
                    })
                    .connectTimeout(15, TimeUnit.SECONDS) //设置超时连接
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) //Json数据转换
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //将Callable的借口转化为Observable接口
                    .client(client) //网络请求客户端为okhttp
                    .build();
            return retrofit.create(Users.class);
        }
    }
}
