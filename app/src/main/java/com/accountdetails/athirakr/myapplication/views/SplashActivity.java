package com.accountdetails.athirakr.myapplication.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.accountdetails.athirakr.myapplication.R;

/**
 * Created by athira.kr on 22-07-2018.
 */

public class SplashActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        loadActivity();
    }

    public void loadActivity(){
      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              navigateToDetailsPage();
          }
      },1*1000);
    }

    /**
     * navigation to details page
     */
    private void navigateToDetailsPage() {
        Intent intent=new Intent(SplashActivity.this,AccountDetailsActivity.class);
        startActivity(intent);
        finish();
    }
}
