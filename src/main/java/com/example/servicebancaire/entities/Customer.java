package com.example.servicebancaire.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "customer") // Quand il y a une relation bidirectionnelle, on doit utiliser mappedBy
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //Permet de choisir quelle action l'attribut peut faire
    private List<BankAccount> bankAccounts;
}
