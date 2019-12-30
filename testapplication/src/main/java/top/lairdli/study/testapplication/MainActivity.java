package top.lairdli.study.testapplication;

import androidx.appcompat.app.AppCompatActivity;
import top.lairdli.study.comon.router.ARouterHelper;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        ARouterHelper.getInstance().dispatchPage(intent);
        finish();
    }
}
