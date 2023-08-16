package com.example.backend.bl;

import com.example.backend.dao.CryptocurrencyRepository;
import com.example.backend.dao.TransactionRepository;
import com.example.backend.dao.UserRepository;
import com.example.backend.dto.TransactionDto;
import com.example.backend.entity.Cryptocurrency;
import com.example.backend.entity.Transaction;
import com.example.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionBl {

    @Autowired
    private final TransactionRepository transactionRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final CryptocurrencyRepository cryptocurrencyRepository;

    public TransactionBl(TransactionRepository transactionRepository,
                         UserRepository userRepository,
                         CryptocurrencyRepository cryptocurrencyRepository) {
        this.cryptocurrencyRepository = cryptocurrencyRepository;
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    public void saveTransaction(TransactionDto transactionDto){
        //User
        User user = userRepository.findByUserId(transactionDto.getUserId().getId());
        //Cryptocurrency
        Cryptocurrency cryptocurrency = cryptocurrencyRepository.findByCryptocurrencyId(transactionDto.getCryptocurrencyId().getId());

        //Transaction
        Transaction transaction = new Transaction();
        transaction.setUser(user);
        transaction.setCryptocurrency(cryptocurrency);
        transaction.setTransactionType(transactionDto.getTransactionType());
        transaction.setAmount(transactionDto.getAmount());
        Date date = new Date();
        transaction.setTransactionDate(date);
        transactionRepository.saveAndFlush(transaction);

    }


}
