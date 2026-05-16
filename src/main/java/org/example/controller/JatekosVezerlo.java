package org.example.controller;

import org.example.model.Jatekos;
import org.example.service.JatekosSzerviz;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/focistak")
@RequiredArgsConstructor
public class JatekosVezerlo {

    private final JatekosSzerviz jatekosSzerviz;

    @PostMapping("mentes")
    public ResponseEntity<Jatekos> mentes(@RequestBody Jatekos jatekos) {
        return ResponseEntity.ok(jatekosSzerviz.ujJatekosMentese(jatekos));
    }

    @GetMapping("lista")
    public List<Jatekos> lista() {
        return jatekosSzerviz.osszesJatekosLekerese();
    }

    @DeleteMapping("torles/{id}")
    public ResponseEntity<Void> torles(@PathVariable Long id) {
        jatekosSzerviz.jatekosEltavolitasa(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("modositas/{id}")
    public ResponseEntity<Jatekos> modositas(@PathVariable Long id, @RequestBody Jatekos jatekos) {
        return ResponseEntity.ok(jatekosSzerviz.jatekosModositasa(id, jatekos));
    }
}
