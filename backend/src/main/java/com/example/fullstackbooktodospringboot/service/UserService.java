package com.example.fullstackbooktodospringboot.service;

import com.example.fullstackbooktodospringboot.dto.CreateUserDto;
import com.example.fullstackbooktodospringboot.dto.UserDto;
import com.example.fullstackbooktodospringboot.dto.UpdateUserDto;
import com.example.fullstackbooktodospringboot.exception.UserException;
import com.example.fullstackbooktodospringboot.model.User;
import com.example.fullstackbooktodospringboot.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository UserRepository;

    public UserService (UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    public UserDto createUser(CreateUserDto createUserDTO) {
        User newUser = new User();
        newUser.setName(createUserDTO.getName());
        newUser.setUsername(createUserDTO.getUsername());
        newUser.setDateRegister(createUserDTO.getDateRegister());
        newUser.setPassword(createUserDTO.getPassword());
        newUser.setCompleted(false);
        User toDo = UserRepository.save(newUser);
        return new UserDto(toDo);
    }

    public List<UserDto> getUsers() {
        List<User> users = UserRepository.findAll();
        return users.stream().map(entity -> new UserDto(entity)).toList();
    }

    public UserDto getUserById(Long id) {
        Optional<User> user = UserRepository.findById(id);
        if (user.isPresent()) {
            return new UserDto(user.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "getUserById - user not found");
        }
    }

    public UserDto updateUser(Long id, UpdateUserDto updateUserDto) {
        Optional<User> user = UserRepository.findById(id);
        if (user.isPresent()) {
            user.get().setName(updateUserDto.getName());
            UserRepository.save(user.get());
            return new UserDto(user.get());
        } else {
            throw new UserException(404, "updateUser - user not found");
        }
    }

    public void deleteUser(Long id) {
        Optional<User> user = UserRepository.findById(id);
        if (user.isPresent()) {
            UserRepository.delete(user.get());
        } else {
            throw new RuntimeException("deleteUser - user not found");
        }
    }
}
