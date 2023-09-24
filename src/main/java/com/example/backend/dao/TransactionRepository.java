package com.example.backend.dao;

import com.example.backend.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    @Query("SELECT t FROM Transaction t WHERE t.user.keyCloakId = :userId AND t.cryptocurrencyId = :cryptocurrencyId")
    Page<Transaction> findByUserIdAndCryptocurrencyId(@Param("userId") String userId, @Param("cryptocurrencyId") Long cryptocurrencyId, Pageable pageable);
}
