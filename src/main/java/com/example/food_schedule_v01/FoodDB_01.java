package com.example.food_schedule_v01;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.food_schedule_v01.data.d_breakfast;
import com.example.food_schedule_v01.data.d_dinner;
import com.example.food_schedule_v01.data.d_launch;
import com.example.food_schedule_v01.data.d_other;
import com.example.food_schedule_v01.data.d_schedule;
import com.example.food_schedule_v01.data.d_sign;

import java.util.ArrayList;
import java.util.List;

import static com.example.food_schedule_v01.DB_Scheme.CREATE_TABLE01;
import static com.example.food_schedule_v01.DB_Scheme.CREATE_TABLE02;
import static com.example.food_schedule_v01.DB_Scheme.CREATE_TABLE03;
import static com.example.food_schedule_v01.DB_Scheme.CREATE_TABLE04;
import static com.example.food_schedule_v01.DB_Scheme.CREATE_TABLE05;
import static com.example.food_schedule_v01.DB_Scheme.CREATE_TABLE06;
import static com.example.food_schedule_v01.DB_Scheme.DATABASE_NAME;
import static com.example.food_schedule_v01.DB_Scheme.DATABASE_Version;
import static com.example.food_schedule_v01.DB_Scheme.DROP_TABLE01;
import static com.example.food_schedule_v01.DB_Scheme.DROP_TABLE02;
import static com.example.food_schedule_v01.DB_Scheme.DROP_TABLE03;
import static com.example.food_schedule_v01.DB_Scheme.DROP_TABLE04;
import static com.example.food_schedule_v01.DB_Scheme.DROP_TABLE05;
import static com.example.food_schedule_v01.DB_Scheme.PASSWORD;
import static com.example.food_schedule_v01.DB_Scheme.UID01;
import static com.example.food_schedule_v01.DB_Scheme.USERNAME;

public class FoodDB_01 {


    static class myFoodTables extends SQLiteOpenHelper{

        public Context context;
        public myFoodTables(Context context){
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context = context;
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE01);
//            db.execSQL(CREATE_TABLE02);
//            db.execSQL(CREATE_TABLE03);
//            db.execSQL(CREATE_TABLE04);
            db.execSQL(CREATE_TABLE05);
            db.execSQL(CREATE_TABLE06);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL(DROP_TABLE01);
//            db.execSQL(DROP_TABLE02);
//            db.execSQL(DROP_TABLE03);
//            db.execSQL(DROP_TABLE04);
            db.execSQL(DROP_TABLE05);
            onCreate(db);
        }
    }

    myFoodTables foodTables;
    public FoodDB_01(Context context){
        foodTables = new myFoodTables(context);
    }

    public long insertBFData(d_breakfast ent){
        SQLiteDatabase db = foodTables.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DB_Scheme.NAME01, ent.getName());
        contentValues.put(DB_Scheme.CALORIE01, ent.getCalorie());
        contentValues.put(DB_Scheme.GRAM01, ent.getGram());
        contentValues.put(DB_Scheme.NUMBER01, ent.getNumber());
        contentValues.put(DB_Scheme.PRICE01, ent.getPrice());
        contentValues.put(DB_Scheme.INGREDIENT01, ent.getIngredient());
        contentValues.put(DB_Scheme.RECIPE01, ent.getRecipe());
        contentValues.put(DB_Scheme.FLAG01, ent.isFlag());
        long id = db.insert(DB_Scheme.TABLE_NAME01, null, contentValues);
        return id;
    }
    public long insertLData(String name,String calorie,String gram,String no,String ingredient,String recipe,String price){
        SQLiteDatabase db = foodTables.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DB_Scheme.NAME02, name);
        contentValues.put(DB_Scheme.CALORIE02, calorie);
        contentValues.put(DB_Scheme.GRAM02, gram);
        contentValues.put(DB_Scheme.NUMBER02, no);
        contentValues.put(DB_Scheme.PRICE02, price);
        contentValues.put(DB_Scheme.INGREDIENT02, ingredient);
        contentValues.put(DB_Scheme.RECIPE02, recipe);
        contentValues.put(DB_Scheme.FLAG02, true);
        long id = db.insert(DB_Scheme.TABLE_NAME02, null, contentValues);
        return id;
    }
    public long insertDData(String name,String calorie,String gram,String no,String ingredient,String recipe,String price){
        SQLiteDatabase db = foodTables.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DB_Scheme.NAME03, name);
        contentValues.put(DB_Scheme.CALORIE03, calorie);
        contentValues.put(DB_Scheme.GRAM03, gram);
        contentValues.put(DB_Scheme.NUMBER03, no);
        contentValues.put(DB_Scheme.PRICE03, price);
        contentValues.put(DB_Scheme.INGREDIENT03, ingredient);
        contentValues.put(DB_Scheme.RECIPE03, recipe);
        contentValues.put(DB_Scheme.FLAG03, true);
        long id = db.insert(DB_Scheme.TABLE_NAME03, null, contentValues);
        return id;
    }
    public long insertOData(String name,String type,String calorie,String gram,String no,String ingredient,String recipe,String price){
        SQLiteDatabase db = foodTables.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DB_Scheme.TYPE04, type);
        contentValues.put(DB_Scheme.NAME04, name);
        contentValues.put(DB_Scheme.CALORIE04, calorie);
        contentValues.put(DB_Scheme.GRAM04, gram);
        contentValues.put(DB_Scheme.NUMBER04, no);
        contentValues.put(DB_Scheme.PRICE04, price);
        contentValues.put(DB_Scheme.INGREDIENT04, ingredient);
        contentValues.put(DB_Scheme.RECIPE04, recipe);
        contentValues.put(DB_Scheme.FLAG04, true);
        long id = db.insert(DB_Scheme.TABLE_NAME04, null, contentValues);
        return id;
    }
    public long insertSData(d_sign ent){
        long id=-1;
        if (!checksignup(ent)) {
            SQLiteDatabase db = foodTables.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(DB_Scheme.USERNAME, ent.getUsername());
            contentValues.put(DB_Scheme.PASSWORD, ent.getPassword());
            contentValues.put(DB_Scheme.EMAIL, ent.getEmail());
            id = db.insert(DB_Scheme.TABLE_NAME05, null, contentValues);
        }else {
            id=-2;
        }
        return id;
    }
    public long insertScheduleData(d_schedule ent){
        SQLiteDatabase db = foodTables.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DB_Scheme.DATE, ent.getDate());
        contentValues.put(DB_Scheme.DAY, ent.getDay());
        contentValues.put(DB_Scheme.BREAKFAST_NAME, ent.getBreakfastName());
        contentValues.put(DB_Scheme.LAUNCH_NAME, ent.getLaunchName());
        contentValues.put(DB_Scheme.DINNER_NAME, ent.getDinnerName());
        contentValues.put(DB_Scheme.OTHER_NAME, ent.getOtherName());
        contentValues.put(DB_Scheme.EATEN_BREAKFAST, ent.getEatenBreakfast());
        contentValues.put(DB_Scheme.EATEN_LAUNCH, ent.getEatenLaunch());
        contentValues.put(DB_Scheme.EATEN_DINNER, ent.getEatenDinner());
        contentValues.put(DB_Scheme.EATEN_OTHER, ent.getEatenOther());
        long id = db.insert(DB_Scheme.TABLE_NAME06, null, contentValues);
        return id;
    }

    public d_breakfast findBFbyId(int id){
        SQLiteDatabase db = foodTables.getWritableDatabase();
        try {
            d_breakfast foods = new d_breakfast();
            String selectQuery = "SELECT * FROM " + DB_Scheme.TABLE_NAME01 +" where " + UID01 + "= " + id;
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()){
                do {
                    foods.setId(Integer.parseInt(cursor.getString(0)));
                    foods.setName(cursor.getString(1));
                    foods.setNumber(cursor.getString(2));
                    foods.setGram(cursor.getString(3));
                    foods.setCalorie(cursor.getString(4));
                    foods.setPrice(cursor.getString(5));
                    foods.setIngredient(cursor.getString(6));
                    foods.setRecipe(cursor.getString(7));
                    foods.setFlag(true);
                }while (cursor.moveToNext());
            }
            cursor.close();
            return foods;
        }catch (Exception e) {
            return null;
        }
    }

    public boolean updateBFData(d_breakfast ent){
        SQLiteDatabase db = foodTables.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DB_Scheme.NAME01, ent.getName());
        contentValues.put(DB_Scheme.CALORIE01, ent.getCalorie());
        contentValues.put(DB_Scheme.GRAM01, ent.getGram());
        contentValues.put(DB_Scheme.NUMBER01, ent.getNumber());
        contentValues.put(DB_Scheme.PRICE01, ent.getPrice());
        contentValues.put(DB_Scheme.INGREDIENT01, ent.getIngredient());
        contentValues.put(DB_Scheme.RECIPE01, ent.getRecipe());
        contentValues.put(DB_Scheme.FLAG01, ent.isFlag());
        String[] whereArgs = {String.valueOf(ent.getId())};
        try {
            if (db.update(DB_Scheme.TABLE_NAME01,contentValues, DB_Scheme.UID01 + " = ? ", whereArgs) != -1 ){
                return true;
            }
            else return false;
        }catch (Exception e){
            return false;
        }
    }
    public boolean updateLData(d_launch ent){
        SQLiteDatabase db = foodTables.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DB_Scheme.NAME02, ent.getName());
        contentValues.put(DB_Scheme.CALORIE02, ent.getCalorie());
        contentValues.put(DB_Scheme.GRAM02, ent.getGram());
        contentValues.put(DB_Scheme.NUMBER02, ent.getNumber());
        contentValues.put(DB_Scheme.PRICE02, ent.getPrice());
        contentValues.put(DB_Scheme.INGREDIENT02, ent.getIngredient());
        contentValues.put(DB_Scheme.RECIPE02, ent.getRecipe());
        contentValues.put(DB_Scheme.FLAG02, ent.isFlag());
        String[] whereArgs = {String.valueOf(ent.getId())};
        try {
            if (db.update(DB_Scheme.TABLE_NAME02,contentValues, DB_Scheme.UID02 + " = ? ", whereArgs) != -1 ){
                return true;
            }
            else return false;
        }catch (Exception e){
            return false;
        }
    }
    public boolean updateDData(d_dinner ent){
        SQLiteDatabase db = foodTables.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DB_Scheme.NAME03, ent.getName());
        contentValues.put(DB_Scheme.CALORIE03, ent.getCalorie());
        contentValues.put(DB_Scheme.GRAM03, ent.getGram());
        contentValues.put(DB_Scheme.NUMBER03, ent.getNumber());
        contentValues.put(DB_Scheme.PRICE03, ent.getPrice());
        contentValues.put(DB_Scheme.INGREDIENT03, ent.getIngredient());
        contentValues.put(DB_Scheme.RECIPE03, ent.getRecipe());
        contentValues.put(DB_Scheme.FLAG03, ent.isFlag());
        String[] whereArgs = {String.valueOf(ent.getId())};
        try {
            if (db.update(DB_Scheme.TABLE_NAME03,contentValues, DB_Scheme.UID03 + " = ? ", whereArgs) != -1 ){
                return true;
            }
            else return false;
        }catch (Exception e){
            return false;
        }
    }
    public boolean updateOData(d_other ent){
        SQLiteDatabase db = foodTables.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DB_Scheme.NAME04, ent.getName());
        contentValues.put(DB_Scheme.CALORIE04, ent.getCalorie());
        contentValues.put(DB_Scheme.GRAM04, ent.getGram());
        contentValues.put(DB_Scheme.NUMBER04, ent.getNumber());
        contentValues.put(DB_Scheme.PRICE04, ent.getPrice());
        contentValues.put(DB_Scheme.INGREDIENT04, ent.getIngredient());
        contentValues.put(DB_Scheme.RECIPE04, ent.getRecipe());
        contentValues.put(DB_Scheme.FLAG04, ent.isFlag());
        String[] whereArgs = {String.valueOf(ent.getId())};
        try {
            if (db.update(DB_Scheme.TABLE_NAME04,contentValues, DB_Scheme.UID04 + " = ? ", whereArgs) != -1 ){
                return true;
            }
            else return false;
        }catch (Exception e){
            return false;
        }
    }
    public boolean updateSData(d_sign ent){
        SQLiteDatabase db = foodTables.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DB_Scheme.PASSWORD, ent.getPassword());
        String[] whereArgs = {String.valueOf(ent.getId())};
        try {
            if (db.update(DB_Scheme.TABLE_NAME05,contentValues, DB_Scheme.UID05 + " = ? ", whereArgs) != -1 ){
                return true;
            }
            else return false;
        }catch (Exception e){
            return false;
        }
    }
    public boolean updateScheduleData(d_schedule ent){
        SQLiteDatabase db = foodTables.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DB_Scheme.DATE, ent.getDate());
        contentValues.put(DB_Scheme.DAY, ent.getDay());
        contentValues.put(DB_Scheme.BREAKFAST_NAME, ent.getBreakfastName());
        contentValues.put(DB_Scheme.LAUNCH_NAME, ent.getLaunchName());
        contentValues.put(DB_Scheme.DINNER_NAME, ent.getDinnerName());
        contentValues.put(DB_Scheme.OTHER_NAME, ent.getOtherName());
        contentValues.put(DB_Scheme.EATEN_BREAKFAST, ent.getEatenBreakfast());
        contentValues.put(DB_Scheme.EATEN_LAUNCH, ent.getEatenLaunch());
        contentValues.put(DB_Scheme.EATEN_DINNER, ent.getEatenDinner());
        contentValues.put(DB_Scheme.EATEN_OTHER, ent.getEatenOther());
        String[] whereArgs = {String.valueOf(ent.getId())};
        try {
            if (db.update(DB_Scheme.TABLE_NAME06,contentValues, DB_Scheme.UID06 + " = ? ", whereArgs) != -1 ){
                return true;
            }
            else return false;
        }catch (Exception e){
            return false;
        }
    }

    public List<d_breakfast> getBFData(){
        SQLiteDatabase db = foodTables.getWritableDatabase();
        List<d_breakfast> breakfast = new ArrayList<d_breakfast>();
        try {
            String selectQuery = "SELECT * FROM " + DB_Scheme.TABLE_NAME01;
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()){
                do {
                    d_breakfast foods = new d_breakfast();
                    foods.setId(Integer.parseInt(cursor.getString(0)));
                    foods.setName(cursor.getString(1));
                    foods.setCalorie(cursor.getString(2));
                    foods.setGram(cursor.getString(3));
                    foods.setNumber(cursor.getString(4));
                    foods.setPrice(cursor.getString(5));
                    foods.setIngredient(cursor.getString(6));
                    foods.setRecipe(cursor.getString(7));
                    foods.setFlag(Boolean.valueOf(cursor.getString(8)));
                    breakfast.add(foods);
                }while (cursor.moveToNext());
            }
            cursor.close();
            return breakfast;
        }catch (Exception e){
            return null;
        }
    }
    public List<d_launch> getLData(){
        SQLiteDatabase db = foodTables.getWritableDatabase();
        List<d_launch> launch = new ArrayList<d_launch>();
        try {
            String selectQuery = "SELECT * FROM " + DB_Scheme.TABLE_NAME02;
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()){
                do {
                    d_launch foods = new d_launch();
                    foods.setId(Integer.parseInt(cursor.getString(0)));
                    foods.setName(cursor.getString(1));
                    foods.setCalorie(cursor.getString(2));
                    foods.setGram(cursor.getString(3));
                    foods.setNumber(cursor.getString(4));
                    foods.setIngredient(cursor.getString(5));
                    foods.setRecipe(cursor.getString(6));
                    foods.setPrice(cursor.getString(7));
                    foods.setFlag(true);
                    launch.add(foods);
                }while (cursor.moveToNext());
            }
            cursor.close();
            return launch;
        }catch (Exception e){
            return null;
        }
    }
    public List<d_dinner> getDData(){
        SQLiteDatabase db = foodTables.getWritableDatabase();
        List<d_dinner> dinner = new ArrayList<d_dinner>();
        try {
            String selectQuery = "SELECT * FROM " + DB_Scheme.TABLE_NAME03;
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()){
                do {
                    d_dinner foods = new d_dinner();
                    foods.setId(Integer.parseInt(cursor.getString(0)));
                    foods.setName(cursor.getString(1));
                    foods.setCalorie(cursor.getString(2));
                    foods.setGram(cursor.getString(3));
                    foods.setNumber(cursor.getString(4));
                    foods.setIngredient(cursor.getString(5));
                    foods.setRecipe(cursor.getString(6));
                    foods.setPrice(cursor.getString(7));
                    foods.setFlag(true);
                    dinner.add(foods);
                }while (cursor.moveToNext());
            }
            cursor.close();
            return dinner;
        }catch (Exception e){
            return null;
        }
    }
    public List<d_other> getOData(){
        SQLiteDatabase db = foodTables.getWritableDatabase();
        List<d_other> other = new ArrayList<d_other>();
        try {
            String selectQuery = "SELECT * FROM " + DB_Scheme.TABLE_NAME04;
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()){
                do {
                    d_other foods = new d_other();
                    foods.setId(Integer.parseInt(cursor.getString(0)));
                    foods.setName(cursor.getString(1));
                    foods.setCalorie(cursor.getString(2));
                    foods.setGram(cursor.getString(3));
                    foods.setNumber(cursor.getString(4));
                    foods.setIngredient(cursor.getString(5));
                    foods.setRecipe(cursor.getString(6));
                    foods.setPrice(cursor.getString(7));
                    foods.setFlag(true);
                    foods.setType(cursor.getString(9));
                    other.add(foods);
                }while (cursor.moveToNext());
            }
            cursor.close();
            return other;
        }catch (Exception e){
            return null;
        }
    }
    public List<d_sign> getSData(){
        SQLiteDatabase db = foodTables.getWritableDatabase();
        List<d_sign> register = new ArrayList<d_sign>();
        try {
            String selectQuery = "SELECT * FROM " + DB_Scheme.TABLE_NAME05;
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()){
                do {
                    d_sign sign = new d_sign();
                    sign.setId(Integer.parseInt(cursor.getString(0)));
                    sign.setUsername(cursor.getString(1));
                    sign.setPassword(cursor.getString(2));
                    sign.setEmail(cursor.getString(3));
                    register.add(sign);
                }while (cursor.moveToNext());
            }
            cursor.close();
            return register;
        }catch (Exception e){
            return null;
        }
    }
    public List<d_schedule> getScheduleData(){
        SQLiteDatabase db = foodTables.getWritableDatabase();
        List<d_schedule> schedule = new ArrayList<d_schedule>();
        try {
            String selectQuery = "SELECT * FROM " + DB_Scheme.TABLE_NAME06;
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()){
                do {
                    d_schedule foodSchedule = new d_schedule();
                    foodSchedule.setId(Integer.parseInt(cursor.getString(0)));
                    foodSchedule.setDate(cursor.getString(1));
                    foodSchedule.setDay(cursor.getString(2));
                    foodSchedule.setBreakfastName(cursor.getString(3));
                    foodSchedule.setLaunchName(cursor.getString(4));
                    foodSchedule.setDinnerName(cursor.getString(5));
                    foodSchedule.setOtherName(cursor.getString(6));
                    foodSchedule.setEatenBreakfast(cursor.getString(7));
                    foodSchedule.setEatenLaunch(cursor.getString(8));
                    foodSchedule.setEatenDinner(cursor.getString(9));
                    foodSchedule.setEatenOther(cursor.getString(10));
                    schedule.add(foodSchedule);
                }while (cursor.moveToNext());
            }
            cursor.close();
            return schedule;
        }catch (Exception e){
            return null;
        }
    }

    public int deleteBFData(int id){
        SQLiteDatabase db = foodTables.getWritableDatabase();
        String[] whereArgs = {String.valueOf(id)};
            int d = db.delete(DB_Scheme.TABLE_NAME01, DB_Scheme.UID01 + " = ? ", whereArgs);
            return d;
    }


    public boolean checkLogin(d_sign ent){
        SQLiteDatabase db = foodTables.getWritableDatabase();
        try {
            String selectQuery = "SELECT * FROM " + DB_Scheme.TABLE_NAME05+" where " + USERNAME + " ='" + ent.getUsername() + "' and " + PASSWORD + " ='" + ent.getPassword()+"'";
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.getCount()==1)
                return true;
            else  return false;
        }catch (Exception e) {
            return false;
        }
    }
    public boolean checksignup(d_sign ent){
        SQLiteDatabase db = foodTables.getWritableDatabase();
        try {
            String selectQuery = "SELECT * FROM " + DB_Scheme.TABLE_NAME05+" where " + USERNAME + " ='" + ent.getUsername()+"'";
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.getCount()>0)
                return true;
            else  return false;
        }catch (Exception e) {
            return false;
        }
    }

}
