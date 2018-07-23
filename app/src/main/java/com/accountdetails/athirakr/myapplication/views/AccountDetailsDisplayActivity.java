package com.accountdetails.athirakr.myapplication.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.accountdetails.athirakr.myapplication.R;
import com.accountdetails.athirakr.myapplication.dto.AdapterListDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by athira.kr on 22-07-2018.
 */

public class AccountDetailsDisplayActivity extends AppCompatActivity {
    /**
     * Recycler view object
     */
    private RecyclerView recyclerView;
    /**
     * adapter list dto class
     */
    private static List<AdapterListDto> adapterList;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_display);
        initView();
        loadData();
    }

    /**
     * used for initializing views
     */
    private void initView() {
        recyclerView=(RecyclerView)findViewById(R.id.lstData);
    }


    /**
     * Used for loading data
     */
    private void loadData() {
        getIntentExtras();
        if(adapterList!=null&&adapterList.size()>0) {
            setAdapter();
        }
    }

    /**
     * getting intent extras
     */
    private void getIntentExtras() {
        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null
                    && bundle.containsKey("jsonData")) {
                String json = (String) bundle
                        .get("jsonData");
                Type type=new TypeToken<List<AdapterListDto>>(){}.getType();
                Gson gson=new Gson();
                adapterList=gson.fromJson(json,type);

            }
        }
    }

    /**
     * set Adapter
     */
    private void setAdapter() {
        AccountDetailsDisplayAdapter accountDetailsDisplayAdapter = new AccountDetailsDisplayAdapter(adapterList,
                AccountDetailsDisplayActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(AccountDetailsDisplayActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(accountDetailsDisplayAdapter);
    }

    @Override
    public void onBackPressed() {
        navigateToHomePage();
    }

    /**
     * navigation to home
     */
    private void navigateToHomePage() {
        Intent intent=new Intent(AccountDetailsDisplayActivity.this,AccountDetailsActivity.class);
        startActivity(intent);
        finish();
    }
}
