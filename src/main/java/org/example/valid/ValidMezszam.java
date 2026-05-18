package org.example.valid;

import org.springframework.stereotype.Component;

@Component
public class ValidMezszam {

    public boolean isErvenyesMezszam(Integer mezszam) {
        if (mezszam == null) {
            return false;
        }
        return mezszam >= 1 && mezszam <= 99;
    }
}