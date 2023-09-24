package com.example.backend.objectMapper;

import com.example.backend.dto.UserDto;
import com.example.backend.entity.User;

public class UserMapper {

    public UserMapper() {

    }

    public UserDto toUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setName(user.getName());
        userDto.setKeyCloakId(user.getKeyCloakId());

//        userDto.setEmail(user.getEmail());
//        userDto.setBalance(user.getBalance());
//        userDto.setStatus(user.isStatus());
        return userDto;
    }
}
