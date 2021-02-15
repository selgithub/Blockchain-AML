package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import org.joda.time.LocalDate;

import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity2 extends AppCompatActivity {
    Button sign;
    EditText birthdate, city, streetname, streetno, studentid, instemail;
    Intent intent1, intent;
    public static int year, month, day;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        getSupportActionBar().setTitle("Register");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        intent = new Intent(this, MainActivity.class);

        sign = (Button) findViewById(R.id.button);
        city = (EditText) findViewById(R.id.city);
        streetname = (EditText) findViewById(R.id.streetname);
        streetno = (EditText) findViewById(R.id.streetno);
        studentid = (EditText) findViewById(R.id.studid);
        instemail = (EditText) findViewById(R.id.instemail);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userregister(createrequest());

            }
        });
    }

    public Register createrequest() {
        intent1 = getIntent();
        Register req = new Register();
        req.setUsername(intent1.getStringExtra("user"));
        req.setPassword(intent1.getStringExtra("password"));
        req.setFirst_name(intent1.getStringExtra("firstname"));
        req.setLast_name(intent1.getStringExtra("lastname"));
        req.setEmail(intent1.getStringExtra("email"));
        req.setPhone_number(intent1.getStringExtra("phone"));
        req.setCreated_by(intent1.getStringExtra("firstname"));
        req.setUpdated_by(intent1.getStringExtra("firstname"));
//            req.setBirthdate(LocalDate.parse(birthdate.getText().toString()));
        req.setCity(city.getText().toString());
        req.setStreetno(streetno.getText().toString());
        req.setstreetname(streetname.getText().toString());
        req.setStudentid(Long.parseLong(studentid.getText().toString()));
        req.setInstemail(instemail.getText().toString());
        req.setEnabled(Boolean.TRUE);
        return req;
    }


    private void userregister(Register request) {
        Call<Register> res = client.api().userregister(request);
        res.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(RegisterActivity2.this, "request sucessful", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } else
                    Toast.makeText(RegisterActivity2.this, "request failed", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {
                Toast.makeText(RegisterActivity2.this, "failed" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();


            }
        });
    }
}

