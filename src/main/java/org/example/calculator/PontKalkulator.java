package org.example.calculator;

import org.springframework.stereotype.Component;

@Component
public class PontKalkulator {

    public int szamol(int gyozelem, int dontetlen, int vereseg) {
        if (gyozelem < 0 & dontetlen < 0 & vereseg < 0) {
            return 0;
        }
        return (gyozelem * 3) + (dontetlen * 1);
    }
}