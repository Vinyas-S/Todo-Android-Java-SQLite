package com.example.todojava;

public class Vinyas {
    private String Date;
    private String Time;
    private String Description;

    public Vinyas(String date,String time,String desc){
        Date=date;
        Time=time;
        Description=desc;

    }

    public String getDate() {
        return Date;
    }

    public String getTime() {
        return Time;
    }

    public String getDescription() {
        return Description;
    }
}
