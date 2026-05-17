
package org.example.service;

import org.example.model.Jatekos;
import org.example.repository.JatekosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JatekosSzerviz {

    private final JatekosRepository jatekosRepository;

    public Jatekos ujJatekosMentese(Jatekos jatekos) {
        if (jatekos.getMezszam() != null && jatekos.getMezszam() > 99) {
            throw new IllegalArgumentException("Túl nagy mezszám!");
        }
        return jatekosRepository.save(jatekos);
    }

    public Jatekos keresesIdAlapjan(Long id) {
        return jatekosRepository.findById(id).orElse(null);
    }

    public List<Jatekos> osszesJatekosLekerese() {
        return jatekosRepository.findAll();
    }

    public void jatekosEltavolitasa(Long id) {
        jatekosRepository.deleteById(id);
    }
    public Jatekos jatekosModositasa(Long id, Jatekos frissitettAdatok) {
        Jatekos regiJatekos = jatekosRepository.findById(id).orElse(null);

        if (regiJatekos != null) {
            regiJatekos.setNev(frissitettAdatok.getNev());
            regiJatekos.setMezszam(frissitettAdatok.getMezszam());
            regiJatekos.setPoszt(frissitettAdatok.getPoszt());

            return jatekosRepository.save(regiJatekos);
        }
        return null;
    }
}
