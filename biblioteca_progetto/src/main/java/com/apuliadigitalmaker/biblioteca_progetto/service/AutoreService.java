package com.apuliadigitalmaker.biblioteca_progetto.service;

import com.apuliadigitalmaker.biblioteca_progetto.model.Autore;
import com.apuliadigitalmaker.biblioteca_progetto.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {

    private final AutoreRepository autoreRepository;

    @Autowired
    public AutoreService(AutoreRepository autoreRepository) {
        this.autoreRepository = autoreRepository;
    }

    // Metodo per trovare tutti gli autori
    public List<Autore> trovaTuttiGliAutori() {
        return autoreRepository.findAll();
    }

    // Metodo per trovare un autore per ID
    public List<Autore> trovaAutorePerNomeECognome(String nome,String cognome) {
        return autoreRepository.findByNomeAndCognome();
    }

    // Metodo per trovare un autore per ID
    public Optional<Autore> trovaAutorePerId(Long id) {
        return autoreRepository.findById(id);
    }

    // Metodo per trovare un autore per Nome
    public List<Autore> trovaAutorePerNome(String nome) {
        return autoreRepository.findByNome(nome);
    }

    // Metodo per trovare un autore per Cognome
    public List<Autore> trovaAutorePerCognome(String cognome) {
        return autoreRepository.findByCognome(cognome);
    }

    // Metodo per trovare un autore per AnnoNascita
    public List<Autore> trovaAutorePerAnnoNascita(int annoNascita) {
        return autoreRepository.findByAnnoNascita(annoNascita);
    }

    // Metodo per creare un nuovo autore
    public Autore creaAutore(Autore autore) {
        return autoreRepository.created();
    }

    // Metodo per aggiornare un autore esistente
    public Autore aggiornaAutore(Autore autore) {
        return autoreRepository.updated();
    }

    // Metodo per eliminare un autore per ID
    public void eliminaAutore(Autore autore) {
        autoreRepository.deleted();
    }
}
