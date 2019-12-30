package top.lairdli.study.comon.router;

import android.app.Activity;
import android.content.Intent;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author laird
 * @date 2019-12-30 11:09
 * @desc
 */
public class ARouterHelper {
    public static final String PATH_ACTIVITY_LIB_TEST = "/ModuleLib/LibActivity";
    public static final String ACTION_ACTIVITY_LIB_TEST = "top.lairdli.action.LIB_TEST";


    public static ARouterHelper getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final ARouterHelper INSTANCE = new ARouterHelper();
    }

    public void build(String path){
        ARouter.getInstance().build(path).navigation();
    }

    public void build(String path, Activity activity, int requestCode){
        ARouter.getInstance().build(path).navigation(activity,requestCode);
    }

    public void build(String path,String key,String value){
        ARouter.getInstance().build(path).withString(key,value).navigation();
    }

    public Postcard getPostCard(String path){
        return ARouter.getInstance().build(path);
    }

    //fix me
    // 1. intent can be replaced by schame-url
    // 2. withSerializable can be replaced by with object,but u should implement SerializationService First

    public void dispatchPage(Intent intent) {

        if (intent == null || intent.getAction() == null) {
            dispatchPageDefault();
            return;
        }


        switch (intent.getAction()) {
            case ACTION_ACTIVITY_LIB_TEST:
                build(PATH_ACTIVITY_LIB_TEST);
                break;

            default:
                dispatchPageDefault();
        }
    }

    private static void dispatchPageDefault() {
        // to add u default page
    }

}
