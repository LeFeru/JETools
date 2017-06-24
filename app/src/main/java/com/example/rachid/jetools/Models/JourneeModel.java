package com.example.rachid.jetools.Models;

/**
 * Created by rachid on 12/05/17.
 */
public class JourneeModel {
    private String journee;
    private int number;
    public JourneeModel(String journee, int id){
        this.journee = journee;
        this.number = id;
    }

    public String getJournee() {
        return journee;
    }

    public void setJournee(String journee) {
        this.journee = journee;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}