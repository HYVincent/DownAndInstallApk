package com.vincent.apk.utils;

import android.content.Context;

/**
 * description ：
 * project name：DownAndInstallApk
 * author : Vincent
 * creation date: 2017/2/7 14:55
 *
 * @version 1.0
 */

public class Utils {
    private static Context context;

    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        Utils.context = context.getApplicationContext();
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Context getContext() {
        if (context != null) return context;
        throw new NullPointerException("u should init first");
    }

}
