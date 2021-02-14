package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    CardView createaccounts, viewaccounts, buytokens, selltokens, viewtxns;
     SharedPreferences sharedPreferences;
     String usertoken;
     Intent crtacct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        crtacct=new Intent(this,createAcct.class);
        sharedPreferences=getApplicationContext().getSharedPreferences("Bearer", Context.MODE_PRIVATE);
        usertoken=sharedPreferences.getString("jwttoken","");
        //
        createaccounts = (CardView) findViewById(R.id.createaccounts);
        viewaccounts = (CardView) findViewById(R.id.viewaccounts);
        buytokens = (CardView) findViewById(R.id.buytokens);
        selltokens = (CardView) findViewById(R.id.selltokens);
        viewtxns = (CardView) findViewById(R.id.viewtransactions);
        //
        createaccounts.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.createaccounts:
                createAccounts();
                startActivity(crtacct);
                break;
        }
    }

    private void createAccounts() {
        Call<List<Register>> users = client.api().getUsers(usertoken);
        users.enqueue(new Callback<List<Register>>() {
            @Override
            public void onResponse(Call<List<Register>> call, Response<List<Register>> response) {
                List<Register> user= response.body();
                System.out.println(response.body().toString());
                System.out.println(user.get(0).first_name);
             }

            @Override
            public void onFailure(Call<List<Register>> call, Throwable t) {

            }
        });

    }
}