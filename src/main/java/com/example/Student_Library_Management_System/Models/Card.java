package com.example.Student_Library_Management_System.Models;


import com.example.Student_Library_Management_System.Enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name="card")
public class Card {

    //Plan to save this card in DB
    //Before saving I have to set its attributes : Rule No 1




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // It is auto-generated
    private int id;

    @CreationTimestamp // Auto timestamp the time when an entry is created
    Date createdOn;  // it is auto generated
    @UpdateTimestamp // Sets time when an entry is updated
    Date updatedOn; // is is auto generated

    @Enumerated(value=EnumType.STRING)
    private CardStatus cardStatus; // Set its attribute


    //Unidirectional Mapping
    @OneToOne
    @JoinColumn
    private Student studentVariableName;
    //This variable is used in the parent class while doing the bidirectional mapping



    public Student getStudentVariableName() {
        return studentVariableName;
    }

    public void setStudentVariableName(Student studentVariableName) {
        this.studentVariableName = studentVariableName;
    }

    public Card() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }



}
