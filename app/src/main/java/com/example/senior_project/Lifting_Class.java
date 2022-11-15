package com.example.senior_project;

public class Lifting_Class {

    private String lift;
    private int number_sets;
    private int number_reps;

    public String getLift() {
        return lift;
    }

    public void setLift(String lift) {
        this.lift = lift;
    }

    public int getNumber_sets() {
        return number_sets;
    }

    public void setNumber_sets(int sets) {
        this.number_sets = sets;
    }

    public int getNumber_reps() {
        return number_reps;
    }

    public void setNumber_reps(int reps) {
        this.number_reps = reps;
    }

    public Lifting_Class(String lift, int sets, int reps) {
        this.lift = lift;
        this.number_sets = sets;
        this.number_reps = reps;
    }

}
