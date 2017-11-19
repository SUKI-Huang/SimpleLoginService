package com.holiestar.http.error;

import com.google.gson.stream.MalformedJsonException;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;

import io.reactivex.exceptions.CompositeException;
import io.rx_cache2.RxCacheException;
import retrofit2.HttpException;

/**
 * Created by Suki on 9/19/2017.
 */

public class RetrofitThrowable extends Exception {
    private Throwable throwable = null;

    private RetrofitThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public int getErrorCode() {
        if (throwable == null) return HttpErrorCode.UNKNOWN_ERROR;
        if (throwable instanceof HttpException) return ((HttpException) throwable).code();
        if (throwable instanceof IOException) return HttpErrorCode.NETWORK_UNAVAILABLE;
        if (throwable instanceof CompositeException && ((CompositeException) throwable).getExceptions() != null) {
            List<Throwable> exceptions = ((CompositeException) throwable).getExceptions();
            for (Throwable throwable : exceptions) {
                if (throwable instanceof SocketTimeoutException) {
                    return HttpErrorCode.NETWORK_UNAVAILABLE;
                } else if (throwable instanceof ConnectException) {
                    return HttpErrorCode.NETWORK_UNAVAILABLE;
                } else if (throwable instanceof UnknownHostException) {
                    return HttpErrorCode.NETWORK_UNAVAILABLE;
                } else if (throwable instanceof RxCacheException) {
                    return HttpErrorCode.NETWORK_UNAVAILABLE;
                } else if (throwable instanceof MalformedJsonException) {
                    return HttpErrorCode.NETWORK_UNAVAILABLE;
                }
            }
        }
        return HttpErrorCode.UNKNOWN_ERROR;
    }

    public String getErrorMessage() {
        if (throwable == null) return HttpErrorMessage.getMessage(HttpErrorCode.UNKNOWN_ERROR);
        if (throwable instanceof HttpException) return HttpErrorMessage.getMessage(((HttpException) throwable).code());
        if (throwable instanceof IOException) return HttpErrorMessage.getMessage(HttpErrorCode.NETWORK_UNAVAILABLE);
        if (throwable instanceof CompositeException && ((CompositeException) throwable).getExceptions() != null) {
            List<Throwable> exceptions = ((CompositeException) throwable).getExceptions();
            for (Throwable throwable : exceptions) {
                if (throwable instanceof SocketTimeoutException) {
                    return HttpErrorMessage.getMessage(HttpErrorCode.NETWORK_UNAVAILABLE);
                } else if (throwable instanceof ConnectException) {
                    return HttpErrorMessage.getMessage(HttpErrorCode.NETWORK_UNAVAILABLE);
                } else if (throwable instanceof UnknownHostException) {
                    return HttpErrorMessage.getMessage(HttpErrorCode.NETWORK_UNAVAILABLE);
                } else if (throwable instanceof RxCacheException) {
                    return HttpErrorMessage.getMessage(HttpErrorCode.NETWORK_UNAVAILABLE);
                } else if (throwable instanceof MalformedJsonException) {
                    return HttpErrorMessage.getMessage(HttpErrorCode.NETWORK_UNAVAILABLE);
                }
            }
        }
        return throwable.getMessage();
    }

    public static RetrofitThrowable from(Throwable throwable) {
        return new RetrofitThrowable(throwable);
    }
}
