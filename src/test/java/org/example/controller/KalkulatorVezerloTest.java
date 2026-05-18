package org.example.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KalkulatorVezerloTest {

    @Test
    public void testKalkulatorVezerloMindenVegpontra() {
        KalkulatorVezerlo vezerlo = new KalkulatorVezerlo();

        var pontResult = vezerlo.pontotSzamol(3, 1, 1);
        assertNotNull(pontResult);

        var buntetesResult = vezerlo.buntetestSzamol("sárga");
        assertNotNull(buntetesResult);

        var mezszamResult = vezerlo.mezszamEllenorzes(10);
        assertNotNull(mezszamResult);

        var atigazolasResult = vezerlo.atigazolasEllenorzes(20, 15.5, 4);
        assertNotNull(atigazolasResult);

        var zonaResult = vezerlo.zonaSzamitas(45, 12);
        assertNotNull(zonaResult);

        var atlagResult = vezerlo.atlagSzamitas(45, 30);
        assertNotNull(atlagResult);
    }
}