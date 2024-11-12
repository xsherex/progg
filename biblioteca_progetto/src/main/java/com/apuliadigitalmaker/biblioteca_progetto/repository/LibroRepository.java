package com.apuliadigitalmaker.biblioteca_progetto.repository;

import com.apuliadigitalmaker.biblioteca_progetto.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    //trova tutti i libri
    List<Libro> findAll();

    // Cerca libri in base al titolo
    List<Libro> findByTitolo(String titolo);

    // Cerca libri in base all'anno di pubblicazione
    List<Libro> findByAnnoPubblicazione(int annoPubblicazione);

    // Cerca libri con un determinato genere
    List<Libro> findByGenere(String genere);

    //Cerca libri disponibili
    List<Libro> findDisponibile();

    // Crea nuvo libro
    List<Libro> createdLibroByTitolo();

    // Aggiorna libro
    Libro updatedLibroByTitolo();

    // rimuovi libro
    Libro deletedLibroByTitolo();
}


