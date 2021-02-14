package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button signin, register;
    public static Api api;
    public static Intent home, intent;
    public static String token;
    private TokenManager tokenmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, RegisterActivity.class);
        home = new Intent(this, HomeActivity.class);
        tokenmanager = new TokenManager(getApplicationContext());
        register = (Button) findViewById(R.id.register);
        signin = (Button) findViewById(R.id.sign);
        username = (EditText) findViewById(R.id.editTextTextPersonName2);
        password = (EditText) findViewById(R.id.editTextTextPassword2);
        signin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                createPost(createrequest());

            }
        });
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    public UsernamePassReq createrequest() {
        UsernamePassReq req = new UsernamePassReq();
        req.setusername(username.getText().toString().trim());
        req.setPassword(password.getText().toString().trim());
        return req;
    }

    private void createPost(UsernamePassReq request) {
        Call<UserTokenState> res = client.api().createPost(request);
        res.enqueue(new Callback<UserTokenState>() {
            @Override
            public void onResponse(Call<UserTokenState> call, Response<UserTokenState> response) {
                if (response.isSuccessful()) {
                    UserTokenState token1 = response.body();
                    tokenmanager.createSession(username.getText().toString().trim(), token1.getAccess_token().toString());
                    Call<List<Register>> users = client.api().getUsers(token1.getAccess_token().toString());
                     System.out.println(token);
//                    Toast.makeText(MainActivity.this, "request sucessful", Toast.LENGTH_LONG).show();
                    startActivity(home);
                } else
                    Toast.makeText(MainActivity.this, "request failed", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<UserTokenState> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failed" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();


            }
        });
    }
}

