package com.example.backend.bl;

import com.example.backend.dao.CryptocurrencyRepository;
import com.example.backend.dto.CryptocurrencyDto;
import com.example.backend.entity.Cryptocurrency;
import com.example.backend.exceptions.CryptocurrencyUpdateException;
import com.example.backend.objectMapper.cryptoMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CryptocurrencyBl {

    @Autowired
    private final CryptocurrencyRepository cryptocurrencyRepository;

    private static final Logger logger = LoggerFactory.getLogger(CryptocurrencyBl.class);

    @Value("${api.url}")
    private String API_URL;


    public CryptocurrencyBl(CryptocurrencyRepository cryptocurrencyRepository) {
        this.cryptocurrencyRepository = cryptocurrencyRepository;
    }

    public boolean saveCryptocurrency(CryptocurrencyDto cryptocurrencyDto) {
        String response = invokeApi(cryptocurrencyDto.getName());
        if (response == null) {
            logger.error("Error al obtener la info de la criptomoneda");

            return false;
        }
        try {
            JsonNode jsonNode = parseJsonResponse(response);
            CryptocurrencyDto cryptocurrencyDto1 = mapJsonToCryptocurrencyDto(jsonNode);
            logger.info("Recibiendo info de " + cryptocurrencyDto.getName() + " desde coinbase");
            Cryptocurrency cryptocurrency = new Cryptocurrency();
            cryptocurrency.setName(cryptocurrencyDto1.getName());
            cryptocurrency.setSymbol(cryptocurrencyDto1.getSymbol());
            cryptocurrency.setCurrentPrice(cryptocurrencyDto1.getCurrentPrice());
            cryptocurrency.setStatus(true);
            logger.info("Guardando " + cryptocurrencyDto.getName() + " a la base de datos");
            cryptocurrencyRepository.save(cryptocurrency);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            logger.error("Error al guardar la criptomoneda");
        }
        return true;

    }

    public void createCryptocurrency(CryptocurrencyDto cryptocurrencyDto){
        Cryptocurrency cryptocurrency = new Cryptocurrency();
        cryptocurrency.setName(cryptocurrencyDto.getName());
        cryptocurrency.setSymbol(cryptocurrencyDto.getSymbol());
        cryptocurrency.setCurrentPrice(cryptocurrencyDto.getCurrentPrice());
        cryptocurrency.setStatus(true);
        cryptocurrencyRepository.save(cryptocurrency);
    }

    public void updateCryptocurrencyCurrentPrice(Long id, CryptocurrencyDto cryptocurrencyDto) {
        try {
            Cryptocurrency cryptocurrency = cryptocurrencyRepository.findById(id).orElse(null);
            if (cryptocurrency == null) {
                throw new CryptocurrencyUpdateException("Criptomoneda no encontrada para la actualización", null);
            }
            cryptocurrency.setCurrentPrice(cryptocurrencyDto.getCurrentPrice());
            cryptocurrencyRepository.saveAndFlush(cryptocurrency);

        } catch (Exception e) {
            throw new CryptocurrencyUpdateException("Error al actualizar el precio de la criptomoneda", e);
        }
    }


    public Page<CryptocurrencyDto> getAll(int page, int size) {
        try {
            Pageable cryptocurrencyPage = PageRequest.of(page, size, Sort.by("id").ascending());
            Page<Cryptocurrency> cryptocurrenciesPage = cryptocurrencyRepository.findAllByStatusTrue(cryptocurrencyPage);

            return cryptocurrenciesPage.map(cryptocurrency -> {
                CryptocurrencyDto dto = new CryptocurrencyDto();
                dto.setId(cryptocurrency.getId());
                dto.setName(cryptocurrency.getName());
                dto.setSymbol(cryptocurrency.getSymbol());
                dto.setCurrentPrice(cryptocurrency.getCurrentPrice());
                return dto;
            });
        } catch (Exception e) {
            throw new CryptocurrencyUpdateException("Error al obtener las criptomonedas", e);
        }
    }


    public String invokeApi(String id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(API_URL + "/" + id, String.class);
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

    public void deleteCryptocurrency(Long id) {
        Cryptocurrency cryptocurrency = cryptocurrencyRepository.findById(id).orElse(null);
        assert cryptocurrency != null;
        cryptocurrency.setStatus(false);
        cryptocurrencyRepository.save(cryptocurrency);


    }


    public List<CryptocurrencyDto> getAllCryptocurrencies() {
        List<Cryptocurrency> cryptocurrencies = cryptocurrencyRepository.findAllActiveCryptocurrencies();
        List<CryptocurrencyDto> cryptocurrencyDtos = new ArrayList<>();
        for (Cryptocurrency cryptocurrency : cryptocurrencies) {
            CryptocurrencyDto cryptocurrencyDto = new CryptocurrencyDto();
            cryptocurrencyDto.setId(cryptocurrency.getId());
            cryptocurrencyDto.setName(cryptocurrency.getName());
            cryptocurrencyDto.setSymbol(cryptocurrency.getSymbol());
            cryptocurrencyDto.setCurrentPrice(cryptocurrency.getCurrentPrice());
            cryptocurrencyDtos.add(cryptocurrencyDto);
        }
        return cryptocurrencyDtos;
    }


}








