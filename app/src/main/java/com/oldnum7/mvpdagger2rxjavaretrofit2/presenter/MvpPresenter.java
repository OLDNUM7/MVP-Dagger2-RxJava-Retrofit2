package com.oldnum7.mvpdagger2rxjavaretrofit2.presenter;

import android.content.Context;

import com.oldnum7.mvpdagger2rxjavaretrofit2.model.MvpModel;
import com.oldnum7.mvpdagger2rxjavaretrofit2.service.RetrofitCall;
import com.oldnum7.mvpdagger2rxjavaretrofit2.view.MvpView;

import retrofit2.Retrofit;

/**
 * Created by admin on 2017/1/10.
 */

public class MvpPresenter extends BasePresenter<MvpView> {
    private MvpModel mMvpModel;
    private Context  mContext;

    //    private RequestQueue mRequestQueue;
    //这里重写当前的构造函数 因为我们需要获取程序的版本，因此需要一个上下文对象
    public MvpPresenter(Context mContext) {
        this.mContext = mContext;
        //当前的Mvp模式的讲解我是采用Volley进行网络请求的所以 就封装了一个VolleyManager用于获取唯一的RequestQueue对象
//        mRequestQueue = VolleyManager.getInstance(mContext).getRequestQueue();
        //对业务层初始化为后面获取的apk版本进行存放
//        mUpdateModel = new MvpModel();
    }

    //由于逻辑处理放到我们的Presenter中了，因此我们需要将在Activity的onResume 时候进行版本的检查
    public void onResume() {

        getVerFromServer();
    }

    public void getVerFromServer() {

        Retrofit mRxjavaRetrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1:8080/")
                //由于需要转为Observable 需要添加RxJavaCallAdapterFactory
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitCall call = mRxjavaRetrofit.create(RetrofitCall.class);
        call.getVerByRxJavaWithRetrofit("1")
                //指定时间消费在主线程
                .observeOn(AndroidSchedulers.mainThread())
                //事件产生在新线程
                .subscribeOn(Schedulers.newThread())
                //指定一个观察者
                .subscribe(new Observer<Version>() {
                    @Override
                    public void onCompleted() {

                        mView.showMessage();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    /*这个时候是订阅者需要跟新UI的时间了通知它更新*/
                    @Override
                    public void onNext(LogoBean logoBean) {
                        /*这里先不做判断*/

                    }


                });

    }
}
