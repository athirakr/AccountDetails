package com.accountdetails.athirakr.myapplication.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by athira.kr on 22-07-2018.
 */

public class Service {
    @SerializedName("links")
    @Expose
    private Links____ links;

    public Links____ getLinks() {
        return links;
    }

    public void setLinks(Links____ links) {
        this.links = links;
    }
}
