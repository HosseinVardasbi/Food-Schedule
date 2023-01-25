package com.example.food_schedule_v01.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.food_schedule_v01.FoodDB_01;
import com.example.food_schedule_v01.R;
import com.example.food_schedule_v01.popup.popup_seeFood;
import com.example.food_schedule_v01.update_mainFood;

import java.util.List;

public class recy_foodsAdapter extends RecyclerView.Adapter<recy_foodsAdapter.MyViewHolder> {
    private List<recy_foodsList> foodsList;
    PopupWindow popupWindow;
    RelativeLayout relativeLayout;
    Context context;
    FoodDB_01 dbHelper6;
    AlertDialog.Builder deleteAlert;
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView foodidlist, foodnamelist;
        Button editButton, deleteButton;
        public MyViewHolder(View view) {
            super(view);
            foodidlist = (TextView) view.findViewById(R.id.foodidList);
            foodnamelist = (TextView) view.findViewById(R.id.foodnameList);
            editButton = (Button) view.findViewById(R.id.editButton);
            deleteButton = (Button) view.findViewById(R.id.deleteButton);
            dbHelper6 = new FoodDB_01(context);
            deleteAlert = new AlertDialog.Builder(context);
        }
    }
    public recy_foodsAdapter(List<recy_foodsList> foodsList,Context _context){
        this.foodsList = foodsList;
        this.context=_context;
    }
    @Override
    public recy_foodsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.foods_list_row,parent,false);
        return new MyViewHolder(itemView);

    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final recy_foodsList recyFoodsList = foodsList.get(position);
        holder.foodidlist.setText(String.valueOf(recyFoodsList.getId()));
        holder.foodnamelist.setText(recyFoodsList.getName());
        holder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent transfer = new Intent(context, update_mainFood.class);
                transfer.putExtra("transferId", recyFoodsList.getId());
                context.startActivity(transfer);
            }
        });

        holder.foodnamelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup_seeFood popupSeeFood = new popup_seeFood(recyFoodsList.getId(),context);
                popupSeeFood.showPopupWindow(view);
            }
        });

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                int id = recyFoodsList.getId();
//                int a = dbHelper6.deleteBFData(id);
                deleteAlert.setMessage("Do you want to delete this food ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int id = recyFoodsList.getId();
                                int a = dbHelper6.deleteBFData(id);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alert = deleteAlert.create();
                alert.setTitle("Delete Food");
                alert.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return foodsList.size();
    }
}
