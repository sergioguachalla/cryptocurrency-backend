package com.example.backend.objectMapper;

import com.example.backend.dto.CryptocurrencyDto;
import com.example.backend.entity.Cryptocurrency;
import com.fasterxml.jackson.databind.ObjectMapper;

public class cryptoMapper {


    public cryptoMapper() {

    }

    public CryptocurrencyDto toCryptoDto(Cryptocurrency cryptocurrency){
        CryptocurrencyDto cryptocurrencyDto = new CryptocurrencyDto();
        cryptocurrencyDto.setId(cryptocurrency.getId());
        cryptocurrencyDto.setName(cryptocurrency.getName());
        cryptocurrencyDto.setSymbol(cryptocurrency.getSymbol());
        cryptocurrencyDto.setCurrentPrice(cryptocurrency.getCurrentPrice());
        return cryptocurrencyDto;
    }


}
