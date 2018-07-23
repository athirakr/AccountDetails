package com.accountdetails.athirakr.myapplication.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.accountdetails.athirakr.myapplication.R;

/**
 * Created by athira.kr on 22-07-2018.
 */

public class LoginActivity extends AppCompatActivity {
    /**
     * edit text for credential
     */
    private EditText edtCredential;
    /**
     * button for login
     */
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        setOnClickListener();
    }

    /**
     * registering onclick listner
     */
    private void setOnClickListener() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processLogin();
            }
        });
    }

    /**
     * login process
     */
    private void processLogin() {
        if (validate()) {
            navigateToSplashPage();
        } else {
            edtCredential.getText().clear();
            Toast.makeText(LoginActivity.this, "Invalid login details", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * check the credential is valid
     *
     * @return
     */
    private boolean validate() {
        boolean isValid = false;
        if (edtCredential.getText() != null && edtCredential.getText().length() > 0) {
            String credential = edtCredential.getText().toString().trim();
            if (credential.equals("0468874507")) {
                isValid = true;
            }
        }
        return isValid;
    }

    /**
     * Used for initialize views
     */
    private void initViews() {
        edtCredential = (EditText) findViewById(R.id.edtCredential);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }

    /**
     * navigation to splash page
     */
    private void navigateToSplashPage() {
        edtCredential.getText().clear();
        Intent intent = new Intent(LoginActivity.this, SplashActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {

    }
}
