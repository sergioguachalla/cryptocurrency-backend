package com.example.backend.dao;

import com.example.backend.entity.Cryptocurrency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptocurrencyRepository extends JpaRepository<Cryptocurrency,Long> {
}
