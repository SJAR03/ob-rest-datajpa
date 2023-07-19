package com.example.obrestdatajpa.controller;
import com.example.obrestdatajpa.model.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    // atributos
    private BookRepository bookRepository;

    // constructores

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    // CRUD sobre la entidad Book

    // Buscar todos los libros (lista de libros)

    /**
     * http://localhost:8081/api/books
     * @return
     */
    @GetMapping("/api/books")
    public List<Book> findAll(){
        // recuperar y devolver los libros de base de datos
        return bookRepository.findAll();
    }

    // Buscar un solo libro en base de datos segun su id
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id){
        Optional<Book> bookOptional = bookRepository.findById(id);

        // Opción 1
        if (bookOptional.isPresent())
            return ResponseEntity.ok(bookOptional.get());
        else
            return ResponseEntity.notFound().build();

        // Opción 2
        /*return bookOptional.orElse(null);*/

        // Opción 3
        /*return bookOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());*/
    }

    // Crear un nuevo libro en base de datos
    @PostMapping("/api/books")
    public Book create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        // guardar libro recibido por parámetro en la base de datos
        return bookRepository.save(book);
    }

    // Actualizar un libro existente en base de datos

    // Borrar un libro en base de datos


}
