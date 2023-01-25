package com.example.food_schedule_v01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.PopupWindow;
import android.view.ViewGroup.LayoutParams;

import com.example.food_schedule_v01.RecyclerView.recy_foodsAdapter;
import com.example.food_schedule_v01.RecyclerView.recy_foodsList;
import com.example.food_schedule_v01.data.d_breakfast;

import java.util.ArrayList;
import java.util.List;

public class SeeFood extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    FoodDB_01 dbHelper2;
    Spinner foodSpinner;
    ArrayAdapter  selectFoodAdapter;
    String[] selectFood;
    RecyclerView recyclerView;
    List<recy_foodsList> foodsList = new ArrayList<>();
    recy_foodsAdapter foodsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_food);
        //setContentView(R.layout.foods_list_row);
        foodSpinner = (Spinner) findViewById(R.id.foodSpinner);
        dbHelper2 = new FoodDB_01(this);
        foodSpinner.setOnItemSelectedListener(this);
        selectFood = new String[]{"breakfast", "launch", "dinner", "other"};
        selectFoodAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, selectFood);
        selectFoodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        foodSpinner.setAdapter(selectFoodAdapter);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        foodsAdapter = new recy_foodsAdapter(foodsList,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(foodsAdapter);



    }
    private void prepareBFData(){
        List<d_breakfast> d_breakfasts = new ArrayList<>();
        d_breakfasts=dbHelper2.getBFData();
        for (d_breakfast d:d_breakfasts) {
            recy_foodsList recyFoods = new recy_foodsList();
            recyFoods.setId(d.getId());
            recyFoods.setName(d.getName());
            recyFoods.setFlag(d.isFlag());
            foodsList.add(recyFoods);

        }
        foodsAdapter.notifyDataSetChanged();
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

        switch (position){
            case 0:
                prepareBFData();
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
