package com.example.backend.api;

import com.example.backend.bl.CryptocurrencyBl;
import com.example.backend.dto.CryptocurrencyDto;
import com.example.backend.dto.ResponseDto;
import com.example.backend.entity.Cryptocurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class CryptoApi {

    @Autowired
    private CryptocurrencyBl cryptocurrencyBl;

    public CryptoApi(CryptocurrencyBl cryptocurrencyBl) {
        this.cryptocurrencyBl = cryptocurrencyBl;
    }
    @PostMapping("api/v1/cryptocurrency")
    public ResponseDto<String> saveCrypto(@RequestBody CryptocurrencyDto cryptocurrencyDto){
        ResponseDto response = new ResponseDto();
        this.cryptocurrencyBl.saveCryptocurrency(cryptocurrencyDto);
        response.setErrorMessage(null);
        response.setResponse("Cryptocurrency saved");
        response.setCode("0000");
        return response;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("api/v1/cryptocurrency")
    public ResponseDto<Page<CryptocurrencyDto>> getAssets(@RequestParam int page, @RequestParam int size){
        ResponseDto<Page<CryptocurrencyDto>> response = new ResponseDto<>();
        response.setErrorMessage(null);
        response.setResponse(this.cryptocurrencyBl.getAll(page, size));
        response.setCode("0000");
        return response;
    }

    @PutMapping("api/v1/cryptocurrency/{id}")
    public ResponseDto<String> deleteCrypto(@PathVariable Long id){
        ResponseDto response = new ResponseDto();
        this.cryptocurrencyBl.deleteCryptocurrency(id);
        response.setErrorMessage(null);
        response.setResponse("Cryptocurrency deleted");
        response.setCode("0000");
        return response;
    }

    @PutMapping("api/v1/cryptocurrency/{id}/price")
    public ResponseDto<String> updateBalance(@PathVariable Long id, @RequestBody CryptocurrencyDto cryptocurrencyDto){
        ResponseDto response = new ResponseDto();
        this.cryptocurrencyBl.updateCryptocurrencyCurrentPrice(id, cryptocurrencyDto);
        response.setErrorMessage(null);
        response.setResponse("Cryptocurrency balance updated");
        response.setCode("0000");
        return response;
    }
}
