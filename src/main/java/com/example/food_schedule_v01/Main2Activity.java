package com.example.food_schedule_v01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.food_schedule_v01.data.d_breakfast;
import com.example.food_schedule_v01.data.d_schedule;
import com.example.food_schedule_v01.popup.popup_chooseFood;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Button addBreakfastB, addLaunchB, addDinnerB, addOtherB;
    TextView showBreakfastT, showLaunchT, showDinnerT, showOtherT;
    PopupWindow popupWindow;
    static String foodsChosenName;
    ListView chooseFoodList;
    ArrayList<String> choosefoodArray = new ArrayList<String>();
    ArrayAdapter chooseFoodAdapter;
    FoodDB_01 dbHelper12;
    d_schedule scheduleHelper;
    public Main2Activity(String _foodsChosenName){
        this.foodsChosenName = _foodsChosenName;
    }
    public Main2Activity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addBreakfastB = (Button) findViewById(R.id.addB);
        addLaunchB = (Button) findViewById(R.id.addL);
        addDinnerB = (Button) findViewById(R.id.addD);
        addOtherB = (Button) findViewById(R.id.addO);
        showBreakfastT = (TextView) findViewById(R.id.showB);
        showLaunchT = (TextView) findViewById(R.id.showL);
        showDinnerT = (TextView) findViewById(R.id.showD);
        showOtherT = (TextView) findViewById(R.id.showO);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT, true);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    drawerLayout.setElevation(30);
                }
                drawerLayout.dispatchSetSelected(true);
                //drawerLayout.setSelected(false);
            }
        });
        setNavigationDrawer();
        dbHelper12 = new FoodDB_01(this);
        scheduleHelper = new d_schedule();
        List<d_breakfast> d_breakfasts = new ArrayList<>();
        d_breakfasts = dbHelper12.getBFData();
        for (d_breakfast d: d_breakfasts) {
            choosefoodArray.add(d.getId() + "-" + d.getName());
        }
        addBreakfastB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                popup_chooseFood popupChooseFood = new popup_chooseFood(Main2Activity.this);
//                String sss=popupChooseFood.showPopupWindow(view);
//                showBreakfastT.setText(sss);
                showPopupWindow(view);
            }
        });
       // showBreakfastT.setText(foodsChosenName);
    }

    private void showPopupWindow(View view){
        LayoutInflater layoutInflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.popup_choose_food, null);
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

//        dbHelper12 = new FoodDB_01(this);
        chooseFoodList = (ListView) popupView.findViewById(R.id.chooseFoodList);

//        List<d_breakfast> d_breakfasts = new ArrayList<>();
//        d_breakfasts = dbHelper12.getBFData();
//        for (d_breakfast d: d_breakfasts) {
//            choosefoodArray.add(d.getId() + "-" + d.getName());
//        }
        chooseFoodAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, choosefoodArray);
        chooseFoodList.setAdapter(chooseFoodAdapter);

        chooseFoodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[] dBreakfastName = String.valueOf(adapterView.getAdapter().getItem(i)).split("-");
                foodsChosenName = String.valueOf(dBreakfastName[1]);
//                showBreakfastT.setText(foodsChosenName);
                String breakfastName = foodsChosenName;
                scheduleHelper.setBreakfastName(breakfastName);
//                d_schedule dSchedule = new d_schedule(breakfastName);
                long id = dbHelper12.insertScheduleData(scheduleHelper);
                if (id > 0){
                    showBreakfastT.setText(breakfastName);
                }
//                List<d_schedule> d_schedules = new ArrayList<>();
//                d_schedules = dbHelper12.getScheduleData();
//                for (d_schedule d: d_schedules) {
//
//                }
                popupWindow.dismiss();
            }
        });
    }

    private void setNavigationDrawer(){
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.navigation);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.mAdd){
                    Intent transfer = new Intent(Main2Activity.this, AddFood.class);
                    startActivity(transfer);
                    drawerLayout.closeDrawers();
                    return true;
                }else if (itemId == R.id.mSee){
                    Intent transfer2 = new Intent(Main2Activity.this, SeeFood.class);
                    startActivity(transfer2);
                    drawerLayout.closeDrawers();
                    return true;
                }else if (itemId == R.id.mLogOut){
                    Intent transfer3 = new Intent(Main2Activity.this, login.class);
                    transfer3.putExtra("typeBtn","logout");
                    startActivity(transfer3);
                    drawerLayout.closeDrawers();
                    return true;
                }
                return false;
            }
        });
    }
}
