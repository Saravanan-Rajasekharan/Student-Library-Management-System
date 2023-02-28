package com.example.Student_Library_Management_System.Service;


import com.example.Student_Library_Management_System.DTOs.IssueBookRequestDto;
import com.example.Student_Library_Management_System.Enums.CardStatus;
import com.example.Student_Library_Management_System.Enums.TransactionStatus;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Models.Card;
import com.example.Student_Library_Management_System.Models.Transactions;
import com.example.Student_Library_Management_System.Repository.BookRepository;
import com.example.Student_Library_Management_System.Repository.CardRepository;
import com.example.Student_Library_Management_System.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    public String issueBook(IssueBookRequestDto issueBookRequestDto)throws Exception{

        int bookId = issueBookRequestDto.getBookId();
        int cardId = issueBookRequestDto.getCardId();

        // Get the Book and Card entity ---> Why do we need ths---> We want to set the txn attributes

        Book book = bookRepository.findById(bookId).get();

        Card card = cardRepository.findById(cardId).get();

        //Final goal is to make a txn entity and save it

        Transactions transaction = new Transactions();

        // Setting the attributes
        transaction.setBook(book);
        transaction.setCard(card);

        transaction.setIssueOperation(true);
        transaction.setTransactionStatus(TransactionStatus.PENDING);

        //Attribute left is txn status success/failure
        //check for validations

        if(book==null || book.isIssued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED); //save the transaction
            transactionRepository.save(transaction);
            throw new Exception("Book is not available");
        }
        if(card==null || (card.getCardStatus() != CardStatus.ACTIVATED )){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is not valid");
        }

        //We have reached the success case now

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        //set the attributes of book
        book.setIssued(true);


        List<Transactions> listOfTransactionForBook = book.getListOfTransactions();
        listOfTransactionForBook.add(transaction);
        book.setListOfTransactions(listOfTransactionForBook);

        //set attributes on the card

        List<Book> issuedBooksForCard = card.getBooksIssued();
        issuedBooksForCard.add(book);
        card.setBooksIssued(issuedBooksForCard);

        List<Transactions> transactionsListForCard = card.getTransactionsList();
        transactionsListForCard.add(transaction);
        card.setTransactionsList(transactionsListForCard);



        // Save the parent

        cardRepository.save(card);

        //Automatically by cascading : book and transaction will be saved

        return "Book issued successfully";
    }



}
