package com.apuliadigitalmaker.biblioteca_progetto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.List;
import java.time.LocalDate;


@Entity
@Table(name = "autori")
@Data
public class Autore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(nullable = false)
    private int annoNascita;

    @OneToMany(mappedBy = "autore", cascade = CascadeType.ALL)
    private List<Libro> libri;

    @JsonIgnore
    @ColumnDefault("current_timestamp()")
    @Column(name = "created", updatable = false)
    private Instant created;

    @JsonIgnore
    @ColumnDefault("current_timestamp()")
    @Column(name = "updated")
    private Instant updated;

    @JsonIgnore
    @Column(name = "deleted")
    private Instant deleted;

}

