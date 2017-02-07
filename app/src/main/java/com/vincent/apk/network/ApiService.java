package com.vincent.apk.network;

import com.vincent.apk.bean.ZhiHuMessageListBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * description ：
 * project name：DownAndInstallApk
 * author : Vincent
 * creation date: 2017/2/7 17:23
 *
 * @version 1.0
 */

public interface ApiService {
    //http://news-at.zhihu.com/api/4/news/before/20170207
    @GET("api/4/news/before/20170207")
    Call<ZhiHuMessageListBean> getZhiHuMessage(@QueryMap Map<String,String> paramter);

}
