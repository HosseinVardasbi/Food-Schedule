package com.example.food_schedule_v01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.food_schedule_v01.data.d_sign;

public class login extends AppCompatActivity {
    private static final String TAG = "login";
    private static final int REQUEST_SIGNUP = 0;
    EditText inputName, inputPass;
    Button loginBtn;
    TextView signupLink;
    Handler handler;
    FoodDB_01 dbHelper10;
    d_sign signHelper;
    CheckBox checkBoxRememberMe;
    SharedPreferences sharedPreferences;
    String prefName = "prefName";
    String prefPass = "prefPass";
    String myPrefrences = "myPrefs";
    boolean a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inputName = (EditText) findViewById(R.id.input_Lname);
        inputPass = (EditText) findViewById(R.id.input_Lpassword);
        loginBtn = (Button) findViewById(R.id.login);
        signupLink = (TextView) findViewById(R.id.link_signup);
        checkBoxRememberMe = (CheckBox) findViewById(R.id.checkBoxRememberMe);
        sharedPreferences = getSharedPreferences(myPrefrences, Context.MODE_PRIVATE);
        dbHelper10 = new FoodDB_01(this);
        signHelper = new d_sign();



        SharedPreferences pref = getApplicationContext().getSharedPreferences(myPrefrences, 0);


        String type = getIntent().getStringExtra("typeBtn");
        if (type !=null && type.toString().equals("logout")){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(prefName, "-1");
            editor.putString(prefPass, "-1");
            editor.commit();
            inputName.setText(null);
            inputPass.setText(null);

        }
        String nn=pref.getString(prefName,"-1");
        String pp = pref.getString(prefPass, "-1");
        if (pref !=null)
        {
            if(!nn.equals("-1") && !pp.equals("-1"))
            {
                inputName.setText(nn);
                inputPass.setText(pp);
                login();
            }
        }



        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        signupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent transfer = new Intent(getApplicationContext(), signup.class);
                startActivityForResult(transfer, REQUEST_SIGNUP);
            }
        });
    }
    public void login(){
        if (!validate()){
            onLoginFailed();
            return;
        }
        loginBtn.setEnabled(false);
        final ProgressDialog progressDialog = new ProgressDialog(login.this, R.style.Theme_AppCompat);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String name = inputName.getText().toString();
        String pass = inputPass.getText().toString();
//        signHelper.setUsername(name);
//        signHelper.setPassword(pass);
//        a = dbHelper10.checkLogin(signHelper);
        if (checkBoxRememberMe.isChecked()){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(prefName, name);
            editor.putString(prefPass, pass);
            editor.commit();
            Toast.makeText(this,"saved",Toast.LENGTH_LONG).show();
        }

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onLoginSuccess();
                progressDialog.dismiss();
            }
        },3000);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == REQUEST_SIGNUP){
            if (resultCode == RESULT_OK){
                this.finish();
            }
        }
    }
    public void onLoginSuccess(){
        loginBtn.setEnabled(true);
        Intent transfer2 = new Intent(login.this, MainActivity.class);
        startActivity(transfer2);
        finish();
    }
    public void onLoginFailed(){
        Toast.makeText(getBaseContext(), "login failed", Toast.LENGTH_SHORT).show();
        loginBtn.setEnabled(true);
    }
    public boolean validate(){
        boolean valid = true;

        String name = inputName.getText().toString();
        String pass = inputPass.getText().toString();
        signHelper.setUsername(name);
        signHelper.setPassword(pass);


        if (name.isEmpty() || name.length() < 3){

            inputName.setError("at least 3 characters");
            valid = false;
        }else {

            if (pass.isEmpty() || pass.length() < 4 || pass.length() > 20 ){
                inputPass.setError("between 4 and 20 characters");
                valid = false;
            }else {
                a = dbHelper10.checkLogin(signHelper);
                if (a) {
                    valid=true;
                }
                else {
                    inputPass.setError("wrong");
                    inputName.setError("wrong");
                    valid = false;
                }
            }
        }

        return valid;
    }
}
