package com.apuliadigitalmaker.biblioteca_progetto.repository;

import com.apuliadigitalmaker.biblioteca_progetto.model.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoreRepository extends JpaRepository<Autore, Long> {

    //cerca autori per nome
    List<Autore> findByNome(String nome);

    // Cerca autori per cognome
    List<Autore> findByCognome(String cognome);

    // Cerca autori per nome e cognome
    List<Autore> findByNomeAndCognome();

    // Cerca autori nati in un certo anno
    List<Autore> findByAnnoNascita(int annoNascita);

    Autore created();
    Autore deleted();
    Autore updated();
}


