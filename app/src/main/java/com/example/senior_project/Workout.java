package com.example.senior_project;

import android.widget.TextView;

import java.util.ArrayList;

public class Workout {
    private String lift, weight;

    public Workout(String newLift, String newWeight) {
        setLift(newLift);
        setWeight(newWeight);
    }

    public void setLift(String newLift) {
        lift = newLift;
    }

    public void setWeight(String newWeight) {
        weight = newWeight;
    }

    public String getLift() {
        return lift;
    }

    public String getWeight() {
        return weight;
    }

    public String toString() {
        return lift + " " + weight;
    }

}
