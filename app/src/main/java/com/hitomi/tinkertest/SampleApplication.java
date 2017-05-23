package com.hitomi.tinkertest;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by hitomi on 2017/5/22.
 */

@DefaultLifeCycle(application = "tinker.sample.android.app.SampleApplication",
        flags = ShareConstants.TINKER_ENABLE_ALL,
        loadVerifyFlag = false)
public class SampleApplication extends DefaultApplicationLike {

    public SampleApplication(Application application,
                             int tinkerFlags,
                             boolean tinkerLoadVerifyFlag,
                             long applicationStartElapsedTime,
                             long applicationStartMillisTime,
                             Intent tinkerResultIntent) {


        super(application, tinkerFlags, tinkerLoadVerifyFlag,
                applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        //you must install multiDex whatever tinker is installed!
        MultiDex.install(base);
        TinkerInstaller.installTinker(this);
    }
}
