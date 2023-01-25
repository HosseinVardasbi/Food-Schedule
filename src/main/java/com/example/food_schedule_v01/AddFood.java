package com.example.food_schedule_v01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddFood extends AppCompatActivity {

    Button breakfast, launch, dinner, other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        breakfast = (Button) findViewById(R.id.BFbutton);
        launch = (Button) findViewById(R.id.Lbutton);
        dinner = (Button) findViewById(R.id.Dbutton);
        other = (Button) findViewById(R.id.Obutton);
        breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent transfer = new Intent(AddFood.this, add_mainFood.class);
                transfer.putExtra("typeBtn","breakfast");
                startActivity(transfer);
            }
        });
        launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent transfer2 = new Intent(AddFood.this, add_mainFood.class);
                transfer2.putExtra("typeBtn","launch");
                startActivity(transfer2);
            }
        });
        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent transfer3 = new Intent(AddFood.this, add_mainFood.class);
                transfer3.putExtra("typeBtn","dinner");
                startActivity(transfer3);
            }
        });
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent transfer4 = new Intent(AddFood.this, otherFood.class);
                startActivity(transfer4);
            }
        });

    }
}
