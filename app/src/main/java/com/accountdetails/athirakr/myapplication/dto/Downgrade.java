package com.accountdetails.athirakr.myapplication.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by athira.kr on 22-07-2018.
 */

public class Downgrade {
    @SerializedName("data")
    @Expose
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
