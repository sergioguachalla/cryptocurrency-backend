package com.example.backend.objectMapper;

import com.example.backend.dto.TransactionDto;
import com.example.backend.entity.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionMapper {

    public TransactionMapper() {

    }

    public List<TransactionDto> toTransactionDtoList(List<Transaction> transactionList){
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        for(Transaction transaction : transactionList){
            TransactionDto transactionDto = new TransactionDto();
            transactionDto.setId(transaction.getId());
            transactionDto.setUserId(new UserMapper().toUserDto(transaction.getUser()));
            transactionDto.setCryptocurrencyId(new cryptoMapper().toCryptoDto(transaction.getCryptocurrency()));
            transactionDto.setTranscationType(transaction.getTransactionType());
            transactionDto.setAmount(transaction.getAmount());
            transactionDto.setTransactionDate(transaction.getTransactionDate());
            transactionDtoList.add(transactionDto);
        }
        return transactionDtoList;
    }

}
