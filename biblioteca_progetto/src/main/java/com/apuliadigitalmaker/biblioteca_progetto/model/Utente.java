package com.apuliadigitalmaker.biblioteca_progetto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "utenti", schema = "biblioteca_progetto")
@Data
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column
    private boolean isActive;

    @Column(name = "ruolo", nullable = false)
    private String ruolo;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "prestiti",
            joinColumns = @JoinColumn(name = "utente_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id")
    )
    private List<Libro> libriPresiInPrestito;

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

