package com.example.Student_Library_Management_System.Service;

import com.example.Student_Library_Management_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management_System.DTOs.AuthorResponseDto;
import com.example.Student_Library_Management_System.DTOs.BookResponseDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public String createAuthor(AuthorEntryDto authorEntryDto){

        //Important step
        //In the params the object is of type DTO, but the repository interacts only with the help of entity

        //Solution : convert authorEntryDto ---> Author

        //Created an object of type author
        Author author = new Author();
        //We are setting its attribute so that we can save correct values in DB

        author.setName(authorEntryDto.getName());
        author.setAge(authorEntryDto.getAge());
        author.setCountry(authorEntryDto.getCountry());
        author.setRating(authorEntryDto.getRating());

        authorRepository.save(author);
        return "Author added successfully";
    }

    public AuthorResponseDto getAuthor(Integer authorId){
        Author author = authorRepository.findById(authorId).get();
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        //Set its attributes

        //List of book ---> List<BookResponseDto>

        List<Book> bookList = author.getBooksWritten();

        List<BookResponseDto> booksWrittenDto = new ArrayList<>();
        for(Book b : bookList){
            BookResponseDto bookResponseDto = new BookResponseDto();
            bookResponseDto.setName(b.getName());
            bookResponseDto.setPages(b.getPages());
            bookResponseDto.setGenre(b.getGenre());

            booksWrittenDto.add(bookResponseDto);
        }

        //Set attributes in authorResponseDto

        authorResponseDto.setBooksWritten(booksWrittenDto);
        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setCountry(author.getCountry());
        authorResponseDto.setRating(author.getRating());


        return authorResponseDto;
    }

}
