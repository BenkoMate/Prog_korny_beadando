package org.example.service;

import org.example.model.Jatekos;
import org.example.repository.JatekosRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JatekosSzervizTest {

    @Mock
    private JatekosRepository jatekosRepository;

    @InjectMocks
    private JatekosSzerviz jatekosSzerviz;

    @Test
    void mentésMűködikTeszt() {
        Jatekos j = new Jatekos();
        j.setNev("Teszt Elek");
        j.setMezszam(10);

        when(jatekosRepository.save(any())).thenReturn(j);

        Jatekos eredmeny = jatekosSzerviz.ujJatekosMentese(j);

        assertNotNull(eredmeny);
        assertEquals("Teszt Elek", eredmeny.getNev());
    }

    @Test
    void mentésHibaTeszt() {
        Jatekos j = new Jatekos();
        j.setMezszam(150);

        assertThrows(IllegalArgumentException.class, () -> {
            jatekosSzerviz.ujJatekosMentese(j);
        });
    }

    @Test
    void keresésMűködikTeszt() {
        Jatekos j = new Jatekos();
        j.setNev("Dibusz Dénes");

        when(jatekosRepository.findById(1L)).thenReturn(Optional.of(j));

        Jatekos talalat = jatekosSzerviz.keresesIdAlapjan(1L);

        assertNotNull(talalat);
        assertEquals("Dibusz Dénes", talalat.getNev());
    }
    @Test
    public void testMindenJatekosLekerese() {
        var eredmény = jatekosSzerviz.osszesJatekosLekerese();
        assertNotNull(eredmény);
    }

    @Test
    public void testJatekosMentese() {
        org.example.model.Jatekos ujJatekos = new org.example.model.Jatekos();
        jatekosSzerviz.ujJatekosMentese(ujJatekos);
    }

    @Test
    public void testJatekosTorlese() {
        assertDoesNotThrow(() -> jatekosSzerviz.jatekosEltavolitasa(999L));
    }
}

