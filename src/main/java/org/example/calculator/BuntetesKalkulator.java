package org.example.calculator;

import org.springframework.stereotype.Component;

@Component
public class BuntetesKalkulator {

    public int szamol(String kartyaSzin) {
        if (kartyaSzin == null) {
            return 0;
        }

        switch (kartyaSzin.toLowerCase().trim()) {
            case "sarga":
                return 5000;
            case "piros":
                return 20000;
            default:
                return 0;
        }
    }
}