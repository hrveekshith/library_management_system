package com.app.library.member.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//model book

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member{

    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Long id;
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private  LocalDate memStartDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate memEndDate;
    private String phoneNum;
    private String email;

    public String toString(){
        return "Member Id: "+id
                +"{Name: "+this.name+", Email: "+this.email+", Phone Number: "+this.phoneNum+", Membership start date: "+this.memStartDate.format(dateFormat)+", Membership end date: "+this.memEndDate.format(dateFormat)+" }\n";
    }
}