package com.example.backend.api;

import com.example.backend.bl.UserBl;
import com.example.backend.dto.ResponseDto;
import com.example.backend.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {

    @Autowired
    private UserBl userBl;

    @PostMapping("/api/v1/user")
    public ResponseDto<String> saveUser(@RequestBody UserDto userDto) {
        ResponseDto<String> response = new ResponseDto<>();
        userBl.saveUser(userDto);
        response.setResponse("User saved");
        response.setCode("0000");
        response.setErrorMessage(null);
        return response;

    }

}
