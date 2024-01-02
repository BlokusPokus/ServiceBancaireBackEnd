package com.example.servicebancaire.services;

import com.example.servicebancaire.dtos.*;

import com.example.servicebancaire.exceptions.BalanceNotSufficientException;
import com.example.servicebancaire.exceptions.BankAccountNotFoundException;
import com.example.servicebancaire.exceptions.CustomerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BankAccountService {
    //toutes les operations doivent etre faites par couche service pour bonnes pratiques
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomers();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BalanceNotSufficientException, BankAccountNotFoundException; // add money
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException; //remove money
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;

    List<BankAccountDTO> bankAccountList();

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;


    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHistory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;

    List<CustomerDTO> searchCustomers(String keyword);
}
