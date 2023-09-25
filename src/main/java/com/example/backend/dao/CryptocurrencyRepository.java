package com.example.backend.dao;

import com.example.backend.entity.Cryptocurrency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CryptocurrencyRepository extends JpaRepository<Cryptocurrency,Long>, PagingAndSortingRepository<Cryptocurrency,Long> {
    Page<Cryptocurrency> findAllByStatusTrue(Pageable pageable);

    @Query("SELECT c FROM Cryptocurrency c WHERE c.status = true")
    List<Cryptocurrency> findAllActiveCryptocurrencies();

    @Query("SELECT c FROM Cryptocurrency c WHERE c.name = :name and c.status = true")
    Cryptocurrency findByName(@Param("name") String name);
}
