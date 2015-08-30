package com.muxistudio.jinyixin.guisheng;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.app.ActionBar;
import android.view.LayoutInflater;
import android.view.ViewGroup;


/**
 * Created by jinyixin on 15/8/17.
 */

public class SplashActivity extends Activity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        ViewGroup myActionBarLayout = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.actionbar_layout, null);
        ActionBar actionBar = getActionBar();
        assert actionBar != null;
        actionBar.setCustomView(myActionBarLayout);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.hide();


        new Handler().postDelayed(new Runnable(){
            public void run() {
                Intent intent = new Intent(SplashActivity.this,
                        MainActivity.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }
        },SPLASH_DISPLAY_LENGTH);
    }
}




