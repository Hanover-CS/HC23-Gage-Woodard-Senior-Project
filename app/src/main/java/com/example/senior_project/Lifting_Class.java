package com.example.senior_project;

public class Lifting_Class {

    private String day;
    private String liftOne;
    private String liftTwo;
    private String liftThree;
    private String liftFour;
    private String liftFive;
    private int id;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getLiftOne() {
        return liftOne;
    }

    public void setLiftOne(String liftOne) {
        this.liftOne = liftOne;
    }

    public String getLiftTwo() {
        return liftTwo;
    }

    public void setLiftTwo(String liftTwo) {
        this.liftTwo = liftTwo;
    }

    public String getLiftThree() {
        return liftThree;
    }

    public void setLiftThree(String liftThree) {
        this.liftThree = liftThree;
    }

    public String getLiftFour() {
        return liftFour;
    }

    public void setLiftFour(String liftFour) {
        this.liftFour = liftFour;
    }

    public String getLiftFive() {
        return liftFive;
    }

    public void setLiftFive(String liftFive) {
        this.liftFive = liftFive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lifting_Class(String day, String liftOne, String liftTwo, String liftThree,
                         String liftFour, String liftFive) {
        this.day = day;
        this.liftOne = liftOne;
        this.liftTwo = liftTwo;
        this.liftThree = liftThree;
        this.liftFour = liftFour;
        this.liftFive = liftFive;
    }

}
