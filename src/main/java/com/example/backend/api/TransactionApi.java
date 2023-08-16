package com.example.backend.api;

import com.example.backend.bl.TransactionBl;
import com.example.backend.dto.ResponseDto;
import com.example.backend.dto.TransactionDto;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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




}
