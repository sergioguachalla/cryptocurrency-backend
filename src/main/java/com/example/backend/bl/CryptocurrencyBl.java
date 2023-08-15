package com.example.backend.bl;

import com.example.backend.dao.CryptocurrencyRepository;
import com.example.backend.dto.CryptocurrencyDto;
import com.example.backend.entity.Cryptocurrency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CryptocurrencyBl {

    @Autowired
    private final CryptocurrencyRepository cryptocurrencyRepository;



    @Value("${api.url}")
    private String API_URL;

    public CryptocurrencyBl(CryptocurrencyRepository cryptocurrencyRepository) {
        this.cryptocurrencyRepository = cryptocurrencyRepository;
    }

    public void saveCryptocurrency(CryptocurrencyDto cryptocurrencyDto) {
        String id = getRandomId();
        //invokeApi(id);
        //logger.info("Saving cryptocurrency");
        Cryptocurrency cryptocurrency = new Cryptocurrency();
        cryptocurrency.setName(cryptocurrencyDto.getName());
        cryptocurrency.setSymbol(cryptocurrencyDto.getSymbol());
        cryptocurrency.setCurrentPrice(cryptocurrencyDto.getCurrentPrice());
        cryptocurrency.setStatus(true);
        cryptocurrencyRepository.save(cryptocurrency);
        //logger.info("Cryptocurrency saved");

    }


    public String getAssets(){
        //logger.info("Getting assets");
        RestTemplate restTemplate = new RestTemplate();
        //logger.info("Assets received");
        return restTemplate.getForObject("https://api.coincap.io/v2/assets", String.class);
    }

    public void invokeApi(String randomId) {
        //logger.info("Invoking API");
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(API_URL, String.class);
        System.out.println(response);
        //logger.info("API invoked");
    }

    private String getRandomId(){
        //logger.info("Getting random crypto id");
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(API_URL, String.class);
        System.out.println(response);
        //logger.info("Random crypto id received", response);
        return restTemplate.getForObject(API_URL, String.class);


    }




}
