package com.example.food_schedule_v01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.food_schedule_v01.data.d_breakfast;

public class add_mainFood extends AppCompatActivity {
    FoodDB_01 dbHelper;
    d_breakfast BFhelper1;
    EditText name, calorie,gram, number,price, ingredient,recipe;
    CheckBox flag;
    String nnnn = "";
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_main_food);
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
        BFhelper1 = new d_breakfast();


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type=getIntent().getStringExtra("typeBtn");
                if (type != null) {
                    if(type.equals("breakfast"))
                    {
                        AddBFFood(view);
                    }
                    else  if(type.equals("lunch"))
                    {
                        AddLFood(view);
                    }
                    else  if(type.equals("dinner"))
                    {
                        AddDFood(view);
                    }
                }

            }
        });
    }

    public void AddBFFood(View view){
        String F1 = name.getText().toString();
        String F2 = calorie.getText().toString();
        String F3 = gram.getText().toString();
        String F4 = number.getText().toString();
        String F5 = price.getText().toString();
        String F6 = ingredient.getText().toString();
        String F7 = recipe.getText().toString();
        Boolean F8 = flag.isChecked();
        BFhelper1.setName(F1);
        BFhelper1.setCalorie(F2);
        BFhelper1.setGram(F3);
        BFhelper1.setNumber(F4);
        BFhelper1.setPrice(F5);
        BFhelper1.setIngredient(F6);
        BFhelper1.setRecipe(F7);
        BFhelper1.setFlag(F8);
        long id = dbHelper.insertBFData(BFhelper1);
        if (id > 0){
            Toast.makeText(this, "insert successful", Toast.LENGTH_SHORT).show();
        }
    }
    public void AddLFood(View view){
        String F1 = name.getText().toString();
        String F2 = calorie.getText().toString();
        String F3 = gram.getText().toString();
        String F4 = number.getText().toString();
        String F5 = price.getText().toString();
        String F6 = ingredient.getText().toString();
        String F7 = recipe.getText().toString();
        long a = dbHelper.insertLData(F1,F2,F3,F4,F5,F6,F7);
        if (a > 0){
            Toast.makeText(this, "insert successful", Toast.LENGTH_SHORT).show();
        }
    }
    public void AddDFood(View view){
        String F1 = name.getText().toString();
        String F2 = calorie.getText().toString();
        String F3 = gram.getText().toString();
        String F4 = number.getText().toString();
        String F5 = price.getText().toString();
        String F6 = ingredient.getText().toString();
        String F7 = recipe.getText().toString();
        long b = dbHelper.insertDData(F1,F2,F3,F4,F5,F6,F7);
        if (b > 0){
            Toast.makeText(this, "insert successful", Toast.LENGTH_SHORT).show();
        }
    }
//    public void ViewBreakFast(View view){
//        List<d_breakfast> d_breakfasts = new ArrayList<>();
//      d_breakfasts=dbHelper.getBFData();
//        for (d_breakfast d:d_breakfasts) {
//            nnnn = d.getId()+"\n"+d.getName()+"\n"+d.getCalorie()+"\n"+d.getGram()+"\n"+
//                    d.getNumber()+"\n"+d.getPrice()+"\n"+d.getIngredient()+"\n"+d.getRecipe();
//        }
//        Toast.makeText(this, nnnn, Toast.LENGTH_LONG).show();
//    }
}
