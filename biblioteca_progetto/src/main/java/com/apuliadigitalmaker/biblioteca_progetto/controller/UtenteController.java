package com.apuliadigitalmaker.biblioteca_progetto.controller;

import com.apuliadigitalmaker.biblioteca_progetto.model.Utente;
import com.apuliadigitalmaker.biblioteca_progetto.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    private final UtenteService utenteService;

    @Autowired
    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    // Endpoint per trovare tutti gli utenti
    @GetMapping
    public ResponseEntity<List<Utente>> getAllUtenti() {
        List<Utente> utenti = utenteService.trovaTuttiGliUtenti();
        return new ResponseEntity<>(utenti, HttpStatus.OK);
    }

    // Endpoint per trovare un utente per ID
    @GetMapping("/{id}")
    public ResponseEntity<Utente> getUtenteById(@PathVariable Long id) {
        Optional<Utente> utente = utenteService.trovaUtentePerId(id);
        return utente.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint per trovare utenti per nome
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Utente>> getUtentiByNome(@PathVariable String nome) {
        List<Utente> utenti = utenteService.trovaUtentePerNome(nome);
        return new ResponseEntity<>(utenti, HttpStatus.OK);
    }

    // Endpoint per trovare utenti per email
    @GetMapping("/email/{email}")
    public ResponseEntity<List<Utente>> getUtentiByEmail(@PathVariable String email) {
        List<Utente> utenti = utenteService.trovaUtentePerEmail(email);
        return new ResponseEntity<>(utenti, HttpStatus.OK);
    }

    // Endpoint per trovare utenti per ruolo
    @GetMapping("/ruolo/{ruolo}")
    public ResponseEntity<List<Utente>> getUtentiByRuolo(@PathVariable String ruolo) {
        List<Utente> utenti = utenteService.trovaUtentePerRuolo(ruolo);
        return new ResponseEntity<>(utenti, HttpStatus.OK);
    }

    // Endpoint per trovare utenti attivi
    @GetMapping("/attivo")
    public ResponseEntity<List<Utente>> getUtentiAttivi() {
        List<Utente> utenti = utenteService.trovaUtenteAttivo(true);
        return new ResponseEntity<>(utenti, HttpStatus.OK);
    }

    // Endpoint per creare un nuovo utente
    @PostMapping
    public ResponseEntity<Utente> creaNuovoUtente(@RequestBody Utente utente) {
        Utente nuovoUtente = utenteService.creaUtente(utente);
        return new ResponseEntity<>(nuovoUtente, HttpStatus.CREATED);
    }

    // Endpoint per aggiornare un utente esistente
    @PutMapping("/{id}")
    public ResponseEntity<Utente> aggiornaUtente(@PathVariable Long id, @RequestBody Utente utente) {
        Optional<Utente> utenteEsistente = utenteService.trovaUtentePerId(id);
        if (utenteEsistente.isPresent()) {
            utente.setId(id);  // Assicurarsi che l'ID sia mantenuto
            Utente utenteAggiornato = utenteService.aggiornaUtente(utente);
            return new ResponseEntity<>(utenteAggiornato, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint per eliminare un utente per ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminaUtente(@PathVariable Long id) {
        Optional<Utente> utente = utenteService.trovaUtentePerId(id);
        if (utente.isPresent()) {
            utenteService.eliminaUtente(utente.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}