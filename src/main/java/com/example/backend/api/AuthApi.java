package com.example.backend.api;

import com.example.backend.bl.AuthBl;
import com.example.backend.dto.ResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")

public class AuthApi {

    @Autowired
    private AuthBl authBl;

    @GetMapping("api/v1/auth/token")
    @CrossOrigin("*")
    public ResponseDto<String> getAccessToken() throws JsonProcessingException {
        ResponseDto<String> responseDto = new ResponseDto<>();
        responseDto.setResponse(this.authBl.getAccessToken());
        responseDto.setErrorMessage("");
        responseDto.setCode("0000");
        return responseDto;
    }
}
