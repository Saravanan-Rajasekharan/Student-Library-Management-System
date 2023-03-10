package com.example.Student_Library_Management_System.Controllers;

import com.example.Student_Library_Management_System.DTOs.BookRequestDto;
import com.example.Student_Library_Management_System.DTOs.BookResponseDto;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public String addBook(@RequestBody BookRequestDto bookRequestDto){

        return bookService.addBook(bookRequestDto);
    }


    @GetMapping("/getBook")
    public BookResponseDto getBook(@RequestParam("id") Integer id ){
        return  bookService.getBook(id);
    }

}
