package com.apuliadigitalmaker.biblioteca_progetto.service;

import com.apuliadigitalmaker.biblioteca_progetto.model.Utente;
import com.apuliadigitalmaker.biblioteca_progetto.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    private final UtenteRepository utenteRepository;

    @Autowired
    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    // Metodo per trovare tutti gli utenti
    public List<Utente> trovaTuttiGliUtenti() {
        return utenteRepository.findAll();
    }

    //trovare un utente per ID
    public Optional<Utente> trovaUtentePerId(Long id) {
        return utenteRepository.findById(id);
    }

    //cerca utente per nome
    public List<Utente> trovaUtentePerNome(String nome) {
        return utenteRepository.findByNome(nome);
    }

    //trova utente per email
    public List<Utente> trovaUtentePerEmail(String email) {
        return utenteRepository.findByEmail(email);
    }

    //trova utente per ruolo
    public List<Utente> trovaUtentePerRuolo(String ruolo) {
        return utenteRepository.findByRuolo(ruolo);
    }

    public List<Utente> trovaUtenteAttivo(boolean disponibile) {
        return utenteRepository.isActive(String.valueOf(disponibile=true));
    }

    //creare un nuovo utente
    public Utente creaUtente(Utente utente) {
        return utenteRepository.created(utente);
    }

    //aggiornare un utente esistente
    public Utente aggiornaUtente(Utente utente) {
        return utenteRepository.updated(utente);
    }

    //eliminare un utente per ID
    public void eliminaUtente(Utente utente) {
        utenteRepository.deleted(utente);
    }
}
