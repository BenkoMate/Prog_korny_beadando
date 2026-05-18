package org.example.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PontKalkulatorTest {

    private final PontKalkulator pontKalkulator = new PontKalkulator();

    @Test
    void sikeresPontszamitasTeszt() {
        int pontok = pontKalkulator.szamol(10, 5, 2);
        assertEquals(35, pontok);
    }

    @Test
    void negativErtekKevelesTeszt() {
        int pontok = pontKalkulator.szamol(-1, 5, 2);
        assertEquals(0, pontok);
    }
}