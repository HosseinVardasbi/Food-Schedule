package com.example.food_schedule_v01.popup;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.example.food_schedule_v01.FoodDB_01;
import com.example.food_schedule_v01.Main2Activity;
import com.example.food_schedule_v01.R;
import com.example.food_schedule_v01.data.d_breakfast;

import java.util.ArrayList;
import java.util.List;

public class popup_chooseFood {
    ListView chooseFoodList;
    ArrayList<String> choosefoodArray = new ArrayList<String>();
    ArrayAdapter chooseFoodAdapter;
    FoodDB_01 dbHelper12;
    Main2Activity getChosenName;
    Context context;
   static String rettt;

    public popup_chooseFood(Context context){
        this.context = context;
    }

    public String showPopupWindow(View view) {
        LayoutInflater layoutInflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.popup_choose_food, null);
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        dbHelper12 = new FoodDB_01(context);
        chooseFoodList = (ListView) popupView.findViewById(R.id.chooseFoodList);

        List<d_breakfast> d_breakfasts = new ArrayList<>();
        d_breakfasts = dbHelper12.getBFData();
        for (d_breakfast d: d_breakfasts) {
            choosefoodArray.add(d.getId() + "-" + d.getName());
        }
        chooseFoodAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, choosefoodArray);
        chooseFoodList.setAdapter(chooseFoodAdapter);

        chooseFoodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[] dBreakfastName = String.valueOf(adapterView.getAdapter().getItem(i)).split("-");
              //  getChosenName = new Main2Activity(String.valueOf(dBreakfastName[1]));
                rettt=String.valueOf(dBreakfastName[1]);
                popupWindow.dismiss();
//                d_breakfast dBreakfastName = (d_breakfast) adapterView.getAdapter().getItem(i);
//                getChosenName = new Main2Activity(String.valueOf(dBreakfastName.getName()));


            }
        });

        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                popupWindow.dismiss();
                return true;
            }
        });


        return  rettt;

    }
}
