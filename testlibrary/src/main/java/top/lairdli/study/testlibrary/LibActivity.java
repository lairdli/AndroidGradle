package top.lairdli.study.testlibrary;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

import androidx.appcompat.app.AppCompatActivity;
import top.lairdli.study.comon.router.ARouterHelper;

@Route(path = ARouterHelper.PATH_ACTIVITY_LIB_TEST)
public class LibActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
