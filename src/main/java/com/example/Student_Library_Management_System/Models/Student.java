package com.example.Student_Library_Management_System.Models;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// id parameter will be auto incremented
    private int id;

    private String name;

    @Column(unique = true) // Makes the email entry unique
    private String email;

    private String mobNo;

    private int age;

    private String country;



    //Syntax for Bidirectional Mapping
    @OneToOne(mappedBy = "studentVariableName", cascade = CascadeType.ALL)
    private Card card;




    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Student() {

    }

    public Student(int id, String name, String email, String mobNo, int age, String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobNo = mobNo;
        this.age = age;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
