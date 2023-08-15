package com.example.backend.bl;

import com.example.backend.dao.CryptocurrencyRepository;
import com.example.backend.dto.CryptocurrencyDto;
import com.example.backend.entity.Cryptocurrency;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    private static final Logger logger = LoggerFactory.getLogger(CryptocurrencyBl.class);

    @Value("${api.url}")
    private String API_URL;

    public String getAPI_URL() {
        return API_URL;
    }

    public CryptocurrencyBl(CryptocurrencyRepository cryptocurrencyRepository) {
        this.cryptocurrencyRepository = cryptocurrencyRepository;
    }

    public void saveCryptocurrency(CryptocurrencyDto cryptocurrencyDto) {
        String response = invokeApi(cryptocurrencyDto.getName());
        try {
            JsonNode jsonNode = parseJsonResponse(response);
            CryptocurrencyDto cryptocurrencyDto1 = mapJsonToCryptocurrencyDto(jsonNode);
            logger.info("CryptocurrencyDto: {}", cryptocurrencyDto1.getName());
            Cryptocurrency cryptocurrency = new Cryptocurrency();
            cryptocurrency.setName(cryptocurrencyDto1.getName());
            cryptocurrency.setSymbol(cryptocurrencyDto1.getSymbol());
            cryptocurrency.setCurrentPrice(cryptocurrencyDto1.getCurrentPrice());
            cryptocurrency.setStatus(true);
            cryptocurrencyRepository.save(cryptocurrency);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //logger.info("Saving cryptocurrency");

        //logger.info("Cryptocurrency saved");

    }


    public String getAssets() {
        logger.info("Getting assets");
        RestTemplate restTemplate = new RestTemplate();
        logger.info("Assets received");
        return restTemplate.getForObject(API_URL, String.class);
    }

    public String invokeApi(String id) {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(API_URL + "/" + id, String.class);
        return response;
    }

    private JsonNode parseJsonResponse(String response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(response);
    }

    private CryptocurrencyDto mapJsonToCryptocurrencyDto(JsonNode jsonNode) {
        CryptocurrencyDto cryptocurrencyDto = new CryptocurrencyDto();
        JsonNode dataNode = jsonNode.path("data");

        cryptocurrencyDto.setName(dataNode.get("name").asText());
        cryptocurrencyDto.setSymbol(dataNode.get("symbol").asText());
        cryptocurrencyDto.setCurrentPrice(dataNode.get("priceUsd").asDouble());

        return cryptocurrencyDto;
    }

}








