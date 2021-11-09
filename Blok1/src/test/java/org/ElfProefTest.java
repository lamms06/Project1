package org;


import h4.ElfProefApp;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ElfProefTest {

    ElfProefApp target;

    @Disabled
    @Test
    public void testConvertNumbersToArray() {
        int number = 123456789;
        int[] result = target.convertNumbersToArray(number);
        for (int i = 0; i < 9; i++) {
            assertEquals(result[i], i + 1);
        }
    }
    @Disabled
    @Test
    public void testIsElfProef() {
        int[] invoer = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertTrue(target.isElfProef(invoer));
    }
}




