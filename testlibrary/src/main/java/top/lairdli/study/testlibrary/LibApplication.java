package top.lairdli.study.testlibrary;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;

import top.lairdli.study.comon.base.BaseApplication;

/**
 * @author laird
 * @date 2019-12-30 09:48
 * @desc
 */
public class LibApplication extends BaseApplication {

    @Override
    public void init(Application instance) {
        Log.d(LOG_TAG,"---init");
    }
}
