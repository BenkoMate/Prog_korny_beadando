package org.example.calculator;

import org.springframework.stereotype.Component;

@Component
public class CsapatStatisztikaKalkulator {

    public int kalkulalFormaPontszam(String formaSzoveg) {
        if (formaSzoveg == null || formaSzoveg.isEmpty()) {
            return 0;
        }

        int osszPontszam = 0;
        char[] meccsek = formaSzoveg.toUpperCase().toCharArray();

        for (char meccs : meccsek) {
            if (meccs == 'W') {
                osszPontszam += 3;
            } else if (meccs == 'D') {
                osszPontszam += 1;
            } else if (meccs == 'L') {
                osszPontszam += 0;
            }
        }
        return osszPontszam;
    }

    public String hatarozMegBajnokiZona(int pontszam, int golKulonbseg) {
        if (pontszam < 0) {
            return "Érvénytelen pontszám";
        }

        if (pontszam >= 60) {
            return "Bajnokesélyes";
        } else if (pontszam >= 45) {
            return "Nemzetközi kupaszereplés";
        } else if (pontszam >= 30) {
            if (golKulonbseg >= 0) {
                return "Biztonságos középmezőny";
            } else {
                return "Biztonságos középmezőny";
            }
        } else if (pontszam >= 15) {
            return "Veszélyzóna";
        } else {
            return "Kiesőhely";
        }
    }

    public double golatlagSzamitas(int lottGolok, int meccsekSzama) {
        if (meccsekSzama <= 0 || lottGolok < 0) {
            return 0.0;
        }

        return (double) lottGolok / meccsekSzama;
    }
}