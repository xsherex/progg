package com.apuliadigitalmaker.biblioteca_progetto.repository;

import com.apuliadigitalmaker.biblioteca_progetto.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    List<Utente> findAll();

    Optional<Utente> findById(Long id);

    // Cerca utenti per nome
    List<Utente> findByNome(String nome);

    // Cerca utenti per ruolo (es. admin, utente, etc.)
    List<Utente> findByRuolo(String ruolo);

    // Cerca utenti attivi
    List<Utente> isActive(String s);

    // Trova un utente per email
    List<Utente> findByEmail(String email);

    Utente created(Utente utente);
    Utente updated(Utente utente);
    Utente deleted(Utente utente);
}


