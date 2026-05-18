package org.example.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CsapatStatisztikaKalkulatorTest {

    private final CsapatStatisztikaKalkulator kalkulator = new CsapatStatisztikaKalkulator();

    @Test
    void formaPontszamKiiertekelesTeszt() {
        assertEquals(10, kalkulator.kalkulalFormaPontszam("WWWDl"));

        assertEquals(0, kalkulator.kalkulalFormaPontszam(""));
        assertEquals(0, kalkulator.kalkulalFormaPontszam(null));
        assertEquals(3, kalkulator.kalkulalFormaPontszam("WXYZ"));
    }

    @Test
    void bajnokiZonaMeghatarozoTeszt() {
        assertEquals("Érvénytelen pontszám", kalkulator.hatarozMegBajnokiZona(-5, 0));
        assertEquals("Bajnokesélyes", kalkulator.hatarozMegBajnokiZona(65, 25));
        assertEquals("Nemzetközi kupaszereplés", kalkulator.hatarozMegBajnokiZona(50, 12));
        assertEquals("Biztonságos középmezőny", kalkulator.hatarozMegBajnokiZona(35, 5));
        assertEquals("Biztonságos középmezőny", kalkulator.hatarozMegBajnokiZona(35, -5));
        assertEquals("Veszélyzóna", kalkulator.hatarozMegBajnokiZona(20, -12));
        assertEquals("Kiesőhely", kalkulator.hatarozMegBajnokiZona(8, -15));
    }

    @Test
    void golatlagSzamitasiTeszt() {
        assertEquals(2.5, kalkulator.golatlagSzamitas(10, 4));

        assertEquals(0.0, kalkulator.golatlagSzamitas(5, 0));
        assertEquals(0.0, kalkulator.golatlagSzamitas(-5, 4));
        assertEquals(0.0, kalkulator.golatlagSzamitas(0, -1));
    }
}