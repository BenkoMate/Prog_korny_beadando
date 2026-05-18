package org.example.controller;

import org.example.calculator.BuntetesKalkulator;
import org.example.calculator.PontKalkulator;
import org.example.calculator.CsapatStatisztikaKalkulator;
import org.example.valid.ValidMezszam;
import org.example.valid.AtigazolasEllenorzo;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/kalkulator")
public class KalkulatorVezerlo {

    private final PontKalkulator pontKalkulator = new PontKalkulator();
    private final BuntetesKalkulator buntetesKalkulator = new BuntetesKalkulator();
    private final ValidMezszam validMezszam = new ValidMezszam();
    private final AtigazolasEllenorzo atigazolasEllenorzo = new AtigazolasEllenorzo();
    private final CsapatStatisztikaKalkulator csapatStatisztikaKalkulator = new CsapatStatisztikaKalkulator();

    @GetMapping("/pontok")
    public Map<String, Object> pontotSzamol(@RequestParam int gyozelem, @RequestParam int dontetlen, @RequestParam int vereseg) {
        int vegeredmeny = pontKalkulator.szamol(gyozelem, dontetlen, vereseg);
        Map<String, Object> valasz = new LinkedHashMap<>();
        valasz.put("szolgaltatas", "Foci Pont Kalkulátor API");
        valasz.put("gyozelem", gyozelem);
        valasz.put("dontetlen", dontetlen);
        valasz.put("vereseg", vereseg);
        valasz.put("osszesitettPontszam", vegeredmeny);
        return valasz;
    }

    @GetMapping("/buntetes")
    public Map<String, Object> buntetestSzamol(@RequestParam String szin) {
        int buntetesOsszeg = buntetesKalkulator.szamol(szin);
        Map<String, Object> valasz = new LinkedHashMap<>();
        valasz.put("szolgaltatas", "Foci Büntetés API");
        valasz.put("kartyaSzine", szin);
        valasz.put("buntetesOsszegFt", buntetesOsszeg);
        return valasz;
    }

    @GetMapping("/valid/mezszam")
    public Map<String, Object> mezszamEllenorzes(@RequestParam int szam) {
        boolean ervenyes = validMezszam.isErvenyesMezszam(szam);
        Map<String, Object> valasz = new LinkedHashMap<>();
        valasz.put("vizsgalat", "Mezszám ellenőrzés");
        valasz.put("bevittSzam", szam);
        valasz.put("eredmeny", ervenyes ? "ELFOGADVA" : "ELUTASÍTVA");
        valasz.put("leiras", ervenyes ? "Ez egy szabályos mezszám." : "Hiba: A mezszám érvénytelen!");
        return valasz;
    }

    @GetMapping("/valid/atigazolas")
    public Map<String, Object> atigazolasEllenorzes(@RequestParam int kor, @RequestParam double arMillio, @RequestParam int szerzodesEvek) {
        String ertekeles = atigazolasEllenorzo.igazolasErtekelese(kor, arMillio, szerzodesEvek);
        Map<String, Object> valasz = new LinkedHashMap<>();
        valasz.put("vizsgalat", "Átigazolás minősítése");
        valasz.put("kor", kor);
        valasz.put("arMillio", arMillio);
        valasz.put("szerzodesEvek", szerzodesEvek);
        valasz.put("kapottErtekeles", ertekeles);

        if (ertekeles.equals("Érvénytelen adatok") || ertekeles.startsWith("Kockázatos")) {
            valasz.put("statusz", "BLOKKOLVA");
        } else {
            valasz.put("statusz", "ENGEDÉLYEZVE");
        }
        return valasz;
    }

    @GetMapping("/zona")
    public Map<String, Object> zonaSzamitas(@RequestParam int pontszam, @RequestParam int golKulonbseg) {
        String zona = csapatStatisztikaKalkulator.hatarozMegBajnokiZona(pontszam, golKulonbseg);
        Map<String, Object> valasz = new LinkedHashMap<>();
        valasz.put("vizsgalat", "Bajnoki Zóna Kiértékelése");
        valasz.put("pontszam", pontszam);
        valasz.put("golKulonbseg", golKulonbseg);
        valasz.put("besorolas", zona);
        return valasz;
    }

    @GetMapping("/golatlag")
    public Map<String, Object> atlagSzamitas(@RequestParam int lottGolok, @RequestParam int meccsekSzama) {
        double atlag = csapatStatisztikaKalkulator.golatlagSzamitas(lottGolok, meccsekSzama);
        Map<String, Object> valasz = new LinkedHashMap<>();
        valasz.put("vizsgalat", "Gólátlag Számítása");
        valasz.put("lottGolok", lottGolok);
        valasz.put("meccsekSzama", meccsekSzama);
        valasz.put("golatlag", atlag);
        return valasz;
    }
}