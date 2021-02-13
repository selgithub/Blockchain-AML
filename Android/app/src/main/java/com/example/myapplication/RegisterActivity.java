package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private Button bRegister, backtologin;
    private EditText etName, etLastname, etEmail, etUsername, etPassword, etPhone;
    String fname, lname, email, pass, user, phone;
    public static Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etName = (EditText) findViewById(R.id.fname);
        etLastname = (EditText) findViewById(R.id.lname);
        etEmail = (EditText) findViewById(R.id.email);
        etUsername = (EditText) findViewById(R.id.username);
        etPhone = (EditText) findViewById(R.id.phone);
        etPassword = (EditText) findViewById(R.id.password);
        bRegister = (Button) findViewById(R.id.register1);


        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(RegisterActivity.this, RegisterActivity2.class);
                intent1.putExtra("firstname", etName.getText().toString());
                intent1.putExtra("lastname", etLastname.getText().toString());
                intent1.putExtra("email", etEmail.getText().toString());
                intent1.putExtra("user", etUsername.getText().toString());
                intent1.putExtra("password", etPassword.getText().toString());
                intent1.putExtra("phone", etPhone.getText().toString());
                startActivity(intent1);

            }
        });
    }

}
