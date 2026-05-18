package org.example.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BuntetesKalkulatorTest {

    private final BuntetesKalkulator kalkulator = new BuntetesKalkulator();

    @Test
    void sargaKartyaBuntetesTeszt() {
        int buntetes = kalkulator.szamol("sárga");
        assertEquals(5000, buntetes);
    }

    @Test
    void pirosKartyaBuntetesTeszt() {
        int buntetes = kalkulator.szamol("piros");
        assertEquals(20000, buntetes);
    }

    @Test
    void ismetetlenVagyNullKartyaTeszt() {
        assertEquals(0, kalkulator.szamol("zöld"));
        assertEquals(0, kalkulator.szamol(null));
    }
}