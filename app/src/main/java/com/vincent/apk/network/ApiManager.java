package com.vincent.apk.network;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vincent.apk.app.App;
import com.vincent.apk.app.Constant;
import com.vise.log.ViseLog;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.TlsVersion;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
   rxjava+Retrofit+okhttp3 之间串联
 */
public class ApiManager {

	public static ObjectMapper objectMapper = null;
	private static HashMap<String, String> map;

	public static Retrofit getRetrofit(){

		ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
				.tlsVersions(TlsVersion.TLS_1_1)
				.tlsVersions(TlsVersion.TLS_1_2)
				.cipherSuites(
						CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
						CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
						CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256)
				.build();

		OkHttpClient client = new OkHttpClient.Builder()
				.addInterceptor(new Interceptor() {
					@Override
					public Response intercept(Chain chain) throws IOException {
						Request request = chain.request();
						ViseLog.e("-->"+ "okhttp3:" + request.toString());//输出请求前整个url
						Response response = chain.proceed(chain.request());
						okhttp3.MediaType mediaType = response.body().contentType();
						String content = response.body().string();
						ViseLog.d("reuslt:-->"+content);
						return response.newBuilder()
								.body(okhttp3.ResponseBody.create(mediaType, content))
								.build();
					}
				})
				.cache(new Cache(App.getApp(). getCacheDir(), 10 * 1024 * 102))//缓存
				.retryOnConnectionFailure(true)
				.connectTimeout(3, TimeUnit.SECONDS)//连接超时时间
				.writeTimeout(5, TimeUnit.SECONDS)//写入超时
				.readTimeout(5, TimeUnit.SECONDS)//读取超时
				.connectionSpecs(Collections.singletonList(spec))//解决部分手机  SSL handshake timed out
				.build();




		return new Retrofit.Builder()
				.baseUrl(Constant.ZHIHU_SERVICE_API_ADDRESS)
				.client(client)
				.addConverterFactory(GsonConverterFactory.create())
//				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.build();
	}

	/***
	 * 返回一个APIService
	 * @return
	 */
	public static ApiService getApiService(){
		return getRetrofit().create(ApiService.class);
	}



	/**
	 * 设置公共参数
	 */
	public static Map<String, String> getBasicMap() {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
			objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

		}
		if (map == null) {
			map = new HashMap<>();
		} else {
			map.clear();
		}
		//打印MAP
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		for (Map.Entry<String, String> entry : entrySet) {
			ViseLog.d( entry.getKey() + "//" + entry.getValue() + "");
		}
		return map;
	}

}
