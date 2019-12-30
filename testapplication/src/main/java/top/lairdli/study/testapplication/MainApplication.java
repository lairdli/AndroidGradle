package top.lairdli.study.testapplication;

import android.app.Application;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

import top.lairdli.study.comon.base.BaseApplication;
import top.lairdli.study.comon.base.IAppApplication;

/**
 * @author laird
 * @date 2019-12-30 09:39
 * @desc
 */
public class MainApplication extends BaseApplication implements IAppApplication {

    private static final String[] MODULESLIST =
            {"top.lairdli.study.testlibrary.LibApplication"};

    @Override
    public List<String> getModuleAppClassList() {
        return Arrays.asList(MODULESLIST);
    }

    @Override
    public void init(Application instance) {
        Log.d(LOG_TAG, "---init");
    }
}
