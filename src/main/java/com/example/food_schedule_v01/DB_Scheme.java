package com.example.food_schedule_v01;

import android.content.Context;

public class DB_Scheme {
    public static final String DATABASE_NAME = "MealDB";
    public static final int DATABASE_Version = 9;

    //breakfast
    public static final String TABLE_NAME01 = "breakfastTB";
    public static final String UID01 = "id01";
    public static final String NAME01 = "name01";
    public static final String CALORIE01 = "calorie01";
    public static final String GRAM01 = "gr01";
    public static final String NUMBER01 = "no01";
    public static final String PRICE01 = "price01";
    public static final String INGREDIENT01 = "ingredient01";
    public static final String RECIPE01 = "recipe01";
    public static final String FLAG01 = "flag01";
//    public static final String CREATE_TABLE01 = "CREATE TABLE01"+TABLE_NAME01+
//            "("+UID01+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME01+" VARCHAR(255));"+ "\n"+
//            "("+NUMBER01+" VARCHAR(255));" +"\n"+
//            "("+GRAM01+" VARCHAR(255));" +"\n"+ "("+CALORIE01+" VARCHAR(255));"+"\n"+
//            "("+INGREDIENT01+" VARCHAR(255));"+"\n"+ "("+RECIPE01+" VARCHAR(255));"+"\n"+
//            "("+PRICE01+" VARCHAR(255));"+"\n"+ "("+FLAG01+" BOOLEAN);";
    public static final String CREATE_TABLE01 = "CREATE TABLE "+TABLE_NAME01+
        "("+UID01+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME01+" VARCHAR(255),"+CALORIE01+" VARCHAR(255),"+GRAM01+" VARCHAR(255),"+NUMBER01+" VARCHAR(255),"+PRICE01+" VARCHAR(255),"+INGREDIENT01+" VARCHAR(255),"+RECIPE01+" VARCHAR(255),"+FLAG01+" BOOLEAN);";

    public static final String DROP_TABLE01 = "DROP TABLE IF EXISTS "+TABLE_NAME01;

    //launch
    public static final String TABLE_NAME02 = "LaunchTB";
    public static final String UID02 = "id02";
    public static final String NAME02 = "name02";
    public static final String CALORIE02 = "calorie02";
    public static final String GRAM02 = "gr02";
    public static final String NUMBER02 = "no02";
    public static final String INGREDIENT02 = "ingredient02";
    public static final String RECIPE02 = "recipe02";
    public static final String PRICE02 = "price02";
    public static final String FLAG02 = "flag02";
//    public static final String CREATE_TABLE02 = "CREATE TABLE"+TABLE_NAME02+
//            "("+UID02+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME02+" VARCHAR(255));"+ "\n"+
//            "("+NUMBER02+" VARCHAR(255));" +"\n"+
//            "("+GRAM02+" VARCHAR(255));" +"\n"+ "("+CALORIE02+" VARCHAR(255));"+"\n"+
//            "("+INGREDIENT02+" VARCHAR(255));"+"\n"+ "("+RECIPE02+" VARCHAR(255));"+"\n"+
//            "("+PRICE02+" VARCHAR(255));"+"\n"+ "("+FLAG02+" BOOLEAN);";
public static final String CREATE_TABLE02 = "CREATE TABLE "+TABLE_NAME01+
        "("+UID02+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME02+" VARCHAR(255),"+CALORIE02+" VARCHAR(255),"+GRAM02+" VARCHAR(255),"+NUMBER02+" VARCHAR(255),"+PRICE02+" VARCHAR(255),"+INGREDIENT02+" VARCHAR(255),"+RECIPE02+" VARCHAR(255),"+FLAG02+" BOOLEAN);";
    public static final String DROP_TABLE02 = "DROP TABLE IF EXISTS "+TABLE_NAME02;


    //dinner
    public static final String TABLE_NAME03 = "DinnerTB";
    public static final String UID03 = "id03";
    public static final String NAME03 = "name03";
    public static final String CALORIE03 = "calorie03";
    public static final String GRAM03 = "gr03";
    public static final String NUMBER03 = "no03";
    public static final String INGREDIENT03 = "ingredient03";
    public static final String RECIPE03 = "recipe03";
    public static final String PRICE03 = "price03";
    public static final String FLAG03 = "flag03";
//    public static final String CREATE_TABLE03 = "CREATE TABLE03"+TABLE_NAME03+
//            "("+UID03+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME03+" VARCHAR(255));"+ "\n"+
//            "("+NUMBER03+" VARCHAR(255));" +"\n"+
//            "("+GRAM03+" VARCHAR(255));" +"\n"+ "("+CALORIE03+" VARCHAR(255));"+"\n"+
//            "("+INGREDIENT03+" VARCHAR(255));"+"\n"+ "("+RECIPE03+" VARCHAR(255));"+"\n"+
//            "("+PRICE03+" VARCHAR(255));"+"\n"+ "("+FLAG03+" BOOLEAN);";
public static final String CREATE_TABLE03 = "CREATE TABLE "+TABLE_NAME01+
        "("+UID03+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME03+" VARCHAR(255),"+CALORIE03+" VARCHAR(255),"+GRAM03+" VARCHAR(255),"+NUMBER03+" VARCHAR(255),"+PRICE03+" VARCHAR(255),"+INGREDIENT03+" VARCHAR(255),"+RECIPE03+" VARCHAR(255),"+FLAG03+" BOOLEAN);";
    public static final String DROP_TABLE03 = "DROP TABLE IF EXISTS "+TABLE_NAME03;


    //others
    public static final String TABLE_NAME04 = "otherFoodsTB";
    public static final String UID04 = "id04";
    public static final String NAME04 = "name04";
    public static final String CALORIE04 = "calorie04";
    public static final String GRAM04 = "gr04";
    public static final String NUMBER04 = "no04";
    public static final String INGREDIENT04 = "ingredient04";
    public static final String RECIPE04 = "recipe04";
    public static final String PRICE04 = "price04";
    public static final String FLAG04 = "flag04";
    public static final String TYPE04 = "type04";
//    public static final String CREATE_TABLE04 = "CREATE TABLE04"+TABLE_NAME04+
//            "("+UID04+" INTEGER PRIMARY KEY AUTOINCREMENT, "+TYPE04+" VARCHAR(255) : ,"+NAME04+" VARCHAR(255));"+ "\n"+
//            "("+NUMBER04+" VARCHAR(255));" +"\n"+
//            "("+GRAM04+" VARCHAR(255));" +"\n"+ "("+CALORIE04+" VARCHAR(255));"+"\n"+
//            "("+INGREDIENT04+" VARCHAR(255));"+"\n"+ "("+RECIPE04+" VARCHAR(255));"+"\n"+
//            "("+PRICE04+" VARCHAR(255));"+"\n"+ "("+FLAG04+" BOOLEAN);";
public static final String CREATE_TABLE04 = "CREATE TABLE "+TABLE_NAME01+
        "("+UID04+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME04+" VARCHAR(255),"+CALORIE04+" VARCHAR(255),"+GRAM04+" VARCHAR(255),"+NUMBER04+" VARCHAR(255),"+PRICE04+" VARCHAR(255),"+INGREDIENT04+" VARCHAR(255),"+RECIPE04+" VARCHAR(255),"+FLAG04+" BOOLEAN);";
    public static final String DROP_TABLE04 = "DROP TABLE IF EXISTS "+TABLE_NAME04;

    //sign
    public static final String TABLE_NAME05 = "signTB";
    public static final String UID05 = "id05";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";
    public static final String CREATE_TABLE05 = "CREATE TABLE "+TABLE_NAME05+
            "("+UID05+" INTEGER PRIMARY KEY AUTOINCREMENT, "+USERNAME+" VARCHAR(255),"+PASSWORD+" VARCHAR(255),"+EMAIL+" VARCHAR(255));";
    public static final String DROP_TABLE05 = "DROP TABLE IF EXISTS "+TABLE_NAME05;

    //save schedule
    public static final String TABLE_NAME06 = "scheduleTB";
    public static final String UID06 = "id06";
    public static final String DATE = "date";
    public static final String DAY = "day";
    public static final String BREAKFAST_NAME = "BFName";
    public static final String LAUNCH_NAME = "LName";
    public static final String DINNER_NAME = "DName";
    public static final String OTHER_NAME = "OName";
    public static final String EATEN_BREAKFAST = "BFEaten";
    public static final String EATEN_LAUNCH = "LEaten";
    public static final String EATEN_DINNER = "DEaten";
    public static final String EATEN_OTHER = "OEaten";
    public static final String CREATE_TABLE06 = "CREATE TABLE "+TABLE_NAME06+
            "("+UID06+" INTEGER PRIMARY KEY AUTOINCREMENT, "+DATE+" VARCHAR(255),"+DAY+" VARCHAR(255),"+BREAKFAST_NAME+" VARCHAR(255), "+LAUNCH_NAME+" VARCHAR(255),"+DINNER_NAME+" VARCHAR(255),"+OTHER_NAME+" VARCHAR(255),"+EATEN_BREAKFAST+" VARCHAR(255), "+EATEN_LAUNCH+" VARCHAR(255),"+EATEN_DINNER+" VARCHAR(255),"+EATEN_OTHER+" VARCHAR(255));";
    public static final String DROP_TABLE06 = "DROP TABLE IF EXISTS "+TABLE_NAME06;

}
