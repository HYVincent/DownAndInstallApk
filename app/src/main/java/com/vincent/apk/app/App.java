package com.vincent.apk.app;

import android.app.Application;

import com.vincent.apk.utils.Utils;

import hugo.weaving.DebugLog;
import hugo.weaving.internal.Hugo;

/**
 * description ：
 * project name：DownAndInstallApk
 * author : Vincent
 * creation date: 2017/2/7 14:56
 *
 * @version 1.0
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
