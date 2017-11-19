package com.holiestar.http.loader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.holiestar.constant.Constants;
import com.holiestar.http.ApiLoader;
import com.holiestar.http.ApiManager;
import com.holiestar.http.error.HttpErrorCode;
import com.holiestar.http.error.HttpErrorMessage;
import com.holiestar.http.interfaces.LoginApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by SsuChi on 7/27/2015.
 */
public class LoaderLoginByFacebook extends ApiLoader {
    private String TAG = getClass().getSimpleName();
    private Context context;
    private Activity activity;
    private LoginApi loginApi;
    private CallbackManager callbackManager;
    private String photoUrl;

    public LoaderLoginByFacebook(Activity activity) {
        super(activity);
        init(activity);
        initFacebook();
        initAction();
    }

    private void init(Activity activity) {
        this.context = activity;
        this.activity = activity;
        this.loginApi = ApiManager.getRetrofit().create(LoginApi.class);
        this.callbackManager = CallbackManager.Factory.create();
    }

    private void initFacebook() {
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), (object, response) -> {
                            if (object == null) {
                                callOnFailed(HttpErrorCode.UNKNOWN_ERROR, HttpErrorMessage.getMessage(HttpErrorCode.UNKNOWN_ERROR));
                                return;
                            }
                            boolean hasId = object.has("id") && object.optString("id") != null && !object.optString("id").isEmpty();
                            boolean hasName = object.has("name") && object.optString("name") != null && !object.optString("name").isEmpty();
                            boolean hasEmail = object.has("email") && object.optString("email") != null && !object.optString("email").isEmpty();
                            boolean hasBirth = object.has("birthday") && object.optString("birthday") != null && !object.optString("birthday").isEmpty();
                            boolean hasGender = object.has("gender") && object.optString("gender") != null && !object.optString("gender").isEmpty() && (object.optString("gender").equals("male") || object.optString("gender").equals("female"));

                            String name = hasName ? object.optString("name") : "user";
                            String email = hasEmail ? object.optString("email") : null;
                            String birth = hasBirth ? object.optString("hasBirth") : "01/01/1900";
                            String gender = hasGender ? (object.optString("gender").equals("male") ? "1" : "0") : "0";

                            try {
                                birth = (new SimpleDateFormat("yyyy-MM-dd")).format((new SimpleDateFormat("MM/dd/yyyy")).parse(birth));
                            } catch (ParseException e) {
                            }

                            loadServer(email, name, gender);
                        });
                        Bundle parameters = new Bundle();
                        parameters.putString("fields", "id,name,email,birthday,gender");
                        request.setParameters(parameters);
                        request.executeAsync();
                    }

                    @Override
                    public void onCancel() {
                        callOnFailed(HttpErrorCode.UNKNOWN_ERROR, "login failed");
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        callOnFailed(exception);
                    }
                });
    }

    private void initAction() {
    }

    public void load() {
        callOnStart();
        loadServer("tony13678@gmail.com","qq123","0");
//        boolean isFacebookLogin = AccessToken.getCurrentAccessToken() != null;
//        if (isFacebookLogin) {
//            callOnFailed(HttpErrorCode.UNKNOWN_ERROR, "already login");
//            return;
//        }
//        LoginManager.getInstance().logInWithReadPermissions(activity, Arrays.asList("email", "public_profile", "user_birthday"));
//        ((Activity) context).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }


    private void loadServer(String email, String name, String gender) {
        loginApi.loginByFacebookViaAzure(
                Constants.getApiLoginByFacebookAzure(),
                new HashMap<String, Object>() {
                    {
                        put("email", email);
                        put("name", name.replace("'", ""));
                        put("gender", Integer.valueOf(gender));
                    }
                })
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(azureResultData -> {
                    loadedSuccess(name);
                }, throwable -> {
                    loadFailed(throwable);
                });

    }

    private void loadedSuccess(String name) {
        callOnLoaded(name);
    }

    private void loadFailed(Throwable t) {
        t.printStackTrace();
        LoginManager.getInstance().logOut();
        callOnFailed(t);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
