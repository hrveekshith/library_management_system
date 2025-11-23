//Book service
package com.app.library.book.service;

import com.app.library.book.model.Book;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Service
public class BookService{

    private List<Book> books;

    public List<Book> getAllBooks(){
        return books;
    }

    public Optional<Book> getBookById(Long id){
        Optional<Book> Foundbook = books.stream().filter(book -> book.getId().equals(id)).findFirst();
        return Foundbook;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void updateBook(Book updated, Long id){
        int n = books.size();
        for(int i=0;i<n;i++){
            Book book = books.get(i);
            if(book.getId().equals(id)){
                books.set(i, updated);
            }
        }
    }

    public void deleteBookById(Long id){
        books.removeIf(book -> book.getId().equals(id));
    }
}