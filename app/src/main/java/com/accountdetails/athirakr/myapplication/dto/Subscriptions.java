package com.accountdetails.athirakr.myapplication.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by athira.kr on 22-07-2018.
 */

public class Subscriptions {
    @SerializedName("links")
    @Expose
    private Links___ links;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public Links___ getLinks() {
        return links;
    }

    public void setLinks(Links___ links) {
        this.links = links;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}
