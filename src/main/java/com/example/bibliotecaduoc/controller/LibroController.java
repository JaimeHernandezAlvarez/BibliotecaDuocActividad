package com.example.bibliotecaduoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.services.LibroService;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("api/v1/libros")

public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> listarLibros(){
        return libroService.getLibros();
    }

    @PostMapping
    public Libro agregaLibro(@RequestBody Libro libro){
        return libroService.saveLibro(libro);
    }

    @GetMapping("{id}")
    public Libro buscarLibro(@PathVariable int id) {
        return libroService.getLibroId(id);
    }

    @PutMapping("{id}")
    public Libro actualizaLibro(@PathVariable int id, @RequestBody Libro libro) {
        //El id se usará mas adelante
        return libroService.updateLibro(libro);
    }
    
    @DeleteMapping("{id}")
    public String eliminarLibro(@PathVariable int id){
        return libroService.deleteLibro(id);
    }

    @GetMapping("/total")
    public int totalLibros() {
        return libroService.totalLibros();
    }

}
