package org.h6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import h6.Exercise;

public class ExerciseTest {

    Exercise target = new Exercise();

    @Test
    public void testExerciseOne() {
        target.exerciseOne();
    }

    @Test
    public void testExerciseTwo() {
        target.exerciseTwo();
        fail();
    }
}