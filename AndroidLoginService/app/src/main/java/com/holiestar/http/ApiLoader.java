package com.holiestar.http;


import android.content.Context;

import com.holiestar.http.error.RetrofitThrowable;


/**
 * Created by tony1 on 2/19/2017.
 */

public class ApiLoader<T> {
    private Context context;
    private boolean isLoading;

    public ApiLoader(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    private OnStartListener onStartListener;

    public interface OnStartListener {
        void OnStart();
    }

    private OnSimpleLoadedListener onSimpleLoadedListener;

    public interface OnSimpleLoadedListener {
        void OnLoaded();
    }

    private OnLoadedListener<T> onLoadedListener;

    public interface OnLoadedListener<T> {
        void OnLoaded(T result);
    }

    private OnSimpleFailedListener onSimpleFailedListener;

    public interface OnSimpleFailedListener {
        void OnFailed();
    }

    private OnFailedListener onFailedListener;

    public interface OnFailedListener {
        void OnFailed(int errorCode, String errorMessage);
    }

    public OnStartListener getOnStartListener() {
        return onStartListener;
    }

    public ApiLoader setOnStartListener(OnStartListener onStartListener) {
        this.onStartListener = onStartListener;
        return this;
    }

    public OnSimpleLoadedListener getOnSimpleLoadedListener() {
        return onSimpleLoadedListener;
    }

    public ApiLoader setOnSimpleLoadedListener(OnSimpleLoadedListener onSimpleLoadedListener) {
        this.onSimpleLoadedListener = onSimpleLoadedListener;
        return this;
    }

    public OnLoadedListener<T> getOnLoadedListener() {
        return onLoadedListener;
    }

    public ApiLoader setOnLoadedListener(OnLoadedListener<T> onLoadedListener) {
        this.onLoadedListener = onLoadedListener;
        return this;
    }

    public OnSimpleFailedListener getOnSimpleFailedListener() {
        return onSimpleFailedListener;
    }

    public ApiLoader setOnSimpleFailedListener(OnSimpleFailedListener onSimpleFailedListener) {
        this.onSimpleFailedListener = onSimpleFailedListener;
        return this;
    }

    public OnFailedListener getOnFailedListener() {
        return onFailedListener;
    }

    public ApiLoader setOnFailedListener(OnFailedListener onFailedListener) {
        this.onFailedListener = onFailedListener;
        return this;
    }

    public void callOnStart() {
        isLoading = true;
        if (onStartListener != null) onStartListener.OnStart();
    }

    public void callOnSimpleLoaded() {
        isLoading = false;
        if (onSimpleLoadedListener != null) onSimpleLoadedListener.OnLoaded();
        if (onLoadedListener != null) onLoadedListener.OnLoaded(null);
    }

    public void callOnLoaded(T t) {
        isLoading = false;
        if (onSimpleLoadedListener != null) onSimpleLoadedListener.OnLoaded();
        if (onLoadedListener != null) onLoadedListener.OnLoaded(t);
    }

    public void callOnFailed(int errorCode, String errorMessage) {
        isLoading = false;
        if (onSimpleFailedListener != null) onSimpleFailedListener.OnFailed();
        if (onFailedListener != null) onFailedListener.OnFailed(errorCode, errorMessage);
    }

    public void callOnFailed(Throwable throwable) {
        isLoading = false;
        RetrofitThrowable retrofitThrowable = RetrofitThrowable.from(throwable);
        if (onSimpleFailedListener != null) onSimpleFailedListener.OnFailed();
        if (onFailedListener != null) onFailedListener.OnFailed(retrofitThrowable.getErrorCode(), retrofitThrowable.getErrorMessage());
    }

    public boolean isLoading() {
        return isLoading;
    }
}
