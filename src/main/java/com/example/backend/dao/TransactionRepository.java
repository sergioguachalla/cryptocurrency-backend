package com.example.backend.dao;

import com.example.backend.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    @Query("SELECT t FROM Transaction t WHERE t.user.id = :userId AND t.cryptocurrencyId.id = :cryptocurrencyId")
    Page<Transaction> findByUserIdAndCryptocurrencyId(@Param("userId") int userId, @Param("cryptocurrencyId") int cryptocurrencyId, Pageable pageable);

    @Query("SELECT t FROM Transaction t WHERE t.user.id = :userId AND t.cryptocurrencyId.id = :cryptocurrencyId")
    Page<Transaction> findTotalAmountByUserIdAndCryptocurrencyId(@Param("userId") String userId, @Param("cryptocurrencyId") Long cryptocurrencyId, Pageable pageable);

    @Query("SELECT t.cryptocurrencyId.id, SUM(t.amount) FROM Transaction t WHERE t.user.keyCloakId = :userId GROUP BY t.cryptocurrencyId.id")
    List<Object[]> getPortfolio(@Param("userId") String userId);
}
