package org.h6;

import h6.Exercise;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class ExerciseTest {

    Exercise target = new Exercise();

    @Test
    public void testExerciseOne() {
        target.exerciseOne();
    }

    @Disabled
    @Test
    public void testExerciseTwo() {
        target.exerciseTwo();
        fail();
    }
}