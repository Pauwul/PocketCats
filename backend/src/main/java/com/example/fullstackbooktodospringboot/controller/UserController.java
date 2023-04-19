package com.example.fullstackbooktodospringboot.controller;

import com.example.fullstackbooktodospringboot.dto.CreateUserDto;
import com.example.fullstackbooktodospringboot.dto.UserDto;
import com.example.fullstackbooktodospringboot.dto.UpdateUserDto;
import com.example.fullstackbooktodospringboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/User")
public class UserController {
    private UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto newUserDto) {
        UserDto UserDTO = userService.createUser(newUserDto);
        return new ResponseEntity<>(UserDTO, HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<UserDto> getUsers(@RequestParam Optional<Boolean> completed) {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UpdateUserDto updateUserDto) {
        return userService.updateUser(id, updateUserDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
