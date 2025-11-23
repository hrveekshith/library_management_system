package com.app.library.member.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.library.member.model.Member;
import com.app.library.member.service.MemberService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
@Getter
@Setter
@AllArgsConstructor
public class MemberController{

    @Autowired
    private final MemberService service;

    @GetMapping("/")
    public ResponseEntity<List<Member>> getAllmembers(){
        return new ResponseEntity<>(service.getAllmembers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getmemberById(@PathVariable Long id){
        Optional<Member> member = service.getmemberById(id);
        return member.map(temp-> new ResponseEntity<>(temp,HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<String> addmember(@RequestBody  Member member){
        service.addmember(member);
        return ResponseEntity.ok("New member added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatemember(@PathVariable Long id,@RequestBody Member updated){
        service.updatemember(updated,id);
        return ResponseEntity.ok("member updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletemember(@PathVariable Long id){
        service.deletememberById(id);
        return ResponseEntity.ok("member deleted successfully");
    }
}