package org.example.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Csapat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nev;
    private String varos;
    private Integer alapitasiEv;

    @OneToMany(mappedBy = "csapat", cascade = CascadeType.ALL)
    private List<Jatekos> jatekosok;
}
