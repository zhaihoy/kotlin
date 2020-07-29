package com.example.kotlin.rxrequest;


import com.example.kotlin.bean.ApiConstants;
import com.example.kotlin.bean.Constants;
import com.example.kotlin.http.BaseApplication;
import com.example.kotlin.http.HttpLoggingInterceptor;

import java.io.File;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    private static OkHttpClient.Builder getOkHttpClientBuilder() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor("OkHttp");
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
        loggingInterceptor.setColorLevel(Level.INFO);
//        File cacheFile = new File(Objects.requireNonNull(BaseApplication.Companion.getContext()).getCacheDir(), "cache");
//        //100Mb
//        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100);

        return new OkHttpClient.Builder()
                .readTimeout(Constants.DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
                .connectTimeout(Constants.DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
                .addInterceptor(loggingInterceptor);
//                .addInterceptor(new AddCookiesInterceptor())
//                .addInterceptor(new SaveCookiesInterceptor())
//                .cache(cache);
    }
//配置一下retrofit

    static Retrofit factory() {
        OkHttpClient okHttpClient = getOkHttpClientBuilder().build();
        return new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiConstants.BASE_URL)
                .build();
    }
}
