package com.accountdetails.athirakr.myapplication.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by athira.kr on 22-07-2018.
 */

public class Relationships {

    @SerializedName("services")
    @Expose
    private Services services;

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }
}
