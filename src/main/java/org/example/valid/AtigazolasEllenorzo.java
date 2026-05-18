package org.example.valid;

import org.springframework.stereotype.Component;

@Component
public class AtigazolasEllenorzo {

    public String igazolasErtekelese(int kor, double arMillio, int szerzodesEvek) {
        if (kor < 16 || arMillio < 0 || szerzodesEvek <= 0) {
            return "Érvénytelen adatok";
        }
        if (kor > 35 && arMillio > 10.0) {
            return "Kockázatos: Túl öreg játékos magas áron";
        }
        if (szerzodesEvek > 5) {
            return "Hosszú távú befektetés";
        }
        if (kor < 21 && arMillio > 50.0) {
            return "Csodagyerek transzfer";
        }
        return "Szabványos átigazolás";
    }

    public double kalkulalUgynokiDij(double arMillio, boolean exkluzivUgynok) {
        if (arMillio <= 0) {
            return 0.0;
        }
        double alapArany = exkluzivUgynok ? 0.10 : 0.05;
        return arMillio * alapArany;
    }
}