//Per gestire le richieste HTTP per le operazioni CRUD (creazione, lettura, aggiornamento e cancellazione)


package com.apuliadigitalmaker.biblioteca_progetto.controller;

import com.apuliadigitalmaker.biblioteca_progetto.model.Autore;
import com.apuliadigitalmaker.biblioteca_progetto.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/autori")
public class AutoreController {

    private final AutoreService autoreService;

    @Autowired
    public AutoreController(AutoreService autoreService) {
        this.autoreService = autoreService;
    }

    // Endpoint per ottenere tutti gli autori
    @GetMapping
    public ResponseEntity<List<Autore>> trovaTuttiGliAutori() {
        List<Autore> autori = autoreService.trovaTuttiGliAutori();
        return ResponseEntity.ok(autori);
    }

    // Endpoint per trovare un autore per nome e cognome
    @GetMapping("/cerca")
    public ResponseEntity<List<Autore>> trovaAutorePerNomeECognome(
            @RequestParam String nome,
            @RequestParam String cognome) {
        List<Autore> autori = autoreService.trovaAutorePerNomeECognome(nome, cognome);
        return ResponseEntity.ok(autori);
    }

    // Endpoint per trovare un autore per ID
    @GetMapping("/{id}")
    public ResponseEntity<Autore> trovaAutorePerId(@PathVariable Long id) {
        Optional<Autore> autore = autoreService.trovaAutorePerId(id);
        return autore.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint per trovare un autore per nome
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Autore>> trovaAutorePerNome(@PathVariable String nome) {
        List<Autore> autori = autoreService.trovaAutorePerNome(nome);
        return ResponseEntity.ok(autori);
    }

    // Endpoint per trovare un autore per cognome
    @GetMapping("/cognome/{cognome}")
    public ResponseEntity<List<Autore>> trovaAutorePerCognome(@PathVariable String cognome) {
        List<Autore> autori = autoreService.trovaAutorePerCognome(cognome);
        return ResponseEntity.ok(autori);
    }

    // Endpoint per trovare un autore per anno di nascita
    @GetMapping("/annoNascita/{annoNascita}")
    public ResponseEntity<List<Autore>> trovaAutorePerAnnoNascita(@PathVariable int annoNascita) {
        List<Autore> autori = autoreService.trovaAutorePerAnnoNascita(annoNascita);
        return ResponseEntity.ok(autori);
    }

    // Endpoint per creare un nuovo autore
    @PostMapping
    public ResponseEntity<Autore> creaAutore(@RequestBody Autore autore) {
        Autore nuovoAutore = autoreService.creaAutore(autore);
        return ResponseEntity.ok(nuovoAutore);
    }

    // Endpoint per aggiornare un autore esistente
    @PutMapping("/{id}")
    public ResponseEntity<Autore> aggiornaAutore(@PathVariable Long id, @RequestBody Autore autore) {
        autore.setId(id); // Imposta l'ID dell'autore per l'aggiornamento
        Autore autoreAggiornato = autoreService.aggiornaAutore(autore);
        return ResponseEntity.ok(autoreAggiornato);
    }

    // Endpoint per eliminare un autore per ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminaAutore(@PathVariable Long id) {
        Optional<Autore> autore = autoreService.trovaAutorePerId(id);
        if (autore.isPresent()) {
            autoreService.eliminaAutore(autore.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
