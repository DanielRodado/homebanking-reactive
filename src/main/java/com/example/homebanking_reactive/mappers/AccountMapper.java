package com.example.homebanking_reactive.mappers;

import com.example.homebanking_reactive.dto.accountDTO.AccountDTO;
import com.example.homebanking_reactive.dto.transactionDTO.TransactionDTO;
import com.example.homebanking_reactive.models.AccountModel;

import java.util.HashSet;
import java.util.List;

public final class AccountMapper {

    public static AccountDTO toAccountDTO(AccountModel account, List<TransactionDTO> transactionsDTO) {
        return new AccountDTO(account, new HashSet<>(transactionsDTO));
    }

}
