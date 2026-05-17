package org.example.controller;

import jdk.jfr.Frequency;
import org.example.calculator.BuntetesKalkulator;
import org.example.calculator.PontKalkulator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kalkulator")
public class KalkulatorVezerlo {

    private final PontKalkulator pontKalkulator = new PontKalkulator();
    private final BuntetesKalkulator buntetesKalkulator = new BuntetesKalkulator();

    @GetMapping("/pontok")
    public String pontotSzamol(@RequestParam int gyozelem, @RequestParam int dontetlen,@RequestParam int vereseg) {
        int vegeredmeny = pontKalkulator.szamol(gyozelem, dontetlen,vereseg);
        return "Számítás eredménye -> Győzelmek: " + gyozelem + ", Döntetlenek: " + dontetlen + " | Összesített pontszám: " + vegeredmeny;
    }
    @GetMapping("/buntetes")
    public String buntetestSzamol(@RequestParam String szin) {
        int buntetesOsszeg = buntetesKalkulator.szamol(szin);
        return "Számítás eredménye -> Kártya színe: " + szin +" Kiszabott pénzbüntetés: " + buntetesOsszeg + " Ft";
    }
}