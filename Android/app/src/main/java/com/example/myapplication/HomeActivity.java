package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    CardView createaccounts, viewaccts, buytokens, selltokens, viewtxns;
    SharedPreferences sharedPreferences;
    String usertoken;
    Intent crtacct, login, viewacct;
    private TokenManager tokenmanager;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tokenmanager = new TokenManager(getApplicationContext());
        getSupportActionBar().setTitle("Home");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);


        crtacct = new Intent(this, createAcct.class);
        login = new Intent(this, MainActivity.class);
        viewacct = new Intent(this, ViewAccount.class);


        sharedPreferences = getApplicationContext().getSharedPreferences("Bearer", Context.MODE_PRIVATE);
        usertoken = sharedPreferences.getString("jwttoken", "");
        //
        createaccounts = (CardView) findViewById(R.id.createaccounts);
        viewaccts = (CardView) findViewById(R.id.viewaccounts);
        buytokens = (CardView) findViewById(R.id.buytokens);
        selltokens = (CardView) findViewById(R.id.selltokens);
        viewtxns = (CardView) findViewById(R.id.viewtransactions);
        //
        createaccounts.setOnClickListener(this);
        viewaccts.setOnClickListener(this);
        buytokens.setOnClickListener(this);
        selltokens.setOnClickListener(this);
        viewtxns.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.createaccounts:
                createAccounts();
                startActivity(crtacct);
                break;
            case R.id.viewaccounts:
                //createAccounts();
                startActivity(viewacct);
                break;
            case R.id.buytokens:
                break;
            case R.id.selltokens:
                break;
            case R.id.viewtransactions:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator = getMenuInflater();
        inflator.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(login);

        return true;
    }

    private void createAccounts() {
        Call<List<Register>> users = client.api().getUsers(usertoken);
        users.enqueue(new Callback<List<Register>>() {
            @Override
            public void onResponse(Call<List<Register>> call, Response<List<Register>> response) {
                List<Register> user = response.body();
                System.out.println(response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Register>> call, Throwable t) {

            }
        });

    }
}