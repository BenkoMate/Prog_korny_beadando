package org.example.valid;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidMezszamTest {

    private final ValidMezszam validator = new ValidMezszam();

    @Test
    void helyesMezszamTeszt() {
        assertTrue(validator.isErvenyesMezszam(10));
        assertTrue(validator.isErvenyesMezszam(1));
        assertTrue(validator.isErvenyesMezszam(99));
    }

    @Test
    void hibasMezszamTeszt() {
        assertFalse(validator.isErvenyesMezszam(0));
        assertFalse(validator.isErvenyesMezszam(-5));
        assertFalse(validator.isErvenyesMezszam(100));
        assertFalse(validator.isErvenyesMezszam(null));
    }
}