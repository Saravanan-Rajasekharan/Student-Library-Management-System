package com.example.Student_Library_Management_System.Models;


import com.example.Student_Library_Management_System.Enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name="card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp // Auto timestamp the time when an entry is created
    Date createdOn;
    @UpdateTimestamp // Sets time when an entry is updated
    Date updatedOn;

    @Enumerated(value=EnumType.STRING)
    private CardStatus cardStatus;

    //Unidirectional Mapping

    @OneToOne
    @JoinColumn
    private Student studentVariableName;
    //This variable is used in the parent class while doing the bidirectional mapping




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
