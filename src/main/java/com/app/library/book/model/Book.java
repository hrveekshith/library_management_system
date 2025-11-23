package com.app.library.book.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
//model book

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book{

    private Long id;
    private String title;
    private  String author;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate publicationYear;
    private  Long avaliableCopy;
    private String genre;

    public String toString(){
        return "Book Id: "+id
                +"{Name: "+this.title+", Author: "+this.author+", Publication Year: "+this.publicationYear+", Genre: "+this.genre+", Avaliable Copies: "+this.avaliableCopy+" }\n";
    }
}