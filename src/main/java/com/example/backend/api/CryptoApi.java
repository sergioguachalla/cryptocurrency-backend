package com.example.backend.api;

import com.example.backend.bl.CryptocurrencyBl;
import com.example.backend.dto.CryptocurrencyDto;
import com.example.backend.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CryptoApi {

    @Autowired
    private CryptocurrencyBl cryptocurrencyBl;

    public CryptoApi(CryptocurrencyBl cryptocurrencyBl) {
        this.cryptocurrencyBl = cryptocurrencyBl;
    }
    @PostMapping("api/v1/cryptocurrency")
    public ResponseDto saveCrypto(@RequestBody CryptocurrencyDto cryptocurrencyDto){
        ResponseDto response = new ResponseDto();
        this.cryptocurrencyBl.saveCryptocurrency(cryptocurrencyDto);
        response.setErrorMessage(null);
        response.setResponse("Cryptocurrency saved");
        response.setCode("0000");
        return response;
    }

    @GetMapping("api/v1/cryptocurrency")
    public ResponseDto getAssets(){
        ResponseDto response = new ResponseDto();
        response.setErrorMessage(null);
        response.setResponse(this.cryptocurrencyBl.getAssets());
        response.setCode("0000");
        return response;
    }
}
