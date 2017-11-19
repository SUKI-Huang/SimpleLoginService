package com.holiestar.http.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tony1 on 8/29/2016.
 */
public class AzureResultData {
    @SerializedName("status")
    private boolean status;
    @SerializedName("error")
    private String message;

    public boolean isStatus() {
        return status;
    }

    public AzureResultData setStatus(boolean status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public AzureResultData setMessage(String message) {
        this.message = message;
        return this;
    }
}
