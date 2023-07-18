package com.example.obrestdatajpa.controller;
import com.example.obrestdatajpa.model.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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
    }

    // Crear un nuevo libro en base de datos

    // Actualizar un libro existente en base de datos

    // Borrar un libro en base de datos


}
