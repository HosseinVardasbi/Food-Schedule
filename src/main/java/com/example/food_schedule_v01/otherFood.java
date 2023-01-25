package com.example.food_schedule_v01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.food_schedule_v01.data.d_breakfast;
import com.example.food_schedule_v01.data.d_other;

import java.util.ArrayList;
import java.util.List;

public class otherFood extends AppCompatActivity {

    FoodDB_01 dbHelper;
    EditText type, name, calorie,gram, number,price, ingredient,recipe;
    CheckBox flag;
    String nnnn = "";
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_food);
        type = (EditText) findViewById(R.id.type);
        name = (EditText) findViewById(R.id.name);
        calorie = (EditText) findViewById(R.id.calorie);
        gram = (EditText) findViewById(R.id.gram);
        number = (EditText) findViewById(R.id.number);
        price = (EditText) findViewById(R.id.price);
        ingredient = (EditText) findViewById(R.id.ingredient);
        recipe = (EditText) findViewById(R.id.recipe);
        flag = (CheckBox) findViewById(R.id.flag);
        add=(Button) findViewById(R.id.add);

        dbHelper = new FoodDB_01(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddOFood(view);
            }
        });
    }
    public void AddOFood(View view){
        String F1 = type.getText().toString();
        String F2 = name.getText().toString();
        String F3 = calorie.getText().toString();
        String F4 = gram.getText().toString();
        String F5 = number.getText().toString();
        String F6 = price.getText().toString();
        String F7 = ingredient.getText().toString();
        String F8 = recipe.getText().toString();
        long id = dbHelper.insertOData(F1,F2,F3,F4,F5,F6,F7,F8);
        if (id > 0){
            Toast.makeText(this, "insert successful", Toast.LENGTH_SHORT).show();
        }
    }
    public void ViewBreakFast(View view){
        List<d_other> d_others = new ArrayList<>();
        d_others=dbHelper.getOData();
        for (d_other d:d_others) {
            nnnn = d.getId()+d.getType()+"\n"+d.getName()+"\n"+d.getCalorie()+"\n"+d.getGram()+"\n"+
                    d.getNumber()+"\n"+d.getPrice()+"\n"+d.getIngredient()+"\n"+d.getRecipe();
        }
        Toast.makeText(this, nnnn, Toast.LENGTH_LONG).show();
    }
}
