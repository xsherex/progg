package com.apuliadigitalmaker.biblioteca_progetto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "libri")
@Data
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name ="titolo", nullable = false)
    private String titolo;

    @ManyToOne
    @JoinColumn(name = "autore_id", nullable = false)
    private Autore autore;

    @Column(name = "genere", nullable = false)
    private String genere;

    @Column(name = "annoPubblicazione", nullable = false)
    private int annoPubblicazione;

    @Column(name = "disponibile")
    private boolean disponibile;

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
