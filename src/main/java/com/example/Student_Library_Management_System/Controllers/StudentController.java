package com.example.Student_Library_Management_System.Controllers;

import com.example.Student_Library_Management_System.Models.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class StudentController {

    @PostMapping("/add")
    public String createStudent(@RequestBody Student student){

        return " ";
    }

}
