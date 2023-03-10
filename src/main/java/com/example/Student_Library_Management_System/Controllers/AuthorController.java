package com.example.Student_Library_Management_System.Controllers;

import com.example.Student_Library_Management_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management_System.DTOs.AuthorResponseDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    // ' / ' is optional

    @Autowired
    AuthorService authorService;

    @PostMapping("/addAuthor")
    public String addAuthor(@RequestBody AuthorEntryDto authorEntryDto){

        return authorService.createAuthor(authorEntryDto);
    }

    //Infinite recursion--> Bidirectional mapping, Author--> Book --> Author
    // Solution --> Use custom responseDto
    @GetMapping("/getAuthor")
    public AuthorResponseDto getAuthor(@RequestParam("authorId") Integer authorId){
        return authorService.getAuthor(authorId);
    }



}
