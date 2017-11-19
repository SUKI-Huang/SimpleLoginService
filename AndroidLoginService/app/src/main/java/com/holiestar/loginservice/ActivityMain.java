package com.holiestar.loginservice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.holiestar.http.ApiManager;
import com.holiestar.http.loader.LoaderLoginByFacebook;
import com.jakewharton.rxbinding2.view.RxView;
import com.rey.material.widget.LinearLayout;

import java.util.concurrent.TimeUnit;

public class ActivityMain extends AppCompatActivity {

    private com.rey.material.widget.LinearLayout btnLoginByFacebook;
    private Context context;
    private LoaderLoginByFacebook loaderLoginByFacebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApiManager.initialize(getApplicationContext());
        FacebookSdk.sdkInitialize(this);
        AppEventsLogger.activateApp(this);

        init();
        initUI();
        initAction();
    }

    private void init() {
        this.context = this;
        this.loaderLoginByFacebook=new LoaderLoginByFacebook(this);

    }

    private void initUI() {
        this.btnLoginByFacebook = (LinearLayout) findViewById(R.id.btnLoginByFacebook);
    }

    private void initAction() {
        RxView.clicks(btnLoginByFacebook).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(o-> loaderLoginByFacebook.load());
        this.loaderLoginByFacebook.setOnLoadedListener(name -> Toast.makeText(context,"hello "+name,Toast.LENGTH_SHORT).show());
        this.loaderLoginByFacebook.setOnFailedListener((errorCode, errorMessage) -> Toast.makeText(context,"login failed",Toast.LENGTH_SHORT).show());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        loaderLoginByFacebook.onActivityResult(requestCode, resultCode, data);
    }
}
