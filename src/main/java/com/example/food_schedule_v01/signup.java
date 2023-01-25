package com.example.food_schedule_v01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.food_schedule_v01.data.d_breakfast;
import com.example.food_schedule_v01.data.d_sign;

import java.util.ArrayList;
import java.util.List;

public class signup extends AppCompatActivity {
    private static final String TAG = "signup";
    String name, pass, email;
    EditText inputName, inputPass, inputEmail;
    Button signupBtn;
    TextView loginLink;
    Handler handler;
    FoodDB_01 dbHelper8;
    d_sign Signhelper;
    boolean b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        inputName = (EditText) findViewById(R.id.input_Sname);
        inputPass = (EditText) findViewById(R.id.input_Spassword);
        inputEmail = (EditText) findViewById(R.id.input_email);
        signupBtn = (Button) findViewById(R.id.signup);
        loginLink = (TextView) findViewById(R.id.link_login);
        dbHelper8 = new FoodDB_01(this);
        Signhelper = new d_sign();

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });
        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void signup(){
        if (!validate()){
            onSignupFailed();
            return;
        }
        signupBtn.setEnabled(false);
        final ProgressDialog progressDialog = new ProgressDialog(signup.this, R.style.Theme_AppCompat);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        name = inputName.getText().toString();
        pass = inputPass.getText().toString();
        email = inputEmail.getText().toString();
        Signhelper.setUsername(name);
        Signhelper.setPassword(pass);
        Signhelper.setEmail(email);
        Long id = dbHelper8.insertSData(Signhelper);

        if (id == -2){
            inputName.setError("used");
            onSignupFailed();
            progressDialog.dismiss();
            return;
        }

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onSignupSuccess();
                progressDialog.dismiss();
            }
        },3000);
    }
    public void onSignupSuccess(){
        signupBtn.setEnabled(true);
//        setResult(RESULT_OK, null);
//        finish();
        Intent transfer = new Intent(signup.this, MainActivity.class);
        startActivity(transfer);
    }
    public void onSignupFailed(){
        Toast.makeText(getBaseContext(), "signup failed", Toast.LENGTH_SHORT).show();
        signupBtn.setEnabled(true);
    }
    public boolean validate(){
        boolean valid = true;
        name = inputName.getText().toString();
        pass = inputPass.getText().toString();
        email = inputEmail.getText().toString();
        Signhelper.setUsername(name);
//        Signhelper.setPassword(pass);
//        Signhelper.setEmail(email);
//        Long id = dbHelper8.insertSData(Signhelper);


        if (name.isEmpty() || name.length() < 3 ){
            inputName.setError("at least 3 characters");
            valid = false;
        }else {
            if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                inputEmail.setError("enter a valid email address");
                valid = false;
            }else {
                if (pass.isEmpty() || pass.length() < 4 || pass.length() > 20){
                    inputPass.setError("between 4 and 20 characters");
                    valid = false;
                }
//                    b = dbHelper8.checksignup(Signhelper);
//                    if (b)
//                    {
//                        valid = false;
//                        inputName.setError("used");
//                    }
//                    else
//                    {
//                        valid = true;
//                    }

            }
        }

        return valid;
    }
}
