package com.example.servicebancaire.exceptions;
//Exception metier, bonnes pratiques
public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
