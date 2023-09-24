package com.example.backend.api;

import com.example.backend.bl.UserBl;
import com.example.backend.dto.ResponseDto;
import com.example.backend.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserApi {

    @Autowired
    private UserBl userBl;



    @PostMapping("/api/v1/user")
    public ResponseDto<String> saveUser(@RequestBody UserDto userDto) {
        ResponseDto<String> response = new ResponseDto<>();
        userBl.createUser(userDto);
        response.setResponse("User saved");
        response.setCode("0000");
        response.setErrorMessage(null);
        return response;

    }

//    @PutMapping("/api/v1/user/{id}")
//    public ResponseDto<String> deleteUser(@PathVariable Long id ) {
//        ResponseDto<String> response = new ResponseDto<>();
//        userBl.deleteUser(id);
//        response.setResponse("User deleted");
//        response.setCode("0000");
//        response.setErrorMessage(null);
//        return response;
//
//    }
//
//    @PutMapping("/api/v1/user/{id}/balance")
//    public ResponseDto<String> updateBalance(@PathVariable Long id, @RequestBody UserDto userDto) {
//        ResponseDto<String> response = new ResponseDto<>();
//        userBl.updateBalance(id, userDto);
//        response.setResponse("Balance updated");
//        response.setCode("0000");
//        response.setErrorMessage(null);
//        return response;
//
//    }


}
