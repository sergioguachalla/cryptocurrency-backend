package com.example.backend.bl;

import com.example.backend.dao.CryptocurrencyRepository;
import com.example.backend.dto.CryptocurrencyDto;
import com.example.backend.entity.Cryptocurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CryptocurrencyBl {

    @Autowired
    private final CryptocurrencyRepository cryptocurrencyRepository;

    public CryptocurrencyBl(CryptocurrencyRepository cryptocurrencyRepository) {
        this.cryptocurrencyRepository = cryptocurrencyRepository;
    }

    public void saveCryptocurrency(CryptocurrencyDto cryptocurrencyDto) {
        Cryptocurrency cryptocurrency = new Cryptocurrency();
        cryptocurrency.setNombre(cryptocurrencyDto.getName());
        cryptocurrency.setSimbolo(cryptocurrencyDto.getSymbol());
        cryptocurrencyRepository.save(cryptocurrency);


    }




}
