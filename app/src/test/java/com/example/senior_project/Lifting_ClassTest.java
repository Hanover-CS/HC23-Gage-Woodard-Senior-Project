/**
 * <summary> This class tests Lifting_Class.
 *     <para>
 *         All tests run and pass.
 *     </para>
 * </summary>
 */


package com.example.senior_project;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Lifting_ClassTest {

    Lifting_Class lifting_class = new Lifting_Class("", 0, 0);

    @Test
    public void setLiftNameTest() {
        lifting_class.setLift("Barbell Squat");
        assertEquals("Barbell Squat", lifting_class.getLift());
    }

    @Test
    public void setNumberSetsTest() {
        lifting_class.setNumber_sets(20);
        assertEquals(20, lifting_class.getNumber_sets());
    }

    @Test
    public void setNumberRepsTest() {
        lifting_class.setNumber_reps(25);
        assertEquals(25, lifting_class.getNumber_reps());
    }

    @Test
    public void setLifting_ClassTest() {
        lifting_class.setLift("Bench");
        lifting_class.setNumber_sets(3);
        lifting_class.setNumber_reps(5);
        assertEquals("Bench", lifting_class.getLift());
        assertEquals(3, lifting_class.getNumber_sets());
        assertEquals(5, lifting_class.getNumber_reps());
    }

}