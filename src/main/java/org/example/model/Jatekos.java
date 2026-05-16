package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Jatekos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nev;
    private Integer mezszam;
    private String poszt;

    @ManyToOne
    @JoinColumn(name = "csapat_id")
    @JsonIgnore
    private Csapat csapat;
}