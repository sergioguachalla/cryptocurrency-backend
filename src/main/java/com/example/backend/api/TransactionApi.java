package com.example.backend.api;

import com.example.backend.bl.TransactionBl;
import com.example.backend.dto.ResponseDto;
import com.example.backend.dto.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionApi {

    @Autowired
    private TransactionBl transactionBl;

    @PostMapping("api/v1/transaction")
    public ResponseDto<String> saveTransaction(@RequestBody TransactionDto transactionDto){
        ResponseDto<String> responseDto = new ResponseDto<>();
        this.transactionBl.saveTransaction(transactionDto);
        responseDto.setResponse("Transaction saved successfully");
        responseDto.setErrorMessage(null);
        responseDto.setCode("0000");
        return responseDto;
    }

    @GetMapping("api/v1/transactions")
    public ResponseDto<List<TransactionDto>> getTransactions(){
        ResponseDto<List<TransactionDto>> responseDto = new ResponseDto<>();
        responseDto.setResponse(this.transactionBl.getTransactions());
        responseDto.setErrorMessage(null);
        responseDto.setCode("0000");
        return responseDto;
    }

    @PutMapping("api/v1/transaction/{id}")
    public ResponseDto<String> updateTransaction(@PathVariable("id") Long id, @RequestBody TransactionDto transactionDto){
        ResponseDto<String> responseDto = new ResponseDto<>();
        this.transactionBl.updateTransactionAmount(id, transactionDto);
        responseDto.setResponse("Transaction updated successfully");
        responseDto.setErrorMessage(null);
        responseDto.setCode("0000");
        return responseDto;
    }




}
