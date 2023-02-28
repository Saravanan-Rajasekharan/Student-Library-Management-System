package com.example.Student_Library_Management_System.Controllers;

import com.example.Student_Library_Management_System.DTOs.IssueBookRequestDto;
import com.example.Student_Library_Management_System.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issueBook")
    public String issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto){
        try {
            return transactionService.issueBook(issueBookRequestDto);
        } catch (Exception e){
            return e.getMessage();
        }

    }

    @GetMapping("/getTransactionId")
    public String getTransactionId(@RequestParam("bookId") Integer bookId, @RequestParam("cardId") Integer cardId){
        return transactionService.getTransactionId(bookId,cardId);
    }
}
