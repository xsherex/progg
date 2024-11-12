package com.apuliadigitalmaker.biblioteca_progetto.controller;

import com.apuliadigitalmaker.biblioteca_progetto.model.Libro;
import com.apuliadigitalmaker.biblioteca_progetto.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libri")
public class LibroController {

    private final LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    // Ottieni tutti i libri
    @GetMapping
    public List<Libro> getAllLibri() {
        return libroService.trovaTuttiILibri();
    }

    // Ottieni i libri per titolo
    @GetMapping("/titolo/{titolo}")
    public List<Libro> getLibriByTitolo(@PathVariable String titolo) {
        return libroService.trovaLibroPerTitolo(titolo);
    }

    // Ottieni i libri per anno di pubblicazione
    @GetMapping("/anno/{annoPubblicazione}")
    public List<Libro> getLibriByAnnoPubblicazione(@PathVariable int annoPubblicazione) {
        return libroService.trovaLibroperAnnoPubblicazione(annoPubblicazione);
    }

    // Ottieni i libri per genere
    @GetMapping("/genere/{genere}")
    public List<Libro> getLibriByGenere(@PathVariable String genere) {
        return libroService.trovaLibroPerGenere(genere);
    }

    // Ottieni tutti i libri disponibili
    @GetMapping("/disponibili")
    public List<Libro> getLibriDisponibili() {
        return libroService.trovaDisponibili(true);
    }

    // Aggiungi un nuovo libro
    @PostMapping
    public ResponseEntity<Libro> aggiungiLibro(@RequestBody Libro libro) {
        Libro nuovoLibro = libroService.aggiungiLibro(libro);
        return ResponseEntity.ok(nuovoLibro);
    }

    // Aggiorna un libro esistente
    @PutMapping
    public ResponseEntity<Libro> aggiornaLibro(@RequestBody Libro libro) {
        Libro libroAggiornato = libroService.aggiornaLibro(libro);
        return ResponseEntity.ok(libroAggiornato);
    }

    // Elimina un libro per ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminaLibro(@PathVariable Long id) {
        libroService.eliminaLibro(id);
        return ResponseEntity.noContent().build();
    }
}
