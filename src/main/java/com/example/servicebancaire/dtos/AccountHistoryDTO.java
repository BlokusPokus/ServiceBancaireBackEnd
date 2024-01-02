package com.example.servicebancaire.dtos;

import lombok.Data;

import java.util.List;

@Data
public class AccountHistoryDTO {
    //Pagination
    private int currentPage;
    private int totalPages;
    private int pageSize;

    private String accountId;
    private  double balance;
    private String accountType;
    private List<AccountOperationDTO> accountOperationDTOS;
}
