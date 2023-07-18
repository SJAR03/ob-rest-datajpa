package com.example.obrestdatajpa;

import com.example.obrestdatajpa.model.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajpaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);
        BookRepository repository = context.getBean(BookRepository.class);

        // CRUD (Debería ir en un service pero para simplificar la práctica
        // lo hago acá)

        // crear un libro
        Book book1 = new Book(null, "IT", "Stephen King", 1280, 1120.00, LocalDate.of(1986, 9, 15), true);
        Book book2 = new Book(null, "Pet sematary", "Stephen King", 845,880.00, LocalDate.of(1983, 11, 14), true);

        // almacenar un libro
        System.out.println("Número de libros en base de datos: " + repository.findAll().size());

        repository.save(book1);
        repository.save(book2);

        // recuperar todos los libros
        /*repository.findAll();*/
        System.out.println("Número de libros en base de datos: " + repository.findAll().size());

        // borrar un libro
        repository.deleteById(1L);

        System.out.println("Número de libros en base de datos: " + repository.findAll().size());
    }

}
