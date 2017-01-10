package com.oldnum7.mvpdagger2rxjavaretrofit2.service;

import android.database.Observable;

import com.oldnum7.mvpdagger2rxjavaretrofit2.model.VersionBean;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by admin on 2017/1/10.
 */

public class RetrofitCall {
    // 我们把之前定义好的api接口 拿来  http://192.168.1:8080/app/index/type?version=query
    //这里我先简单给大家介绍一下 Retrofit 请求网络的接口形式要满足RESTful 形式（有不了解的可自填坑） 不够构成一般是这样的[协议类型：][//主机地址加端口（或者域名）][具体目录][请求参数]
    //所以这个接口的具体目录（path）为app/index/type 也就是下面这个GET注解中应该填入的
//    @GET("app/index/type")
//    Call<VersionBean> getVer(@Query("version")String ver);
    //如果有读者不知道这个VersionBean怎么生成的可以查看我的博客有一篇讲Retrofit的 其实就是利用GSONFromat 来实现的


    @GET("app/index/type")
    Observable<VersionBean> getVerByRxJavaWithRetrofit(@Query("version") String ver);

}
