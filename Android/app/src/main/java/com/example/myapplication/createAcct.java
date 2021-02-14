package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class createAcct extends AppCompatActivity {
    Button createacc;
    EditText acct;
    SharedPreferences sharedPreferences;
    String usertoken;
    Intent home;
    Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        home=new Intent(this,HomeActivity.class);
        sharedPreferences = getApplicationContext().getSharedPreferences("Bearer", Context.MODE_PRIVATE);
        usertoken = sharedPreferences.getString("jwttoken", "");
        setContentView(R.layout.activity_create_acct);
        createacc = (Button) findViewById(R.id.createacc);
        acct = (EditText) findViewById(R.id.acctname);
        createacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 createaccount(createrequest());
            }
        });
    }

    private CreateAccount createrequest() {
        CreateAccount account=new CreateAccount();
        account.setAccountname(acct.getText().toString().trim());
        return account;
    }

    private void createaccount(CreateAccount accountname) {

        Call<AccountRegister> res = client.api().accountregister(usertoken,accountname);
        res.enqueue(new Callback<AccountRegister>() {
            @Override
            public void onResponse(Call<AccountRegister> call, Response<AccountRegister> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(createAcct.this, "request sucessful", Toast.LENGTH_LONG).show();
                    startActivity(home);
                } else
                    Toast.makeText(createAcct.this, "request failed", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<AccountRegister> call, Throwable t) {
                Toast.makeText(createAcct.this, "failed" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();


            }
        });

    }
}