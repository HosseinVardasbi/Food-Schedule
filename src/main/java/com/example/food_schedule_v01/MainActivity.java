package com.example.food_schedule_v01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button addFood, seeFood, logOut, goToMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFood = (Button) findViewById(R.id.addFood);
        seeFood = (Button) findViewById(R.id.seeFood);
        logOut = (Button) findViewById(R.id.logOut);
        goToMenu = (Button) findViewById(R.id.goToMenu);

        addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent transfer = new Intent(MainActivity.this, AddFood.class);
                startActivity(transfer);
            }
        });
        seeFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent transfer = new Intent(MainActivity.this, SeeFood.class);
                startActivity(transfer);
            }
        });
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent transfer2 = new Intent(MainActivity.this, login.class);
                transfer2.putExtra("typeBtn","logout");
                startActivity(transfer2);
            }
        });
        goToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent transfer6 = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(transfer6);
            }
        });
    }
}
