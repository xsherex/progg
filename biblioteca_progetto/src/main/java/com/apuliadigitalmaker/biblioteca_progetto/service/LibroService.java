package com.apuliadigitalmaker.biblioteca_progetto.service;

import com.apuliadigitalmaker.biblioteca_progetto.model.Libro;
import com.apuliadigitalmaker.biblioteca_progetto.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    private final LibroRepository libroRepository;
    private int annoPubblicazioneo;

    @Autowired
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    // Metodo per trovare tutti i libri
    public List<Libro> trovaTuttiILibri() {
        return libroRepository.findAll();
    }

    // Metodo per trovare un libro per ID
    public List<Libro> trovaLibroPerTitolo(String titolo) {
        return libroRepository.findByTitolo(titolo);
    }

    // Metodo per trovare un libro per ID
    public List<Libro> trovaLibroperAnnoPubblicazione(int annoPubblicazione) {
        return libroRepository.findByAnnoPubblicazione(annoPubblicazioneo);
    }

    // Metodo per trovare libri per genere
    public List<Libro> trovaLibroPerGenere(String genere) {
        return libroRepository.findByGenere(genere);
    }

    //metodo per trovare tutti  i libri disponibili
    public List<Libro> trovaDisponibili(boolean disponibili) {
        return libroRepository.findDisponibile();
    }

    // Metodo per creare un nuovo libro
    public Libro aggiungiLibro(Libro libro) {
        return (Libro) libroRepository.createdLibroByTitolo();
    }

    // Metodo per aggiornare un libro esistente
    public Libro aggiornaLibro(Libro libro) {
        return libroRepository.updatedLibroByTitolo();
    }

    // Metodo per eliminare un libro per titolo
    public Libro eliminaLibro(Long libro) {
       return libroRepository.deletedLibroByTitolo();
    }
}
