package com.example.food_schedule_v01.popup;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.food_schedule_v01.FoodDB_01;
import com.example.food_schedule_v01.R;
import com.example.food_schedule_v01.data.d_breakfast;

import java.util.ArrayList;
import java.util.List;

public class popup_seeFood {
    TextView popName, popCalorie,popGram, popNumber,popPrice, popIngredient, popRecipe;
    FoodDB_01 dbHelper3;
    int idfood;
    Context context;

     public popup_seeFood(int id, Context _context)
     {
         this.idfood=id;
         this.context=_context;
     }


    public void showPopupWindow(View view){
        LayoutInflater layoutInflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.popup_see_food,null);
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);
        popName = (TextView) popupView.findViewById(R.id.popName);
        popCalorie = (TextView) popupView.findViewById(R.id.popCalorie);
        popGram = (TextView) popupView.findViewById(R.id.popGram);
        popNumber = (TextView) popupView.findViewById(R.id.popNumber);
        popPrice = (TextView) popupView.findViewById(R.id.popPrice);
        popIngredient = (TextView) popupView.findViewById(R.id.popIngredient);
        popRecipe = (TextView) popupView.findViewById(R.id.popRecipe);
        dbHelper3 = new FoodDB_01(context);
        List<d_breakfast> d_breakfasts = new ArrayList<>();
      d_breakfasts = dbHelper3.getBFData();
        for (d_breakfast d:d_breakfasts) {
            if(d.getId()-idfood==0) {
                popName.setText(d.getName());
                popCalorie.setText(d.getCalorie());
                popGram.setText(d.getGram());
                popNumber.setText(d.getNumber());
                popPrice.setText(d.getPrice());
                popIngredient.setText(d.getIngredient());
                popRecipe.setText(d.getRecipe());
                break;
            }
        }
        //textPopup.setText(R.string.app_name);
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
}
