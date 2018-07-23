package com.accountdetails.athirakr.myapplication.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by athira.kr on 22-07-2018.
 */

public class Links_ {
    @SerializedName("related")
    @Expose
    private String related;

    public String getRelated() {
        return related;
    }

    public void setRelated(String related) {
        this.related = related;
    }
}
