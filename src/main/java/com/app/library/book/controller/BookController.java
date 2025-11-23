package com.app.library.book.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.library.book.model.Book;
import com.app.library.book.service.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@Getter
@Setter
@AllArgsConstructor
public class BookController{

    @Autowired
    private final BookService service;

    @GetMapping("/")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(service.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        Optional<Book> book = service.getBookById(id);
        return book.map(temp-> new ResponseEntity<>(temp,HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<String> addBook(@RequestBody  Book book){
        service.addBook(book);
        return ResponseEntity.ok("New book added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id,@RequestBody Book updated){
        service.updateBook(updated,id);
        return ResponseEntity.ok("Book updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        service.deleteBookById(id);
        return ResponseEntity.ok("Book deleted successfully");
    }
}