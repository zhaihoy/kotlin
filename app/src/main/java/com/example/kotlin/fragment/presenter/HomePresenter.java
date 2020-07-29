package com.example.kotlin.fragment.presenter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.MainThread;

import com.bumptech.glide.Glide;
import com.example.kotlin.bean.BannerBean;
import com.example.kotlin.fragment.HomeFragment;
import com.example.kotlin.http.BaseResponse;
import com.example.kotlin.rxrequest.RxRequestHelper;
import com.to.aboomy.banner.IndicatorView;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter implements HomePresenterLml {


    private final HomeFragment mView;

    public HomePresenter(HomeFragment mHomeFragment) {
        this.mView = mHomeFragment;
    }

    @Override
    public void loadBanner() {
        //加载数据
        RxRequestHelper.INSTANCE.getApiService().getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResponse<List<BannerBean>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResponse<List<BannerBean>> listBaseResponse) {
                            if (mView != null) {
                                mView.showBanner(Objects.requireNonNull(listBaseResponse.getData()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                        System.out.println("zhy====" + e.toString());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

//    //实现HolderCreator接口
////    public interface HolderCreator {
////        View createView(Context context, final int index, Object o);
////    }
////
////    //举个栗子
////    public class ImageHolderCreator implements HolderCreator {
////        @Override
////        public View createView(final Context context, final int index, Object o) {
////            ImageView iv = new ImageView(context);
////            iv.setScaleType(ImageView.ScaleType.FIT_XY);
////            Glide.with(context).load(o).into(iv);
////            //内部实现点击事件
////            iv.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////                    Toast.makeText(context, index + "", Toast.LENGTH_LONG).show();
////                }
////            });
////            return iv;
////        }
//    }
}
