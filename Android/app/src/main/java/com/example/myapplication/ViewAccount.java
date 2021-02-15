package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewAccount extends AppCompatActivity {
    EditText acctname, prkey, pbkey;
    SharedPreferences sharedPreferences;
    String usertoken, username;
    TextView output1;
    List<AccountRegister> accts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_account);
        sharedPreferences = getApplicationContext().getSharedPreferences("Bearer", Context.MODE_PRIVATE);
        usertoken = sharedPreferences.getString("jwttoken", "");
        username = sharedPreferences.getString("username", "");
        output1 = (TextView) findViewById(R.id.result);
        Call<List<AccountRegister>> users = client.api().getAccountById(usertoken);
        users.enqueue(new Callback<List<AccountRegister>>() {
            @Override
            public void onResponse(Call<List<AccountRegister>> call, Response<List<AccountRegister>> response) {
                System.out.println(response.body().toString());
                accts = response.body();

                for (AccountRegister acct : accts) {
                    String content = "";
                    content += "ID: " + acct.getId() + "\n";
                    content += "Account Name: " + acct.getAccountname() + "\n";
                    content += "Private Key: " + acct.getPrikey() + "\n";
                    content += "Public Key: " + acct.getPubkey() + "\n\n";

                    output1.append("content");
                }
            }

            @Override
            public void onFailure(Call<List<AccountRegister>> call, Throwable t) {

            }
        });
    }
}

