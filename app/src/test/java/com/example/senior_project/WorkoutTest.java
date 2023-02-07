package com.example.senior_project;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorkoutTest {

    Workout workout = new Workout("", "");

    @Test
    public void testNewLift() {
        workout.setLift("Bench");
        assertEquals("Bench", workout.getLift());
    }

    @Test
    public void testNewWeight() {
        workout.setWeight("225");
        assertEquals("225", workout.getWeight());
    }

    @Test
    public void testWrongLift() {
        workout.setLift("Squat");
        assertNotEquals("Bench", workout.getLift());
    }

    @Test
    public void testWrongWeight() {
        workout.setLift("650");
        assertNotEquals("700", workout.getWeight());
    }

    @Test
    public void addFullWorkout() {
        workout.setLift("Squat");
        workout.setWeight("630");
        assertEquals(workout.toString(), workout.toString());
    }

}