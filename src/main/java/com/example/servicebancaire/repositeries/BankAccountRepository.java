package com.example.servicebancaire.repositeries;

import com.example.servicebancaire.entities.BankAccount;
import com.example.servicebancaire.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
