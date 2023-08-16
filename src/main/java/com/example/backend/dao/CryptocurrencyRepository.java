package com.example.backend.dao;

import com.example.backend.entity.Cryptocurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CryptocurrencyRepository extends JpaRepository<Cryptocurrency,Long> {

    @Query("SELECT c FROM Cryptocurrency c WHERE c.id = :id")
    Cryptocurrency findByCryptocurrencyId(@Param("id") Long id);

}
