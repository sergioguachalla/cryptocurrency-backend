package com.example.backend.bl;

import com.example.backend.dao.UserRepository;
import com.example.backend.dto.UserDto;
import com.example.backend.entity.User;
import com.example.backend.objectMapper.UserMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserBl {
    @Autowired
    private final UserRepository userRepository;

    private UserMapper userMapper = new UserMapper();

    public UserBl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(UserBl.class);

    public List<UserDto> findAllUsers() {
        try {
            logger.info("Obteniendo todos los usuarios");
            List<User> users = userRepository.findAll();
            List<UserDto> userDtos = new ArrayList<>();
            for (User user : users) {
                userDtos.add(userMapper.toUserDto(user));
            }
            logger.info("Usuarios obtenidos");
            return userDtos;

        } catch (Exception e) {
            logger.error("Error al obtener los usuarios: {}", e.getMessage());
            return new ArrayList<>();
        }
    }

//    public void saveUser(UserDto userDto) {
//        User newuser = new User();
//        newuser.setUsername(userDto.getUsername());
//        newuser.setEmail(userDto.getEmail());
//        newuser.setBalance(userDto.getBalance());
//        newuser.setStatus(true);
//        userRepository.saveAndFlush(newuser);
//    }

//    public void deleteUser(Long id) {
//        userRepository.findById(id).ifPresent(user -> {
//            user.setStatus(false);
//            userRepository.saveAndFlush(user);
//        });
//
//    }

//    public void updateBalance(Long id, UserDto userDto) {
//        userRepository.findById(id).ifPresent(user -> {
//            user.setBalance(userDto.getBalance());
//            userRepository.saveAndFlush(user);
//        });
//    }

    public void createUser(UserDto userDto){
        if(userRepository.findByUsername(userDto.getUsername()) == null){
            User user = new User();
            user.setUsername(userDto.getUsername());
            user.setKeyCloakId(userDto.getKeyCloakId());
            user.setName(userDto.getName());
            userRepository.saveAndFlush(user);
        }

    }




}
