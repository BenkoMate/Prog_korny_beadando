package org.example;

import org.example.model.Jatekos;
import org.example.model.Csapat;
import org.example.repository.JatekosRepository;
import org.example.repository.CsapatRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MintaAdatBetolto implements CommandLineRunner {

    private final JatekosRepository jatekosRepository;
    private final CsapatRepository csapatRepository;

    public MintaAdatBetolto(JatekosRepository jatekosRepository, CsapatRepository csapatRepository) {
        this.jatekosRepository = jatekosRepository;
        this.csapatRepository = csapatRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        jatekosRepository.deleteAll();
        csapatRepository.deleteAll();

        Csapat csapat1 = new Csapat();
        csapat1.setNev("Ferencváros");
        csapat1.setAlapitasiEv(1899);
        csapat1.setVaros("Budapest");
        csapatRepository.save(csapat1);

        Csapat csapat2 = new Csapat();
        csapat2.setNev("Liverpool");
        csapat2.setAlapitasiEv(1892);
        csapat2.setVaros("Anglia");
        csapatRepository.save(csapat2);


        Jatekos jatekos1 = new Jatekos();
        jatekos1.setNev("Szoboszlai Dominik");
        jatekos1.setMezszam(10);
        jatekos1.setPoszt("Középpályás");
        jatekosRepository.save(jatekos1);

        Jatekos jatekos2 = new Jatekos();
        jatekos2.setNev("Dibusz Dénes");
        jatekos2.setMezszam(90);
        jatekos2.setPoszt("Kapus");
        jatekosRepository.save(jatekos2);

        Jatekos jatekos3 = new Jatekos();
        jatekos3.setNev("Varga Barnabás");
        jatekos3.setMezszam(19);
        jatekos3.setPoszt("Csatár");
        jatekosRepository.save(jatekos3);
    }
}