package com.lostfound.loastandfound2;

public class model {

    String Item,Location, Date,Time;

    //blank constructor so that the data goes into the recycler
   model(){

   }

    //constructors
    public model(String item, String location, String date, String time) {
        Item = item;
        Location = location;
        Date = date;
        Time = time;
    }


    //getter and setter for all the variables
    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
