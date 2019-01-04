package com.youzuo.countdown;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Settings.canDrawOverlays(MainActivity.this))
        {
            Intent intent = new Intent(MainActivity.this,MainService.class);
            Toast.makeText(MainActivity.this,"已开启悬浮时间显示",Toast.LENGTH_SHORT).show();
            startService(intent);
            finish();
        }else
        {
            //若没有权限，提示获取.
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
            Toast.makeText(MainActivity.this,"需要取得权限以使用悬浮窗",Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();
        }
    }
}
