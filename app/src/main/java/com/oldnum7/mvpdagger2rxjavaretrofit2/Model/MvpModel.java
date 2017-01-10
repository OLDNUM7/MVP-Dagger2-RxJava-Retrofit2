package com.oldnum7.mvpdagger2rxjavaretrofit2.model;

/**
 * Created by admin on 2017/1/10.
 */

public class MvpModel {
    /*从服务器获取的apk版本*/
    private String newApkVersion;
    //这里我就随便给出一个，正确与否我就不得而知 这里面需要注意的query是跟上请求的参数，通过GET方法来请求的 ，你可能这会问我，不是说不知道正不正确的吗，那还解释这么多？不好意思哈，我这里说明好是为了下面讲到Retrofit 做铺垫的
    public static final String GET_NEW_VER_URL = "http://192.168.1:8080/app/index/type?version=query";

    public String getNewApkVersion() {
        return newApkVersion;
    }

    public void setNewApkVersion(String newApkVersion) {
        this.newApkVersion = newApkVersion;


    }
}
