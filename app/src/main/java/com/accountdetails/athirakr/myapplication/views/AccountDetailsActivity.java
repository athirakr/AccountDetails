package com.accountdetails.athirakr.myapplication.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.accountdetails.athirakr.myapplication.R;
import com.accountdetails.athirakr.myapplication.constant.Constants;
import com.accountdetails.athirakr.myapplication.dto.AdapterListDto;
import com.accountdetails.athirakr.myapplication.dto.Attributes;
import com.accountdetails.athirakr.myapplication.dto.Attributes_;
import com.accountdetails.athirakr.myapplication.dto.Data_;
import com.accountdetails.athirakr.myapplication.dto.Datum;
import com.accountdetails.athirakr.myapplication.dto.Links;
import com.accountdetails.athirakr.myapplication.dto.Links_;
import com.accountdetails.athirakr.myapplication.dto.Links__;
import com.accountdetails.athirakr.myapplication.dto.Links___;
import com.accountdetails.athirakr.myapplication.dto.Links____;
import com.accountdetails.athirakr.myapplication.dto.PlanDetails;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by athira.kr on 22-07-2018.
 */

public class AccountDetailsActivity extends AppCompatActivity {
    /**
     * layout for plan account details
     */
    private RelativeLayout layAccountInfo;
    /**
     * layout for services details
     */
    private RelativeLayout layServices;
    /**
     * layout for subscription details
     */
    private RelativeLayout layScriptionDetails;
    /**
     * layout for products details
     */
    private RelativeLayout layProductDetails;
    /**
     * contents layout
     */
    private ConstraintLayout layContents;
    /**
     *
     */
    private PlanDetails planDetails;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);
        initViews();
        parseData();
        setOnClickListeners();
    }

    /**
     * register on click listners
     */
    private void setOnClickListeners() {
        layAccountInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadAccountDisplayInformations();
            }
        });
        layServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadServiceDisplayInformations();
            }
        });
        layScriptionDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSubScriptionsInformations();
            }
        });
        layProductDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadProductDisplayInformations();
            }
        });
    }

    /**
     * Account display information loading
     */
    private void loadAccountDisplayInformations() {
        List<AdapterListDto> adapterList = new ArrayList<>();
        AdapterListDto adapterDto;
        if (planDetails != null && planDetails.getData() != null) {
            adapterDto = setValuesToListDto("Type :", planDetails.getData().getType());
            adapterList.add(adapterDto);
            adapterDto = setValuesToListDto("Id :", planDetails.getData().getId());
            adapterList.add(adapterDto);
            if (planDetails.getData().getAttributes() != null) {
                Attributes attributes = planDetails.getData().getAttributes();
                adapterDto = setValuesToListDto("Customer Name :", attributes.getTitle() + " " +
                        attributes.getFirstName() + " " + attributes.getLastName());
                adapterList.add(adapterDto);
                adapterDto = setValuesToListDto("Payment Type :", attributes.getPaymentType());
                adapterList.add(adapterDto);
                adapterDto = setValuesToListDto("Contact Number :", attributes.getContactNumber());
                adapterList.add(adapterDto);
                adapterDto = setValuesToListDto("Email Address :", attributes.getEmailAddress());
                adapterList.add(adapterDto);
                adapterDto = setValuesToListDto("DOB :", attributes.getDateOfBirth());
                adapterList.add(adapterDto);
            }
            if (planDetails.getData().getLinks() != null) {
                Links links = planDetails.getData().getLinks();
                adapterDto = setValuesToListDto("Self :", links.getSelf());
                adapterList.add(adapterDto);

            }
            if (planDetails.getData().getRelationships().getServices().getLinks() != null) {
                Links_ links = planDetails.getData().getRelationships().getServices().getLinks();
                adapterDto = setValuesToListDto("Related :", links.getRelated());
                adapterList.add(adapterDto);

            }
            saveDataLocally(adapterList);

        }
    }

    /**
     * service display information loading
     */
    private void loadServiceDisplayInformations() {
        List<AdapterListDto> adapterList = new ArrayList<>();
        AdapterListDto adapterDto;
        if (planDetails != null && planDetails.getIncluded().get(0) != null) {
            adapterDto = setValuesToListDto("Type :", planDetails.getIncluded().get(0).getType());
            adapterList.add(adapterDto);
            adapterDto = setValuesToListDto("Id :", planDetails.getIncluded().get(0).getId());
            adapterList.add(adapterDto);
            if (planDetails.getData().getAttributes() != null) {
                Attributes_ attributes = planDetails.getIncluded().get(0).getAttributes();
                adapterDto = setValuesToListDto("Msn :", attributes.getMsn());
                adapterList.add(adapterDto);
                adapterDto = setValuesToListDto("Credit :", attributes.getCredit() + "");
                adapterList.add(adapterDto);
                adapterDto = setValuesToListDto("Credit Expiry :", attributes.getCreditExpiry());
                adapterList.add(adapterDto);
            }
            if (planDetails.getIncluded().get(0).getLinks() != null) {
                Links__ links = planDetails.getIncluded().get(0).getLinks();
                adapterDto = setValuesToListDto("Self :", links.getSelf());
                adapterList.add(adapterDto);

            }
            if (planDetails.getIncluded().get(0).getRelationships().getSubscriptions().getLinks() != null) {
                Links___ links = planDetails.getIncluded().get(0).getRelationships().getSubscriptions().getLinks();
                adapterDto = setValuesToListDto("Related :", links.getRelated());
                adapterList.add(adapterDto);
            }
            if (planDetails.getIncluded().get(0).getRelationships().getSubscriptions().getData() != null) {
                List<Datum> data = planDetails.getIncluded().get(0).getRelationships().getSubscriptions().getData();
                adapterDto = setValuesToListDto("Type :", data.get(0).getType());
                adapterList.add(adapterDto);
                adapterDto = setValuesToListDto("Id :", data.get(0).getId());
                adapterList.add(adapterDto);
            }
            saveDataLocally(adapterList);

        }
    }

    /**
     * subscritpions display information loading
     */
    private void loadSubScriptionsInformations() {
        List<AdapterListDto> adapterList = new ArrayList<>();
        AdapterListDto adapterDto;
        if (planDetails != null && planDetails.getIncluded().get(1) != null) {
            adapterDto = setValuesToListDto("Type :", planDetails.getIncluded().get(1).getType());
            adapterList.add(adapterDto);
            adapterDto = setValuesToListDto("Id :", planDetails.getIncluded().get(1).getId());
            adapterList.add(adapterDto);
            if (planDetails.getData().getAttributes() != null) {
                Attributes_ attributes = planDetails.getIncluded().get(1).getAttributes();
                adapterDto = setValuesToListDto("Included data balance :", attributes.getIncludedDataBalance() + "");
                adapterList.add(adapterDto);
                adapterDto = setValuesToListDto("Expiry Date :", attributes.getExpiryDate());
                adapterList.add(adapterDto);
                adapterDto = setValuesToListDto("Auto renewal :", attributes.getAutoRenewal() + "");
                adapterList.add(adapterDto);
                adapterDto = setValuesToListDto("Primary Description :", attributes.getPrimarySubscription() + "");
                adapterList.add(adapterDto);
            }
            if (planDetails.getIncluded().get(1).getLinks() != null) {
                Links__ links = planDetails.getIncluded().get(1).getLinks();
                adapterDto = setValuesToListDto("Self :", links.getSelf());
                adapterList.add(adapterDto);

            }
            if (planDetails.getIncluded().get(1).getRelationships().getService().getLinks() != null) {
                Links____ links = planDetails.getIncluded().get(1).getRelationships().getService().getLinks();
                adapterDto = setValuesToListDto("Related :", links.getRelated());
                adapterList.add(adapterDto);
            }
            if (planDetails.getIncluded().get(1).getRelationships().getProduct().getData() != null) {
                Data_ data = planDetails.getIncluded().get(1).getRelationships().getProduct().getData();
                adapterDto = setValuesToListDto("Type :", data.getType());
                adapterList.add(adapterDto);
                adapterDto = setValuesToListDto("Id :", data.getId());
                adapterList.add(adapterDto);
            }
            saveDataLocally(adapterList);


        }
    }

    /**
     * Account display information loading
     */
    private void loadProductDisplayInformations() {
        List<AdapterListDto> adapterList = new ArrayList<>();
        AdapterListDto adapterDto;
        if (planDetails != null && planDetails.getIncluded().get(2) != null) {
            adapterDto = setValuesToListDto("Type :", planDetails.getIncluded().get(2).getType());
            adapterList.add(adapterDto);
            adapterDto = setValuesToListDto("Id :", planDetails.getIncluded().get(2).getId());
            adapterList.add(adapterDto);
            if (planDetails.getData().getAttributes() != null) {
                Attributes_ attributes = planDetails.getIncluded().get(2).getAttributes();
                adapterDto = setValuesToListDto("Name :", attributes.getName() + "");
                adapterList.add(adapterDto);
                adapterDto = setValuesToListDto("Unlimitd Text :", attributes.getUnlimitedText() + "");
                adapterList.add(adapterDto);
                adapterDto = setValuesToListDto("Unlimited Talk :", attributes.getUnlimitedTalk() + "");
                adapterList.add(adapterDto);
                adapterDto = setValuesToListDto("Price :", attributes.getPrice() + "");
                adapterList.add(adapterDto);
            }
            saveDataLocally(adapterList);

        }
    }

    @NonNull
    private AdapterListDto setValuesToListDto(String heading, String values) {
        AdapterListDto adapterDto;
        adapterDto = new AdapterListDto();
        adapterDto.setHeading(heading);
        adapterDto.setValue(values);
        return adapterDto;
    }

    /**
     * initializing views
     */
    private void initViews() {
        layAccountInfo = (RelativeLayout) findViewById(R.id.layAccountInfo);
        layServices = (RelativeLayout) findViewById(R.id.layServices);
        layScriptionDetails = (RelativeLayout) findViewById(R.id.layScriptionDetails);
        layProductDetails = (RelativeLayout) findViewById(R.id.layProductDetails);
        layContents = (ConstraintLayout) findViewById(R.id.layContent);
    }

    /**
     * Used for parsing the data
     */
    private void parseData() {
        try {
            Gson gson = new Gson();
            planDetails = gson.fromJson(Constants.jsonData, PlanDetails.class);
            layContents.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            layContents.setVisibility(View.GONE);
            Toast.makeText(AccountDetailsActivity.this, "Data Parsing error", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * saving data locally
     *
     * @param list
     */
    private void saveDataLocally(List<AdapterListDto> list) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<AdapterListDto>>() {
        }.getType();
        String json = gson.toJson(list, type);
        navigateToDetailsDisplayPage(json);
    }

    /**
     * navigation to splash page
     */
    private void navigateToDetailsDisplayPage(String json) {
        Intent intent = new Intent(AccountDetailsActivity.this, AccountDetailsDisplayActivity.class);
        intent.putExtra("jsonData", json);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        confirmExit();
    }

    /**
     * Confirm exit alert
     */
    private void confirmExit() {
        android.app.AlertDialog.Builder alertDialog
                = new android.app.AlertDialog.Builder(new ContextThemeWrapper(
                AccountDetailsActivity.this, R.style.AppTheme));
        alertDialog.setTitle("Logout");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            alertDialog.setMessage(Html.fromHtml("Do you want to logout?", Html.FROM_HTML_MODE_LEGACY));
        } else {
            alertDialog.setMessage(Html.fromHtml("Do you want to logout?"));
        }
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        navigateToLoginPage();
                        finish();
                    }
                });
        alertDialog.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }

    /**
     * navigation to login
     */
    private void navigateToLoginPage() {
        Intent intent = new Intent(AccountDetailsActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
