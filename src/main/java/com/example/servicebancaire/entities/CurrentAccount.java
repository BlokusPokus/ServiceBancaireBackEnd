package com.example.servicebancaire.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CA") //Donne la valeur de la colonne type
@Data @NoArgsConstructor @AllArgsConstructor

public class CurrentAccount extends BankAccount{
    private double overDraft;
}
