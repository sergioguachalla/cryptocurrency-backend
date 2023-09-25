package com.example.backend.api;


import com.example.backend.bl.TransactionBl;
import com.example.backend.dto.*;
import com.example.backend.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
public class TransactionApi {

    @Autowired
    private TransactionBl transactionBl;

    @GetMapping("/api/v1/transactions/{userId}/{cryptocurrencyId}/")
    public ResponseDto<Page<TransactionDto>> getTransactionsByUserAndCryptoId(@PathVariable int userId, @PathVariable int cryptocurrencyId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        ResponseDto<Page<TransactionDto>> response = new ResponseDto<>();
        response.setResponse(transactionBl.findByUserIdAndCryptocurrencyId(userId, cryptocurrencyId, page, size));
        response.setCode("0000");
        response.setErrorMessage(null);
        return response;
    }

    @PostMapping("/api/v1/transactions")
    public ResponseDto<String> saveTransaction(@RequestBody TransactionDto transactionDto) {
        ResponseDto<String> response = new ResponseDto<>();
        transactionBl.saveTransaction(transactionDto);
        response.setResponse("Transaction saved");
        response.setCode("0000");
        response.setErrorMessage(null);
        return response;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("api/v1/portfolio")
    public ResponseDto<Page<PortfolioDto>> getPortfolio(@RequestParam String userId,
            @RequestParam int page,
            @RequestParam int size) {
        ResponseDto<Page<PortfolioDto>> response = new ResponseDto<>();
        response.setResponse(this.transactionBl.getPortfolio(userId, page, size));
        response.setCode("0000");
        response.setErrorMessage(null);
        return response;

    }

    @PostMapping("api/v1/transactions/memento")
    public ResponseDto<String> saveMemento(@RequestBody List<TransactionDto> transactions) {
        ResponseDto<String> response = new ResponseDto<>();
        this.transactionBl.saveTransactions(transactions);
        response.setResponse("All transactions saved");
        response.setCode("0000");
        response.setErrorMessage(null);
        return response;
    }


}
