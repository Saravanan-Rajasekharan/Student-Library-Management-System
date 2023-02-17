package com.example.Student_Library_Management_System.Service;

import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Repository.AuthorRepository;
import com.example.Student_Library_Management_System.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;


    public String addBook(Book book){
        // Get the author entity
        // Get authorId
        int authorId = book.getAuthor().getId();
        //Fetch the author entity

        Author author = authorRepository.findById(authorId).get(); // Author entity

        //exception handling from get();

        //other attributes are set from postman

        //Setting the foreign key attr in the child class

        book.setAuthor(author);

        // We need to set the listOfBooks written in the parent class

        List<Book> currentBooksWritten =  author.getBooksWritten();
        currentBooksWritten.add(book); // add the book into the list

        //Book is to be saved and the author also need to be saved
        //Why need to save author? (updating the author)
        // because the author entity updated---we need to re-save/ update it

        authorRepository.save(author); //Date was modified
        //.save --> works as save / updated

        //bookRepository.save();  --> not required bcz it will be auto called by cascading

        return "Book Added successfully";

    }
}
