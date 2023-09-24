package com.example.backend.bl;

import com.example.backend.dao.CryptocurrencyRepository;
import com.example.backend.dao.TransactionRepository;
import com.example.backend.dao.UserRepository;
import com.example.backend.dto.PortfolioDto;
import com.example.backend.dto.TransactionDto;
import com.example.backend.entity.Cryptocurrency;
import com.example.backend.entity.Transaction;
import com.example.backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;
import java.math.BigDecimal;
import java.util.*;

@Service
public class TransactionBl {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    private final CryptocurrencyRepository cryptocurrencyRepository;

    public TransactionBl(TransactionRepository transactionRepository,
                         UserRepository userRepository,
                         CryptocurrencyRepository cryptocurrencyRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.cryptocurrencyRepository = cryptocurrencyRepository;
    }

    public Page<TransactionDto> findByUserIdAndCryptocurrencyId(int userId, int cryptocurrencyId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("transactionDate").descending());
        Page<Transaction> transactions = transactionRepository.findByUserIdAndCryptocurrencyId(userId, cryptocurrencyId, pageable);
        return transactions.map(transaction -> new TransactionDto(transaction.getId(),
                transaction.getUser().getKeyCloakId(), transaction.getCryptocurrencyId().getId(),
                transaction.getTransactionDate(), transaction.getTransactionType(),
                transaction.getAmount(), transaction.getPrice()));

    }

    public void saveTransaction(TransactionDto transactionDto) {
        try {
            User user = userRepository.findByKeyCloakId(transactionDto.getKeycloakUserId());
            Cryptocurrency cryptocurrency = cryptocurrencyRepository.findById(transactionDto.getCryptocurrencyId()).get();
            Transaction transaction = new Transaction();
            transaction.setUser(user);
            transaction.setCryptocurrencyId(cryptocurrency);
            transaction.setTransactionDate(new Date());
            transaction.setTransactionType(transactionDto.getType());
            transaction.setAmount(transactionDto.getQuantity());
            double price = cryptocurrency.getCurrentPrice();
            BigDecimal priceParsed = new BigDecimal(price);
            transaction.setPrice(priceParsed);
            transactionRepository.saveAndFlush(transaction);

        } catch (Exception e) {
            System.out.println(e.getMessage() + "Error saving transaction");
        }

    }

    public Page<PortfolioDto> findTotalAmountByUserIdAndCryptocurrencyId(String userId, Long cryptocurrencyId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("totalAmount").descending());
        Page<Transaction> transactions = transactionRepository.findTotalAmountByUserIdAndCryptocurrencyId(userId, cryptocurrencyId, pageable);
        return transactions.map(transaction -> new PortfolioDto(transaction.getUser().getKeyCloakId(),
                transaction.getCryptocurrencyId().getName(), transaction.getCryptocurrencyId().getSymbol(),
                transaction.getAmount(), transaction.getPrice()));

    }

    public List<PortfolioDto> getPortfolio(String userId) {
        List<Object[]> portfolio = transactionRepository.getPortfolio(userId);
        List<PortfolioDto> portfolioDtoList = new ArrayList<>();
        for (Object[] objects :
                portfolio) {
            PortfolioDto portfolioDto = new PortfolioDto();
            Cryptocurrency cryptocurrency = cryptocurrencyRepository.findById((Long) objects[0]).get();
            portfolioDto.setCryptocurrencyName(cryptocurrency.getName());
            portfolioDto.setCryptocurrencySymbol(cryptocurrency.getSymbol());
            portfolioDto.setTotalAmount((BigDecimal) objects[1]);
            portfolioDto.setAmountInUsd((BigDecimal) objects[1]);
            portfolioDtoList.add(portfolioDto);
        }
        return portfolioDtoList;


    }


}

