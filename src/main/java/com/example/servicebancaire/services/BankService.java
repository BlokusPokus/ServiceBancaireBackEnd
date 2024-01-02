package com.example.servicebancaire.services;


import com.example.servicebancaire.entities.BankAccount;
import com.example.servicebancaire.entities.CurrentAccount;
import com.example.servicebancaire.entities.SavingAccount;
import com.example.servicebancaire.repositeries.BankAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    public void consulter(){
        BankAccount bankAccount=
                bankAccountRepository.findById("07259cca-1051-4bfc-9fae-3003acd95c8c").orElse(null);
        if(bankAccount!=null) {
            System.out.println("***************");
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getStatus());
            System.out.println(bankAccount.getCreatedAt());
            System.out.println(bankAccount.getCustomer().getName());
            if (bankAccount instanceof CurrentAccount) {
                System.out.println("Over Draft =>" + ((CurrentAccount) bankAccount).getOverDraft());
            } else if (bankAccount instanceof SavingAccount) {
                System.out.println("Rate =>" + ((SavingAccount) bankAccount).getInterestRate());
            }
            bankAccount.getAccountOperation().forEach(op -> {
                System.out.println("===========================");
                System.out.println(op.getType());
                System.out.println(op.getAmount());
                System.out.println(op.getOperationDate());
                System.out.println(op.getId());
            });
        }
    }
}
