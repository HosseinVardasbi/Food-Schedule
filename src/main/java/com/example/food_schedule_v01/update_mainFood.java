package com.example.food_schedule_v01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.food_schedule_v01.data.d_breakfast;

import java.util.ArrayList;
import java.util.List;

public class update_mainFood extends AppCompatActivity {
    FoodDB_01 dbHelper4;
    d_breakfast BFhelper;
    EditText name, calorie,gram, number,price, ingredient,recipe;
    CheckBox flag;
    Button update;
    int idfood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_main_food);
        name = (EditText) findViewById(R.id.name);
        calorie = (EditText) findViewById(R.id.calorie);
        gram = (EditText) findViewById(R.id.gram);
        number = (EditText) findViewById(R.id.number);
        price = (EditText) findViewById(R.id.price);
        ingredient = (EditText) findViewById(R.id.ingredient);
        recipe = (EditText) findViewById(R.id.recipe);
        flag = (CheckBox) findViewById(R.id.flag);
        update=(Button) findViewById(R.id.update);
        dbHelper4 = new FoodDB_01(this);
        BFhelper = new d_breakfast();

        idfood = getIntent().getExtras().getInt("transferId");

        List<d_breakfast> d_breakfasts = new ArrayList<>();
        d_breakfasts = dbHelper4.getBFData();
        for (d_breakfast d:d_breakfasts) {
            if(d.getId()-idfood==0) {
                name.setText(d.getName());
                calorie.setText(d.getCalorie());
                gram.setText(d.getGram());
                number.setText(d.getNumber());
                price.setText(d.getPrice());
                ingredient.setText(d.getIngredient());
                recipe.setText(d.getRecipe());
                break;
            }
        }

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateBFFood(view);
            }
        });
    }

    public void UpdateBFFood(View view){
        String F1 = name.getText().toString();
        String F2 = calorie.getText().toString();
        String F3 = gram.getText().toString();
        String F4 = number.getText().toString();
        String F5 = price.getText().toString();
        String F6 = ingredient.getText().toString();
        String F7 = recipe.getText().toString();
        Boolean F8 = flag.isChecked();
        BFhelper.setName(F1);
        BFhelper.setCalorie(F2);
        BFhelper.setGram(F3);
        BFhelper.setNumber(F4);
        BFhelper.setPrice(F5);
        BFhelper.setIngredient(F6);
        BFhelper.setRecipe(F7);
        BFhelper.setFlag(F8);
        BFhelper.setId(idfood);
        boolean a = dbHelper4.updateBFData(BFhelper);
        if (a == true){
            Toast.makeText(this, "update successful", Toast.LENGTH_SHORT).show();
        }
    }
}
