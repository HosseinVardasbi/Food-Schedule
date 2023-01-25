package com.example.food_schedule_v01.data;

public class d_schedule {
    private int id;
    private String date;
    private String day;
    private String breakfastName;
    private String launchName;
    private String dinnerName;
    private String otherName;
    private String eatenBreakfast;
    private String eatenLaunch;
    private String eatenDinner;
    private String eatenOther;

    public d_schedule(){}
    public d_schedule(String _breakfastName){
        this.breakfastName = _breakfastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getBreakfastName() {
        return breakfastName;
    }

    public void setBreakfastName(String breakfastName) {
        this.breakfastName = breakfastName;
    }

    public String getLaunchName() {
        return launchName;
    }

    public void setLaunchName(String launchName) {
        this.launchName = launchName;
    }

    public String getDinnerName() {
        return dinnerName;
    }

    public void setDinnerName(String dinnerName) {
        this.dinnerName = dinnerName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getEatenBreakfast() {
        return eatenBreakfast;
    }

    public void setEatenBreakfast(String eatenBreakfast) {
        this.eatenBreakfast = eatenBreakfast;
    }

    public String getEatenLaunch() {
        return eatenLaunch;
    }

    public void setEatenLaunch(String eatenLaunch) {
        this.eatenLaunch = eatenLaunch;
    }

    public String getEatenDinner() {
        return eatenDinner;
    }

    public void setEatenDinner(String eatenDinner) {
        this.eatenDinner = eatenDinner;
    }

    public String getEatenOther() {
        return eatenOther;
    }

    public void setEatenOther(String eatenOther) {
        this.eatenOther = eatenOther;
    }
}
