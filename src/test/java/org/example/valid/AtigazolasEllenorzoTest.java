package org.example.valid;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AtigazolasEllenorzoTest {

    private final AtigazolasEllenorzo ellenorzo = new AtigazolasEllenorzo();

    @Test
    void igazolasErtekeleseTeszt() {
        assertEquals("Érvénytelen adatok", ellenorzo.igazolasErtekelese(15, 5.0, 3));
        assertEquals("Kockázatos: Túl öreg játékos magas áron", ellenorzo.igazolasErtekelese(36, 12.0, 2));
        assertEquals("Hosszú távú befektetés", ellenorzo.igazolasErtekelese(25, 5.0, 6));
        assertEquals("Csodagyerek transzfer", ellenorzo.igazolasErtekelese(20, 55.0, 4));
        assertEquals("Szabványos átigazolás", ellenorzo.igazolasErtekelese(25, 5.0, 3));
    }

    @Test
    void ugynokiDijTeszt() {
        assertEquals(0.0, ellenorzo.kalkulalUgynokiDij(-1, false));
        assertEquals(1.0, ellenorzo.kalkulalUgynokiDij(10.0, true));
        assertEquals(0.5, ellenorzo.kalkulalUgynokiDij(10.0, false));
    }
}