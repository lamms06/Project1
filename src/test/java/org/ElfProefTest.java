package org;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import h4.ElfProefApp;

public class ElfProefTest {

    ElfProefApp target;

    @Test
    public void testConvertNumbersToArray() {
        int number = 123456789;
        int[] result = target.convertNumbersToArray(number);
        for (int i = 0; i < 9; i++) {
            assertEquals(result[i], i + 1);
        }
    }

    @Test
    public void testIsElfProef() {
        int[] invoer = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertTrue(target.isElfProef(invoer));
    }
}




