/**
 * Copyright (C) 2013 AVIT, All rights reserved
 *
 * @fileName: com.avit.ott.common.base.BaseApplication.java
 * @author: daishulun@avit.com.cn
 * <p>
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2013-8-22     daishulun      v1.0.0        create
 */
package top.lairdli.study.comon.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.LinkedList;
import java.util.List;

import top.lairdli.study.comon.BuildConfig;

/**
 * @Description: BaseApplication
 */
@SuppressLint("Registered")
public abstract class BaseApplication extends Application implements IComponentApplication {

    protected String LOG_TAG = "BaseApplication";
    private static BaseApplication instance;

    public  static BaseApplication getInstance() {
        return instance;
    }

    private List<Activity> mList = new LinkedList<Activity>();

    public BaseApplication() {
        super();
        LOG_TAG = this.getClass().getSimpleName();
    }

    @Override
    public void onCreate() {
        Log.v(LOG_TAG, "onCreate()");

        super.onCreate();

        //init ARouter
        if(BuildConfig.DEBUG){
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);

        instance= this;

        //asbs method ,implementation in sub class
        init(this);

        //init call modulesApplication
        if (IAppApplication.class.isAssignableFrom(this.getClass())) {
            IAppApplication appApplication = (IAppApplication) this;
            modulesApplicationInit(appApplication.getModuleAppClassList());
        }
    }

    private void modulesApplicationInit(List<String> modulesList){
        for (String moduleImpl : modulesList){
            try {
                Class<?> clazz = Class.forName(moduleImpl);
                Object obj = clazz.newInstance();
                if (obj instanceof IComponentApplication){
                    ((IComponentApplication) obj).init(BaseApplication.getInstance());
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onTerminate() {
        Log.v(LOG_TAG, "onTerminate()");
        super.onTerminate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.v(LOG_TAG, "onConfigurationChanged(Configuration<" + newConfig + ">)");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        Log.v(LOG_TAG, "onLowMemory()");
        super.onLowMemory();
    }

}
