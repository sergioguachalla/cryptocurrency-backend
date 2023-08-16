package com.example.backend.bl;

import com.example.backend.dao.UserRepository;
import com.example.backend.dto.UserDto;
import com.example.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBl {
    @Autowired
    private final UserRepository userRepository;

    public UserBl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserDto userDto) {
        User newuser = new User();
        newuser.setUsername(userDto.getUsername());
        newuser.setEmail(userDto.getEmail());
        newuser.setBalance(userDto.getBalance());
        newuser.setStatus(true);
        userRepository.saveAndFlush(newuser);
    }

    public void deleteUser(Long id) {
        userRepository.findById(id).ifPresent(user -> {
            user.setStatus(false);
            userRepository.saveAndFlush(user);
        });

    }

    public void updateBalance(Long id, UserDto userDto) {
        userRepository.findById(id).ifPresent(user -> {
            user.setBalance(userDto.getBalance());
            userRepository.saveAndFlush(user);
        });
    }




}
